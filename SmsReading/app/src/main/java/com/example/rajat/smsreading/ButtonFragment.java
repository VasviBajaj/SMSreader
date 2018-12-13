package com.example.rajat.smsreading;


import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {

    Button btn1;
    public ButtonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_button, container, false);
        btn1 = v.findViewById(R.id.ask_but);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(getPermission())
                {
                    MessagesFragment mf = new MessagesFragment();
                    FragmentManager fg=getFragmentManager();
                    FragmentTransaction transaction = fg.beginTransaction();
                    transaction.replace(R.id.homepage, mf);
                    transaction.commit();
                }
                else
                {
                    getActivity().moveTaskToBack(true);
                    Process.killProcess(Process.myPid());
                    System.exit(1);
                }
            }
        });
        return v;
    }
    private boolean getPermission() {

        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_SMS},0);
        int sms = ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_SMS);

        if (sms != PackageManager.PERMISSION_GRANTED)
        {
            return false;
        }
        return true;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


}
