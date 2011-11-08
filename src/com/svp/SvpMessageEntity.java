package com.svp;

import java.util.HashMap;

import android.util.Log;

public class SvpMessageEntity {

	
	protected String title;
	
public SvpMessageEntity(HashMap<String, String> o) {
		
		title = "No name";
		
		Log.v("svpclient", "parsing item: " + o.toString() );
		
		title = o.get("title");
		
		
	}
	
	public String toString() {
		
		
		return title;
	}
}
