package com.test;

import java.util.List;

import com.dao.DiaryDao;
import com.dbutil.DBconnection;
import com.model.Diary;

import android.test.AndroidTestCase;

/**
 * 
 * @author henry
 *	�������Android��������
 */
public class DaoTest extends AndroidTestCase {
	public void test() throws Exception {
        DBconnection.setContext(this.getContext());
		List<Diary> diaryList = DiaryDao.getDiaryList();
		for(Diary d : diaryList) {
			System.out.println(d.getTitle());
		}
	}
}
