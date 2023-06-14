package com.nttdata.training.domain;

public class Article {
	
	private String Institute_Name;
	private String Article_Title;
	private String Article_Text;
	
	public Article(String institute_Name, String article_Title, String article_Text) {
		super();
		Institute_Name = institute_Name;
		Article_Title = article_Title;
		Article_Text = article_Text;
	}
	public String getInstitute_Name() {
		return Institute_Name;
	}
	public void setInstitute_Name(String institute_Name) {
		Institute_Name = institute_Name;
	}
	public String getArticle_Title() {
		return Article_Title;
	}
	public void setArticle_Title(String article_Title) {
		Article_Title = article_Title;
	}
	public String getArticle_Text() {
		return Article_Text;
	}
	public void setArticle_Text(String article_Text) {
		Article_Text = article_Text;
	}
	@Override
	public String toString() {
		return "Article [Institute_Name=" + Institute_Name + ", Article_Title=" + Article_Title + ", Article_Text="
				+ Article_Text + "]";
	}
	

}
