package com.lock.ui.login.password;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lock.R;
import com.lock.mvp.MVPBaseFragment;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PasswordFragment extends MVPBaseFragment<PasswordContract.View, PasswordPresenter>
        implements PasswordContract.View{

    private EditText userName;
    private EditText password;
    private ImageView close;
    private ImageView agree;
    private Button login;
    private TextView forget;
    private TextView web;
    private PasswordPresenter presenter;

    @Override
    protected int createView() { return R.layout.fragment_password; }

    @Override
    protected void initView(View view) {
        mPresenter.attachView(this);
        web = view.findViewById(R.id.web);
        userName = view.findViewById(R.id.et_username);
        password = view.findViewById(R.id.et_password);
        close = view.findViewById(R.id.im_close);
        agree = view.findViewById(R.id.agree);
        login = view.findViewById(R.id.bt_login);
        forget = view.findViewById(R.id.tv_forget);
    }

    @Override
    protected void initDate() {
        presenter = new PasswordPresenter();
        close.setOnClickListener(v -> {
            presenter.canSee(getActivity(),password,close);
            password.setSelection(password.getText().length());
        });

        web.setOnClickListener(v -> presenter.web(getActivity()));

        agree.setOnClickListener(v -> {
            presenter.agree(getActivity(),agree);
        });

        login.setOnClickListener(v -> {
            presenter.login(getActivity(),userName.getText().toString().trim(),password.getText().toString().trim());
        });

        forget.setOnClickListener(v -> {
            presenter.forget(getActivity());
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
