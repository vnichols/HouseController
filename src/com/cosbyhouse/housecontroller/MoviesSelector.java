package com.cosbyhouse.housecontroller;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MoviesSelector extends Activity{


	/**
	 * Creates the main monopoly screen 
	 */
	@Override
	protected void onCreate(Bundle movies) {
		super.onCreate(movies);
		setContentView(R.layout.movies_layout);
		try {
			final ListView lv = (ListView)findViewById(R.id.movies_list);

			lv.setOnItemClickListener(new OnItemClickListener(){

				@Override
				public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {

					//TextView item = (TextView) lv.getItemAtPosition(position);

					((TextView)view).setText("This has item has been clicked!");

				}

			});

			ArrayAdapter<String> arrayAdaptor;

			arrayAdaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, getList());


			lv.setAdapter(arrayAdaptor);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private List<String> getList() throws IOException {

		List<String> list = new ArrayList<String>();

		ConnectivityManager connMgr = (ConnectivityManager) 
				getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {
			URL url = new URL("http://obiwan:buffduck@192.168.1.13:4242");
			list.add(url.getPath());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setReadTimeout(10000 /* milliseconds */);
	        conn.setConnectTimeout(15000 /* milliseconds */);
	        conn.setRequestMethod("GET");
	        conn.setDoInput(true);
	        // Starts the query
	        conn.connect();
	        int response = conn.getResponseCode();
	        list.add("" + response);
	        //Log.d(DEBUG_TAG, "The response is: " + response);
	        InputStream is = conn.getInputStream();

	        // Convert the InputStream into a string
	        String contentAsString = readIt(is, 500);
	        //return contentAsString;
			list.add(contentAsString);
		} else {

			list.add("foo");
			list.add("bar");
		}

		return list;
	}
	
	public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
	    Reader reader = null;
	    reader = new InputStreamReader(stream, "UTF-8");        
	    char[] buffer = new char[len];
	    reader.read(buffer);
	    return new String(buffer);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
