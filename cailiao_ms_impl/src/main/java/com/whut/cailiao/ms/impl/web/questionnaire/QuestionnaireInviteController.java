package com.whut.cailiao.ms.impl.web.questionnaire;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whut.cailiao.ms.impl.web.BaseController;

@Controller
@RequestMapping("/wjInvite")
public class QuestionnaireInviteController extends BaseController {
	@RequestMapping(value = "/create.html",method = RequestMethod.GET)
	public String navigateToCreateNEWQJYQ() {
		return "wjInvite/create";
	}
	
	@RequestMapping(value = "/list.html",method = RequestMethod.GET)
	public String navigateToListPage() {
		return "wjInvite/list";
	}
}
