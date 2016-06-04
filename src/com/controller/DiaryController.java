package com.controller;

import java.util.Date;
import java.util.List;

import com.dao.DiaryDao;
import com.model.Diary;

public class DiaryController {
	/*
	 * 测试查看所有日记
	 */
	public List<Diary> getDiaryList(){
		return DiaryDao.getDiaryList();
	}
	/*
	 * 测试插入
	 */
	public boolean insert(Date date,String mood,String weather,String title,String content,Date lastUpdate){
		Diary diary = new Diary(date,mood,weather,title,content,lastUpdate);
		if(DiaryDao.insert(diary))
			return true;
		else
			return false;
	}
	/*
	 * 测试查看
	 */
	public List<Diary> select(String diaryTitle){
		return DiaryDao.get(diaryTitle);	
	}
	/*
	 * 测试删除
	 */
	public boolean delete(int id){
		if(DiaryDao.delete(id))
			return true;
		else
			return false;
	}
	/*
	 * 测试删除
	 */
	public boolean delete(Diary diary){
		if(DiaryDao.delete(diary))
			return true;
		else
			return false;
	}
	/*
	 * 测试更新
	 */
	public boolean update(Diary diary){
		if(DiaryDao.set(diary))
			return true;
		else
			return false;
	}
}
