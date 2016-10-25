package com.example.liwei.idiotjigsaw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by Liwei on 2016/8/17.
 */
public class EventAdapter extends BaseAdapter {
    private int imgID;
    private int score;
    private String name;
    private Context context;

    private LinkedList<Achievement> achievements;

    public EventAdapter(int imgID,String name,int score,Context context){
        this.imgID = imgID;
        this.name = name;
        this.score = score;
        this.context = context;
    }

    public EventAdapter(Context context){////////////////////////////////////////////
        achievements = new LinkedList<Achievement>();
        this.context = context;
    }
    public EventAdapter(LinkedList<Achievement> achievements,Context context){
        this.context = context;
        this.achievements = achievements;
    }
    @Override
    public int getCount() {
        return achievements.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item,viewGroup,false);
            viewHolder = new ViewHolder();
            viewHolder.headPhoto = (ImageView) view.findViewById(R.id.head);
            viewHolder.txtScore = (TextView) view.findViewById(R.id.score);
            viewHolder.txtDatetime = (TextView) view.findViewById(R.id.datetime);

            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }



        viewHolder.headPhoto.setBackgroundResource(R.mipmap.ic_launcher);
        viewHolder.txtDatetime.setText(achievements.get(i).getDatetime());
        viewHolder.txtScore.setText("" + achievements.get(i).getScore());
        return view;
    }

    public class ViewHolder{
        TextView txtScore;
        TextView txtDatetime;
        ImageView headPhoto;
    }

    public void addOneAchievement(Achievement achievement){
        achievements.add(achievement);
        notifyDataSetChanged();
    }
}
