package com.tian.cola.dao.article.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tian.cola.dao.BaseDAO;
import com.tian.cola.dao.article.TechArticleDAO;
import com.tian.cola.dto.article.ArticleDTO;
import com.tian.cola.dto.article.TechArticleDTO;

/**
 *@author 田超哲
 *@date 2016年4月4日上午11:17:26
 *@功能:
 */
@Repository("techArticleDao")
public class TechArticleDAOImpl extends BaseDAO implements TechArticleDAO {
	
	@Override
	public List<TechArticleDTO> getAllArticle() {
		List<TechArticleDTO> articles = new ArrayList<>();
		articles = CDUtil().selectList("getTechArticles");
		return articles;
	}
	@Override
	public List<TechArticleDTO> getArticleInfo() {
		List<TechArticleDTO> articles = new ArrayList<>();
		articles = CDUtil().selectList("getBlogsUser");
		return articles;
	}

	@Override
	public int insertArticle(String sql, TechArticleDTO article) {
		return CDUtil().insert(sql, article);
	}

	@Override
	public TechArticleDTO getArticleById(String sql,String id) {
		TechArticleDTO article = new TechArticleDTO();
		article = CDUtil().selectOne(sql,id);
		return article;
	}
	
	public int deleteArticleById(String sql,String id){
		return CDUtil().delete(sql, id);
	}

}
