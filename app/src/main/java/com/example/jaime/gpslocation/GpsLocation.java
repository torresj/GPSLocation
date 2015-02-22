package com.example.jaime.gpslocation;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class GpsLocation extends ActionBarActivity implements LocationListener {

    TextView lon;
    TextView lat;
    TextView alt;
    LocationManager loc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps_location);

        lon= (TextView)findViewById(R.id.longitud);
        lat= (TextView)findViewById(R.id.latitud);
        alt= (TextView)findViewById(R.id.altitud);

        lon.setText("");
        lat.setText("");
        alt.setText("");

        loc=(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        loc.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gps_location, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLocationChanged(Location location) {
        if(location!=null){
            lon.setText(String.valueOf(location.getLongitude()));
            lat.setText(String.valueOf(location.getLatitude()));
            alt.setText(String.valueOf(location.getAltitude()));
        }else{
            lon.setText("No disponible");
            lat.setText("No disponible");
            alt.setText("No disponible");
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
