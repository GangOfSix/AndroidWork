package com.test;

import java.util.List;

import org.junit.Test;

import com.dao.DiaryDao;
import com.model.Diary;

public class DiaryDaoTest {
	@Test
	public void testGetDiaryList() throws Exception {
		List<Diary> diaryList = DiaryDao.getDiaryList();
		for(Diary d : diaryList) {
			System.out.println(d.getTitle());
		}
	}
}
