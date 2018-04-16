package com.cool2bgoodgav.warcr.yisusapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetailsGrupoJ extends AppCompatActivity {
    /*Strings globales*/
    String IdGrupoJ;
    String IdIglesia;
    /*listas*/
    public List<ListItemIglesia> listItemIglesia;
    /*RecycleView*/
    private RecyclerView recyclerViewIglesia;
    /*RV Adapters*/
    private RecyclerView.Adapter adapterIglesia;
    /*Declaring XML objects*/
    ImageView imageViewGrupoJ;
    TextView textViewNombreGrupoJ;
    TextView textViewHorarioGrupoJ;
    TextView textViewNombreCoordinador;
    TextView textViewTelefonoCoord;
    TextView textViewMailCoord;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_grupo_j);
        /*Getting intents*/
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        IdGrupoJ = extras.getString("EXTRA_IdG");
        IdIglesia = extras.getString("EXTRA_IdP");
        /*Managing RecycleViews Properties*/
        recyclerViewIglesia = (RecyclerView) findViewById(R.id.recycleViewIglesiaGrupoJD);
        recyclerViewIglesia.setHasFixedSize(true);
        recyclerViewIglesia.setLayoutManager(new LinearLayoutManager(this));
        /*ListItems*/
        listItemIglesia = new ArrayList<>();
         /*Objectifing*/
        imageViewGrupoJ = (ImageView) findViewById(R.id.imageViewGrupoJuvenil);
        textViewNombreGrupoJ = (TextView) findViewById(R.id.textViewNombreGrupoJuvenil);
        textViewHorarioGrupoJ = (TextView) findViewById(R.id.textViewHorarioGrupoJuvenil);
        textViewNombreCoordinador = (TextView) findViewById(R.id.textViewNombreCoordinador);
        textViewTelefonoCoord = (TextView) findViewById(R.id.textViewTelefonoCoordinador);
        textViewMailCoord = (TextView) findViewById(R.id.textViewCorreoCoordinador);
        /*LoadData Functions*/
        loadRecyclerViewDataGrupoJ();
        loadRecyclerViewData();

    }


    public void loadRecyclerViewDataGrupoJ() {

        /*URL_DATA = "http://10.0.2.2:81/dbproject/get_platillos.php?IdRestaurante=" + IdRestaurante;*/
        final String URL_DATA = "http://iglesiasensalida.000webhostapp.com/get_one_grupojv.php?idg=" + IdGrupoJ;

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onResponse(String s) {

                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("result");

                            for (int i = 0; i < array.length(); i++) {
                                JSONObject o = array.getJSONObject(i);
                                String foto = o.getString("imagen grupoj");
                                Picasso.with(getApplicationContext()).load(foto).into(imageViewGrupoJ);
                                textViewNombreGrupoJ.setText( o.getString("nombre grupoj"));
                                textViewHorarioGrupoJ.setText(o.getString("horario grupoj"));
                                textViewNombreCoordinador.setText(o.getString("nombre coordinador"));
                                textViewTelefonoCoord.setText(o.getString("telefono coordinador"));
                                textViewMailCoord.setText(" " + o.getString("email coordinador"));

                            }




                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);


    }

    public void loadRecyclerViewData()
    {
        final String URL_DATA = "http://iglesiasensalida.000webhostapp.com/get_one_parroquia.php?idp=" + IdIglesia;


        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {

                        try {
                            JSONObject jsonObject = new JSONObject(s);
                            JSONArray array = jsonObject.getJSONArray("result");

                            for(int i = 0; i<array.length();i++)
                            {
                                JSONObject o = array.getJSONObject(i);
                                ListItemIglesia item = new ListItemIglesia(
                                        IdIglesia,
                                        o.getString("nombre"),
                                        o.getString("foto"),
                                        o.getString("ubicacion")


                                );
                                listItemIglesia.add(item);
                            }
                            adapterIglesia = new MyAdapterIglesia(listItemIglesia,getApplicationContext());
                            recyclerViewIglesia.setAdapter(adapterIglesia);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);

    }

    public void Toast(String toastText)
    {
        Context context = getApplicationContext();
        CharSequence text = toastText;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}

