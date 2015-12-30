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

public class Lawrence extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final String[] values=new String[]{	"Welcome to The Lawrence School, Lovedale",
        					"A computer quiz was organised for the Senior School", 
        					"wehfhefhwehfuwhefowhefohewfh", 
        					"uihfuiowhef89wyefefyhfyhweyhfhweuifhiuf",
        					"uihfuiowhef89wyefefyhfyhweyhfhweuifhiuf",
        					"uihfuiowhef89wyefefyhfyhweyhfhweuifhiuf",
        					"uihfuiowhef89wyefefyhfyhweyhfhweuifhiuf",
        					"uihfuiowhef89wyefefyhfyhweyhfhweuifhiuf",
        					"uihfuiowhef89wyefefyhfyhweyhfhweuifhiuf",
        					"uihfuiowhef89wyefefyhfyhweyhfhweuifhiuf",
        					"uihfuiowhef89wyefefyhfyhweyhfhweuifhiuf",
        					"uihfuiowhef89wyefefyhfyhweyhfhweuifhiuf",
        					"uihfuiowhef89wyefefyhfyhweyhfhweuifhiuf",
        					"uihfuiowhef89wyefefyhfyhweyhfhweuifhiuf"
        				  };
        				  Log.d("Lawrence Activity","initialising araylist inputsream");
	ArrayList<EventItem> a=null;
	InputStream stream=null;
       	try{
       		Log.d("Lawrence","before donwload");
       		 stream=download("http://www.randomsongs.hostei.com/test.xml");
       		 Log.d("Lawrence","after download");
        	 a=LawrenceXmlParser.parse(stream);
        	 stream.close();
        }catch(Exception e){
        	Toast.makeText(getApplicationContext(), "Internet Error",Toast.LENGTH_LONG).show();
        	Log.d("Lawrence","internet");
        	e.printStackTrace();
        }
        Log.d("Lawrence Activity","initialised araylist inputsream");
        final ArrayList<String> list=new ArrayList<String>();
        Log.d("Lawrence Activity","initialised list");
        for(int i=0;i<a.size();i++){
        	Log.d("Lawrence Activity"," "+i);
        	list.add(a.get(i).val);
        }
        Log.d("Lawrence Activity","added values");
        final ArrayAdapter adapter = new ArrayAdapter(this, R.layout.simple_list_item_1, R.id.textview,list);
        ((ListView)findViewById(R.id.listview)).setAdapter(adapter);
        Log.d("Lawrence Activity","set adapter");
    }
    private InputStream download(String urlString) throws IOException{
    	Log.d("Lawrence","before url");
    	URL url=new URL(urlString);
    	Log.d("Lawrence","http initialising");
    	HttpURLConnection conn=(HttpURLConnection)url.openConnection();
    	/*
    	Log.d("Lawrence","http initialised");
    	conn.setReadTimeout(10000);
    	conn.setConnectTimeout(15000);
    	conn.setRequestMethod("GET");
    	
    	Log.d("Lawrence","connecting");
    	conn.connect();
    	Log.d("Lawrence","connected");
    	*/
    	return conn.getInputStream();
    }
}
