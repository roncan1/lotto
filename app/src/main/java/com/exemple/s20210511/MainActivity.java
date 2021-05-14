package com.exemple.s20210511;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView [][] tvnum;
    Button bt_start;
    int [][] num ;

    int[][] id_num ={
            {  R.id.TV_num_00,  R.id.TV_num_01,  R.id.TV_num_02,  R.id.TV_num_03,  R.id.TV_num_04,  R.id.TV_num_05  },
            {  R.id.TV_num_10,  R.id.TV_num_11,  R.id.TV_num_12,  R.id.TV_num_13,  R.id.TV_num_14,  R.id.TV_num_15  },
            {  R.id.TV_num_20,  R.id.TV_num_21,  R.id.TV_num_22,  R.id.TV_num_23,  R.id.TV_num_24,  R.id.TV_num_25  },
            {  R.id.TV_num_30,  R.id.TV_num_31,  R.id.TV_num_32,  R.id.TV_num_33,  R.id.TV_num_34,  R.id.TV_num_35  },
            {  R.id.TV_num_40,  R.id.TV_num_41,  R.id.TV_num_42,  R.id.TV_num_43,  R.id.TV_num_44,  R.id.TV_num_45  }
    };

    int [] id_ball = {
            R.drawable.b01, R.drawable.b02, R.drawable.b03, R.drawable.b04, R.drawable.b05,
            R.drawable.b06, R.drawable.b07, R.drawable.b08, R.drawable.b09, R.drawable.b10,
            R.drawable.b11, R.drawable.b12, R.drawable.b13, R.drawable.b14, R.drawable.b15,
            R.drawable.b16, R.drawable.b17, R.drawable.b18, R.drawable.b19, R.drawable.b20,
            R.drawable.b21, R.drawable.b22, R.drawable.b23, R.drawable.b24, R.drawable.b25,
            R.drawable.b26, R.drawable.b27, R.drawable.b28, R.drawable.b29, R.drawable.b30,
            R.drawable.b31, R.drawable.b32, R.drawable.b33, R.drawable.b34, R.drawable.b35,
            R.drawable.b36, R.drawable.b37, R.drawable.b38, R.drawable.b39, R.drawable.b40,
            R.drawable.b41, R.drawable.b42, R.drawable.b43, R.drawable.b44, R.drawable.b45
    };

    Random ran;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_start = (Button)findViewById(R.id.BT_start);
        bt_start.setOnClickListener(this);

        tvnum = new TextView[5][6];
        num = new int[5][6];

        for(int  y=0; y<5 ; y++){
            for(int x=0; x<6 ; x++){
                tvnum[y][x] = (TextView)findViewById(id_num[y][x]);
            }
        }
        ran = new Random();
    }




    @Override
    public void onClick(View v) {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 6; x++) {
                num[y][x] = check_num(y, x);
            }
            sort(y);
        }
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 6; x++) {
                int temp;
                temp = num[y][x];
                tvnum[y][x].setBackgroundResource(id_ball[temp]);
            }
        }
    }

    private int check_num(int yy, int xx) {
        boolean check = true;
        int temp_num;
        temp_num = ran.nextInt(45);
        while (check){
            check = false;
            for(int x = 0 ; x < xx ; x++){
                if(num[yy][x] == temp_num){
                    check = true;
                    temp_num = ran.nextInt(45);
                }
            }
        }
        return temp_num;
    }

    private void sort(int y) {
        int temp;
        for(int i = 0 ; i < 6 ; i++){
            for(int k = i ; k < 6 ; k++) {
                if(num[y][k] < num[y][i] ){
                    temp = num[y][k];
                    num[y][k] = num[y][i];
                    num[y][i] = temp;
                }
            }
        }
    }
}
