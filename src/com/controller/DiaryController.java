package com.controller;

import java.util.Date;
import java.util.List;

import com.dao.DiaryDao;
import com.model.Diary;

public class DiaryController {
	/*
	 * ���Բ鿴�����ռ�
	 */
	public List<Diary> getDiaryList(){
		return DiaryDao.getDiaryList();
	}
	/*
	 * ���Բ���
	 */
	public boolean insert(Date date,String mood,String weather,String title,String content,Date lastUpdate){
		Diary diary = new Diary(date,mood,weather,title,content,lastUpdate);
		if(DiaryDao.insert(diary))
			return true;
		else
			return false;
	}
	/*
	 * ���Բ鿴
	 */
	public List<Diary> select(String diaryTitle){
		return DiaryDao.get(diaryTitle);	
	}
	/*
	 * ����ɾ��
	 */
	public boolean delete(int id){
		if(DiaryDao.delete(id))
			return true;
		else
			return false;
	}
	/*
	 * ����ɾ��
	 */
	public boolean delete(Diary diary){
		if(DiaryDao.delete(diary))
			return true;
		else
			return false;
	}
	/*
	 * ���Ը���
	 */
	public boolean update(Diary diary){
		if(DiaryDao.set(diary))
			return true;
		else
			return false;
	}
}
