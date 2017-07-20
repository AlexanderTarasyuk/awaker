package com.future.awaker.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.future.awaker.R;
import com.future.awaker.base.BaseFragment;
import com.future.awaker.base.listener.OnItemClickListener;
import com.future.awaker.data.HomeItem;
import com.future.awaker.databinding.FragHomeListBinding;
import com.future.awaker.news.NewListActivity;

/**
 * Copyright ©2017 by Teambition
 */

public class HomeListFragment extends BaseFragment<FragHomeListBinding> implements OnItemClickListener<HomeItem> {

    private HomeListAdapter adapter;

    public static HomeListFragment newInstance() {
        return new HomeListFragment();
    }

    @Override
    protected int getLayout() {
        return R.layout.frag_home_list;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new HomeListAdapter(this);
        binding.recyclerView.setAdapter(adapter);

        GridLayoutManager manager = new GridLayoutManager(getActivity(), 4);
        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return adapter.getSpanSize(position);
            }
        });
        binding.recyclerView.setLayoutManager(manager);
        adapter.setData();
    }

    @Override
    public void onItemClick(View view, int position, HomeItem bean) {
        if (bean.id >= 0) {
            NewListActivity.launch(getActivity(), bean.id, bean.title);

        } else {

        }
    }
}
