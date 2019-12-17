package com.lock.ui.order.incomplete;


import android.view.View;
import android.widget.ListView;

import com.lock.R;
import com.lock.mvp.MVPBaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class IncompleteFragment extends MVPBaseFragment<IncompleteContract.View, IncompletePresenter>
        implements IncompleteContract.View {
    private int i = 1;
    private IncompletePresenter presenter;
    private SmartRefreshLayout refresh;
    private ListView listview;

    @Override
    protected int createView() {
        return R.layout.fragment_incomplete;
    }

    @Override
    protected void initView(View view) {
        refresh = view.findViewById(R.id.refresh);
        listview = view.findViewById(R.id.listView);

    }

    @Override
    protected void initDate() {
        presenter = new IncompletePresenter();
      //  refresh.setEnableOverScrollDrag(false);
        refresh.setOnRefreshListener(refreshLayout -> {
            i = 1;
            refresh.finishRefresh();
            presenter.getList(getActivity(),i, listview,true);
        });
        refresh.setOnLoadMoreListener(refreshLayout -> {
            refresh.finishLoadMore();
            i += 1;
            presenter.getList(getActivity(),i, listview,false);
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        i = 1;
        presenter.getList(getActivity(),i,listview,true);
    }

    @Override
    public void finish() {
        refresh.finishLoadMore();
    }
}
