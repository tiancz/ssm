package com.tian.cola.controller.music;

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
 *@date 2016年5月12日下午10:20:11
 *@功能:
 */
@Controller
@RequestMapping("/music")
public class MusicController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MusicController.class);
	@Autowired
	@Qualifier("articleService")
	private ArticleService articleService;
	
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping("/music")
	public String movie(Model model){
		String result = "music/music";
		LOGGER.info("start music controller");

		return result;
	}
}
