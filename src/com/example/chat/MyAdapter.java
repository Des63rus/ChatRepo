package com.example.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Vector;

/**
 * Created by User on 25.11.2014.
 */
public class MyAdapter extends android.widget.BaseAdapter {

    private Context mContext;


    Vector<Message> messageVector;
    RelativeLayout rl;

    public MyAdapter(Context mContext) {
        this.mContext = mContext;
        messageVector = Singleton.getInstance().getMessageVector();

    }

    @Override
    public int getCount() {
        return messageVector.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        rl = null;

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rl = (RelativeLayout) inflater.inflate(R.layout.chatmess, viewGroup, false);


        TextView tvMass = (TextView) rl.findViewById(R.id.tvMass);
        tvMass.setText(messageVector.get(i).getFrom() + ": "+ messageVector.get(i).getMessage());


        TextView tvFrom = (TextView) rl.findViewById(R.id.tvFrom);
        tvFrom.setText("TO: "+ messageVector.get(i).getTo());


        TextView tvTime = (TextView) rl.findViewById(R.id.tvTime);
        tvTime.setText(messageVector.get(i).getDate().toString().substring(11,16));



        return rl;

    }


    public Vector<Message> getMessageVector() {
        return messageVector;
    }

    public void setMessageVector(Vector<Message> messageVector) {
        this.messageVector = messageVector;
    }

}