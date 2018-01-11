package com.example.passapon.getpostarduino2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.passapon.getpostarduino2.Fragment.MainFragment;
import com.physicaloid.lib.Physicaloid;
import com.physicaloid.lib.usb.driver.uart.ReadLisener;

public class MainActivity extends AppCompatActivity {

    private Physicaloid physicaloid;
    private String resultString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Add Fragment
//        addFragment(savedInstanceState);
//         Receive Arduino
        receiveArduino();


    } // Main Method

    private void receiveArduino() {
        try {

            if (physicaloid.open()) {

                physicaloid.addReadListener(new ReadLisener() {
                    @Override
                    public void onRead(int i) {

                        byte[] bytes = new byte[i];
                        physicaloid.read(bytes, i);
                        resultString = new String(bytes);
                        showMessage("Result==>"+resultString);

                        if (resultString.equals("9")) {
                            openScanQRcode();
                        }

                    }
                });

            } else {
            }


        } catch (Exception e) {

            showMessage("Error ==> " + e.toString());
        }

    }



    private void showMessage(String messageSting) {
        Toast.makeText(MainActivity.this,messageSting,
                Toast.LENGTH_LONG).show();

    }

    public void clickTestReceiveByArduino(View view) {
        openScanQRcode();
    }

    private void openScanQRcode() {
        Toast.makeText(MainActivity.this, getString(R.string.receive_ok),
                Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, ScanCodeActivity.class);
        startActivity(intent);

    } // openScanQRcode

//    private void addFragment(Bundle savedInstanceState) {
//        if (savedInstanceState == null) {
//
//            getSupportFragmentManager().beginTransaction()
//                    .add(R.id.contentMainFragment, new MainFragment())
//                    .commit();
//        }
//    }
} // Main Class
