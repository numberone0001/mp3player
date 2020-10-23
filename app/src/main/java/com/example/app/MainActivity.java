package com.example.app;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

import com.example.app.ui.main.Song;
import com.example.app.ui.main.SongRetriever;
import com.example.app.ui.main.SongTab;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.app.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(), new ArrayList<Song>());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (grantResults[0] != PackageManager.PERMISSION_GRANTED && requestCode == 1001) {
//            Toast.makeText(this, "read lox", Toast.LENGTH_LONG).show();
//        }
        switch (requestCode) {
            case 1234:
            {
                if (grantResults.length < 1 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "write lox", Toast.LENGTH_LONG).show();
                }
            }
            case 1001:
                if (grantResults.length < 1 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "write lox", Toast.LENGTH_LONG).show();
                }
            default:
        }
    }

    //    @Override
//    public void onResume() {
//        super.onResume();
//        requestForPermission();
//
//    }
//
//    public final String[] EXTERNAL_PERMS = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE
//    };
//
//    public final int EXTERNAL_REQUEST = 138;
//
//
//    public boolean requestForPermission() {
//
//        boolean isPermissionOn = true;
//        final int version = Build.VERSION.SDK_INT;
//        if (version >= 23) {
//            if (!canAccessExternalSd()) {
//                isPermissionOn = false;
//                requestPermissions(EXTERNAL_PERMS, EXTERNAL_REQUEST);
//            }
//        }
//
//        return isPermissionOn;
//    }
//
//    public boolean canAccessExternalSd() {
//        return (hasPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE));
//    }
//
//    private boolean hasPermission(String perm) {
//        return (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(this, perm));
//
//    }
}
