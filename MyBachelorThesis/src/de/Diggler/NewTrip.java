package de.Diggler;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class NewTrip extends Activity {
	
	CheckBox compas, zoomButtons, fixedMap, tracking, fotoMarker;
	EditText tripName, tripNote;
	Button keyboard, startTrip;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		
		setUpButtonsEtc();
		
	}
	
	public void hideKeyBoardAfterEditText(EditText et){
		if(getCurrentFocus()!=null && getCurrentFocus() instanceof EditText) {
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(tripName.getWindowToken(), 0);
			imm.hideSoftInputFromWindow(tripNote.getWindowToken(), 0);
		}
	}

	
	public void setUpButtonsEtc(){
		compas = 		(CheckBox) findViewById(R.id.cbActivateCompass);		
		zoomButtons = 	(CheckBox) findViewById(R.id.cbActivateZoomButtons);		
		fixedMap = 		(CheckBox) findViewById(R.id.cbActivateFixMap);		
		tracking = 		(CheckBox) findViewById(R.id.cbActivateTracking);		
		tripName = 		(EditText) findViewById(R.id.etTripName);	
		tripNote = 		(EditText) findViewById(R.id.etTripNote);		
		keyboard = 		(Button)   findViewById(R.id.bHideKeyboard);
		startTrip= 		(Button)   findViewById(R.id.bConfirmNewTrip);
	}
}
