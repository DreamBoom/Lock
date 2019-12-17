package com.lock.ui.login.message;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.lock.R;
import com.lock.mvp.MVPBaseFragment;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MessageFragment extends MVPBaseFragment<MessageContract.View, MessagePresenter>
        implements MessageContract.View {

    private EditText username;
    private EditText et_code;
    private TextView sendCode;
    private TextView tv_djs;
    private ImageView agree;
    private Button login;

    @Override
    protected int createView() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initView(View view) {
        username = view.findViewById(R.id.et_username);
        et_code = view.findViewById(R.id.et_code);
        sendCode = view.findViewById(R.id.send_code);
        tv_djs = view.findViewById(R.id.tv_djs);
        agree = view.findViewById(R.id.agree);
        login = view.findViewById(R.id.bt_login);
    }

    @Override
    protected void initDate() {
        MessagePresenter presenter = new MessagePresenter();
        sendCode.setOnClickListener(v -> {
            presenter.getCode(getActivity(),sendCode,tv_djs,username.getText().toString().trim(),et_code);
        });

        agree.setOnClickListener(v -> {
            presenter.agree(getActivity(),agree);
        });

        login.setOnClickListener(v -> {
            presenter.login(getActivity(),username.getText().toString().trim(),et_code.getText().toString().trim());
        });
    }
}
