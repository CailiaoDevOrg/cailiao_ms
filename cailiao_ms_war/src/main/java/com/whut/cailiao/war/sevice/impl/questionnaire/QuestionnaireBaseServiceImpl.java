
package com.whut.cailiao.war.sevice.impl.questionnaire;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.IntField;
import org.apache.lucene.document.StringField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whut.cailiao.api.model.questionnaire.Questionnaire;
import com.whut.cailiao.api.service.questionnaire.QuestionnaireBaseService;
import com.whut.cailiao.war.dao.questionnaire.QuestionnaireDao;
import com.whut.cailiao.war.utils.redis.RedisSupport;


@Service
public class QuestionnaireBaseServiceImpl extends RedisSupport implements QuestionnaireBaseService {
    
    @Autowired
    private QuestionnaireDao questionnaireDao;

    @Override
    public void saveQuestionnaire(Questionnaire questionnaire) {
        if (questionnaire == null) {
            return;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("name", questionnaire.getName());
        map.put("description", questionnaire.getDescription());
        map.put("createPerson", questionnaire.getCreatePerson());
        map.put("createTime", questionnaire.getCreateTime());
        map.put("modifyTime", questionnaire.getModifyTime());
        map.put("beginTime", questionnaire.getBeginTime());
        map.put("endTime", questionnaire.getEndTime());
        map.put("templateJspUrl", questionnaire.getTemplateJspUrl());
        map.put("status4Time", questionnaire.getStatus4Time());
        map.put("status4Op", questionnaire.getStatus4Op());
        this.questionnaireDao.insertNewQuestionnaire(map);
    }

    @Override
    public void updateQuestionnaire(Questionnaire questionnaire) {
        if (questionnaire == null || questionnaire.getId() <= 0) {
            return;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("id", questionnaire.getId());
        map.put("name", questionnaire.getName());
        this.questionnaireDao.updateQuestionnaireItem(map);
        String key = "questionnaire20160216_" + questionnaire.getId();
        deleteTestData(key);
    }

    @Override
    public void deleteQuestionnaireById(int id) {
        if (id <= 0) {
            return;
        }
        // delete from db
        this.questionnaireDao.deleteQuestionnaireById(id);
        // delete from cache
        String key = "questionnaire20160216_" + id;
        deleteTestData(key);
    }

    @Override
    public Questionnaire getQuestionnaireById(int id) {
        String key = "questionnaire20160216_" + id;
        Questionnaire questionnaire = (Questionnaire) getTestData(key);
        if (questionnaire == null) {
            questionnaire = this.questionnaireDao.selectQuestionnaireById(id);
            setTestData(key, questionnaire);
        }
        /**try {
            createIndex(questionnaire);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return questionnaire;
    }
    
    
    @SuppressWarnings("unused")
    private void createIndex(Questionnaire questionnaire) throws IOException {
        
        if (questionnaire == null) {
            return;
        }
        Analyzer analyzer = new StandardAnalyzer();
        Directory dir = new RAMDirectory();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        IndexWriter indexWriter = new IndexWriter(dir, indexWriterConfig);
        Document doc = new Document();
        doc.add(new IntField("id", questionnaire.getId(), Store.YES));
        doc.add(new StringField("name", questionnaire.getName() + " world", Store.YES));
        doc.add(new StringField("description", questionnaire.getDescription(), Store.YES));
        doc.add(new StringField("createPerson", questionnaire.getCreatePerson(), Store.YES));
        indexWriter.addDocument(doc);
        indexWriter.close();
        
        DirectoryReader ireader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(ireader);
        Term term = new Term("name", "hello");
        TermQuery query = new TermQuery(term);  
        TopDocs topdocs = searcher.search(query, 5);  
        ScoreDoc[] scoreDocs = topdocs.scoreDocs;
        
        for(int i=0; i < scoreDocs.length; i++) {  
            int d = scoreDocs[i].doc;  
            Document document = searcher.doc(d);  
            String name = document.get("name");
            System.out.println("name===="+name);  
        }  
        
        ireader.close();
        dir.close();
        
    }

}
