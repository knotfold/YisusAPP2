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

public class MyAdapterGruposJ extends RecyclerView.Adapter<MyAdapterGruposJ.ViewHolder> {

    private List<ListItemGruposJ> listItems;
    private Context context;

    public MyAdapterGruposJ(List<ListItemGruposJ> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public MyAdapterGruposJ.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rv_grupos_j, parent, false);
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(MyAdapterGruposJ.ViewHolder holder, int position) {
        final ListItemGruposJ listItemGruposJ = listItems.get(position);
        holder.textViewIdGrupoJ.setText(listItemGruposJ.getIdG());
        holder.textViewNombreGrupoJ.setText(listItemGruposJ.getNombreGrupo());
        holder.textViewNombreIglesiaGrupoJ.setText(listItemGruposJ.getNombreIglesia());
        holder.textViewIdIglesiaGrupoJ.setText(listItemGruposJ.getIdP());
        Picasso.with(context).load(listItemGruposJ.getImagenGrupo()).into(holder.imageViewGrupoJ);

        holder.linearLayoutGrupoJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*Toast.makeText(context, "You clicked" + listItemIglesia.getNombreIglesia(), Toast.LENGTH_LONG).show();*/

                Intent intent = new Intent(v.getContext(), DetailsGrupoJ.class);
                Bundle extras = new Bundle();
                extras.putString("EXTRA_IdG", listItemGruposJ.getIdG());
                extras.putString("EXTRA_IdP", listItemGruposJ.getIdP());
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


        public ImageView imageViewGrupoJ;
        public TextView textViewNombreGrupoJ;
        public TextView textViewNombreIglesiaGrupoJ;
        public TextView textViewIdGrupoJ;
        public TextView textViewIdIglesiaGrupoJ;
        public LinearLayout linearLayoutGrupoJ;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewGrupoJ = (ImageView) itemView.findViewById(R.id.imageViewGrupoJ);
            textViewNombreGrupoJ = (TextView) itemView.findViewById(R.id.textViewNombreGrupoJ);
            textViewNombreIglesiaGrupoJ = (TextView) itemView.findViewById(R.id.textViewNombreIglesiaGrupoJ);
            textViewIdGrupoJ = (TextView) itemView.findViewById(R.id.textViewIdGrupoJ);
            textViewIdIglesiaGrupoJ = (TextView) itemView.findViewById(R.id.textViewIdIglesiaGrupoJ);
            linearLayoutGrupoJ = (LinearLayout) itemView.findViewById(R.id.linearLayoutGrupoJ);

        }
    }
}

