package com.whut.cailiao.search;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * 只提供搜索功能
 * 不提供创建索引的功能
 * 待测试
 * Created by niuyang on 16/3/8.
 */
public class Test {

    public static void main(String[] args) throws IOException {
        // 创建分词器
        Analyzer analyzer = new StandardAnalyzer();
        // 创建索引写入工具
        FSDirectory directory = FSDirectory.open(Paths.get("indexFile"));
        // Directory directory = new RAMDirectory();
        IndexWriterConfig indexWriterConfig = new IndexWriterConfig(analyzer);
        indexWriterConfig.setOpenMode(IndexWriterConfig.OpenMode.CREATE);
        IndexWriter indexWriter =  new IndexWriter(directory, indexWriterConfig);

        Document document = new Document();
        document.add(new StringField("id", "2", Field.Store.YES));
        document.add(new StringField("questionnaireTemplateId", "10", Field.Store.YES));
        document.add(new StringField("jsonContent", "hello", Field.Store.YES));
        indexWriter.addDocument(document);

        Document document2 = new Document();
        document2.add(new StringField("id", "1", Field.Store.YES));
        document2.add(new StringField("questionnaireTemplateId", "11", Field.Store.YES));
        document2.add(new StringField("jsonContent", "java", Field.Store.YES));
        indexWriter.addDocument(document2);

        indexWriter.close();

        IndexReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);

        BooleanQuery.Builder builder = new BooleanQuery.Builder();
        TermQuery idQuery = new TermQuery(new Term("id", "2"));
        TermQuery query = new TermQuery(new Term("questionnaireTemplateId", "11"));
        builder.add(idQuery, BooleanClause.Occur.MUST);
        builder.add(query, BooleanClause.Occur.MUST);
        BooleanQuery booleanQuery = builder.build();

       //TermQuery idQuery = new TermQuery(new Term("id", "1"));

        //Term term = new Term("id", "1");
        //TermQuery termQuery = new TermQuery(term);

        TopDocs topDocs = searcher.search(booleanQuery, 100);
        ScoreDoc[] scoreDocs = topDocs.scoreDocs;
        for (int i = 0; i < scoreDocs.length; i++) {
            int doc = scoreDocs[i].doc;
            Document dd = searcher.doc(doc);
            String content = dd.get("jsonContent");
            System.out.println("content = " + content);
        }
    }

}
