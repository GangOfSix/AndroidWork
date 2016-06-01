package com.dbutil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBconnection extends SQLiteOpenHelper {
	private final static int DATABASE_VERSION = 1;// 数据库版本号
	private final static String DATABASE_NAME = "diary.db";// 数据库名

	private static Context context;

	public static void setContext(Context context) {
		DBconnection.context = context;
	}

	public DBconnection() {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public void onCreate(SQLiteDatabase db) {
		String sql = "create table diary(" + "id integer primary key autoincrement,"
				+ "date date,"
				+ "mood varchar(5),"
				+ "weather varchar(8),"
				+ "title varchar(10),"
				+ "content text,"
				+ "lastupdate date;";
		db.execSQL(sql);
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

	public SQLiteDatabase getConnection() {
		SQLiteDatabase db = getWritableDatabase();
		return db;
	}

	public void close(SQLiteDatabase db) {
		db.close();
	}

}
