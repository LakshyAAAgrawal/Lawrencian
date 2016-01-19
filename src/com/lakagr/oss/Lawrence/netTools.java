package com.lakagr.oss.Lawrence;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import android.util.Log;
import android.os.Environment;

public class netTools{
	public static InputStream getHttpInputStream(String urlString) throws IOException{
    		URL url=new URL(urlString);
    		HttpURLConnection conn=(HttpURLConnection)url.openConnection();
    		return conn.getInputStream();
    	}
    	public static void download(File dir, String urlString, String filename) throws Exception{
    		InputStream stream=getHttpInputStream(urlString);
    		BufferedInputStream bis= new BufferedInputStream(stream);
    		FileOutputStream out=new FileOutputStream(new File(dir,filename));
    		byte[] buffer=new byte[5000];
    		int len1=0;
    		Log.d("download","start reading"+filename);
    		while((len1=stream.read(buffer))>0){
    			out.write(buffer,0,len1);
    		}
    		Log.d("download","downloaded"+filename);
    		out.close();
    	}
    	public static void download(String urlString, String filename) throws Exception{
    		InputStream stream=getHttpInputStream(urlString);
    		BufferedInputStream bis= new BufferedInputStream(stream);
    		FileOutputStream out=new FileOutputStream(new File(new File(Environment.getExternalStorageDirectory()+File.separator+"Lawrence"),filename));
    		byte[] buffer=new byte[5000];
    		int len1=0;
    		Log.d("download","start reading"+filename);
    		while((len1=stream.read(buffer))>0){
    			out.write(buffer,0,len1);
    		}
    		Log.d("download","downloaded "+filename);
    		out.close();
    	}
}
