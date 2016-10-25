package com.example.liwei.idiotjigsaw;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by Liwei on 2016/8/17.
 */
public class SettingsFragment extends Fragment implements OnItemSelectedListener,OnClickListener{

    String[] strList = new String[]{"teddy","rabbit","panda"};
    private Button btnAbout;
    private Button btnHelp;
    private Spinner spnSel;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings,container,false);

        btnAbout = (Button) view.findViewById(R.id.btn_about);
        btnHelp = (Button) view.findViewById(R.id.btn_help);
        spnSel = (Spinner) view.findViewById(R.id.spn_sel_game);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item,strList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnSel.setAdapter(arrayAdapter);
        spnSel.setOnItemSelectedListener(SettingsFragment.this);
        btnAbout.setOnClickListener(this);
        btnHelp.setOnClickListener(SettingsFragment.this);
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View view) {
        int btnID = view.getId();
        switch (btnID){
            case R.id.btn_about:{
                new AlertDialog.Builder(getActivity()).setTitle("About Idiot Jigsaw").
                        setMessage("祝你玩得愉快！").
                       setPositiveButton("确认",null).show();
                break;
            }
            case R.id.btn_help:{
                new AlertDialog.Builder(getActivity()).setTitle("Help").
                        setMessage("自力更生！").
                        setPositiveButton("确认",null).show();
                break;
            }
            default:
                break;
        }
    }
}
