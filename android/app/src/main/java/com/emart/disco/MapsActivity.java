package com.emart.disco;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    SearchView map_searchView;
    Button confirm_location;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        map_searchView = findViewById(R.id.mapSearchView);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        map_searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //get location name from search view
                String Location = map_searchView.getQuery().toString();
                // a list of address where we store the all the address;
                List<Address> addressList = null;

                if (Location!=null || !Location.equals("")) {
                    Geocoder geocoder = new Geocoder(MapsActivity.this);
                    try {

                        addressList = geocoder.getFromLocationName(Location, 1);

                        // from our list a first position.
                        Address address = addressList.get(0);
                        LatLng latlag = new LatLng(address.getLatitude(), address.getLongitude());
                        mMap.addMarker(new MarkerOptions().position(latlag).title(Location));
                        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlag, 15));
                        address.clearLongitude();
                        address.clearLatitude();
                    }
                    catch (IOException e) {
                        Toast.makeText(MapsActivity.this, "Location unavailable", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        mapFragment.getMapAsync(this);

        confirm_location = findViewById(R.id.button_confirm_location);
        confirm_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = map_searchView.getQuery().toString();
                //shared preferences (Name, Mode)
                sharedPreferences = getSharedPreferences("location", MODE_PRIVATE);
                //edit shared preference (put data)
                SharedPreferences.Editor editor = sharedPreferences.edit();
                //put data in shared preference
                editor.putString("location", location);
                //apply changes to shared preference
                editor.apply();

                startActivity(new Intent(MapsActivity.this, disco_cart.class));
            }
        });
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

        // Add a marker in Kuala Lumpur and move the camera
        LatLng KL = new LatLng(3.1371016402412004, 101.69545672897894);
        mMap.addMarker(new MarkerOptions().position(KL).title("Marker in Kuala Lumpur"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(KL, 15));
    }
}