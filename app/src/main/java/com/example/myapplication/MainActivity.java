package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        SachbearbeiterErfassenK sErfassen = new SachbearbeiterErfassenK();
        sErfassen.erfasseSachbearbeiter("Drew Decker", "screamqueen", false);
        sErfassen.erfasseSachbearbeiter("Cindy Campbell", "ghostface", true);
        sErfassen.erfasseSachbearbeiter("Bobby Prinze", "whatsyourfavoritemovie", false);
        sErfassen.erfasseSachbearbeiter("Brenda Meeks", "thatswhatfriendsarefor", false);
        sErfassen.erfasseSachbearbeiter("Ray Wilkins", "gottagetoutalive", false);
        sErfassen.erfasseSachbearbeiter("Shorty Meeks", "shortyisback", false);
        sErfassen.erfasseSachbearbeiter("Greg Phillipe", "scarymoviesrule", false);
        sErfassen.erfasseSachbearbeiter("Buffy Gilmore", "slaythehorror", false);
        sErfassen.erfasseSachbearbeiter("Doofy Gilmore", "doofylaughs", false);
        sErfassen.erfasseSachbearbeiter("Gail Hailstorm", "gailforcewind", true);
        sErfassen.erfasseSachbearbeiter("Default", "default1", true);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        

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
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}