package com.diary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.controller.DiaryController;
import com.dbutil.DBconnection;
import com.model.Diary;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity {

	private List<Diary> diaryList = new ArrayList<Diary>();

	TextView tv1;
	TextView tv2;
	ListView listView;
	Button createButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DBconnection.setContext(this.getApplicationContext());
		setContentView(R.layout.fragment_main);

		/*
		 * Fuction:Button OnClick event Button:
		 * fragment_main.xml.frag_create_button
		 */
		Create_button_onClick();

		// 初始化一个Diary用以测试
		initialize();

		/*
		 * Fuction:listView OnItemClick 事件 
		 * Button: fragment_main.xml.listView
		 */
		listView_touch_action();

	}

	/*
	 * Fuction:listView OnItemClick 事件
	 * Button: fragment_main.xml.listView
	 */
	public void listView_touch_action() {
		DiaryAdapter adapter = new DiaryAdapter(MainActivity.this,
				R.layout.listview_item, diaryList);
		listView = (ListView) findViewById(R.id.listView1);
		listView.setAdapter(adapter);
		// List 单个Item 点击事件
		listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Diary diary = diaryList.get(position);

				final Dialog d = new Dialog(MainActivity.this);
				d.setTitle("Date");
				d.setContentView(R.layout.detail);
				// deail.xml页面中设置 editText detailxml_moon内容
				tv1 = (TextView) d.findViewById(R.id.detailxml_date);
				// 日期格式诡异 先这样转换一下 之后可以考虑单例模式 new java.text.SimpleDateFormat
				tv1.setText(new java.text.SimpleDateFormat(("MM-dd")).format(diary.getDate()));
				// deail.xml页面中设置 editText detailxml_moon内容
				tv2 = (TextView) d.findViewById(R.id.detailxml_moon);
				tv2.setText(diary.getMood());
				d.show();
			}
		});
	}

	/*
	 * Fuction:Button OnClick 事件 
	 * Button: fragment_main.xml.frag_create_button
	 */
	public void Create_button_onClick() {
		createButton = (Button) this.findViewById(R.id.frag_create_button);
		createButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				final Dialog c = new Dialog(MainActivity.this);
				c.setTitle("Cteate Date");
				c.setContentView(R.layout.create_detail);
				/*
				 * 这里插入 创建子窗口的线程 进行逻辑代码
				 */
				c.show();
			}
		});
	}

	public void initialize() {
		DiaryController control = new DiaryController();
		Date da = new Date();
		control.insert(da, "good", "well", "diary1", "diary1 context", da);
		diaryList = control.getDiaryList();

	}

	/*
	 * if (savedInstanceState == null) { getFragmentManager().beginTransaction()
	 * .add(R.id.container, new PlaceholderFragment()) .commit(); } }
	 * 
	 * 
	 * 
	 * @Override public boolean onCreateOptionsMenu(Menu menu) {
	 * 
	 * // Inflate the menu; this adds items to the action bar if it is present.
	 * getMenuInflater().inflate(R.menu.main, menu); return true; }
	 * 
	 * @Override public boolean onOptionsItemSelected(MenuItem item) { // Handle
	 * action bar item clicks here. The action bar will // automatically handle
	 * clicks on the Home/Up button, so long // as you specify a parent activity
	 * in AndroidManifest.xml. int id = item.getItemId(); if (id ==
	 * R.id.action_settings) { return true; } return
	 * super.onOptionsItemSelected(item); }
	 *//**
	 * A placeholder fragment containing a simple view.
	 */
	/*
	 * public static class PlaceholderFragment extends Fragment {
	 * 
	 * public PlaceholderFragment() {
	 * 
	 * }
	 * 
	 * @Override public View onCreateView(LayoutInflater inflater, ViewGroup
	 * container, Bundle savedInstanceState) { View rootView =
	 * inflater.inflate(R.layout.fragment_main, container, false);
	 * 
	 * return rootView; } }
	 */

}
