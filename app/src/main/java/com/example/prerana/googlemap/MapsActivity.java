package com.example.prerana.googlemap;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.example.prerana.googlemap.models.LatitudeLongitude;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        List<LatitudeLongitude> latLngs = new ArrayList<>();
        latLngs.add(new LatitudeLongitude(27.706195, 85.3300396,"Softwarica College"));
        latLngs.add(new LatitudeLongitude(27.7050028, 85.3269488,"Vijay Smarak"));
        latLngs.add(new LatitudeLongitude(27.7052356, 85.3294158,"Block E of college"));
        latLngs.add(new LatitudeLongitude(-33.7319287, 151.1414574,"Pymble Sydney"));
        latLngs.add(new LatitudeLongitude(27.6634881,84.4187542, "BP KOoirala"));
        latLngs.add(new LatitudeLongitude(28.1472464, 84.0822671,"Pokahara University"));
        latLngs.add(new LatitudeLongitude(27.7107553,83.4679022, "Butwal College"));

        CameraUpdate center, zoom;

        for (int i = 0; i <latLngs.size();i++)
        {
            center = CameraUpdateFactory.newLatLng(new LatLng(latLngs.get(i).getLat(),
                                                       latLngs.get(i).getLon()));

            zoom = CameraUpdateFactory.zoomTo(16);
            mMap.addMarker(new MarkerOptions().position(new LatLng(latLngs.get(i).getLat(),
                                       latLngs.get(i).getLon())).title(latLngs.get(i).getMarker()));

            mMap.moveCamera(center);
            mMap.animateCamera(zoom);
            mMap.getUiSettings().setZoomControlsEnabled(true);
        }


    }
}
