package com.idankorenisraeli.mysettingsscreen.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.recycler.SettingsRecyclerAdapter;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.BasicTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.InnerPageTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;

import java.util.ArrayList;


public class InnerPageFragment extends Fragment {

    private InnerPageTileData mData;

    private android.widget.Toolbar actionBar;
    private RecyclerView settingsRecycler;


    public InnerPageFragment() {
        // Required empty public constructor
    }

    public InnerPageFragment(InnerPageTileData data){
        mData = data;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView =  inflater.inflate(R.layout.fragment_inner_settings_page, container, false);
        actionBar = fragmentView.findViewById(R.id.inner_settings_TB_toolbar);
        settingsRecycler = fragmentView.findViewById(R.id.inner_settings_RV_recycler);



        initRecycler(inflater.getContext());
        initActionBar();
        return fragmentView;
    }

    private void initRecycler(Context context){
        settingsRecycler.setLayoutManager(new LinearLayoutManager(context));
        settingsRecycler.setAdapter(new SettingsRecyclerAdapter(context, mData.getInnerTilesData()));
        actionBar.setTitle(mData.getActionBarTitle());
    }

    private void initActionBar(){
        if(mData.getActionBarTitle()==null)
            hideActionBar();
        else
            actionBar.setTitle(mData.getActionBarTitle());

        actionBar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24);
        actionBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().onBackPressed();
            }
        });
    }

    private void hideActionBar(){
        actionBar.setVisibility(View.GONE);
    }


}