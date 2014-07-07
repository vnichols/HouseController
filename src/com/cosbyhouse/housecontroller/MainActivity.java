package com.cosbyhouse.housecontroller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Context context = this;
		final LightController lc = new LightController(this);
		final PowerController pc = new PowerController(this);
		final MoviesController movc = new MoviesController();
		final MusicController musc = new MusicController();

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);

		Switch lights = (Switch)findViewById(R.id.lights);
		lights.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

				lc.changeLights(isChecked);
			}
		});

		Switch receiver = (Switch)findViewById(R.id.receiver);
		receiver.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

				pc.changeReceiverPower(isChecked);
			}

		});

		Switch projector = (Switch)findViewById(R.id.projector);
		projector.setOnCheckedChangeListener(new OnCheckedChangeListener(){

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

				pc.changeProjectorPower(isChecked);
			}

		});

		Button movies = (Button)findViewById(R.id.movies);
		movies.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {

				Intent i = new Intent(context, MoviesSelector.class);
				//MainActivity.finishActivity(0);
				MainActivity.this.startActivity(i);

			}

		});

		Button music = (Button)findViewById(R.id.music);
		music.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {

				Intent i = new Intent(context, MusicSelector.class);
				//MainActivity.finishActivity(0);
				MainActivity.this.startActivity(i);

			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
