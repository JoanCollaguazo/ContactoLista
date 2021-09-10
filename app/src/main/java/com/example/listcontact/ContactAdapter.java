package com.example.listcontact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;


public class ContactAdapter extends ArrayAdapter{

    Contact contact;
    private Context context;
    private List<Contact> contactArrayList;


    public ContactAdapter(Context context, List<Contact> contactArrayList){
        super(context, R.layout.list_contact);
        this.context=context;
        this.contactArrayList=contactArrayList;

    }

    @Override
    public int getCount() {
        return contactArrayList.size();
    }

    @Override
    public Contact getItem(int position) {
        return contactArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //Este método permite obtener la vista a partir de una fila
    //la vista que representa la lista se apsa por parámetro al método
    @Override
    public View getView (int position, View convertView, ViewGroup parent){
        View view;
        final  ViewHolder viewHolder;
        if (convertView == null || convertView.getTag()==null){
            viewHolder=new ViewHolder();
            view= LayoutInflater.from(context).inflate(R.layout.list_contact,parent,false);
            viewHolder.mContactName=(TextView) view.findViewById(R.id.adapterContactName);
            viewHolder.mImageContact= view.findViewById(R.id.adapterContactImage);
            view.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
            view=convertView;
        }

        viewHolder.mContactName.setText(contactArrayList.get(position).getNombre());
        Glide.with(context)
                .load(contactArrayList.get(position).getUrl())
                .into(viewHolder.mImageContact);
        return  view;
    }


    static  class ViewHolder{
        protected TextView mContactName;
        protected ImageView mImageContact;

    }

}
