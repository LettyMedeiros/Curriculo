package com.example.lc_me.curriculoleticia;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
public class MyCustomAdapter extends BaseExpandableListAdapter {
    private Context context;
    private HashMap<String, List<String>>listasHashMap;
    private List<String> caractLista;

    public MyCustomAdapter(Context context,
                           HashMap<String, List<String>> hashMap,
                           List<String> list) {
        listasHashMap = hashMap;
        this.context = context;
        this.listasHashMap = hashMap;
        this.caractLista = list;
    }

    @Override
    public int getGroupCount() {
        return listasHashMap.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listasHashMap.get(caractLista.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return caractLista.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listasHashMap.get(caractLista.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String groupTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.parent_layout, parent, false);
        }
        TextView parentTextView = (TextView) convertView.findViewById(R.id.textViewParent);
        parentTextView.setText(groupTitle);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition,
                             int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        Log.i("test", "parent view: " + parent.getTag());

        String childTitle = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_layout, parent, false);
        }
        TextView childTextView = (TextView) convertView.findViewById(R.id.textViewChild);
        childTextView.setText(childTitle);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
