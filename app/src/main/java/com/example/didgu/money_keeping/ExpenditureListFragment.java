package com.example.didgu.money_keeping;

import android.app.ListFragment;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static android.content.ContentValues.TAG;

/**
 * Created by didgu on 2017-06-30.
 */

public class ExpenditureListFragment extends Fragment {

    View rootView;
    float monthlyAllowance = 0;
    float remainder = 0;
    float totalSpent = 0;
    ArrayList<Expenditure> expends = new ArrayList<>();
    DatabaseReference entryRef = FirebaseDatabase.getInstance().getReference().child("entry").child("user1");
    SharedPreferences sharedPref;

    @Nullable
    @Override
    @RequiresApi(api = Build.VERSION_CODES.N)
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_expend_list, container, false);
        entryRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Clear the ArrayList?
                expends.clear();
                for (DataSnapshot child:dataSnapshot.getChildren())
                    expends.add(child.getValue(Expenditure.class));
                populate();
                calculateRemainder();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadExpend:onCancelled", databaseError.toException());
            }
        });

        sharedPref = PreferenceManager.getDefaultSharedPreferences(getContext());

        // TODO: Implement preference change listener
        SharedPreferences.OnSharedPreferenceChangeListener listener =
                new SharedPreferences.OnSharedPreferenceChangeListener() {
                    public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
                        // listener implementation
                        calculateRemainder();
                    }
                };
        sharedPref.registerOnSharedPreferenceChangeListener(listener);
        calculateRemainder();
        return rootView;
    }

    // Sort the array and then populate the list view
    private void populate()
    {
        Collections.sort(expends, new ExpenditureDateComparator());
        ExpendituresAdapter adapter = new ExpendituresAdapter(this.getContext(), expends);
        ListView lv = (ListView) rootView.findViewById(R.id.list);
        lv.setAdapter(adapter);
    }

    // TODO: Get the total monthly expenditure, do subtraction
    // TODO: Change the db import to a Map of date(month year), and arraylist of details
    // TODO: Compare Months and year
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void calculateRemainder()
    {
        TextView tv = (TextView) rootView.findViewById(R.id.allowance);

        DateFormat df = new SimpleDateFormat("MM");
        Date date = new Date();
        String currMonth = df.format(date);
        Log.d("Curr Month", currMonth);
        for (int i = 0;i<expends.size(); i++)
        {
            try {
                if (df.format(expends.get(i).dateOut()).equals(currMonth))
                    totalSpent += expends.get(i).amountOut();
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        monthlyAllowance = getMonthlyAllowance();
        remainder = monthlyAllowance - totalSpent;
        tv.setText(String.format("%.2f", monthlyAllowance));
        tv = (TextView) rootView.findViewById(R.id.total);
        tv.setText(String.format("%.2f", totalSpent));
        tv = (TextView) rootView.findViewById(R.id.remain);
        tv.setText(String.format("%.2f", remainder));

    }

    private float getMonthlyAllowance()
    {
        String allow_temp = sharedPref.getString("mAllowance", "100");
        return Float.parseFloat(allow_temp);
    }
}
