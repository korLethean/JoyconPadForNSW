package com.example.hd.joyconpadfornsw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.button_up, R.id.button_down, R.id.button_left, R.id.button_right, R.id.button_a, R.id.button_b, R.id.button_x, R.id.button_y, R.id.button_sl,
            R.id.button_sr, R.id.button_z, R.id.button_zl})
    void onClickEvent(Button button) {
        String str = button.getText().toString();
    }

}
