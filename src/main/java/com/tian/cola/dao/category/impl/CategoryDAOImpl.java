package com.tian.cola.dao.category.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tian.cola.dao.BaseDAO;
import com.tian.cola.dao.category.CategoryDAO;
import com.tian.cola.dto.article.CategoryDTO;
import com.tian.cola.dto.article.TagDTO;

/**
 *@author 田超哲
 *@date 2016年4月4日上午11:26:23
 *@功能:
 */
@Repository("categoryDao")
public class CategoryDAOImpl extends BaseDAO implements CategoryDAO {

	@Override
	public List<CategoryDTO> getAllCategory() {
		List<CategoryDTO> lists = new ArrayList<>();
		lists = CDUtil().selectList("getCategorys");
		return lists;
	}

	@Override
	public List<CategoryDTO> getCategoryIdByName(String sql, String categoryNames) {
		List<CategoryDTO> lists = new ArrayList<>();
		lists = CDUtil().selectList(sql, categoryNames);
		return lists;
	}
	
	@Override
	public List<TagDTO> getTagIdByName(String sql, String tagNames) {
		List<TagDTO> lists = new ArrayList<>();
		lists = CDUtil().selectList(sql, tagNames);
		return lists;
	}
	@Override
	public List<TagDTO> getAllTag() {
		List<TagDTO> lists = new ArrayList<>();
		lists = CDUtil().selectList("getTags");
		return lists;
	}

}
