package com.a1techandroid.test_preperation_app;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.a1techandroid.test_preperation_app.Fragments.AboutFragment;
import com.a1techandroid.test_preperation_app.Fragments.HistoryFragment;
import com.a1techandroid.test_preperation_app.Fragments.HomeFragment;
import com.a1techandroid.test_preperation_app.Fragments.RequirementFragment;
import com.a1techandroid.test_preperation_app.Fragments.SettingFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static com.facebook.FacebookSdk.getApplicationContext;

public class MainActivityNew extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private FrameLayout frameLayout;
    private NavigationView navigationView;
    FirebaseAuth auth;
    FirebaseUser user ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        initializeViews();
        toggleDrawer();
        initializeDefaultFragment(savedInstanceState,0);
    }

    private void initializeViews() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("ISSB Test Prepearation App");
        setSupportActionBar(toolbar);
        frameLayout = findViewById(R.id.framelayout_id);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationview_id);
        navigationView.setNavigationItemSelectedListener(this);

        View headerLayout = navigationView.getHeaderView(0);
        TextView name = headerLayout.findViewById(R.id.nav_header_name_id);
        TextView email = headerLayout.findViewById(R.id.nav_header_emailaddress_id);
        email.setText(user.getEmail());
    }

    private void toggleDrawer() {
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        //Checks if the navigation drawer is open -- If so, close it
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        // If drawer is already close -- Do not override original functionality
        else {
            super.onBackPressed();
        }
    }

    private void initializeDefaultFragment(Bundle savedInstanceState, int itemIndex){
        if (savedInstanceState == null){
            MenuItem menuItem = navigationView.getMenu().getItem(itemIndex);
            onNavigationItemSelected(menuItem);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){

            case R.id.item0:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new HomeFragment()).addToBackStack("home")
                        .commit();
                closeDrawer();
                break;
            case R.id.item1:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new HistoryFragment()).addToBackStack("history")
                        .commit();
                closeDrawer();
                break;
            case R.id.item2:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id, new SettingFragment()).addToBackStack("setting")
                        .commit();
                closeDrawer();
                break;
            case R.id.item3:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new AboutFragment()).addToBackStack("about")
                        .commit();
                closeDrawer();
                break;
            case R.id.item4:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_id,new RequirementFragment()).addToBackStack("requirement")
                        .commit();
                closeDrawer();
                break;
            case R.id.item5:
                showPopUp();
                deSelectCheckedState();
                closeDrawer();
                break;
        }
        return true;
    }

    private void deSelectCheckedState(){
        int noOfItems = navigationView.getMenu().size();
        for (int i=0; i<noOfItems;i++){
            navigationView.getMenu().getItem(i).setChecked(false);
        }
    }

    private void closeDrawer(){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    void showPopUp(){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivityNew.this);
        builder.setTitle("Are you sure?");
        builder.setMessage("Want to logout");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivty.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                finish();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();

    }


}
