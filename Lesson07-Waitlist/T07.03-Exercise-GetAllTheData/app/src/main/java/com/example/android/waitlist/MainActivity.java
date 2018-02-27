package com.example.android.waitlist;

import com.example.android.waitlist.data.TestUtil;
import com.example.android.waitlist.data.WaitlistContract;
import com.example.android.waitlist.data.WaitlistDbHelper;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    private GuestListAdapter mAdapter;

    // COMPLETED (1) Create a local field member of type SQLiteDatabase called mDb
    private SQLiteDatabase mDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView waitlistRecyclerView;

        // Set local attributes to corresponding views
        waitlistRecyclerView = (RecyclerView) this.findViewById(R.id.all_guests_list_view);

        // Set layout for the RecyclerView, because it's a list we are using the linear layout
        waitlistRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create an adapter for that cursor to display the data

        // COMPLETED (2) Create a WaitlistDbHelper instance, pass "this" to the constructor as context
        // Create a DB helper (this will create the DB if run for the first time)
        WaitlistDbHelper waitlistDbHelper = new WaitlistDbHelper(this);

        // COMPLETED (3) Get a writable database reference using getWritableDatabase and store it in mDb
        // Keep a reference to the mDb until paused or killed.
        // Get a writable database because we will be adding restaurant customers
        // Can be Readable or Writable
        mDb = waitlistDbHelper.getWritableDatabase();

        // COMPLETED (4) call insertFakeData from TestUtil and pass the database reference mDb
        // Fill the database with fake data
        TestUtil.insertFakeData(mDb);

        // COMPLETED (7) Run the getAllGuests function and store the result in a Cursor variable
        Cursor allGuestCursor = getAllGuest();

        // COMPLETED (12) Pass the resulting cursor count to the adapter
        // Create an adapter for that cursor to display the data
        mAdapter = new GuestListAdapter(this, allGuestCursor.getCount());

        // Link the adapter to the RecyclerView
        waitlistRecyclerView.setAdapter(mAdapter);

    }

    /**
     * This method is called when user clicks on the Add to waitlist button
     *
     * @param view The calling view (button)
     */
    public void addToWaitlist(View view) {

    }

    // COMPLETED (5) Create a private method called getAllGuests that returns a cursor

    /**
     * * Query the mDb and get all guests from the waitlist table
     * *
     * * @return Cursor containing the list of guests
     * */

    private Cursor getAllGuest() {

        // COMPLETED (6) Inside, call query on mDb passing in the table name and projection String [] order by COLUMN_TIMESTAMP
        return mDb.query(
            WaitlistContract.WaitlistEntry.TABLE_NAME, //table
            null, //column array projector
            null, //selection
            null, //selection args array
            null, //group by
            null, //having
            WaitlistContract.WaitlistEntry.COLUMN_TIMESTAMP //orderby
        );

    }


}