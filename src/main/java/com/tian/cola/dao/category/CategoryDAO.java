package com.tian.cola.dao.category;

import java.util.List;
import com.tian.cola.dto.article.CategoryDTO;
import com.tian.cola.dto.article.TagDTO;

/**
 *@author 田超哲
 *@date 2016年4月4日上午11:24:11
 *@功能:
 */
public interface CategoryDAO {
	public List<CategoryDTO> getAllCategory();
	
	public List<CategoryDTO> getCategoryIdByName(String sql,String categoryNames);

	public List<TagDTO> getTagIdByName(String sql,String tagNames);

	public List<TagDTO> getAllTag();
}
