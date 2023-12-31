package com.example.comupnchuquirunaalvafinal;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.comupnchuquirunaalvafinal.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private LocationManager mLocationManager;

    private  double latitud, longitud;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        latitud = getIntent().getDoubleExtra("latitud", 0.0f);
        longitud = getIntent().getDoubleExtra("longitud", 0.0f);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng location = new LatLng(latitud, longitud);
        mMap.addMarker(new MarkerOptions().position(location).title("Marker in Peru"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(location));
    }
    @Override
    public void onLocationChanged(@NonNull Location location) {

    }
}