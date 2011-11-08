package com.svp;

import java.io.Console;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;
import com.svp.SvpClient;

public class TabsActivity extends TabActivity {
    /** Called when the activity is first created. */
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        	
        	
            
        	SvpClient cli = SvpClient.getInstance();
        	
        	if(!cli.isLoggedIn()) {
        		
        		Log.v("svp main", "User is not signed in, showing login form");
        		
        		
        		Intent intent = new Intent(this, LoginActivity.class);
	        	this.startActivity(intent);
	        	
            	
            } else {
            	
            	Log.v("svp main", "User is signed in, showing GUI");
            	buildGui();
            }
            
        
	        
			
      }
      
    @Override
      public void onResume() {
    	
    		super.onResume();
    	
    	  SvpClient cli = SvpClient.getInstance();
    	  
    	  if(!cli.isLoggedIn()) {
      		
      		Log.v("svp main", "User is not signed in, showing login form");
      		
      		//Intent intent = new Intent(this, SvpLoginActivity.class);
	        //	this.startActivity(intent);
	        	
          	
          } else {
          	
          	Log.v("svp main", "User is signed in, showing GUI");
          	buildGui();
          }
      }
     
      protected void buildGui() {
    	  
    	  
    	  setContentView(R.layout.main);
    	  

	        Resources res = getResources();	// Resource object to get Drawables
			TabHost tabHost = getTabHost();  // The activity TabHost
			TabHost.TabSpec spec;			// Resusable TabSpec for each tab
		    Intent intent;  // Reusable Intent for each tab
	
		    
		    // Do the same for the other tabs
		    intent = new Intent().setClass(this, MessagesActivity.class);
		    spec = tabHost.newTabSpec("messages").setIndicator("Spravy",
		                      res.getDrawable(R.drawable.ic_tab_messages))
		                  .setContent(intent);
		    tabHost.addTab(spec);
		    	
		    
		    intent = new Intent().setClass(this, NewsActivity.class);
		    spec = tabHost.newTabSpec("news").setIndicator("Clanky",
		                      res.getDrawable(R.drawable.ic_tab_news))
		                  .setContent(intent);
		    tabHost.addTab(spec);
			
		    
		    intent = new Intent().setClass(this, EventsActivity.class);
		    spec = tabHost.newTabSpec("events").setIndicator("Akcie",
		                      res.getDrawable(R.drawable.ic_tab_events))
		                  .setContent(intent);
		    tabHost.addTab(spec);
		    
		    
		    // Create an Intent to launch an Activity for the tab (to be reused)
		    intent = new Intent().setClass(this,PeopleActivity.class);
		    // Initialize a TabSpec for each tab and add it to the TabHost
		    spec = tabHost.newTabSpec("people").setIndicator("Ludia",
		                      res.getDrawable(R.drawable.ic_tab_people))
		                  .setContent(intent);
		    tabHost.addTab(spec);
		    
		    
		    // Create an Intent to launch an Activity for the tab (to be reused)
		    intent = new Intent().setClass(this,OtherActivity.class);
		    // Initialize a TabSpec for each tab and add it to the TabHost
		    spec = tabHost.newTabSpec("other").setIndicator( "...",
		                      res.getDrawable(R.drawable.ic_tab_other))
		                  .setContent(intent);
		    
		    tabHost.addTab(spec);
      }
    
   
}