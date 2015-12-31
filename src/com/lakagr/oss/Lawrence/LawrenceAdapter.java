package com.lakagr.oss.Lawrence;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lakagr.oss.Lawrence.*;
import java.util.ArrayList;

public class LawrenceAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<EventItem> list;
	private LayoutInflater layoutInflator;
	
	public LawrenceAdapter(Context context, ArrayList<EventItem> list){
		this.context=context;
		this.list=list;
		layoutInflator=(LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	public int getCount(){
		return list.size();
	}
	
	public Object getItem(int position){
		return list.get(position);
	}
	
	public long getItemId(int position){
		return position;
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		View v=convertView;
		EventItem item=list.get(position);
		if(item.type.equals("text")){
			v=layoutInflator.inflate(R.layout.simple_list_item_1,null);
			TextView tv=(TextView)v.findViewById(R.id.textview);
			tv.setText(item.val);
		}else
		if(item.type.equals("image")){
			v=layoutInflator.inflate(R.layout.simple_list_item_1,null);
			TextView tv=(TextView)v.findViewById(R.id.textview);
			tv.setText("image");
		}
		
		return v;
	}
}
