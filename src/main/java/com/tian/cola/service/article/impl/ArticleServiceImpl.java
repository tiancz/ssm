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

import com.tian.cola.dao.article.ArticleDAO;
import com.tian.cola.dto.article.ArticleDTO;
import com.tian.cola.dto.article.TagDTO;
import com.tian.cola.service.article.ArticleService;
import com.tian.cola.service.category.CategoryService;
import com.tian.cola.service.user.UserService;

/**
 *@author 田超哲
 *@date 2016年4月4日上午11:32:15
 *@功能:
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	private final static Logger LOGGER = LoggerFactory.getLogger(ArticleServiceImpl.class); 
	
	@Autowired
	@Qualifier("articleDao")
	private ArticleDAO articleDao;

	@Autowired
	@Qualifier("categoryService")
	private CategoryService categoryService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	public void setArticleDao(ArticleDAO articleDao) {
		this.articleDao = articleDao;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Override
	public List<ArticleDTO> getAllArticle() {
		List<ArticleDTO> articles = articleDao.getAllArticle();
		List<ArticleDTO> result = new ArrayList<>(); 
		for (ArticleDTO articleDTO : articles) {
			articleDTO.setArticleTitle(unPaserContent(articleDTO.getArticleTitle()));
			articleDTO.setArticleContent(unPaserContent(articleDTO.getArticleContent()));
			result.add(articleDTO);
		}
		return result;
	}
	@Override
	public List<ArticleDTO> getArticleInfo() {
		return articleDao.getArticleInfo();
	}

	@Override
	public ArticleDTO insertArticle(ArticleDTO article) {
		Date d = new Date();
		Random r = new Random();
		ArticleDTO resultArticle = new ArticleDTO();
		
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
		article.setCategoryId("00014");
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
		
		List<TagDTO> tagIds = categoryService.getTagIdByName("getTagIdByTagsName", article.getTag());
		String tagId = "";
		for (TagDTO tagDTO : tagIds) {
			tagId += tagDTO.getTagId();
		}
		for(int i=0;i<tagIds.size();i++){
			if(tagIds.size()==1){
				tagId = tagIds.get(0).getTagId();
			}else if(i==0){
				tagId = tagIds.get(0).getTagId();
			}else{
				tagId = tagId+","+tagIds.get(i).getTagId();
			}
		}
		article.setTagId(tagId);
		
		int result = 0;
		result = articleDao.insertArticle("addArticle",article);
		if(result==0){
			LOGGER.info("insertArticle failure");
		}else{
			LOGGER.info("insert a Article");
		}
		resultArticle = articleDao.getArticleById("getArticleByID",article.getArticleId());
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
		result = articleDao.deleteArticleById("delteArticleByID", id);
		return result;
	}
	
	public ArticleDTO getArticleById(String id){
		ArticleDTO article = new ArticleDTO();
		article = articleDao.getArticleById("getArticleByID", id);
		return article;
	}
	
}
