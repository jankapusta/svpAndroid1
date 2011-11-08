package com.svp;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.util.Log;



public class SvpArticleEntity {
	
	public String uid;
	
	public String status;
	
	public String nid;
	
	public String moderate;
	
	public String type;
	
	public String changed;
	
	public String sticky;
	public String title;
	public String promote;
	public String created;
	public String translate;
	public String tnid;
	public String language;
	public String comment;
	public String vid;
	
	public SvpArticleEntity(HashMap<String, String> o) {
		
		title = "No name";
		
		Log.v("svpclient", "parsing item: " + o.toString() );
		
		title = o.get("title");
		
		
	}
	
	public String toString() {
		
		
		return title;
	}
	
	
	
}