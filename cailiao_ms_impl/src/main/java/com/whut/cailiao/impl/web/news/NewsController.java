package com.whut.cailiao.impl.web.news;

import com.whut.cailiao.api.commons.ApiResponse;
import com.whut.cailiao.api.service.news.NewsService;
import com.whut.cailiao.impl.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by gammaniu on 16/4/16.
 */
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public String navigateToListPage() {
        return "news/list";
    }

    @RequestMapping(value = "/getNewsList.html", method = RequestMethod.GET)
    @ResponseBody
    public String getNewsList() {
        ApiResponse response = this.newsService.getNewsList();
        return convertApiResponseToJSONString(response);
    }

}
