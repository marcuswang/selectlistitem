package com.witmob.selectlistitem_demo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wangjun
 * Date: 13-3-31
 * Time: 下午8:42
 * To change this template use File | Settings | File Templates.
 */
public class SelectAdapter extends BaseAdapter {
    private List<?> dataList;
    private Context mContext;

    public SelectAdapter(Context context, List<?> list) {
        selectedList = new ArrayList();
        mContext = context;
        dataList = list;
    }

    @Override
    public int getCount() {
        return dataList.size();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public long getItemId(int i) {
        return i;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        HoldView holdView = null;
        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext
                    .getSystemService("layout_inflater");
            view = layoutInflater.inflate(
                    R.layout.listitem, null);
            holdView = new HoldView(view);
            view.setTag(holdView);
        } else {
            holdView = (HoldView) view.getTag();
        }
        holdView.initView((Map<?, ?>) this.dataList.get(i));
        return view;
    }

    public class HoldView {
        private TextView textView;
        private CheckBox checkBox;
        Map<?, ?> dataMap;

        public HoldView(View view) {
            textView = (TextView) view.findViewById(R.id.textView);
            checkBox = (CheckBox) view.findViewById(R.id.checkbox1);
            checkBox.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Log.v("testTAG", "---" + dataMap.get("name"));
                    if (b) {
                        selectedList.add((Map) dataMap);
                    } else {
                        selectedList.remove(dataMap);
                    }
                }
            });
        }

        public void initView(Map<?, ?> map) {
            dataMap = map;
            checkBox.setChecked(selectedList.contains(dataMap));
        }
    }
    private List<Map> selectedList;
}