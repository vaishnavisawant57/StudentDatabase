package com.example.studentdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomListAdaptor extends ArrayAdapter {
    List<Student>result;
    Context context;
    public CustomListAdaptor(Context context,List<Student>result) {
        super(context, 0, result);
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder stu=new ViewHolder();
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.student_info, parent, false);
            stu.tvname = (TextView)convertView.findViewById(R.id.line_a);
            stu.tvcnum = (TextView)convertView.findViewById(R.id.line_b);
            convertView.setTag(stu);
        }else{
            stu = (ViewHolder)convertView.getTag();
        }

        stu.tvname.setText(result.get(position).getName());
        stu.tvcnum.setText(String.valueOf(result.get(position).getID()));
        return convertView;
    }

    static class ViewHolder{
        TextView tvname;
        TextView tvcnum;
    }
}
