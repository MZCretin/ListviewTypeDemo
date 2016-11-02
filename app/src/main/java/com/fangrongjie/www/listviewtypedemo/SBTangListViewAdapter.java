package com.fangrongjie.www.listviewtypedemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by cretin on 16/10/31.
 */

public class SBTangListViewAdapter extends BaseAdapter {
    private List<Item> mArrayList;
    private LayoutInflater mLayoutInflater;

    private final int TYPE_COUNT = 2;
    public static final int FIRST_TYPE = 0;
    public static final int OTHERS_TYPE = 1;
    private int currentType;

    public SBTangListViewAdapter(Context context, List<Item> data) {
        this.mArrayList = data;
        mLayoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if (mArrayList == null) {
            return 0;
        } else {
            return (mArrayList.size());
        }

    }

    @Override
    public Object getItem(int position) {
        if (mArrayList == null) {
            return null;
        } else {
            return mArrayList.get(position);
        }
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    ///////////////////////////////////////////////////////
    @Override
    public int getViewTypeCount() {
        return TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        return mArrayList.get(position).getType();
    }
    ///////////////////////////////////////////////////////

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View firstItemView = null;
        View othersItemView = null;
        //获取到当前位置所对应的Type
        currentType = getItemViewType(position);
        System.out.println("type=" + currentType);
        if (currentType == FIRST_TYPE) {
            firstItemView = convertView;
            FirstItemViewHolder firstItemViewHolder = null;
            if (firstItemView == null) {
                System.out.println("firstItemView==null ");
                firstItemView = mLayoutInflater.inflate(R.layout.item_listview_type_one, null);
                firstItemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        System.out.println("=====click first item=======");
                    }
                });
                firstItemViewHolder = new FirstItemViewHolder();
                firstItemViewHolder.tvName = (TextView) firstItemView.findViewById(R.id.tv_name);
                firstItemView.setTag(firstItemViewHolder);
            } else {
                System.out.println("firstItemView!=null ");
                System.out.println("111 getClass=" + firstItemView.getTag().getClass().toString());
                firstItemViewHolder = (FirstItemViewHolder) firstItemView.getTag();
            }

            if (position == 0) {
                firstItemView.findViewById(R.id.view_divider).setVisibility(View.GONE);
            } else {
                firstItemView.findViewById(R.id.view_divider).setVisibility(View.VISIBLE);
            }

            if (firstItemViewHolder.tvName != null) {
                firstItemViewHolder.tvName.setText("团队长：" + mArrayList.get(position).getTeamName());
            }
            convertView = firstItemView;
        } else if (currentType == OTHERS_TYPE) {
            othersItemView = convertView;
            SecondViewHolder secondViewHolder = null;
            if (othersItemView == null) {
                System.out.println("othersItemView==null ");
                othersItemView = mLayoutInflater.inflate(R.layout.item_listview_type_two, null);
                secondViewHolder = new SecondViewHolder();
                secondViewHolder.tvName = (TextView) othersItemView.findViewById(R.id.tv_name);
                secondViewHolder.tvRank = (TextView) othersItemView.findViewById(R.id.tv_rank);
                secondViewHolder.tvPhone = (TextView) othersItemView.findViewById(R.id.tv_phone);
                secondViewHolder.tvMoney = (TextView) othersItemView.findViewById(R.id.tv_money);
                othersItemView.setTag(secondViewHolder);
            } else {
                System.out.println("othersItemView!=null ");
                System.out.println("222 getClass=" + othersItemView.getTag().getClass().toString());
                secondViewHolder = (SecondViewHolder) othersItemView.getTag();
            }

            if (mArrayList != null) {
                if (secondViewHolder.tvName != null) {
                    secondViewHolder.tvName.setText(mArrayList.get(position).getName());
                }

                if (secondViewHolder.tvRank != null) {
                    secondViewHolder.tvRank.setText(mArrayList.get(position).getRank());
                }

                if (secondViewHolder.tvPhone != null) {
                    secondViewHolder.tvPhone.setText(mArrayList.get(position).getPhone());
                }

                if (secondViewHolder.tvMoney != null) {
                    secondViewHolder.tvMoney.setText(mArrayList.get(position).getMoney());
                }
            }
            convertView = othersItemView;
        }
        return convertView;
    }


    //第一个Item的ViewHolder
    private class FirstItemViewHolder {
        TextView tvName;
    }

    //除第一个Item以外其余Item的ViewHolder
    private class SecondViewHolder {
        TextView tvName;
        TextView tvRank;
        TextView tvPhone;
        TextView tvMoney;
    }
}