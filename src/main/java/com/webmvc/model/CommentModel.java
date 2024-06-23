package com.webmvc.model;

public class CommentModel extends AbstractModel<CommentModel> {
     
    private long userId;

    private long newsId;

    private String content;

    private String code;
    
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getNewsId() {
		return this.newsId;
	}

	public void setNewsId(long newsId) {
		this.newsId = newsId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
