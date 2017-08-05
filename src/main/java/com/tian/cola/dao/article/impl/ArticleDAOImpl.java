package com.tian.cola.dao.article.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tian.cola.dao.BaseDAO;
import com.tian.cola.dao.article.ArticleDAO;
import com.tian.cola.dto.article.ArticleDTO;

/**
 *@author 田超哲
 *@date 2016年4月4日上午11:17:26
 *@功能:
 */
@Repository("articleDao")
public class ArticleDAOImpl extends BaseDAO implements ArticleDAO {
	
	@Override
	public List<ArticleDTO> getAllArticle() {
		List<ArticleDTO> articles = new ArrayList<>();
		articles = CDUtil().selectList("getBlogs");
		return articles;
	}
	@Override
	public List<ArticleDTO> getArticleInfo() {
		List<ArticleDTO> articles = new ArrayList<>();
		articles = CDUtil().selectList("getBlogsUser");
		return articles;
	}

	@Override
	public int insertArticle(String sql, ArticleDTO article) {
		return CDUtil().insert(sql, article);
	}

	@Override
	public ArticleDTO getArticleById(String sql,String id) {
		ArticleDTO article = new ArticleDTO();
		article = CDUtil().selectOne(sql,id);
		return article;
	}
	
	public int deleteArticleById(String sql,String id){
		return CDUtil().delete(sql, id);
	}

}
