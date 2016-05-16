package com.example.muhammad_usman.mapmarker;

import android.location.Location;
import android.net.Uri;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.nearby.messages.PublishCallback;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    public static Location loc;
    private GoogleMap mMap;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String data= getIntent().getStringExtra("Filename");
        setContentView(R.layout.activity_maps);
        sydney = new ArrayList<LatLng>();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        String allread = readfile(data);
        String[] longlat = allread.split("\\r?\\n");
        for (int i = 0; i < longlat.length; i++) {
            String[] longno = longlat[i].split(" ");


            try {
                sydney.add(new LatLng(Double.parseDouble(longno[0]), Double.parseDouble(longno[1])));
            } catch (Exception e) {
                Toast.makeText(getBaseContext(), "Your file is not formatted properly or",
                        Toast.LENGTH_SHORT).show();

            }
        }


    }

    ArrayList<LatLng> sydney;


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        if (sydney.isEmpty()) {
            mMap.addMarker(new MarkerOptions().position(new LatLng(33.7294, 73.0931)).title("located"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(33.7294, 73.0931)));
            Toast.makeText(getBaseContext(), "your file is empty!!this is Islamabad Location",
                    Toast.LENGTH_SHORT).show();

        } else {
            for (LatLng bahi : sydney
                    ) {
                mMap.addMarker(new MarkerOptions().position(bahi).title("located"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(bahi));
            }
        }


    }


    public String readfile(String path) {
        String aBuffer = "";
        try {

            File myFile = new File("/sdcard/"+path);
            if (myFile.exists()) {
                FileInputStream fIn = new FileInputStream(myFile);
                BufferedReader myReader = new BufferedReader(
                        new InputStreamReader(fIn));
                String aDataRow = "";

                while ((aDataRow = myReader.readLine()) != null) {
                    aBuffer += aDataRow + "\n";
                }

                myReader.close();
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }

        return aBuffer;

    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.muhammad_usman.mapmarker/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Maps Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.muhammad_usman.mapmarker/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }


}
