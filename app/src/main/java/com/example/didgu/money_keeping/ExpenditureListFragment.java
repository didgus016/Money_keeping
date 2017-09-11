package com.example.didgu.money_keeping;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by didgu on 2017-06-30.
 */

public class ExpenditureListFragment extends Fragment {

    View rootView;
    ArrayList<Expenditure> expends = new ArrayList<>();
    DatabaseReference entryRef = FirebaseDatabase.getInstance().getReference().child("entry").child("user1");

    @Nullable
    @Override
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
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w(TAG, "loadExpend:onCancelled", databaseError.toException());
            }
        });
        return rootView;
    }

    // Sort the array and then populate the list view
    private void populate()
    {
        ExpendituresAdapter adapter = new ExpendituresAdapter(this.getContext(), expends);
        ListView lv = (ListView) rootView.findViewById(R.id.list);
        lv.setAdapter(adapter);
    }
}
