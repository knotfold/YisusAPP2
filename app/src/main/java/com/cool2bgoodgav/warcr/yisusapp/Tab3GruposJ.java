package com.cool2bgoodgav.warcr.yisusapp;

/**
 * Created by warcr on 24/02/2018.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tab3GruposJ extends Fragment {


    private RecyclerView recyclerViewGruposJ;
    private RecyclerView.Adapter adapterGruposJ;
    /*private static final String URL_DATA ="http://10.0.2.2:81/dbproject/get_promos.php";*/
    private static final String URL_DATA = "http://iglesiasensalida.000webhostapp.com/get_all_grupojv.php";

    public List<ListItemGruposJ> listItems;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listItems = new ArrayList<>();
        loadRecyclerViewData();






    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab3grupos_j,container,false);
        recyclerViewGruposJ = (RecyclerView) rootView.findViewById(R.id.recycleViewGruposJ);
        recyclerViewGruposJ.setHasFixedSize(true);
        recyclerViewGruposJ.setLayoutManager(new LinearLayoutManager(getActivity()));

        return rootView;

    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewGruposJ.setAdapter(adapterGruposJ);





    }


    public void loadRecyclerViewData()
    {


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
                                ListItemGruposJ item = new ListItemGruposJ(
                                        o.getString("id grupo"),
                                        o.getString("nombre"),
                                        o.getString("imagen"),
                                        o.getString("id parroquia"),
                                        o.getString("nombre ")



                                );
                                listItems.add(item);
                            }
                            adapterGruposJ = new MyAdapterGruposJ(listItems,getActivity());
                            recyclerViewGruposJ.setAdapter(adapterGruposJ);

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

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);

    }


}
