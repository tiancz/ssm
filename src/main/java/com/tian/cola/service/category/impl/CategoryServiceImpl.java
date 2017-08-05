package com.tian.cola.service.category.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.tian.cola.dao.category.CategoryDAO;
import com.tian.cola.dto.article.CategoryDTO;
import com.tian.cola.dto.article.TagDTO;
import com.tian.cola.service.category.CategoryService;

/**
 *@author 田超哲
 *@date 2016年4月4日上午11:36:17
 *@功能:
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	@Qualifier("categoryDao")
	private CategoryDAO categoryDao;
	
	public void setCategoryDao(CategoryDAO categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		return categoryDao.getAllCategory();
	}

	@Override
	public List<CategoryDTO> getCategoryIdByName(String sql,String categoryNames) {
		return categoryDao.getCategoryIdByName(sql, categoryNames);
	}
	@Override
	public List<TagDTO> getTagIdByName(String sql,String tagNames) {
		return categoryDao.getTagIdByName(sql, tagNames);
	}

	@Override
	public List<TagDTO> getAllTag() {
		return categoryDao.getAllTag();
	}

}
