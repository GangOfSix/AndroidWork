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
	 * 这是构造方法，方便实例化对象时传递参数。
	 * @param mood 心情
	 * @param weather 天气
	 * @param title 标题
	 * @param content 内容
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
	 * 这是构造方法，方便从数据库中取数据时传递参数。
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
