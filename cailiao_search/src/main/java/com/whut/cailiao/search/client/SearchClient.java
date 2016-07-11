package com.whut.cailiao.search.client;

import com.whut.cailiao.ms.api.commons.ApiResponse;
import com.whut.cailiao.ms.api.commons.ApiResponseCode;
import com.whut.cailiao.ms.api.model.questionnaire.QuestionnaireContent;
import com.whut.cailiao.ms.api.model.search.QuestionnaireQueryBean;
import com.whut.cailiao.ms.api.model.search.wjcontent.QuestionnaireContentDetail;
import com.whut.cailiao.search.helper.BeanConvertHelper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 只提供搜索功能
 * 不提供创建索引的功能
 * 待测试
 * Created by niuyang on 16/3/8.
 */
public class SearchClient {
    
    private static SearchClient searchClient = null;
    
    private SearchClient() {
        
    }
    
    public static SearchClient getInstance() {
        if (searchClient == null) {
            synchronized (SearchClient.class) {
                if (searchClient == null) {
                    searchClient = new SearchClient();
                }
            }
        }
        return searchClient;
    }

    /**
     * 根据查询条件搜索
     * @param questionnaireQueryBean
     * @return
     */
    public ApiResponse search(QuestionnaireQueryBean questionnaireQueryBean) throws IOException {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (questionnaireQueryBean == null) {
            return response;
        }
        BooleanQuery booleanQuery = createBooleanQuery(questionnaireQueryBean);
        IndexSearcher searcher = createSearcherInstance();
        List<String> resultList = getResultList(searcher, booleanQuery);
        if (CollectionUtils.isNotEmpty(resultList)) {
            response.addBody("resultList", resultList);
        }
        return response;
    }



    /**
     * 创建索引
     * @param questionnaireContentList
     * @return
     */
    public ApiResponse createIndex(List<QuestionnaireContent> questionnaireContentList) {
        // 获取索引写入器
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (CollectionUtils.isEmpty(questionnaireContentList)) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        IndexWriter indexWriter = null;
        try {
            indexWriter = getIndexWriter();
            // 创建索引
            buildIndex(indexWriter, questionnaireContentList);
        } catch (IOException e) {
            response.setRetCode(ApiResponseCode.IO_EXCEPTION);
        } finally {
            try {
                if (indexWriter != null) {
                    indexWriter.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return response;
    }

    /**
     * 创建组合搜索条件
     * @param questionnaireQueryBean
     * @return
     */
    private BooleanQuery createBooleanQuery(QuestionnaireQueryBean questionnaireQueryBean) {
        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        Class<? extends QuestionnaireQueryBean> clazz = questionnaireQueryBean.getClass();
        java.lang.reflect.Field[] declaredFields = clazz.getDeclaredFields();
        if (ArrayUtils.isNotEmpty(declaredFields)) {
            for (java.lang.reflect.Field field : declaredFields) {
                if (!"serialVersionUID".equalsIgnoreCase(field.getName())) {
                    field.setAccessible(true);
                    try {
                        String value = (String) field.get(questionnaireQueryBean);
                        if (StringUtils.isNotBlank(value)) {
                            TermQuery termQuery = new TermQuery(new Term(field.getName(), value));
                            builder.add(termQuery, BooleanClause.Occur.MUST);
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return builder.build();
    }

    private IndexSearcher createSearcherInstance() throws IOException {
        FSDirectory directory = FSDirectory.open(Paths.get("indexFile"));
        IndexReader reader = DirectoryReader.open(directory);
        return new IndexSearcher(reader);
    }

    private List<String> getResultList(IndexSearcher searcher, Query query) throws IOException {
        TopDocs topDocs = searcher.search(query, 100);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        List<String> resultList = new ArrayList<>();
        for (int i = 0; i < scoreDocs.length; i++) {
            int indexDoc = scoreDocs[i].doc;
            Document doc = searcher.doc(indexDoc);
            String content = doc.get("id");
            if (StringUtils.isNotBlank(content)) {
                resultList.add(content);
            }
        }
        return resultList;
    }

    /**
     * 创建索引
     * @param indexWriter
     * @param questionnaireContentList
     */
    private void buildIndex(IndexWriter indexWriter,
                            List<QuestionnaireContent> questionnaireContentList) throws IOException {
        if (indexWriter == null || CollectionUtils.isEmpty(questionnaireContentList)) {
            return;
        }
        Class<? extends QuestionnaireContentDetail> clazz = QuestionnaireContentDetail.class;
        java.lang.reflect.Field[] declaredFields = clazz.getDeclaredFields();

        for (QuestionnaireContent questionnaireContent : questionnaireContentList) {
            if (questionnaireContent == null) {
                continue;
            }
            Document document = new Document();
            document.add(new TextField("id", questionnaireContent.getId().toString(), Field.Store.YES));
            document.add(new TextField("questionnaireTemplateId", String.valueOf(questionnaireContent.getQuestionnaireTemplateId()), Field.Store.YES));

            try {
                QuestionnaireContentDetail questionnaireContentDetail = BeanConvertHelper.convertJsonContentToBean(questionnaireContent.getJsonContent());
                buildIndex(questionnaireContentDetail, declaredFields, document);
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
            indexWriter.addDocument(document);
        }
    }

    private void buildIndex(Object object, java.lang.reflect.Field[] declaredFields, Document document) {
        if (object != null && ArrayUtils.isNotEmpty(declaredFields)) {
            for (java.lang.reflect.Field field : declaredFields) {
                if (!"serialVersionUID".equalsIgnoreCase(field.getName())) {
                    field.setAccessible(true);
                    Class<?> aClass = field.getType();
                    if (aClass == String.class) {
                        String value = null;
                        try {
                            value = (String) field.get(object);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                        if (StringUtils.isNotBlank(value)) {
                            document.add(new TextField(field.getName(), value, Field.Store.YES));
                        }
                    } else {
                        java.lang.reflect.Field[] declaredFieldsSubCls = aClass.getDeclaredFields();
                        try {
                            buildIndex(field.get(object), declaredFieldsSubCls, document);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private IndexWriter getIndexWriter() throws IOException {
        // 创建分词器
        Analyzer analyzer = new StandardAnalyzer();
        // 创建索引写入工具
        FSDirectory directory = FSDirectory.open(Paths.get("indexFile"));
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        return new IndexWriter(directory, indexWriterConfig);
    }

}
