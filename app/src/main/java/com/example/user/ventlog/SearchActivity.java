
package com.example.user.ventlog;

import android.support.constraint.ConstraintLayout;
import android.support.constraint.solver.widgets.Snapshot;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.DatePicker;
import android.widget.EditText;

import com.example.user.ventlog.R;
//import com.example.user.ventlog.ventlog.SearchAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
/**
 * __Searching events by their properties.___
 * @author __Ece Çanga___
 * @version __11.05.2018__
 */

public class SearchActivity extends AppCompatActivity {
    EditText search_edit_text;
    RecyclerView recyclerView;
    DatabaseReference databaseReference;
    FirebaseUser firebaseUser;
    ArrayList<String> titleList;
    ArrayList<String> dateList;
    ArrayList<String> withWhoList;
    ArrayList<String> locationList;
    ArrayList<String> commentsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_search_bar);

        //search_edit_text = (EditText) findViewById(R.id.search_edit_text);
        //recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        /*
         * Create a array list for each node you want to use
         * */
        titleList = new ArrayList<String>();
        dateList = new ArrayList<String>();
        withWhoList = new ArrayList<String>();
        locationList = new ArrayList<String>();
        commentsList = new ArrayList<String>();

        search_edit_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!editable.toString().isEmpty()) {
                    setAdapter(editable.toString());
                }  else {
                    /*
                     * Clear the list when editText is empty
                     * */
                    titleList.clear();
                    withWhoList.clear();
                    commentsList.clear();
                    dateList.clear();
                    recyclerView.removeAllViews();
                }
            }
        });
    }

    private void setAdapter(final String searchedString) {
        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /*
                 * Clear the list for every new search
                 * */
                titleList.clear();
                dateList.clear();
                commentsList.clear();
                locationList.clear();
                withWhoList.clear();
                recyclerView.removeAllViews();

                int counter = 0;

                /*
                 * Search all users for matching searched string
                 * */
                for (DataSnapshot snapShot : dataSnapshot.getChildren()) {
                    String uid = snapShot.getKey();
                    String title = snapShot.child("title").getValue(String.class);
                    String who = snapShot.child("who").getValue(String.class);
                    String date = snapShot.child("date").getValue(String.class);
                    String comments = snapShot.child("comments").getValue(String.class);

                    if (title.contains(searchedString.toLowerCase())) {
                        titleList.add(title);
                        withWhoList.add(who);
                        dateList.add(date);
                        commentsList.add(comments);
                        counter++;
                    } else if (who.contains(searchedString.toLowerCase())) {
                        titleList.add(title);
                        withWhoList.add(who);
                        dateList.add(date);
                        commentsList.add(comments);
                        counter++;
                    } else if (date.contains(searchedString.toLowerCase())) {
                        titleList.add(title);
                        withWhoList.add(who);
                        dateList.add(date);
                        counter++;
                    } else if (comments.contains(searchedString.toLowerCase())) {
                        titleList.add(title);
                        withWhoList.add(who);
                        dateList.add(date);
                        commentsList.add(comments);
                        counter++;
                    }

                    /*
                     * Get maximum of 15 searched results only
                     * */
                    if (counter == 15) {
                        break;
                    }
                }

                //SearchAdapter searchAdapter = new SearchAdapter(SearchActivity.this, titleList, dateList, withWhoList, locationList, commentsList);
                //recyclerView.setAdapter(searchAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
