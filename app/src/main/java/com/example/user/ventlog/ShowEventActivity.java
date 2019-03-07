package com.example.user.ventlog;

import com.example.user.ventlog.ventlog.*;
import com.squareup.picasso.Picasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
/**
 * __This activity shows the event fully to user when it is clicked on the event flow on MyLog.___
 * @author __Münib Emre Sevilgen. Tuana Türkmen. Efe Dağdemir.___
 * @version __11.05.2018__
 */

public class ShowEventActivity extends AppCompatActivity {
    Event event;
    TextView title;
    TextView date;
    TextView location;
    TextView with;
    TextView comments;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_event);

        event = (Event) getIntent().getSerializableExtra("event");
        title = findViewById(R.id.titleTextShow);
        date = findViewById(R.id.dateTextShow);
        location = findViewById(R.id.locationTextShow);
        with = findViewById(R.id.withTextShow);
        comments = findViewById(R.id.commentsTextShow);
        image = findViewById( R.id.imageView3);
        title.setText(event.getTitle());
        date.setText(event.getDate());
        location.setText(event.getLocation());
        with.setText(event.getWithPeople());
        comments.setText(event.getText());

        Picasso.get().load(event.getMediaList().get(0)).into(image);
    }

    public void pinEvent() {
        if ( event.getIsPinned())
            event.setIsPinned( false);
        else
            event.setIsPinned(true);
    }

    public void trashEvent() {

    }

    public void archiveEvent() {

    }

    public void editEvent() {

    }
}
