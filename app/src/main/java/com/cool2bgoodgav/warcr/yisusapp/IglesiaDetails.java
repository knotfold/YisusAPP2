package com.cool2bgoodgav.warcr.yisusapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class IglesiaDetails extends AppCompatActivity {
    /*Strings globales*/
    String IdIglesia;
    /*listas*/
    public List<ListItemIglesia> listItemIglesia;
    /*RecycleView*/
    private RecyclerView recyclerViewIglesia;
    /*RV Adapters*/
    private RecyclerView.Adapter adapterIglesia;
    /*Declaring XML objects*/
    ImageView imageViewIglesia;
    TextView textViewNombreIglesia;
    TextView textViewDireccionIglesia;
    TextView textViewHorariosMisaIglesia;
    TextView textViewHorariosConfesionIglesia;
    TextView textViewHorariosOficinaIglesia;
    TextView textViewTelefonoIglesia;
    TextView textViewAvisoSemIglesia;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iglesia_details);
        /*Getting intents*/
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        IdIglesia = extras.getString("EXTRA_IdIglesia");
        String NombreIglesia = extras.getString("EXTRA_NombreIglesia");
        /*Managing RecycleViews Properties*/
        /*ListItems*/
        listItemIglesia = new ArrayList<>();
         /*Objectifing*/
         imageViewIglesia = (ImageView) findViewById(R.id.imageViewIglesia);
         textViewAvisoSemIglesia = (TextView) findViewById(R.id.textViewAvisoSemIglesia);
         textViewDireccionIglesia = (TextView) findViewById(R.id.textViewDireccionIglesia);
         textViewHorariosMisaIglesia = (TextView) findViewById(R.id.textViewHorariosMisaIglesia);
         textViewNombreIglesia = (TextView) findViewById(R.id.textViewNombreIglesia);
         textViewHorariosConfesionIglesia = (TextView) findViewById(R.id.textViewHorariosConfesionesIglesia);
         textViewHorariosOficinaIglesia = (TextView) findViewById(R.id.textViewHorariosOficinaIglesia);
         textViewTelefonoIglesia = (TextView) findViewById(R.id.textViewTelefonoIglesia);
        /*LoadData Functions*/
        loadRecyclerViewDataIglesia();

    }


    public void loadRecyclerViewDataIglesia() {

        /*URL_DATA = "http://10.0.2.2:81/dbproject/get_platillos.php?IdRestaurante=" + IdRestaurante;*/
        final String URL_DATA = "https://iglesiasensalida.000webhostapp.com/get_one_parroquia.php?idp=" + IdIglesia;

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
                                String foto = o.getString("foto");
                                Picasso.with(getApplicationContext()).load(foto).into(imageViewIglesia);
                                textViewNombreIglesia.setText(" " + o.getString("nombre"));
                                textViewDireccionIglesia.setText(o.getString("ubicacion"));
                                textViewHorariosMisaIglesia.setText(o.getString("hmisa"));
                                textViewHorariosOficinaIglesia.setText(o.getString("hoficina"));
                                textViewHorariosConfesionIglesia.setText(o.getString("hconfesion"));
                                textViewTelefonoIglesia.setText(o.getString("telefono"));
                                textViewAvisoSemIglesia.setText(o.getString("avisem"));
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

    public void Toast(String toastText)
    {
        Context context = getApplicationContext();
        CharSequence text = toastText;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
