package dongting.bwei.com.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dongting.bwei.com.mvp.presenter.MyPresenter;
import dongting.bwei.com.mvp.view.IMain;

/**
 * 处理view的显示和隐藏
 */
public class MainActivity extends Activity implements IMain {

    MyPresenter myPresenter;
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.btn)
    Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        myPresenter = new MyPresenter(this);
    }

    //登录按钮监听
    @OnClick(R.id.btn)
    public void loginBtn(View view) {

        myPresenter.login(username.getText().toString(), password.getText().toString());

    }

    @Override
    public void usernameEmpty() {
        Toast.makeText(this, "用户名为空", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordEmpty() {
        Toast.makeText(this, "密码为空", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void loginFail() {

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
