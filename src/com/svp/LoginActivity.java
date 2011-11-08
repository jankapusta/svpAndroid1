package com.svp;

import java.io.Console;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import com.svp.SvpClient;

public class LoginActivity extends Activity {
    /** Called when the activity is first created. */
    

    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        SvpClient cli = SvpClient.getInstance();
        
        if(!cli.isLoggedIn()) {
        		
        	setContentView(R.layout.login);
        	
        	Button b1 = (Button) findViewById( R.id.button1);
        	b1.setText(R.string.loginButton);
        	
        	b1.setOnClickListener( new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
			        SvpClient cli = SvpClient.getInstance();
			        
			        EditText usernameField = (EditText) findViewById(R.id.editText2);
			        String username = usernameField.getText().toString(); 
			        
			        EditText passwordField = (EditText) findViewById(R.id.editText1);
			        String password = passwordField.getText().toString(); 
			        
			        
			        if( cli.auth(username, password)) {
			        	Log.v("svp main", "Login successfull, closing login activity");
			        	LoginActivity.this.finish();
			        	
			        } else {
			        	Log.v("svp main", "Login failed");
			        	AlertDialog.Builder alertD = new AlertDialog.Builder(LoginActivity.this);
			        	alertD.setTitle(R.string.loginFailed);
			        	AlertDialog dial = alertD.create();
			        	dial.show();
			        }
			        	
		        	
				}
			});
        	
        	
        } else {
        	
        	//setContentView(R.layout.signedIn);
        	
        	//Intent intent = new Intent(this, SvpTabsActivity.class);
        	//this.startActivity(intent);
        	this.finish();
        	
        }
        
            
      }
    
    	
    
}