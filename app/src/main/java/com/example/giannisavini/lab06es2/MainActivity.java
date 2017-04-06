package com.example.giannisavini.lab06es2;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * Questa classe la si può caricare da Goole apis (visita il sito)...
         * il link è nel file build.gradle(app).
         * Se non caricato correttamente l'IDE non da neanche il suggerimeto di tale classe.
         */
        MapFragment mapFragment = MapFragment.newInstance();
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                //Latitudine Longitudine
                LatLng cesena = new LatLng(44.1390675, 12.2429281);

                Marker marker = googleMap.addMarker(new MarkerOptions().position(cesena)
                .title("Cesena!!"));
                //Costrutto per mostrare in una finsestra il metodo
                marker.showInfoWindow();

                googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(cesena, ));
            }
        });

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //containar da aggiungere al file activity_main.xml
        transaction.add(R.id.container, mapFragment);
        transaction.commit();
    }
}
