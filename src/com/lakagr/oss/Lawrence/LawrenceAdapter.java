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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import android.os.Environment;
import android.widget.ImageView;
import com.lakagr.oss.Lawrence.*;
import java.io.InputStream;
import android.os.AsyncTask;

public class LawrenceAdapter extends BaseAdapter {
	private Context context;
	private ArrayList<EventItem> list;
	private LayoutInflater layoutInflator;
	private ImageView iv;
	private final File directory = new File(Environment.getExternalStorageDirectory()+File.separator+"Lawrence");
	private File file;
	private View v;
	private EventItem item;
	private TextView tv;
	
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
		//if(convertView==null){
			v=convertView;
			item=list.get(position);
			if(item.type.equals("text")){
				v=layoutInflator.inflate(R.layout.simple_list_item_1,null);
				tv=(TextView)v.findViewById(R.id.textview);
				tv.setText(item.val);
				}else
			if(item.type.equals("image")){
			
				v=layoutInflator.inflate(R.layout.simple_image_layout,null);
				iv=(ImageView)v.findViewById(R.id.imageview);
				directory.mkdirs();
				file = new File(directory, item.filename);
				if(!file.exists()){
					iv.setImageResource(R.drawable.not_available);
				}else{
					iv.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
				}
				/*
				if(!file.exists()){
					new DownloadFiles().execute();
				}else{
					iv.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
				}
				*/
				/*
				if(!file.exists()){
					try{
						netTools.download(directory,item.val,item.filename);
					}catch(Exception e){}
				}
				iv.setImageBitmap(BitmapFactory.decodeFile(file.getAbsolutePath()));
				*/
			}
		//}else{
		//}
		return v;
		}
	
	private class DownloadFiles extends AsyncTask<String, Void, Bitmap>{
		View x=v;
		protected Bitmap doInBackground(String... param){
			try{
				netTools.download(directory,item.val,item.filename);
			}catch(Exception e){}
			return BitmapFactory.decodeFile(file.getAbsolutePath());
		}
		protected void onPostExecute(Bitmap bitmap){
			((ImageView)x.findViewById(R.id.imageview)).setImageBitmap(bitmap);
			//iv.setImageBitmap(bitmap);
		}
	}
	
	
}
