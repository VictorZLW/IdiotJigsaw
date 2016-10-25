package com.example.liwei.idiotjigsaw;

import android.app.Fragment;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Liwei on 2016/8/17.
 */
public class GameFragment extends Fragment implements View.OnClickListener{

    private CheckBox btnStart;
    private ImageButton btnEnd;
    private Chronometer timer;
    private ImageView imgOrigin;
    private long timeRecord;
    private long totalTime;
    private long baseTime = 0;
    private Achievement achievement;

//    private ImageButton imgBtn1;
//    private ImageButton imgBtn2;
//    private ImageButton imgBtn3;
//    private ImageButton imgBtn4;
//    private ImageButton imgBtn5;
//    private ImageButton imgBtn6;
//    private ImageButton imgBtn7;
//    private ImageButton imgBtn8;
//    private ImageButton imgBtn9;

    private ImageButton[] cells = new ImageButton[9];

    private int EmptyCell = 8;

    private int[] stateOfCell = new int[]{0,1,2,3,4,5,6,7,8};
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game,container,false);
        bindViews(view);
        setStartButton();
        setEndButton();
        return view;
    }


    public void bindViews(View view){
        btnStart = (CheckBox) view.findViewById(R.id.btn_start);
        btnEnd = (ImageButton) view.findViewById(R.id.imgBtn_end);
        timer = (Chronometer) view.findViewById(R.id.timer);
        imgOrigin = (ImageView) view.findViewById(R.id.imgV_origin);

        cells[0] =  (ImageButton) view.findViewById(R.id.imageBtn_01);
        cells[1] =  (ImageButton) view.findViewById(R.id.imageBtn_02);
        cells[2] =  (ImageButton) view.findViewById(R.id.imageBtn_03);
        cells[3] =  (ImageButton) view.findViewById(R.id.imageBtn_04);
        cells[4] =  (ImageButton) view.findViewById(R.id.imageBtn_05);
        cells[5] =  (ImageButton) view.findViewById(R.id.imageBtn_06);
        cells[6] =  (ImageButton) view.findViewById(R.id.imageBtn_07);
        cells[7] =  (ImageButton) view.findViewById(R.id.imageBtn_08);
        cells[8] =  (ImageButton) view.findViewById(R.id.imageBtn_09);

        for(int i = 0;i < 9;i++){
            cells[i].setOnClickListener(this);
        }


    }

    private void setStartButton(){
        btnStart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    startTime();
                }else {
                    pauseTime();
                }
            }
        });

    }

    private void setEndButton(){


        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                totalTime = System.currentTimeMillis() - baseTime;
                endTime();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String datetime = dateFormat.format(new Date());
                long score = 1000 - totalTime / 1000;
                achievement = new Achievement((int)score,datetime);
                EventFragment eventFragment = (EventFragment)getFragmentManager().findFragmentByTag("eventFrag");
                eventFragment.eventAdapter.addOneAchievement(achievement);
            }
        });

    }



    public void startTime(){
        if(baseTime == 0){
            baseTime = System.currentTimeMillis();
        }
        timer.setBase(SystemClock.elapsedRealtime() - timeRecord);
        timer.start();
    }

    public void pauseTime(){
        timer.stop();
        timeRecord = SystemClock.elapsedRealtime() - timer.getBase();
    }

    public void endTime(){
        baseTime = 0;
        timeRecord = 0;
        btnStart.setChecked(false);
        timer.setBase(SystemClock.elapsedRealtime());
        timer.stop();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageBtn_01:
                if(EmptyCell == 1 || EmptyCell == 3){
                    cells[EmptyCell].setBackground(cells[0].getBackground());
                    cells[0].setBackgroundResource(R.mipmap.empty);
                    EmptyCell = 0;

                }
                break;
            case R.id.imageBtn_02:
                if(EmptyCell == 0 || EmptyCell == 2 || EmptyCell == 4){
                    cells[EmptyCell].setBackground(cells[1].getBackground());
                    cells[1].setBackgroundResource(R.mipmap.empty);
                    EmptyCell = 1;
                }
                break;
            case R.id.imageBtn_03:
                if(EmptyCell == 1 || EmptyCell == 5){
                    cells[EmptyCell].setBackground(cells[2].getBackground());
                    cells[2].setBackgroundResource(R.mipmap.empty);
                    EmptyCell = 2;
                }
                break;
            case R.id.imageBtn_04:
                if(EmptyCell == 0 || EmptyCell == 4 || EmptyCell == 6){
                    cells[EmptyCell].setBackground(cells[3].getBackground());
                    cells[3].setBackgroundResource(R.mipmap.empty);
                    EmptyCell = 3;
                }
                break;
            case R.id.imageBtn_05:
                if(EmptyCell == 1 || EmptyCell == 3 || EmptyCell == 5 || EmptyCell ==7){
                    cells[EmptyCell].setBackground(cells[4].getBackground());
                    cells[4].setBackgroundResource(R.mipmap.empty);
                    EmptyCell = 4;
                }
                break;
            case R.id.imageBtn_06:
                if(EmptyCell == 2 || EmptyCell == 4 || EmptyCell == 8){
                    cells[EmptyCell].setBackground(cells[5].getBackground());
                    cells[5].setBackgroundResource(R.mipmap.empty);
                    EmptyCell = 5;
                }
                break;
            case R.id.imageBtn_07:
                if(EmptyCell == 3 || EmptyCell == 7){
                    cells[EmptyCell].setBackground(cells[6].getBackground());
                    cells[6].setBackgroundResource(R.mipmap.empty);
                    EmptyCell = 6;
                }
                break;
            case R.id.imageBtn_08:
                //Log.i("呵呵呵","按钮被点击了");
                if(EmptyCell == 4 || EmptyCell == 6 || EmptyCell == 8){
                    cells[EmptyCell].setBackground(cells[7].getBackground());
                    cells[7].setBackgroundResource(R.mipmap.empty);
                    EmptyCell = 7;
                }
                break;
            case R.id.imageBtn_09:
                if(EmptyCell == 5 || EmptyCell == 7){
                    cells[EmptyCell].setBackground(cells[8].getBackground());
                    cells[8].setBackgroundResource(R.mipmap.empty);
                    EmptyCell = 8;
                }
                break;
            default:
                break;
        }
    }
}
