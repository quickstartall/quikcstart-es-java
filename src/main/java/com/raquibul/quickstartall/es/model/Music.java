package com.raquibul.quickstartall.es.model;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import io.searchbox.annotations.JestId;

public class Music {
	private String name;
	private Date year;
	private String lyrics;
	
	@JestId
	private String documentId;
	
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getYear() {
		return year;
	}
	public void setYear(Date year) {
		this.year = year;
	}
	public String getLyrics() {
		return lyrics;
	}
	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}
	
	@Override
	public String toString() {
		//System.out.println(ToStringBuilder.reflectionToString(this));
		return ToStringBuilder.reflectionToString(this);
	}
}
