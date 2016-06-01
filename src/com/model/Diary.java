package com.model;

import java.util.Date;

public class Diary {
	private int id;
	private Date date;
	private String mood;
	private String weather;
	private String title;
	private String content;
	private Date lastUpdate;
	
	
	/**
	 * ���ǹ��췽��������ʵ��������ʱ���ݲ�����
	 * @param mood ����
	 * @param weather ����
	 * @param title ����
	 * @param content ����
	 */
	public Diary(String mood, String weather, String title,
			String content) {
		super();
		this.mood = mood;
		this.weather = weather;
		this.title = title;
		this.content = content;
	}
	
	/**
	 * ���ǹ��췽������������ݿ���ȡ����ʱ���ݲ�����
	 * @param id
	 * @param date
	 * @param mood
	 * @param weather
	 * @param title
	 * @param content
	 * @param lastupdate
	 */
	public Diary(int id, Date date, String mood, String weather, String title,
			String content, Date lastupdate) {
		super();
		this.id = id;
		this.date = date;
		this.mood = mood;
		this.weather = weather;
		this.title = title;
		this.content = content;
		this.lastUpdate = lastupdate;
	}

	public Diary() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMood() {
		return mood;
	}
	public void setMood(String mood) {
		this.mood = mood;
	}
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastupdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
}
