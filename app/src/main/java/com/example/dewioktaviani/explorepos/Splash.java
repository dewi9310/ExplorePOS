package com.example.dewioktaviani.explorepos;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.dewioktaviani.explorepos.Data.DatabaseManager;

public class Splash extends AppCompatActivity {

    final private int REQUEST_CODE_ASK_PERMISSIONS = 123;
    private static final long SPLASH_TIMEOUT = 5000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);

        initDB();

    }

    private void initDB(){
        DatabaseManager.init(this);
    }
    private void continuesss(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                startActivity(intent);
            }
        }, SPLASH_TIMEOUT);

    }

    @Override
    protected void onResume() {
        super.onResume();
        int hasWriteExternalStoragePermission = ContextCompat.checkSelfPermission(Splash.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int hasReadExternalStoragePermission = ContextCompat.checkSelfPermission(Splash.this,
                Manifest.permission.READ_EXTERNAL_STORAGE);
//        int hasAccessFineLocationPermission = ContextCompat.checkSelfPermission(Splash.this,
//                Manifest.permission.ACCESS_FINE_LOCATION);
        int hasCameraPermission = ContextCompat.checkSelfPermission(Splash.this,
                Manifest.permission.CAMERA);
        int hasPhonePermission = ContextCompat.checkSelfPermission(Splash.this,
                Manifest.permission.READ_PHONE_STATE);

        if (Build.VERSION.SDK_INT >= 23){
            if (hasWriteExternalStoragePermission != PackageManager.PERMISSION_GRANTED) {
                boolean checkPermission = checkPermission();
            } else if (hasReadExternalStoragePermission != PackageManager.PERMISSION_GRANTED){
                boolean checkPermission = checkPermission();
//            } else if (hasAccessFineLocationPermission != PackageManager.PERMISSION_GRANTED){
//                boolean checkPermission = checkPermission();
//            } else if (hasCameraPermission != PackageManager.PERMISSION_GRANTED){
//                boolean checkPermission = checkPermission();
            } else if (hasPhonePermission != PackageManager.PERMISSION_GRANTED){
                boolean checkPermission = checkPermission();
            }  else {
//                StartAnimations();
//                checkStatusMenu();
                continuesss();
            }
        } else {
//            StartAnimations();
//            checkStatusMenu();
            continuesss();
        }
    }

    private boolean checkPermission() {

        AlertDialog.Builder builder = new AlertDialog.Builder(Splash.this);
        builder.setMessage("You need to allow access. . .");
        builder.setCancelable(false);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                if (!ActivityCompat.shouldShowRequestPermissionRationale(Splash.this,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        && !ActivityCompat.shouldShowRequestPermissionRationale(Splash.this,
                        Manifest.permission.READ_EXTERNAL_STORAGE)
                        &&!ActivityCompat.shouldShowRequestPermissionRationale(Splash.this,
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        &&!ActivityCompat.shouldShowRequestPermissionRationale(Splash.this,
                        Manifest.permission.CAMERA)
                        &&!ActivityCompat.shouldShowRequestPermissionRationale(Splash.this,
                        Manifest.permission.VIBRATE)
                        &&!ActivityCompat.shouldShowRequestPermissionRationale(Splash.this,
                        Manifest.permission.READ_PHONE_STATE)){
                    ActivityCompat.requestPermissions(Splash.this,
                            new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_PHONE_STATE},
                            REQUEST_CODE_ASK_PERMISSIONS);
                    dialog.dismiss();

                }
                ActivityCompat.requestPermissions(Splash.this,
                        new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CAMERA, Manifest.permission.READ_PHONE_STATE},
                        REQUEST_CODE_ASK_PERMISSIONS);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();

        return true;
    }

}
