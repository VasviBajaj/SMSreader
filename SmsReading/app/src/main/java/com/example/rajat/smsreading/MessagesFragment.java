package com.example.rajat.smsreading;


import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessagesFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<SMSData> smsList = new ArrayList<SMSData>();
    public MessagesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_messages, container, false);
        recyclerView= (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Cursor cursor = getActivity().getContentResolver().query(Uri.parse("content://sms/inbox"), null, null, null, null);
        getActivity().startManagingCursor(cursor);
        if (cursor.moveToFirst()) { // must check the result to prevent exception
            for(int i=0; i < cursor.getCount(); i++) {
                SMSData sms = new SMSData();
                sms.setBody(cursor.getString(cursor.getColumnIndexOrThrow("body")).toString());
                sms.setAddr(cursor.getString(cursor.getColumnIndexOrThrow("address")).toString());
                sms.setRec_date(cursor.getString(cursor.getColumnIndexOrThrow("date")));
                sms.setSend_date(cursor.getString(cursor.getColumnIndexOrThrow("date_sent")));
                smsList.add(sms);
                cursor.moveToNext();
            }
            adapter=new MyAdapter(getActivity(),smsList);
            recyclerView.setAdapter(adapter);
        } else {
            // empty box, no SMS
        }
        return v;
    }

}
