package com.controller;

import java.util.List;

import com.dao.DiaryDao;
import com.model.Diary;

public class DiaryController {
	
	public List<Diary> getDiaryList(){
		return DiaryDao.getDiaryList();
	}
}
