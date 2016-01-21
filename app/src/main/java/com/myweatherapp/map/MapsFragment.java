package com.myweatherapp.map;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


public class MapsFragment extends MapFragment implements OnMapReadyCallback
{
    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Float standardZoom = 15.5f;

    public LatLng currentPosition;

    private OnMapReadyListener mCallback;

    public LatLng getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(LatLng currentPosition) {
        this.currentPosition = currentPosition;
    }
    // Container Activity must implement this interface
    public interface OnMapReadyListener
    {
        public void onMapReadyListener(String city);
    }

    public static MapsFragment newInstance() {
        MapsFragment fragment = new MapsFragment();

        return fragment;
    }

    public MapsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getMapAsync(this);

        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (OnMapReadyListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMyLocationChangeListener(myLocationChangeListener);

        if (currentPosition == null) {

            LocationManager locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
            String locationProvider = LocationManager.NETWORK_PROVIDER;

            if (ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                    && ActivityCompat.checkSelfPermission(this.getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                return;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(locationProvider);
            this.currentPosition = new LatLng(lastKnownLocation.getLatitude(),lastKnownLocation.getLongitude());
        }

        setUpMap(currentPosition);

        // Update the map when we click
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener()
        {
            @Override
            public void onMapClick(LatLng latLng)
            {
                setUpMap(latLng);
                currentPosition = latLng;
                mCallback.onMapReadyListener(getCity());
            }

        });

        // Send the event to the host activity
        mCallback.onMapReadyListener(getCity());

    }

    @Override
    public void onStop()
    {
        super.onStop();
    }

    //display marker + zoom on map
    private void setUpMap(LatLng currentPosition)
    {
        Marker marker = mMap.addMarker(new MarkerOptions().position(currentPosition));

        mMap.setMyLocationEnabled(true);

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentPosition, standardZoom));

    }

    private GoogleMap.OnMyLocationChangeListener myLocationChangeListener = new GoogleMap.OnMyLocationChangeListener()
    {
        @Override
        public void onMyLocationChange(Location location)
        {
            LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());

        }
    };

    public String getCity()
    {
        String city = "";
        Geocoder geocoder = new Geocoder(this.getActivity(), Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(currentPosition.latitude, currentPosition.longitude, 1);
            if (addresses.size() > 0)
                city = addresses.get(0).getLocality();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return city;
    }

}
