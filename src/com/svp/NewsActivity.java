package com.svp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class NewsActivity extends Activity {
	
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TextView textview = new TextView(this);
        textview.setText("Tu su clanky");
        setContentView(textview);
        /*
        // prepare the list of all records
        List<HashMap<String, String>> fillMaps = new ArrayList<HashMap<String, String>>();
        for(int i = 0; i < 10; i++){
        	HashMap<String, String> map = new HashMap<String, String>();
        	map.put("rowid", "" + i);
        	map.put("col_1", "col_1_item_" + i);
        	map.put("col_2", "col_2_item_" + i);
        	map.put("col_3", "col_3_item_" + i);
        	fillMaps.add(map);
        }
        TextView tv = new TextView(this);*/
        //lv=(ListView)findViewById(R.layout.list);
	    
	     // By using setAdpater method in listview we an add string array in list.
	    //lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1 , lv_arr));
	     
        // fill in the grid_item layout
        //SimpleAdapter adapter = new SimpleAdapter(this, fillMaps, R.layout.simple_list_item_1, from, to);
        //lv.setAdapter(adapter);
        //lv.setAdapter(new ArrayAdapter<String>(this,R.layout.adaptor_content, lv_arr)) ;
        //setContentView(lv);
        //fillMaps.to
        
        
        //setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, lv_arr));
    }
	
}



