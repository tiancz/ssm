package com.tian.cola.dto.article;

import java.util.Date;

/**
 *@author 田超哲
 *@date 2016年4月17日上午11:50:07
 *@功能:
 */
public class TagDTO {
	private String tagId;
	private String tagName;
	private Date tagDate;
	public String getTagId() {
		return tagId;
	}
	public void setTagId(String tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public Date getTagDate() {
		return tagDate;
	}
	public void setTagDate(Date tagDate) {
		this.tagDate = tagDate;
	}
}
