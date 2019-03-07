package com.example.user.ventlog;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * __This class gets ArrayLists of Firebase data that contains event properties.Then it fills these data to custom_view.xml
 *   custom_view.xml is used for filling listView in MyLog.So this class becomes a bridge between Firebase database and MyLog listView. ___
 * @author __Utku Kalkanlı___
 * @version __11.05.2018__
 */

public class PostEvent extends ArrayAdapter<String> {

    private final ArrayList<String> usermail;
    private final ArrayList<String> eventTitle;
    private final ArrayList<String> eventDate;
    private final ArrayList<String> eventLocation;
    private final ArrayList<String> eventWho;
    private final ArrayList<String> eventComment;
    private final ArrayList<String> eventImageView;
    private final Activity context;


    public PostEvent(ArrayList<String> usermail, ArrayList<String> eventTitle, ArrayList<String> eventDate, ArrayList<String> eventLocation, ArrayList<String> eventWho, ArrayList<String> eventComment, ArrayList<String> eventImageView, Activity context) {

        super(context,R.layout.custom_view,usermail);
        this.usermail = usermail;
        this.eventTitle = eventTitle;
        this.eventDate = eventDate;
        this.eventLocation = eventLocation;
        this.eventWho = eventWho;
        this.eventComment = eventComment;
        this.eventImageView = eventImageView;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {

        // makes us able to reach and change "custom_view" components
        LayoutInflater layoutInflater = context.getLayoutInflater();
        View customView = layoutInflater.inflate(R.layout.custom_view , null, false);

        // getting components of "custom_view.xml"
        TextView title = customView.findViewById(R.id.customTitle);
        TextView date = customView.findViewById(R.id.customDate);
        TextView location = customView.findViewById(R.id.customLocation);
        TextView who = customView.findViewById(R.id.customWho);
        TextView comment = customView.findViewById(R.id.customComment);
        ImageView imageView = customView.findViewById(R.id.customImageView);

        // setting "custom_view.xml" components to values taken from getView (position)
        title.setText(eventTitle.get(position));
        date.setText(eventDate.get(position));
        location.setText(eventLocation.get(position));
        who.setText(eventWho.get(position));
        comment.setText(eventComment.get(position));
        // Picasso is an open source image downloading and catching library for android. It gets the url of an image and puts into an imageView object.
        Picasso.get().load(eventImageView.get(position)).into(imageView);


        return customView;
    }


}
