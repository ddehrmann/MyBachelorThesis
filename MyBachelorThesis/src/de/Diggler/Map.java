package de.Diggler;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

public class Map extends Activity{

	private GoogleMap tmpMap;
	
	/** Wenn bereits ein Trip läuft, soll dieser angezeigt werden
	 * 
	 * isLastTrip Finished? then Map, Else Continue Trip*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map);
		
		MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fMap);
		tmpMap = mapFragment.getMap();
		tmpMap.setMyLocationEnabled(true);
		
	}

	
}
