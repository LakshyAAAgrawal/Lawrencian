package com.lakagr.oss.Lawrence;

import android.app.Activity;
import android.os.Bundle;

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
        					"uihfuiowhef89wyefefyhfyhweyhfhweuifhiuf"
        				  };
        final ArrayList<String> list = new ArrayList<String>();
        for(int i=0;i<values.length;i++){
        	list.add(values[i]);
        }
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        listview.setAdapter(adapter);
    }
}
