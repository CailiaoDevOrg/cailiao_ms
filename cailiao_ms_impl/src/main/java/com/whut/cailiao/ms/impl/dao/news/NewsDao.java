package com.whut.cailiao.ms.impl.dao.news;

import com.whut.cailiao.ms.api.model.news.News;

import java.util.List;

/**
 * Created by gammaniu on 16/4/15.
 */
public interface NewsDao {

    /**
     * 获取新闻详情
     * @param id
     * @return
     */
    News getNewsDetail(int id);

    List<News> getNewsList();

    void saveNews(News news);

    void deleteNews(int id);

    List<News> getNewsListSortByLevel(int topSize);

    void updateNewsStatus(News news);

}
