package com.example.qlydatphongks;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class phongAdapter extends BaseAdapter {

    Context Mycontext;
    int Mylayout;
    List<phong> arraylistphong;
    int i=0;
    public phongAdapter(Context mycontext, int mylayout, List<phong> arraylistphong)
    {
        Mycontext = mycontext;
        Mylayout = mylayout;
        this.arraylistphong = arraylistphong;
    }
    public Context getMycontext() { return Mycontext; }
    public void setMycontext(Context mycontext) { Mycontext = mycontext; }
    public int getMylayout() { return Mylayout; }
    public void setMylayout(int mylayout) { Mylayout = mylayout; }
    public List<phong> getArraylistphong() { return arraylistphong; }
    public void setArraylistphong(List<phong> arraylistphong) {
        this.arraylistphong = arraylistphong; }
    @Override
    public int getCount() { return arraylistphong.size(); }
    @Override
    public Object getItem(int position) { return null; }
    @Override
    public long getItemId(int position) { return 0; }
    private class ViewHolder
    {
        TextView txtten, txtmota, txtgiatien;
        ImageView imgHinh;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater)
                    Mycontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(Mylayout,null);
            viewHolder.txtten=(TextView)convertView.findViewById(R.id.textViewten);
            viewHolder.txtmota=(TextView)convertView.findViewById(R.id.textViewmota);
            viewHolder.txtgiatien=(TextView)convertView.findViewById(R.id.textViewgiatien);
            viewHolder.imgHinh=(ImageView) convertView.findViewById(R.id.imageViewHinh);
            convertView.setTag(viewHolder);

        }else { viewHolder=(ViewHolder) convertView.getTag(); }
        phong sv=arraylistphong.get(position);
        viewHolder.txtten.setText(sv.getTen());
        viewHolder.txtmota.setText(sv.getMota());
        viewHolder.txtgiatien.setText(String.valueOf(sv.getGiatien()));
        //i= Integer.valueOf(sv.getHinh());
        Context context = viewHolder.imgHinh.getContext();
        int id = context.getResources().getIdentifier(sv.hinhanh, "drawable", context.getPackageName());
        viewHolder.imgHinh.setImageResource(id);

        return convertView;
    }

}
