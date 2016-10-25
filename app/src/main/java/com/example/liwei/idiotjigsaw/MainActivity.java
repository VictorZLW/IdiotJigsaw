package com.example.liwei.idiotjigsaw;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

    private TextView txtGame;
    private TextView txtEvent;
    private TextView txtSettings;
    private SettingsFragment settingsFrag;
    private EventFragment eventFrag;
    private GameFragment gameFrag;
    private FragmentManager fragManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        fragManager = getFragmentManager();

        FragmentTransaction fragTransaction = fragManager.beginTransaction();
        hideAll(fragTransaction);
        eventFrag = new EventFragment();
        fragTransaction.add(R.id.ly_content,eventFrag,"eventFrag");
        gameFrag = new GameFragment();
        fragTransaction.add(R.id.ly_content,gameFrag,"gameFrag");
        settingsFrag = new SettingsFragment();
        fragTransaction.add(R.id.ly_content,settingsFrag,"settingsFrag");

        fragTransaction.commit();

        bindViews();
        txtGame.performClick();

    }

    public void bindViews(){
        txtGame = (TextView)findViewById(R.id.txt_game);
        txtEvent = (TextView)findViewById(R.id.txt_event);
        txtSettings = (TextView)findViewById(R.id.txt_settings);
        txtGame.setOnClickListener(this);
        txtEvent.setOnClickListener(this);
        txtSettings.setOnClickListener(this);
    }

    public void hideAll(FragmentTransaction fragmentTransaction){
        if(gameFrag != null)fragmentTransaction.hide(gameFrag);
        if(eventFrag != null)fragmentTransaction.hide(eventFrag);
        if(settingsFrag != null)fragmentTransaction.hide(settingsFrag);
    }

    public void setSelected(){
        txtGame.setSelected(false);
        txtEvent.setSelected(false);
        txtSettings.setSelected(false);
    }
    @Override
    public void onClick(View view) {
        FragmentTransaction fragTransaction = fragManager.beginTransaction();
        hideAll(fragTransaction);

        int txtID = view.getId();
        switch (txtID){
            case R.id.txt_game:{
                setSelected();
                txtGame.setSelected(true);
                if(gameFrag == null){
                    gameFrag = new GameFragment();
                    fragTransaction.add(R.id.ly_content,gameFrag,"gameFrag");
                }
                else
                    fragTransaction.show(gameFrag);
                break;
            }
            case R.id.txt_event:{
                setSelected();
                txtEvent.setSelected(true);
                if(eventFrag == null){
                    eventFrag = new EventFragment();
                    fragTransaction.add(R.id.ly_content,eventFrag,"eventFrag");
                }
                else
                    fragTransaction.show(eventFrag);
                break;
            }
            case R.id.txt_settings:{
                setSelected();
                txtSettings.setSelected(true);
                if(settingsFrag == null){
                    settingsFrag = new SettingsFragment();
                    fragTransaction.add(R.id.ly_content,settingsFrag,"settingsFrag");
                }
                else
                    fragTransaction.show(settingsFrag);
                break;
            }
            default:
                break;
        }
        fragTransaction.commit();
    }
}
