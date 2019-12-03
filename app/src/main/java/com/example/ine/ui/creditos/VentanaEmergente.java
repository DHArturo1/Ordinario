package com.example.ine.ui.creditos;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;

import com.example.ine.R;

public class VentanaEmergente extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ventana_emergente);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.widthPixels;

        getWindow().setLayout((int) (width*.8), (int)(height*.6));
    }
}
