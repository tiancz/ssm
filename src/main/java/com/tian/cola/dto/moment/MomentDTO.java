package com.tian.cola.dto.moment;

public class MomentDTO {
	private String idMoment;
	private String momentContent;
	private String userId;
	private String createdBy;
	private String dateCreated;
	private String updatedBy;
	private String dateUpdated;
	public String getIdMoment() {
		return idMoment;
	}
	public void setIdMoment(String idMoment) {
		this.idMoment = idMoment;
	}
	public String getMomentContent() {
		return momentContent;
	}
	public void setMomentContent(String momentContent) {
		this.momentContent = momentContent;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(String dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	@Override
	public String toString() {
		return "MomentDTO [idMoment=" + idMoment + ", momentContent=" + momentContent + ", userId="
				+ userId + ", createdBy=" + createdBy
				+ ", dateCreated=" + dateCreated + ", updatedBy=" + updatedBy + ", dateUpdated=" + dateUpdated + "]";
	}
	
}
