package dongting.bwei.com.mvp.presenter;

import android.text.TextUtils;

import dongting.bwei.com.mvp.model.MyModel;
import dongting.bwei.com.mvp.view.IMain;

/**
 * 作者:${董婷}
 * 日期:2017/6/13
 * 描述:业务逻辑
 */

public class MyPresenter implements MyModel.Listener{
    IMain iMainView;

    MyModel myModel ;

    public MyPresenter(IMain iMainView){
        this.iMainView=iMainView;
        this.myModel= new MyModel(this);
    }

    public void login(String username,String password) {

        if (TextUtils.isEmpty(username)) {
            //提示用户

            iMainView.usernameEmpty();

            return;
        }
        if (TextUtils.isEmpty(password)) {

            iMainView.passwordEmpty();

            return;
        }
        myModel.login(username,password);
    }

    @Override
    public void success() {
iMainView.loginSuccess();
    }

    @Override
    public void fail() {
        iMainView.loginFail();
    }
}
