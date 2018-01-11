package com.example.passapon.getpostarduino2.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.passapon.getpostarduino2.R;
import com.example.passapon.getpostarduino2.ScanCodeActivity;
import com.google.zxing.Result;

import java.util.logging.LogManager;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

/**
 * Created by Administrator on 11/1/2561.
 */

public class MainFragment extends Fragment {
    // Explicit
    private ZXingScannerView zXingScannerView;
    private String resultCodeString;


    @Override

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Button Controller
        buttonController();


    }   // Main Method

    private void buttonController() {
        Button button = getView().findViewById(R.id.btnRecevice);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScanQRcode();
            }
        });
    }

    private void openScanQRcode() {
        Toast.makeText(getActivity(), getString(R.string.receive_ok),
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ScanCodeActivity.class);
        startActivity(intent);



    } // openScanQRcode


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }

} // Main Class
