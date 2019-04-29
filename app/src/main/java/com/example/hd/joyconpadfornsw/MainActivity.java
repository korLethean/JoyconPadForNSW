package com.example.hd.joyconpadfornsw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import android.os.Handler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static String IP = "192.168.0.1";

    private static final int PORT = 5000;
    private Socket socket;
    private DataInputStream inputStream;
    private DataOutputStream outputStream;
    private Handler handler;
    private String writeMsg, readMsg;

    @BindView(R.id.button_up)
    Button btnUp;
    @BindView(R.id.button_down)
    Button btnDown;
    @BindView(R.id.button_left)
    Button btnLeft;
    @BindView(R.id.button_right)
    Button btnRight;
    @BindView(R.id.button_a)
    Button btnA;
    @BindView(R.id.button_b)
    Button btnB;
    @BindView(R.id.button_x)
    Button btnX;
    @BindView(R.id.button_y)
    Button btnY;
    @BindView(R.id.button_sl)
    Button btnSl;
    @BindView(R.id.button_sr)
    Button btnSr;
    @BindView(R.id.button_z)
    Button btnZ;
    @BindView(R.id.button_zl)
    Button btnZl;
    @BindView(R.id.button_connect)
    Button btnConnect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_connect})
    void connectClickEvent(Button button) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    socket = new Socket(InetAddress.getByName(IP), PORT);
                    inputStream = new DataInputStream(socket.getInputStream());
                    outputStream = new DataOutputStream(socket.getOutputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                while (true) {
                    try {
                        readMsg = inputStream.readUTF();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                            }
                        });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @OnClick({R.id.button_up, R.id.button_down, R.id.button_left, R.id.button_right, R.id.button_a, R.id.button_b, R.id.button_x, R.id.button_y, R.id.button_sl,
            R.id.button_sr, R.id.button_z, R.id.button_zl})
    void onClickEvent(Button button) {
        String str = button.getText().toString();
    }

}
