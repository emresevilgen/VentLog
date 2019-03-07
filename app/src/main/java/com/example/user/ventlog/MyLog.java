package com.example.user.ventlog;
import com.example.user.ventlog.ventlog.Event;
import com.example.user.ventlog.ventlog.VentLog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * __Main part of the app, provides a menu with drawer screen, event adding button, listView of past events.
 *  Getting data from Firebase is processed at this class.Then it is send to PostEvent class to create views.___
 * @author __Meryem Banu Cavlak. Utku Kalkanlı. Münib Emre Sevilgen. Ece Çanga.___
 * @version __11.05.2018__
 */


public class MyLog extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    VentLog ventlog;
    TextView tv;


    ArrayList<String> emailFromFb;
    ArrayList<String> titleFromFb;
    ArrayList<String> dateFromFb;
    ArrayList<String> locationFromFb;
    ArrayList<String> whoFromFb;
    ArrayList<String> commentFromFb;
    ArrayList<String> imageFromFb;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    ListView listView;
    PostEvent adapter;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ventlog = (VentLog) getIntent().getSerializableExtra("mylog");


        setContentView(R.layout.activity_my_log2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),EventAdding.class);
                intent.putExtra("mylog",ventlog);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        emailFromFb = new ArrayList<>();
        titleFromFb = new ArrayList<>();
        dateFromFb = new ArrayList<>();
        locationFromFb = new ArrayList<>();
        whoFromFb = new ArrayList<>();
        commentFromFb = new ArrayList<>();
        imageFromFb = new ArrayList<>();


        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        myRef = firebaseDatabase.getReference();


        listView = findViewById(R.id.listView);

        // creating an adapter class, it will be used to adapt Firebase data to view.
        adapter = new PostEvent(emailFromFb,titleFromFb,dateFromFb,locationFromFb,whoFromFb,commentFromFb,imageFromFb,this);

        listView.setAdapter(adapter);

        // when user clicks on certain event, it opens a new page that shows the event fully.
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                com.example.user.ventlog.ventlog.Event event;
                event = new Event();
                event.setTitle(titleFromFb.get(i));
                event.setDate(dateFromFb.get(i));
                event.setLocation(locationFromFb.get(i));
                event.setText(commentFromFb.get(i));
                event.setWithPeople(whoFromFb.get(i));
                event.addMedia(imageFromFb.get(i));

                Intent intent = new Intent( getApplicationContext(), ShowEventActivity.class);
                intent.putExtra("event",event);
                startActivity( intent);

            }
        });


        getDataFromFireBase();


    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_log, menu);
        tv = (TextView) findViewById(R.id.menuUserEmail);
        tv.setText(ventlog.getSettings().getUser().getEmail());
        tv = (TextView) findViewById(R.id.menuUserName);
        tv.setText(ventlog.getSettings().getUser().getName());
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


    /**
     * The menu selection button. The clicked item on drawer menu navigates user to selected activity in this method.
     * @param item
     * @return
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.menuMyLog) {

        } else if (id == R.id.menuAddGroupLog) {
            Toast.makeText(getApplicationContext(), "This page has not been properly implemented yet", Toast.LENGTH_LONG).show();
        } else if (id == R.id.menuCollages) {
            Toast.makeText(getApplicationContext(), "This page has not been properly implemented yet", Toast.LENGTH_LONG).show();
        } else if (id == R.id.menuArchive) {
            Toast.makeText(getApplicationContext(), "This page has not been properly implemented yet", Toast.LENGTH_LONG).show();
        } else if (id == R.id.menuTrash) {
            Toast.makeText(getApplicationContext(), "This page has not been properly implemented yet", Toast.LENGTH_LONG).show();
        } else if (id == R.id.menuSettings) {
            Intent intent = new Intent( getApplicationContext(), SettingsActivity.class);
            intent.putExtra("mylog",ventlog);
            startActivity( intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /**
     * This method uses Firebase properties and gets certain data from database in ArrayLists.
     */
    protected void getDataFromFireBase()
    {

        // getting current users e-mail, because users are remembered by their e-mails, and we will use it to download data from Firebase.
        FirebaseUser user = mAuth.getCurrentUser();
        String userEmail = user.getEmail().toString();
        String userName = "";
        for(int i = 0; i < userEmail.length(); i++)
        {
            if(userEmail.charAt(i) == '.')
            {
                userName = userEmail.substring(0,i); // cutting "." because it is not allowed to use in Firebase references.
            }
        }
        DatabaseReference newReference = firebaseDatabase.getReference().child("EventPosts").child(userName); // getting related database reference by username.

        newReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) // when data changes in Firebase library.
            {
                //System.out.println("children" + dataSnapshot.getChildren());
                //System.out.println("key" + dataSnapshot.getKey());
                //System.out.println("value" + dataSnapshot.getValue());

                for(DataSnapshot fb : dataSnapshot.getChildren())
                {
                    HashMap<String,String> hashMap = (HashMap<String, String>) fb.getValue();

                    emailFromFb.add(hashMap.get("useremail"));
                    titleFromFb.add(hashMap.get("title"));
                    dateFromFb.add(hashMap.get("date"));
                    locationFromFb.add(hashMap.get("location"));
                    whoFromFb.add(hashMap.get("who"));
                    commentFromFb.add(hashMap.get("comment"));
                    imageFromFb.add(hashMap.get("downloadurl"));

                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    public VentLog getVentlog() {
        return ventlog;
    }
}
