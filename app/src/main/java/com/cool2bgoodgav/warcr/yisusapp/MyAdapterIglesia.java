package com.cool2bgoodgav.warcr.yisusapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by warcr on 05/12/2017.
 */

public class MyAdapterIglesia extends RecyclerView.Adapter<MyAdapterIglesia.ViewHolder> {

    private List<ListItemIglesia> listItems;
    private Context context;

    public MyAdapterIglesia(List<ListItemIglesia> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public MyAdapterIglesia.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rv_iglesia, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MyAdapterIglesia.ViewHolder holder, int position) {
        final ListItemIglesia listItemIglesia = listItems.get(position);
        holder.textViewIdIglesia.setText(listItemIglesia.getIdIgleisa());
        holder.textViewNombreIglesia.setText(listItemIglesia.getNombreIglesia());
        holder.textViewUbicacionIglesia.setText(listItemIglesia.getUbicacionIglesia());
        Picasso.with(context).load(listItemIglesia.getImageUrlIglesia()).into(holder.imageViewIglesia);

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Toast.makeText(context, "You clicked" + listItemIglesia.getNombreIglesia(), Toast.LENGTH_LONG).show();*/

                Intent intent = new Intent(v.getContext(), IglesiaDetails.class);
                Bundle extras = new Bundle();
                extras.putString("EXTRA_IdIglesia", listItemIglesia.getIdIgleisa());
                extras.putString("EXTRA_NombreIglesia", listItemIglesia.getNombreIglesia());
                intent.putExtras(extras);
                v.getContext().startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ImageView imageViewIglesia;
        public TextView textViewNombreIglesia;
        public TextView textViewUbicacionIglesia;
        public TextView textViewIdIglesia;
        public LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewIglesia = (ImageView) itemView.findViewById(R.id.imageViewIglesiaPhoto);
            textViewNombreIglesia = (TextView) itemView.findViewById(R.id.textViewNombreIglesia);
            textViewUbicacionIglesia = (TextView) itemView.findViewById(R.id.textViewUbicacionIglesia);
            textViewIdIglesia = (TextView) itemView.findViewById(R.id.textViewIdIglesia);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);

        }
    }
}

