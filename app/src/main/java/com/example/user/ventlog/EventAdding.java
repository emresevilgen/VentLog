package com.example.user.ventlog;
import com.example.user.ventlog.ventlog.*;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;

import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.ventlog.ventlog.Event;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.UUID;
/**
 * __This class access user gallery and uploads event properties to Firebase database.___
 * @author __Utku Kalkanlı . Münib Emre Sevilgen___
 * @version __11.05.2018__
 */

public class EventAdding extends Activity {

    EditText title;
    EditText date;
    EditText location;
    EditText who;
    EditText comment;
    ImageView imageView;
    private StorageReference mStorageRef;
    Uri selected;
    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;
    VentLog ventlog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_adding);
        ventlog = (VentLog) getIntent().getSerializableExtra("mylog");
        title = findViewById(R.id.titleText);
        date = findViewById(R.id.dateText);
        location = findViewById(R.id.locationText);
        who = findViewById(R.id.whoText);
        comment = findViewById(R.id.commentText);
        imageView = findViewById(R.id.postImageView);
        mAuth = FirebaseAuth.getInstance();

        mStorageRef = FirebaseStorage.getInstance().getReference();


        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();


    }


    /**
     * This method asks for gallery access permission, then sends user to media picking.
     * @param view comes from onClick.
     */
    public void chooseImage(View view)
    {
            // asks for permission to access gallery if it is not given.
        if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[] {Manifest.permission.READ_EXTERNAL_STORAGE} , 1);
        }
        else
        {
            // if permission was given it navigates user to media picking.
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent,2);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        if(requestCode == 1)
        {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,2);
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * This method sets selected image into bitmap, then into ImageView property.
     * @param requestCode The request code we passed to startActivityForResult()
     * @param resultCode if result is ok, if the operation was successful or cancelled.
     * @param data selected image data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if( requestCode == 2 && resultCode == RESULT_OK && data != null)
        {
            selected = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selected);
                imageView.setImageBitmap(bitmap);
            }catch (IOException e){ e.printStackTrace(); }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * This method uploads event properties to Firebase database.
     * @param view comes from onClick.
     */
    public void upload(View view)
    {
        // unique user id of every image. It is necessary to download from database when it is needed to use.
        UUID uuidImage = UUID.randomUUID();
        String imageName = "images/" + uuidImage + ".jpg" ;

        StorageReference storageReference = mStorageRef.child(imageName); // adding image to Firebase storage.
        storageReference.putFile(selected).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override

            // when uploading image is successful.
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                String downloadUrl = taskSnapshot.getDownloadUrl().toString();

                FirebaseUser user = mAuth.getCurrentUser();

                String eventEmail = user.getEmail().toString();
                String eventTitle = title.getText().toString();
                String eventDate = date.getText().toString();
                String eventLocation = location.getText().toString();
                String eventWho = who.getText().toString();
                String eventComment = comment.getText().toString();

                UUID uuid = UUID.randomUUID();
                String uuidString = uuid.toString();


                String userName = "";
                for(int i = 0; i < eventEmail.length(); i++)
                {
                    if(eventEmail.charAt(i) == '.')
                    {
                        userName = eventEmail.substring(0,i); // Firebase does not allow any "." in child references, so we omit . when we see it to build a username.
                    }
                }

                myRef.child("EventPosts").child(userName).child(uuidString).child("useremail").setValue(eventEmail);
                myRef.child("EventPosts").child(userName).child(uuidString).child("title").setValue(eventTitle);
                myRef.child("EventPosts").child(userName).child(uuidString).child("date").setValue(eventDate);
                myRef.child("EventPosts").child(userName).child(uuidString).child("location").setValue(eventLocation);
                myRef.child("EventPosts").child(userName).child(uuidString).child("who").setValue(eventWho);
                myRef.child("EventPosts").child(userName).child(uuidString).child("comment").setValue(eventComment);
                myRef.child("EventPosts").child(userName).child(uuidString).child("downloadurl").setValue(downloadUrl);


                Toast.makeText(getApplicationContext(), "Event Added", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MyLog.class);
                intent.putExtra("mylog",ventlog);
                startActivity(intent);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(), e.getLocalizedMessage(), Toast.LENGTH_LONG).show();
            }
        });



    }

}
