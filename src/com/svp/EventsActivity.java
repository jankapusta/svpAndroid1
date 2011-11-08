
package com.svp;


import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;




public class EventsActivity extends ListActivity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        
        SvpClient cl = SvpClient.getInstance();
    	
        SvpArticleEntity[] n = cl.getArticles();
	    
        ArrayAdapter<SvpArticleEntity> adapter = new ArrayAdapter<SvpArticleEntity>(this,android.R.layout.simple_list_item_1,n);
        
	    
	    for(Object node : n) {
	    	
	    	Log.v("general", node.toString());
	    	
	    }
        
	    setListAdapter(adapter);
    }
}