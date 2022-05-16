package com.example.mymapp;
 
import android.os.Bundle;
import com.google.android.maps.MapActivity;
 
public class GeoMapActivity extends MapActivity {

    @Override
    public void onCreate(Bundle savedInstanceData) {
        super.onCreate(savedInstanceData);
        setContentView(R.layout.geomap);
    }
    
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
}

<uses-library android:name="com.google.android.maps" />

<uses-permission android:name="android.permission.INTERNET" />

<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />

final MapView mMapView = (MapView) findViewById(R.id.mapview);
 

MapController mMapController = mMapView.getController();
 

mMapController.animateTo(new GeoPoint(ur coord input, input coord));
 
mMapController.setZoom(15);

final MapView cMapView = (MapView) findViewById(R.id.map);
 

MapController cMapController = cMapView.getMapController();


cMapView.setBuiltInZoomControls(true);


final LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
final LocationListener locationListener = new LocationListener() {
		
	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {}
			
	@Override
	public void onProviderEnabled(String provider) {}
			
	@Override
	public void onProviderDisabled(String provider) {}
			
	@Override
	public void onLocationChanged(Location location) {}
};
locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);


cMyLocationOverlay = new MyLocationOverlay(this, cMapView);
cMyLocationOverlay.disableCompass();
cMyLocationOverlay.enableMyLocation();
cMapView.getOverlays().add(cMyLocationOverlay);
 
cMapController.setZoomCurrent(15);


Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);


cMapController.animateTo(new GeoPoint((int) location.getLatitude() * 1000000, (int) location.getLongitude() * 1000000));
