package com.tian.cola.dto.article;
/**
 *@author 田超哲
 *@date 2016年4月3日下午10:29:32
 *@功能:
 */
public class CategoryDTO {
	private String categoryId;
	private String categoryName;
	private String categoryDate;

	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDate() {
		return categoryDate;
	}
	public void setCategoryDate(String categoryDate) {
		this.categoryDate = categoryDate;
	}
	@Override
	public String toString() {
		return "CategoryId:"+categoryId+" "+"CategoryName:"+categoryName+" "
	+"CategoryDate:"+categoryDate;
	}
}
