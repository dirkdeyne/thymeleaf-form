package com.example;


import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;

public class FormData {
	
	@NotBlank(message = "cannot be empty")
	private String message;
	private boolean post;
	
	@AssertTrue(message = "you should accept this.")
	private boolean accept;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isPost() {
		return post;
	}
	public void setPost(boolean post) {
		this.post = post;
	}
	public boolean isAccept() {
		return accept;
	}
	public void setAccept(boolean accept) {
		this.accept = accept;
	}
	@Override
	public String toString() {
		return "FormData [message=" + message + ", post=" + post + ", accept=" + accept + "]";
	}
	
}
