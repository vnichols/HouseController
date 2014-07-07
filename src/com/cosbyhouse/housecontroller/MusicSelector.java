package com.cosbyhouse.housecontroller;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class MusicSelector extends Activity{

	/**
	 * Creates the main monopoly screen 
	 */
	@Override
	protected void onCreate(Bundle movies) {
		super.onCreate(movies);
		setContentView(R.layout.music_layout);
		
		final ListView lv = (ListView)findViewById(R.id.music_list);
		
		lv.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
				
				//TextView item = (TextView) lv.getItemAtPosition(position);
				
				((TextView)view).setText("This has item has been clicked!");
						
			}
			
		});
		
		ArrayAdapter<String> arrayAdaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getList());
		
		lv.setAdapter(arrayAdaptor);
		
	}

	private List<String> getList() {
		List<String> list = new ArrayList<String>();
		list.add("foo");
		list.add("bar");
		return list;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
