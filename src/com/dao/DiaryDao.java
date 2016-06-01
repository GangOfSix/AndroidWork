package com.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.dbutil.DBconnection;
import com.model.Diary;


/*
 * 对数据的增、删、改、查
 * 
 */
public class DiaryDao {
	
	private static DBconnection connection;
	private static SQLiteDatabase db;
	private static SimpleDateFormat format; 
	
	private DiaryDao() {
	}
	
	static {
		connection = new DBconnection();
		
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	}
	
	/*
	 * 得到所有日记
	 * 
	 */
	public  static List<Diary> getDiaryList(){
			db = connection.getConnection();
			List<Diary> diaryList = new ArrayList<Diary>();
			Cursor cur = db.query("Diary", null, null, null, null, null, null);
			
			while (cur.moveToNext()) {
				try {
					int id = cur.getColumnIndex("id");
					
					String dateStr = cur.getString(cur.getColumnIndex("date"));
					Date date = format.parse(dateStr);
					String mood = cur.getString(cur.getColumnIndex("mood"));
					String weather = cur.getString(cur.getColumnIndex("weather"));
					String title = cur.getString(cur.getColumnIndex("title"));
					String content = cur.getString(cur.getColumnIndex("content"));
					
					String lastUpdateStr = cur.getString(cur.getColumnIndex("date"));
					Date lastUpdate = format.parse(lastUpdateStr);
					
					Diary diary = new Diary(id, date, mood, weather, title, content, lastUpdate);
					
					diaryList.add(diary);
				
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}
			cur.close();
			db.close();
			return diaryList;
	}
	
	/**
	 * 根据id查找日记
	 * 
	 * @author 子桦
	 * @param diaryId
	 * @return Diary
	 * @throws ParseException 
	 */
	public static Diary get(int diaryId){
		db = connection.getConnection();
		Cursor cur = db.rawQuery("select * from diary where id=?",
				new String[]{Integer.toString(diaryId)});
		try {
			if(cur.moveToNext()){
			
				int id = cur.getColumnIndex("id");
				
				String dateStr = cur.getString(cur.getColumnIndex("date"));
				Date date = format.parse(dateStr);
				
				String mood = cur.getString(cur.getColumnIndex("mood"));
				String weather = cur.getString(cur.getColumnIndex("weather"));
				String title = cur.getString(cur.getColumnIndex("title"));
				String content = cur.getString(cur.getColumnIndex("content"));
				
				String lastUpdateStr = cur.getString(cur.getColumnIndex("date"));
				Date lastUpdate = format.parse(lastUpdateStr);
				Diary Diary = new Diary(id, date, mood, weather, title, content, lastUpdate);
				
				return Diary;
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}finally{
				cur.close();
				db.close();
			}
		return null;
	}

	/**
	 * 根据标题查找日记
	 * 
	 * @author 子桦
	 * @param diaryTitle
	 * @return List
	 */
	public static List<Diary> get(String diaryTitle){
		db = connection.getConnection();
		Cursor cur = db.rawQuery("select * from diary where title like ?",
				new String[]{diaryTitle});
		List<Diary> diaryList = new ArrayList<Diary>();
		try {
			while(cur.moveToNext()){
				int id = cur.getColumnIndex("id");
				
				String dateStr = cur.getString(cur.getColumnIndex("date"));
				Date date = format.parse(dateStr);
				
				String mood = cur.getString(cur.getColumnIndex("mood"));
				String weather = cur.getString(cur.getColumnIndex("weather"));
				String title = cur.getString(cur.getColumnIndex("title"));
				String content = cur.getString(cur.getColumnIndex("content"));
				
				String lastUpdateStr = cur.getString(cur.getColumnIndex("date"));
				Date lastUpdate = format.parse(lastUpdateStr);
				Diary diary = new Diary(id, date, mood, weather, title, content, lastUpdate);
				
				diaryList.add(diary);
			}
			
		} catch (ParseException e) {
				e.printStackTrace();
			}finally{
				cur.close();
				db.close();
			}
		return diaryList;
	}
	
	/**
	 * 根据日期查找日记
	 * 
	 * @author 子桦
	 * @param diaryDate
	 * @return List
	 */
	public static List<Diary> get(Date diaryDate){
		db = connection.getConnection();
		List<Diary> diaryList = new ArrayList<Diary>();
		Cursor cur = db.rawQuery("select * from diary where date like ?",
				new String[]{format.format(diaryDate)});
		try {
			while(cur.moveToNext()){
				int id = cur.getColumnIndex("id");
				
				String dateStr = cur.getString(cur.getColumnIndex("date"));
				Date date = format.parse(dateStr);
				
				String mood = cur.getString(cur.getColumnIndex("mood"));
				String weather = cur.getString(cur.getColumnIndex("weather"));
				String title = cur.getString(cur.getColumnIndex("title"));
				String content = cur.getString(cur.getColumnIndex("content"));
				
				String lastUpdateStr = cur.getString(cur.getColumnIndex("date"));
				Date lastUpdate = format.parse(lastUpdateStr);
				Diary diary = new Diary(id, date, mood, weather, title, content, lastUpdate);
				
				diaryList.add(diary);
			
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}finally{
			cur.close();
			db.close();
		}
		return diaryList;
	}
	
	/**
	 * 往数据库添加一条日记记录
	 * 
	 * @author 子桦
	 * @param diary
	 * @return boolean
	 * 
	 */
	public static boolean insert(Diary diary) {
		if(get(diary.getId()) != null)
			return false;
		else{
			db = connection.getConnection();
			String date = format.format(diary.getDate());
			String mood = diary.getMood();
			String weather = diary.getMood();
			String title = diary.getTitle();
			String content = diary.getContent();
			String lastUpdate = format.format(diary.getLastUpdate());
			
			String sql = "INSERT INTO diary( date, mood, weather, title, content, lastupdate)" 
					+ "VALUES('" + date + "','" + mood + "','"+ weather + "','" 
					+ title + "','" + content + "','" + lastUpdate + "')";
			
			db.execSQL(sql);
			
			db.close();
			return true;
		}
	}
	
	/**
	 * 根据id删除一条日记记录
	 * 
	 * @author 子桦
	 * @param diaryId
	 * @return boolean
	 * 
	 */
	public static  boolean delete(int diaryId) {
		if (get(diaryId) != null) {
			db = connection.getConnection();
			String sql = "DELETE FROM diary WHERE id='" + diaryId + "'";
			db.execSQL(sql);
			db.close();
			return true;
		} else {
			return false;
		}
	}

	public static  boolean delete(Diary diary) {
		if (get(diary.getId()) != null) {
			db = connection.getConnection();
			String sql = "DELETE FROM diary WHERE id='" + diary.getId() + "'";
			db.execSQL(sql);
			db.close();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 更新一条日记记录
	 * 
	 * @author 子桦
	 * @param diary
	 * @return boolean
	 * 
	 */
	public static boolean set(Diary diary) {
		if (get(diary.getId()) != null) {
			db = connection.getConnection();
			
			String mood = diary.getMood();
			String weather = diary.getMood();
			String title = diary.getTitle();
			String content = diary.getContent();
			String lastUpdate = format.format(diary.getLastUpdate());
			
			String sql = "UPDATE diary SET mood='" + mood + "',weather='"+ weather + "',title='" 
					+ title + "',content='" + content + "',lastUpdate='" + lastUpdate + "' WHERE id='" + diary.getId() + "'";
			db.execSQL(sql);
			db.close();
			return true;
		} else {
			return false;
		}
	}
}
