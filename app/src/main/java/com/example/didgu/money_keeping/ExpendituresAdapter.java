package com.example.didgu.money_keeping;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by didgu on 9/8/2017.
 */

public class ExpendituresAdapter extends ArrayAdapter<Expenditure> {
    public ExpendituresAdapter(Context context, ArrayList<Expenditure> expends)
    {
        super(context, 0, expends);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Expenditure curr = getItem(position);
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_expenditure, parent);
        }

        TextView name = (TextView) convertView.findViewById(R.id.name_id);
        TextView desc = (TextView) convertView.findViewById(R.id.desc_id);
        TextView amount = (TextView) convertView.findViewById(R.id.amount_id);
        TextView date = (TextView) convertView.findViewById(R.id.date_id);

        name.setText(curr.getName());
        desc.setText(curr.getDescription());
        amount.setText(curr.getAmount());
        date.setText(curr.getDate());

        return convertView;
    }
}
