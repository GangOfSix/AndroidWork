package com.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.dbutil.DBconnection;
import com.model.Diary;

public class DiaryDao {

	private static DBconnection connection;
	private static SQLiteDatabase db;
	
	private DiaryDao() {
	}
	
	static {
		connection = new DBconnection();
		db = connection.getConnection();
	}
	
	
	public  static List<Diary> getDiaryList() throws Exception {
			List<Diary> diaryList = new ArrayList<Diary>();
			Cursor cur = db.query("Diary", null, null, null, null, null, null);
			while (cur.moveToNext()) {
				int id = cur.getColumnIndex("id");
				
				String dateStr = cur.getString(cur.getColumnIndex("date"));
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
				Date date = format.parse(dateStr);
				String mood = cur.getString(cur.getColumnIndex("mood"));
				String weather = cur.getString(cur.getColumnIndex("weather"));
				String title = cur.getString(cur.getColumnIndex("title"));
				String content = cur.getString(cur.getColumnIndex("price"));
				
				String lastUpdateStr = cur.getString(cur.getColumnIndex("date"));
				Date lastUpdate = format.parse(lastUpdateStr);
				Diary Diary = new Diary(id, date, mood, weather, title, content, lastUpdate);
				
				diaryList.add(Diary);
				cur.moveToNext();
			}
			connection.close(db);
			return diaryList;
	}
	
	/**
	 * ≤È’“id
	 * 
	 * @param Diaryid
	 * @return
	 */
	private boolean checkId(String Diaryid) {
		
		return false;
	}


/*	public boolean insert(Diary Diary) {

		if (checkId(Diary.getId())) {
			return false;
		} else {
			Diarylist.add(Diary);
			String id = Diary.getId();
			String name = Diary.getName();
			String price = Diary.getPrice();
			DBconnection connection = new DBconnection();
			SQLiteDatabase db = connection.getConnection();
			String sql = "INSERT INTO Diary(id,name,price)" + "VALUES('" + id
					+ "','" + name + "','" + price + "')";
			db.execSQL(sql);
			db.close();
			return true;
		}
	}

	public  boolean delete(String name) {
		if (checkName(name)) {
			DBconnection connection = new DBconnection();
			SQLiteDatabase db = connection.getConnection();
			String sql = "DELETE FROM Diary WHERE name='" + name + "'";
			db.execSQL(sql);
			return true;
		} else {
			return false;
		}
	}

	public  boolean set(Diary Diary) {
		if (checkId(Diary.getId())) {
			String id = Diary.getId();
			String name = Diary.getName();
			String price = Diary.getPrice();
			int index = getIndex(id);
			Diarylist.set(index, Diary);
			DBconnection connection = new DBconnection();
			SQLiteDatabase db = connection.getConnection();
			String sql = "UPDATE Diary SET name='" + name + "'," + "price='"
					+ price + "' WHERE id='" + id + "'";
			db.execSQL(sql);
			return true;
		} else {
			return false;
		}
	}*/
}
