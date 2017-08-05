package com.tian.cola.dao.article;

import java.util.List;
import com.tian.cola.dto.article.ArticleDTO;
/**
 *@author 田超哲
 *@date 2016年4月4日上午11:13:49
 *@功能:
 */
public interface ArticleDAO {
	public List<ArticleDTO> getAllArticle();
//	获取所有文章，包括用户信息
	public List<ArticleDTO> getArticleInfo();
	
	public ArticleDTO getArticleById(String sql,String id);
	
	public int insertArticle(String sql,ArticleDTO article);

	public int deleteArticleById(String sql,String id);
}
