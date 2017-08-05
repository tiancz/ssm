package com.tian.cola.controller.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tian.cola.service.article.ArticleService;

/**
 *@author 田超哲
 *@date 2016年4月21日下午11:07:44
 *@功能:
 */
@Controller
@RequestMapping("/movie")
public class MovieController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	@Qualifier("articleService")
	private ArticleService articleService;
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping("/movie")
	public String movie(Model model){
		String result = "movie/movie";
//		String result = "note/finishNote";
		LOGGER.info("start movie controller");
//		ArticleDTO article = new ArticleDTO();
//		article = articleService.getArticleById("14612562804729");
//		model.addAttribute("note", article);
		return result;
	}

}
