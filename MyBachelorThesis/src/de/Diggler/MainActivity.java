package de.Diggler;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class MainActivity extends Activity implements OnClickListener{

	static final String TAG = "MainActivity";
	private Button bCurrentTrip, bManageTrip, bMap, bMedia;
	
	
/**This method is called, when the application start.
 * It set's up the start screen and the Buttons & Options
 * 
 * @methods: setUpButtonsEtc(): Sets up Buttons on the start screen and adds onClickListeners. 
 * 								Also has a function to prevent the keyboard from opening, except you tab a textField
 * 			 checkGoogleServices: Checks which services are available and which not
 * */	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startscreen);
		
		checkGoogleServices();
		setUpButtonsEtc();
	}

	
/**This method is called when the application starts and sets up the menu */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

/**This method is called when the user selects an option item*/
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()){
		
		/*case R.id.menuItem1:		// Actions for help page          
        	  Intent i = new Intent(this, Help.class);
        	  startActivity(i);
             return true;*/
	
		default:
			return super.onOptionsItemSelected(item);
		}
	}


/**This method is called when an item with an onClickListener is clicked*/
	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.bStartCurrentTrip:
				Intent iCurrentTrip = new Intent(this, ContinueTrip.class);
				startActivity(iCurrentTrip);
				break;
			
			case R.id.bStartManageTrips:
				Intent iManageTrip = new Intent(this, ManageTrip.class);
				startActivity(iManageTrip);
				break;
				
			case R.id.bStartMap:
				Intent iMap = new Intent(this, Map.class);
				startActivity(iMap);
				break;
				
			case R.id.bStartMedia:
				Intent iMedia = new Intent(this, Media.class);
				startActivity(iMedia);
				break;
		}
	}


	/** Is called in the onCreate method, to set up the Buttons etc. */
	public void setUpButtonsEtc(){	
		bCurrentTrip = 	(Button) findViewById(R.id.bStartCurrentTrip); 	bCurrentTrip.setOnClickListener(this);		
		bManageTrip =	(Button) findViewById(R.id.bStartManageTrips);		bManageTrip.setOnClickListener(this);
		bMap = 			(Button) findViewById(R.id.bStartMap);			bMap.setOnClickListener(this);		
		bMedia = 		(Button) findViewById(R.id.bStartMedia); 		bMedia.setOnClickListener(this);		
		
		
		//This might be useful to prevent from opening soft keyboard
		this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	}
	
	/**Is called in the onCreate method, to check the Google Services availability*/
	public boolean checkGoogleServices(){
		int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getBaseContext());
		
		if (status != ConnectionResult.SUCCESS)	{		//GooglePlayServices are not available
			((Dialog) GooglePlayServicesUtil.getErrorDialog(status,  this, 10)).show();		//10 = requestCode
			return false;
		}
		else return true;
		
	}
}
