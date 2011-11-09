

package com.svp;


import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;





public class MessagesActivity extends ListActivity {
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        
        SvpClient cli = SvpClient.getInstance();
        
        
        SvpMessageEntity[] msgs =  cli.getMessages();

        
        ArrayAdapter<SvpMessageEntity> adapter = new ArrayAdapter<SvpMessageEntity>(this,android.R.layout.simple_list_item_1,msgs);
        
	    
	    for(Object node : msgs) {
	    	
	    	Log.v("general", node.toString());
	    	
	    }
        
	    setListAdapter(adapter);
        
    }
}