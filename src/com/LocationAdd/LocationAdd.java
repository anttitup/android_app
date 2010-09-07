package com.LocationAdd;

import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class LocationAdd extends Activity {
	
    TextView myLocationView;
    Location myLocation;
    String Advertiser;
    HashMap <Location, String> advertisers = new HashMap();
    
    LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
    
    LocationListener locationListener = new LocationListener() {
    
    public void onLocationChanged(Location location) {
          // Called when a new location is found by the network location provider.
          canIHaveAdvertise(location);
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {}

        public void onProviderEnabled(String provider) {}

        public void onProviderDisabled(String provider) {}
      };
    
    public void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
        
        setContentView(R.layout.main);
        
        myLocationView = (TextView)findViewById(R.id.myLocation);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
    }
    
    private void canIHaveAdvertise(Location myLocation) {
    	{
    		if(advertisers.containsKey(myLocation))
    			advertise(myLocation);
    	}
	}
    
    private void advertise(Location myLocation){
    	myLocationView.setText("Tule Meille! " + advertisers.get(myLocation));
    };
}