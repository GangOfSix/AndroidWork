package com.diary;

import java.text.DateFormat;
import java.util.List;

import com.model.Diary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DiaryAdapter extends ArrayAdapter<Diary> {

	private int resourceId;

	public DiaryAdapter(Context context, int textViewResourceId,
			List<Diary> objects) {
		super(context, textViewResourceId, objects);
		resourceId = textViewResourceId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Diary diary = getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView == null) {
			view = LayoutInflater.from(getContext()).inflate(resourceId, null);
			viewHolder = new ViewHolder();
			viewHolder.diaryDate = (TextView) view.findViewById(R.id.diary_date);
			viewHolder.diaryTitle = (TextView) view.findViewById(R.id.diary_title);
			view.setTag(viewHolder);
		} else {
			view = convertView;
			viewHolder = (ViewHolder) view.getTag();
		}
		//new java.text.SimpleDateFormat(("MM.DD hh:mm"))
		//viewHolder.diaryDate.setText(DateFormat.getDateInstance(0).format(diary.getDate()));
		viewHolder.diaryDate.setText(new java.text.SimpleDateFormat(("MM-dd hh:mm")).format(diary.getDate()));
		
		viewHolder.diaryTitle.setText(diary.getTitle());
		return view;
	}
	
	class ViewHolder {
		
		TextView diaryDate;
		
		TextView diaryTitle;
		
	}

}

