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
	ArrayList<EventItem> a=null;
	InputStream stream=null;
       	try{
       		 stream=download("http://www.randomsongs.hostei.com/test.xml");
        	 a=LawrenceXmlParser.parse(stream);
        	 stream.close();
        }catch(Exception e){
        	Toast.makeText(getApplicationContext(), "Internet Error",Toast.LENGTH_LONG).show();
        	e.printStackTrace();
        }
        final ArrayList<String> list=new ArrayList<String>();
        for(int i=0;i<a.size();i++){
        	list.add(a.get(i).val);
        }
        final ArrayAdapter adapter = new ArrayAdapter(this, R.layout.simple_list_item_1, R.id.textview,list);
        ((ListView)findViewById(R.id.listview)).setAdapter(adapter);
    }
    private InputStream download(String urlString) throws IOException{
    	URL url=new URL(urlString);
    	HttpURLConnection conn=(HttpURLConnection)url.openConnection();
    	return conn.getInputStream();
    	/*
    	conn.setReadTimeout(10000);
    	conn.setConnectTimeout(15000);
    	conn.setRequestMethod("GET");
    	conn.connect();
    	*/
    }
}
