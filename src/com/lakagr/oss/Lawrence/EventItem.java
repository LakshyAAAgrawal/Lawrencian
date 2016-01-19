package com.lakagr.oss.Lawrence;
import java.lang.String;
public class EventItem{
	String type;
	String val;
	String filename;
	public EventItem(String type,String val){
		this.type=type;
		this.val=val;
	}
	public EventItem(String type,String val,String filename){
		this.type=type;
		this.val=val;
		this.filename=filename;
	}
}
