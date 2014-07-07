package com.cosbyhouse.housecontroller;

import android.app.Activity;
import android.widget.Toast;

public class PowerController {
	
	private Activity context;
	
	public PowerController(Activity context){
		this.context = context;
	}

	public void changePower(boolean isChecked) {
		
		
	}

	public void changeReceiverPower(boolean isChecked) {
		CharSequence string = "The Reciever have been powered " + (isChecked? "on": "off");
		
		Toast.makeText(context, string,Toast.LENGTH_LONG).show();
	}

	public void changeProjectorPower(boolean isChecked) {
		
		CharSequence string = "The Projector have been powered " + (isChecked? "on": "off");
		
		Toast.makeText(context, string,Toast.LENGTH_LONG).show();
	}

}
