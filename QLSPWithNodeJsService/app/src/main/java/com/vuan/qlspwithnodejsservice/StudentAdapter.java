package com.vuan.qlspwithnodejsservice;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class StudentAdapter extends BaseAdapter {
    private Context context;
    int layout;
    private List<Student> list;

    public StudentAdapter(Context context, int layout, List<Student> list) {
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

    //lớp nội
    class ViewHolder {
        TextView txtHoTen,txtNgaySinh ,txtDiachi;
        ImageView imgEdit ,imgDelete;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder holder = null;
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(layout ,null);
            //anh xa view
            holder.txtHoTen = view.findViewById(R.id.txtHoTen);
            holder.txtNgaySinh = view.findViewById(R.id.txtNgaySinh);
            holder.txtDiachi = view.findViewById(R.id.txtDiaChi);
            holder.imgEdit = view.findViewById(R.id.imgEdit);
            holder.imgDelete = view.findViewById(R.id.imgDelete);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        //do du lieu vao view
        final Student s = list.get(i);
        holder.txtHoTen.setText(s.getHoTen());
        holder.txtNgaySinh.setText(s.getNgaySinh());
        holder.txtDiachi.setText(s.getDiaChi());
        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "edit "+s.getId(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context ,EditStudentActivity.class);
                intent.putExtra("studentEdit" ,s);
                //context la man hinh hien tai

                context.startActivity(intent);
            }
        });
        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "delete "+s.getId(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
