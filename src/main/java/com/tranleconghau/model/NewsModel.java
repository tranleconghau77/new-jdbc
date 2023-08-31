package com.tranleconghau.model;

public class NewsModel extends AbstractModel {
	
	private String title;
	private String thumbnail;
	private String shortdecription;
	private String content;
	private long categoryid;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortdecription() {
		return shortdecription;
	}
	public void setShortdecription(String shortdecription) {
		this.shortdecription = shortdecription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}
	
	
	
}
