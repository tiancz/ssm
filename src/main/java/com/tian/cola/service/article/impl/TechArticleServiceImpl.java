package com.tian.cola.service.article.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tian.cola.dao.article.TechArticleDAO;
import com.tian.cola.dto.article.TechArticleDTO;
import com.tian.cola.service.article.TechArticleService;
import com.tian.cola.service.user.UserService;

/**
 *@author 田超哲
 *@date 2016年4月4日上午11:32:15
 *@功能:
 */
@Service("techArticleService")
public class TechArticleServiceImpl implements TechArticleService {

	private final static Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class); 
	
	@Autowired
	@Qualifier("techArticleDao")
	private TechArticleDAO techArticleDao;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	public void setTechArticleDao(TechArticleDAO techArticleDao) {
		this.techArticleDao = techArticleDao;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public List<TechArticleDTO> getAllArticle() {
		List<TechArticleDTO> articles = techArticleDao.getAllArticle();
		List<TechArticleDTO> result = new ArrayList<>(); 
		for (TechArticleDTO articleDTO : articles) {
			articleDTO.setArticleTitle(unPaserContent(articleDTO.getArticleTitle()));
			articleDTO.setArticleContent(unPaserContent(articleDTO.getArticleContent()));
			result.add(articleDTO);
		}
		return result;
	}
	@Override
	public List<TechArticleDTO> getArticleInfo() {
		return techArticleDao.getArticleInfo();
	}

	@Override
	public TechArticleDTO insertArticle(TechArticleDTO article) {
		Date d = new Date();
		Random r = new Random();
		TechArticleDTO resultArticle = new TechArticleDTO();
		
		article.setArticleTitle(unPaserContent(article.getArticleTitle()));
		article.setArticleContent(paserContent(article.getArticleContent()));
//		article.setCategory(tags);
		article.setArticleId(d.getTime()+""+r.nextInt(10));
		article.setUserId("00001");
//		yyyy-MM-dd HH:mm:ss
		article.setDateCreated(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
		article.setDateUpdated(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
//		String categoryId = categoryService.getCategoryIdByName("getCategoryIdByName",article.getCategory());
//		List<CategoryDTO> categoryId = categoryService.getCategoryIdByName("getCategoryIdByName",article.getCategory());
		article.setPlanguage("00014");
//		article.setCategoryId(categoryId);
//		resInt = articleService.insertArticle("addArticle", article);
		String tags = article.getTag();
		if(tags.split(",").length==1){
			tags = "'"+tags+"'";
		}else{
			tags = "'"+tags+"'";
			tags = tags.replace(",", "','");
		}
		article.setTag(tags);
		
		int result = 0;
		result = techArticleDao.insertArticle("addArticle",article);
		if(result==0){
			LOGGER.info("insertArticle failure");
		}else{
			LOGGER.info("insert a Article");
		}
		resultArticle = techArticleDao.getArticleById("getArticleByID",article.getArticleId());
		resultArticle.setArticleContent(unPaserContent(resultArticle.getArticleContent()));
		resultArticle.setArticleTitle(unPaserContent(resultArticle.getArticleTitle()));
		return resultArticle;
	}
//	从html转换为text
//	'&lt;' --> '<'
//	'&gt;' --> '>'
//	'&nbsp;' --> ' '
	private String paserContent(String content){
		String result = "";
		content = content.replace("<p>", "&lt;p&gt;");
		content = content.replace("<br>", "&lt;br&gt;");
		content = content.replace("\n", "<br/>");
		content = content.replace(" ", "&nbsp;");
		content = content.replace("	", "&emsp;");
		content = content+"\n";
		result = content;
		return result;
	}
//	从text转换为html
	private String unPaserContent(String content){
		String result = "";
		content = content.replace("&lt;p&gt;", "<p>");
		content = content.replace("&lt;br&gt;", "<br>");
		content = content.replace("<br/>", "\n");
		content = content.replace("&nbsp;", " ");
		content = content.replace("&emsp;", "	");
//		content = content+"\n";
		result = content;
		return result;
	}

	public int deleteArticleById(String id){
		int result = 0;
		result = techArticleDao.deleteArticleById("delteArticleByID", id);
		return result;
	}
	
	public TechArticleDTO getArticleById(String id){
		TechArticleDTO article = new TechArticleDTO();
		article = techArticleDao.getArticleById("getArticleByID", id);
		return article;
	}
	
}
