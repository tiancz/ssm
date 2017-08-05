package com.tian.cola.service.article;

import java.util.List;

import com.tian.cola.dto.article.TechArticleDTO;
/**
 *@author 田超哲
 *@date 2016年4月4日上午11:30:34
 *@功能:
 */
public interface TechArticleService {
	
	public List<TechArticleDTO> getAllArticle();
//	获取文章，包括用户信息
	public List<TechArticleDTO> getArticleInfo();
//	写一篇文章
	public TechArticleDTO insertArticle(TechArticleDTO article);
	
	public int deleteArticleById(String id);

	public TechArticleDTO getArticleById(String id);
}
