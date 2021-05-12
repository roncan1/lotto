package com.exemple.s20210511;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvnum[][];
    Button bt_start;
    int num[][];

    int id_num[][] = {
            {R.id.TV_num_00, R.id.TV_num_01, R.id.TV_num_02, R.id.TV_num_03, R.id.TV_num_04, R.id.TV_num_05,},
            {R.id.TV_num_10, R.id.TV_num_11, R.id.TV_num_12, R.id.TV_num_13, R.id.TV_num_14, R.id.TV_num_15,},
            {R.id.TV_num_20, R.id.TV_num_21, R.id.TV_num_22, R.id.TV_num_23, R.id.TV_num_24, R.id.TV_num_25,},
            {R.id.TV_num_30, R.id.TV_num_31, R.id.TV_num_32, R.id.TV_num_33, R.id.TV_num_34, R.id.TV_num_35,},
            {R.id.TV_num_40, R.id.TV_num_41, R.id.TV_num_42, R.id.TV_num_43, R.id.TV_num_44, R.id.TV_num_45,}
    };



    Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tvnum = new TextView[5][6];
        num = new int[5][6];
        for (int y = 0 ; y < 5 ; y++) {
            for (int x = 0 ; x < 6 ; x++) {
                tvnum[y][x] = (TextView)findViewById(id_num[y][x]);
            }
        }

        bt_start = (Button)findViewById(R.id.BT_start);
        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int y = 0 ; y < 5 ; y++) {
                    for (int x = 0 ; x < 6 ; x++) {
                        num[y][x] = check_num(y,x);
                    }
                    sort(y);
                }

                for (int y = 0 ; y < 5 ; y++) {
                    for (int x = 0 ; x < 6 ; x++) {
                        int temp;
                        temp = num[y][x];
                        tvnum[y][x].setText(temp);
                    }
                }
            }
        });

        random = new Random();

    }

    private void sort(int y) {
        int temp;
        for (int i = 0 ; i < 6 ; i++) {
            for (int k = i ; k < 6 ; k++) {
                if (num[y][i] > num[y][k]){

                    temp = num[y][k];
                    num[y][k] = num[y][i];
                    num[y][i] = temp;
                }
            }
        }
    }

    private int check_num(int yy, int xx) {
        boolean check = true;
        int temp_num;
        temp_num = random.nextInt(45);
        while (check){
            check = false;
            for (int x = 0; x < xx ; x++) {
                if (num[yy][x] == temp_num) {
                    check = true;
                    temp_num = random.nextInt(45);
                }
            }
        }
        return temp_num;
    }
}