package com.tian.cola.dto.article;

/**
 * <p>Title:ArticleDTO</p>
 * <p>Description:</p>
 * @author tianchaozhe665
 * @Email nathanieltian@163.com
 * @date 2016年4月3日下午10:29:32
 **/
public class TechArticleDTO {
	private String articleId;
	private String articleTitle;
	private String articleContent;
	private String dateCreated;
	private String dateUpdated;
	private String userId;
	private String userName;
	private String planguage;
	private String tag;
	private String countComment;
	
	public String getCountComment() {
		return countComment;
	}
	public void setCountComment(String countComment) {
		this.countComment = countComment;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPlanguage() {
		return planguage;
	}
	public void setPlanguage(String planguage) {
		this.planguage = planguage;
	}
	@Override
	public String toString() {
		return "TechArticleDTO [articleId=" + articleId + ", articleTitle=" + articleTitle + ", articleContent="
				+ articleContent + ", dateCreated=" + dateCreated + ", dateUpdated=" + dateUpdated + ", userId="
				+ userId + ", userName=" + userName + ", planguage=" + planguage + ", tag=" + tag + ", countComment="
				+ countComment + "]";
	}
}
