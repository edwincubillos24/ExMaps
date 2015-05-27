package com.example.mapas;

import android.graphics.Camera;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


public class MainActivity extends FragmentActivity {

    private GoogleMap map;
    private CameraUpdate cameraUpdate;

    private final LatLng LOCATION_HOME = new LatLng(6.176627f, -75.612701f);
    private final LatLng LOCATION_UDEA = new LatLng(6.267577f, -75.568995f);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        map =((MapFragment)getFragmentManager().findFragmentById(R.id.map)).getMap();

        map.addMarker(new MarkerOptions().position(LOCATION_HOME).title("My Home").snippet("Carrera 54 N 77-41")
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
        map.addMarker(new MarkerOptions().position(LOCATION_UDEA).title("University of Antioquia").snippet("Calle 67 #53-108"));
    }

    public void onClickHome(View view){
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        cameraUpdate= CameraUpdateFactory.newLatLngZoom(LOCATION_HOME,16);
        map.animateCamera(cameraUpdate);
    }

    public void onClickU(View view){
        map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        cameraUpdate = CameraUpdateFactory.newLatLngZoom(LOCATION_UDEA,16);
        map.animateCamera(cameraUpdate);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
