package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DropdownAdapter extends ArrayAdapter implements View.OnClickListener{
    public interface DropDownClickListener{
        void onDropDownClick(int position);
    }


    int resourceId;
    private DropDownClickListener dropDownClickListener;
    DropdownAdapter( Context context, int resource, ArrayList<String> list,
                           DropDownClickListener clickListener) {
        super(context, resource,list);
        this.resourceId=resource;
        this.dropDownClickListener=clickListener;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final int pos = position ;
        final Context context = parent.getContext();

        // 생성자로부터 저장된 resourceId(listview_btn_item)에 해당하는 Layout을 inflate하여 convertView 참조 획득.
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.resourceId/*R.layout.listview_btn_item*/, parent, false);
        }
        final TextView tvName=(TextView)convertView.findViewById(R.id.tvName);
        final ImageButton ibDrop = (ImageButton) convertView.findViewById(R.id.ibDrop);
        final ListView lvSub = (ListView) convertView.findViewById(R.id.lvSub);
        return super.getView(position, convertView, parent);
    }

    @Override
    public void onClick(View v) {

    }
}
