package com.vuan.listviewnangcao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TuongYTAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<TuongYeuThich> list;

    public TuongYTAdapter(Context context, int layout, List<TuongYeuThich> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout ,null);
        //anh xa cac control tren view
        ImageView imgAvatar = view.findViewById(R.id.imgAvatar);
        TextView txtName = view.findViewById(R.id.txtName);
        TextView txtDescription = view.findViewById(R.id.txtDescription);
        ImageView imgLogo = view.findViewById(R.id.imgLogo);
        TuongYeuThich tuongYeuThich = list.get(i);
        imgAvatar.setImageResource(tuongYeuThich.getImgAvatar());
        txtName.setText(tuongYeuThich.getName());
        txtDescription.setText(tuongYeuThich.getDesciption());
        imgLogo.setImageResource(tuongYeuThich.getLogo());
        return view;
    }
}
