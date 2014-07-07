package com.cosbyhouse.housecontroller;

import android.app.Activity;
import android.widget.Toast;

public class LightController {
	
	private Activity context;

	public LightController(Activity context) {
		this.context = context;
	}

	public void changeLights(boolean isChecked) {
		
		CharSequence string = "Lights have been powered " + (isChecked? "on": "off");
		
		Toast.makeText(context, string,Toast.LENGTH_LONG).show();
		
	}

}
