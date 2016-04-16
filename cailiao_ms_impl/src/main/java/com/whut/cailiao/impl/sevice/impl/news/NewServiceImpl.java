package com.whut.cailiao.impl.sevice.impl.news;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.commons.ApiResponseCode;
import com.whut.cailiao.api.model.news.News;
import com.whut.cailiao.api.service.news.NewsService;
import com.whut.cailiao.impl.dao.news.NewsDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

import static com.whut.cailiao.api.constant.NewsContant.Level;
import static com.whut.cailiao.api.constant.NewsContant.Status;

/**
 * Created by gammaniu on 16/4/15.
 */
@Service("newsService")
public class NewServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public ApiResponse getNewsList() {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        response.addBody("newsList", this.newsDao.getNewsList());
        return response;
    }

    @Override
    public ApiResponse getNewsDetail(int id) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (id <= 0) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        News news = this.newsDao.getNewsDetail(id);
        response.addBody("news", news);
        return response;
    }

    @Override
    public ApiResponse sendNews(News news) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        Timestamp publishedTime = new Timestamp(System.currentTimeMillis());
        if (news == null
                || news.getId() != null
                || news.getLevel() < Level.NORMAL.value()
                || news.getLevel() > Level.IMPORTANT.value()
                || StringUtils.isBlank(news.getTitle())
                || StringUtils.isBlank(news.getContent())
                || news.getBeginTime() == null
                || news.getEndTime() == null
                || news.getBeginTime().after(news.getEndTime())
                || publishedTime.after(news.getEndTime())) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        news.setStatus(Status.DISPLAY.value());
        news.setPublishedTime(publishedTime);
        this.newsDao.saveNews(news);
        return response;
    }

    @Override
    public ApiResponse deleteNews(int id) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (id <= 0) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        this.newsDao.deleteNews(id);
        return response;
    }

    @Override
    public ApiResponse getNewsFrontEndList(int topSize) {
        ApiResponse response = ApiResponse.createDefaultApiResponse();
        if (topSize <= 0) {
            response.setRetCode(ApiResponseCode.PARAM_ERROR);
            return response;
        }
        response.addBody("newsList", this.newsDao.getNewsListSortByLevel(topSize));
        return response;
    }
}
