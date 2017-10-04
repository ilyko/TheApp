package com.slava.theapp.ui.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.slava.theapp.R;
import com.slava.theapp.ui.base.BaseActivity;
import com.slava.theapp.ui.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;

public class TopArtistsFragment extends BaseFragment implements TopArtistsMvp.View{

    //TODO dagger this:
    protected TopArtistsAdapter topArtistsAdapter;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    @Inject
    TopArtistsPresenter presenter;

    @Inject
    public TopArtistsFragment() {
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        topArtistsAdapter = new TopArtistsAdapter();
        mRecyclerView.setAdapter(topArtistsAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.getTopArtists();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_top_artist;
    }

    @Override
    public <T extends BaseActivity> T getAct() {
        return null;
    }

    @Override
    public void setArtistName(String name) {

    }

    @Override
    public void setArtistImage(String path) {

    }
}