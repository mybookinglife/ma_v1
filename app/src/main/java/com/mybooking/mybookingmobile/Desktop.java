package com.mybooking.mybookingmobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Desktop extends AppCompatActivity implements View.OnClickListener {

    Button btnNewBooking;
    Button btnListBookings;

    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop);

        btnNewBooking = (Button) findViewById(R.id.btnNewBooking);
        btnListBookings = (Button) findViewById(R.id.btnListBookings);

        btnNewBooking.setOnClickListener(this);
        btnListBookings.setOnClickListener(this);

        dbHelper = new DBHelper(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNewBooking:
                Intent intentNewBooking = new Intent(this, NewBooking.class);
                startActivity(intentNewBooking);
                break;
            case R.id.btnListBookings:
                Intent intentListBookings = new Intent(this, ListBookings.class);
                startActivity(intentListBookings);
                break;
            default:
                break;
        }
    }
}
