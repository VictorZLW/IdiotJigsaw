package com.example.liwei.idiotjigsaw;

import android.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.LinkedList;

/**
 * Created by Liwei on 2016/8/17.
 */
public class EventFragment extends Fragment {
    private ListView eventList;
    //private String[] strList = new String[]{"中国","美国","英国","日本"};
    EventAdapter eventAdapter;
    LinkedList<Achievement> achievements;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_event,container,false);
        eventList = (ListView) view.findViewById(R.id.list_event);
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                //android.R.layout.simple_list_item_1,strList);
        //eventList.setAdapter(arrayAdapter);
        eventAdapter = new EventAdapter(getActivity());
        //EventAdapter eva = new EventAdapter(R.mipmap.ic_launcher,"android",0,getActivity());
        //achievements = new LinkedList<Achievement>();
        //eventAdapter = new EventAdapter(achievements,getActivity());
        eventList.setAdapter(eventAdapter);
        return view;
    }
}
