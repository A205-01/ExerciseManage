package com.loonies.exercisemanager.data;

import com.loonies.exercisemanager.R;
import com.loonies.exercisemanager.data.ListItemTextView;

import android.app.Activity;
import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;
/**
 * Created by ������ on 2015/8/3.
 */
public class ListViewAdapterA extends BaseAdapter {
    private Context context ;
    private List<ListItemTextView> data ;
    private List<ListItemTextView> dataAll;
    private int colorSwitch,size;
    private String now_time;
    private Activity a;
    public ListViewAdapterA(Context context,List<ListItemTextView> data,Activity a){
        this.context=context;
        this.data=data;
        this.a=a;
        this.size=data.size();
        colorSwitch=1;
        Time t=new Time();
        t.setToNow();
        now_time=t.year+"-"+(t.month+1)+"-"+t.monthDay;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return data.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return data.get(arg0).getId();
    }
    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2){
        View view;
        if(null==arg1){
            view=LayoutInflater.from(context).inflate(R.layout.activity_base_item, null);
        }else{
            view=arg1;
        }
        TextView item_name=(TextView) view.findViewById(R.id.base_item_name);
        TextView item_time=(TextView) view.findViewById(R.id.base_item_time);
        ImageView item_done=(ImageView) view.findViewById(R.id.base_item_done);
        ListItemTextView myltv=data.get(arg0);
        if(myltv.getWrTime().equals(now_time))
            colorSwitch=1;
        else if(!myltv.getWrTime().equals(now_time))
            colorSwitch=2;
        if(colorSwitch==2)
            view.setBackgroundColor(a.getResources().getColor(R.color.listvo_bg));
        item_name.setText(myltv.getItem());
        item_time.setText(myltv.getWrTime());
        if(myltv.getIsDone()==0||myltv.getIsDone()==4)
            item_done.setImageResource(R.drawable.unfinish);
        if(myltv.getIsDone()==1||myltv.getIsDone()==5)
            item_done.setImageResource(R.drawable.unfished);
        if(myltv.getIsDone()==2||myltv.getIsDone()==6)
            item_done.setImageResource(R.drawable.finish);
        return view;
    }
}
