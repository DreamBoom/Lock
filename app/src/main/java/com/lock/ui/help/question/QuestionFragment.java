package com.lock.ui.help.question;


import android.view.View;
import android.widget.ListView;

import com.lock.R;
import com.lock.mvp.MVPBaseFragment;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class QuestionFragment extends MVPBaseFragment<QuestionContract.View, QuestionPresenter>
        implements QuestionContract.View {
    private int i = 1;
    private SmartRefreshLayout refresh;
    private ListView listview;
    private QuestionPresenter presenter;

    @Override
    protected int createView() {
        return R.layout.fragment_question;
    }

    @Override
    protected void initView(View view) {
        refresh = view.findViewById(R.id.refresh);
        listview = view.findViewById(R.id.listView);

    }

    @Override
    protected void initDate() {
        presenter = new QuestionPresenter();
        // refresh.setEnableOverScrollDrag(true);
        refresh.setOnRefreshListener(refreshLayout -> {
            i = 1;
            refresh.finishRefresh();
         //   presenter.getList(getActivity(), i, listview,true);
        });
        refresh.setOnLoadMoreListener(refreshLayout -> {
            i += 1;
            refresh.finishLoadMore(true);
         //   presenter.getList(getActivity(), i, listview,false);
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        i = 1;
      //  presenter.getList(getActivity(), i, listview,true);
    }
}
