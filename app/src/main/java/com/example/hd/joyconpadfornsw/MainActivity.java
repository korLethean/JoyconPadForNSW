package com.example.hd.joyconpadfornsw;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static String IP = "192.168.0.13";

    private static final int PORT = 5672;
    private Socket clientSocket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Handler handler;
    private String writeMsg, readMsg;

    private Button btnUp;
    private Button btnDown;
    private Button btnLeft;
    private Button btnRight;
    private Button btnA;
    private Button btnB;
    private Button btnX;
    private Button btnY;
    private Button btnSl;
    private Button btnSr;
    private Button btnZ;
    private Button btnZl;
    private Button btnConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();

        btnUp = (Button) findViewById(R.id.button_up);
        btnDown = (Button) findViewById(R.id.button_down);
        btnLeft = (Button) findViewById(R.id.button_left);
        btnRight = (Button) findViewById(R.id.button_right);
        btnA = (Button) findViewById(R.id.button_a);
        btnB = (Button) findViewById(R.id.button_b);
        btnX = (Button) findViewById(R.id.button_x);
        btnY = (Button) findViewById(R.id.button_y);
        btnSl = (Button) findViewById(R.id.button_sl);
        btnSr = (Button) findViewById(R.id.button_sr);
        btnZ = (Button) findViewById(R.id.button_z);
        btnZl = (Button) findViewById(R.id.button_zl);
        btnConnect = (Button) findViewById(R.id.button_connect);
        btnConnect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                connectClickEvent(v);
            }
        });

        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    outputStream.writeUTF(new String("U"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    outputStream.writeUTF(new String("D"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    outputStream.writeUTF(new String("L"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    outputStream.writeUTF(new String("R"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    outputStream.writeUTF(new String("A"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    outputStream.writeUTF(new String("B"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    outputStream.writeUTF(new String("X"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    outputStream.writeUTF(new String("Y"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnSl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    outputStream.writeUTF(new String("Sl"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnSr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    outputStream.writeUTF(new String("Sr"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    outputStream.writeUTF(new String("Z"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        btnZl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                try {
                    outputStream.writeUTF(new String("Zl"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    protected void onStop() {
        super.onStop();
        try {
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void connectClickEvent(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    clientSocket = new Socket(InetAddress.getByName(IP), PORT);
                    Log.d("ClientLog", "Connected");
                    inputStream = new DataInputStream(clientSocket.getInputStream());
                    outputStream = new DataOutputStream(clientSocket.getOutputStream());

                    outputStream.writeUTF("JoyconPad");
                    while (inputStream != null) {
                        try {
                            readMsg = inputStream.readUTF();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        handler.sendEmptyMessage(1);
                    }
                    } catch (UnknownHostException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }

