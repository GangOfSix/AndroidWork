package com.test;

import java.util.Date;
import java.util.List;

import com.dao.DiaryDao;
import com.dbutil.DBconnection;
import com.model.Diary;

import android.test.AndroidTestCase;

/**
 * 
 * @author henry
 *	这个类是Android测试用例
 */
public class DaoTest extends AndroidTestCase {
	public void test() throws Exception {
        DBconnection.setContext(this.getContext());
        
/*		List<Diary> diaryList = DiaryDao.getDiaryList();
		for(Diary d : diaryList) {
			System.out.println(d.getTitle());
		}*/
        Date diaryDate = new Date();
        Diary diary = new Diary(1,diaryDate, "", "", "",
    			"", diaryDate);
       DiaryDao.insert(diary);
       DiaryDao.set(diary);
       diary = DiaryDao.get(diaryDate).get(0);
       DiaryDao.get("");
        
        DiaryDao.delete(diary);
	}
}
