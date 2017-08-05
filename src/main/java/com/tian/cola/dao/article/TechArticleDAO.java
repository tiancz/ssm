package com.tian.cola.dao.article;

import java.util.List;

import com.tian.cola.dto.article.TechArticleDTO;
/**
 *@author 田超哲
 *@date 2016年4月4日上午11:13:49
 *@功能:
 */
public interface TechArticleDAO {
	public List<TechArticleDTO> getAllArticle();
//	获取所有文章，包括用户信息
	public List<TechArticleDTO> getArticleInfo();
	
	public TechArticleDTO getArticleById(String sql,String id);
	
	public int insertArticle(String sql,TechArticleDTO article);

	public int deleteArticleById(String sql,String id);
}
