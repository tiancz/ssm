package com.tian.cola.service.article;

import java.util.List;

import com.tian.cola.dto.article.ArticleDTO;
/**
 *@author 田超哲
 *@date 2016年4月4日上午11:30:34
 *@功能:
 */
public interface ArticleService {
	
	public List<ArticleDTO> getAllArticle();
//	获取文章，包括用户信息
	public List<ArticleDTO> getArticleInfo();
//	写一篇文章
	public ArticleDTO insertArticle(ArticleDTO article);
	
	public int deleteArticleById(String id);

	public ArticleDTO getArticleById(String id);
}
