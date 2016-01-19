package com.lakagr.oss.Lawrence;

import com.lakagr.oss.Lawrence.*;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.File;
import android.os.Environment;
import android.widget.Toast;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import android.util.Log;
import android.content.Context;

public class Lawrence extends Activity
{
	private ArrayList<EventItem> list;
	private InputStream stream;
	private LawrenceAdapter adapter;
	private ListView listview;
	private final File xmlFile=new File(Context.getFilesDir(),"LawrenceXml.xml"),directory=new File(Contex.getFilesDir());
    	/** Called when the activity is first created. */
    	@Override
    	public void onCreate(Bundle savedInstanceState)
    	{
        	super.onCreate(savedInstanceState);
        	setContentView(R.layout.main);
        	init();
       		try{
       			 stream=netTools.getHttpInputStream("http://www.randomsongs.hostei.com/test.xml");
        		 list=new LawrenceXmlParser().parse(stream);
        		 stream.close();
        	}catch(Exception e){
        		Toast.makeText(getApplicationContext(), "Internet Error",Toast.LENGTH_LONG).show();
        		e.printStackTrace();
        	}
        	
        	adapter = new LawrenceAdapter(getApplicationContext(), list);
        	listview=(ListView)findViewById(R.id.listview);
        	listview.setAdapter(adapter);
    	}
    	
 	private InputStream download(String urlString) throws IOException{
    		URL url=new URL(urlString);
    		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
    		return conn.getInputStream();
    	}
    	
    	private void init(){
    		if(!xmlFile.exists()){
    			netTools.download(directory,"http://www.randomsongs.hostei.com/test.xml","LawrenceXml.xml");
    		}
    	}
}
