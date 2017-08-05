package com.tian.cola.service.category;

import java.util.List;
import com.tian.cola.dto.article.CategoryDTO;
import com.tian.cola.dto.article.TagDTO;
/**
 *@author 田超哲
 *@date 2016年4月4日上午11:34:21
 *@功能:
 */
public interface CategoryService {
	public List<CategoryDTO> getAllCategory();
	
	public List<CategoryDTO> getCategoryIdByName(String sql,String categoryNames);

	public List<TagDTO> getTagIdByName(String sql,String tagNames);

	public List<TagDTO> getAllTag();
}
