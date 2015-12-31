package com.lakagr.oss.Lawrence;

import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import java.lang.String;
import org.xmlpull.v1.XmlPullParserException;
import java.io.IOException;
import com.lakagr.oss.Lawrence.*;
import java.io.InputStream;
import org.xmlpull.v1.XmlPullParserFactory;
import android.util.Log;

public class LawrenceXmlParser{
	public static ArrayList<EventItem> parse(InputStream in) throws XmlPullParserException, IOException {
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		XmlPullParser parser=factory.newPullParser();
		parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
		parser.setInput(in,"UTF-8");
		return readFeed(parser);	
	}
	private static ArrayList<EventItem> readFeed(XmlPullParser parser) throws XmlPullParserException, IOException{
		ArrayList<EventItem> list=new ArrayList<EventItem>();
		//parser.require(XmlPullParser.START_TAG, null, "main");
		while(parser.next()!=XmlPullParser.END_TAG){
			if(parser.getEventType()!=XmlPullParser.START_TAG)
				continue;
			String eventName=parser.getName();
			if(eventName.equals("item")){
				list.add(readItem(parser));
			}
			
		}
		return list;
	}
	private static EventItem readItem(XmlPullParser parser) throws XmlPullParserException, IOException {
		parser.require(XmlPullParser.START_TAG,null,"item");
		String type=parser.getAttributeValue(null, "type");
		String val=null;
		if(parser.next()==XmlPullParser.TEXT){
			val=parser.getText();
			parser.nextTag();
		}
		return new EventItem(type,val);
	}
}
