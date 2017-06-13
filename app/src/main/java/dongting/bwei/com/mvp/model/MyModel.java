package dongting.bwei.com.mvp.model;

import java.io.IOException;

import dongting.bwei.com.mvp.view.IMainModel;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者:${董婷}
 * 日期:2017/6/13
 * 描述:网络数据请求，本地数据库
 */

public class MyModel implements IMainModel{

    public static String url = "http://qhb.2dyt.com/Bwei/login" ;

    // username=11111111111
    // password = 1
// postkey = 1503d

    @Override
    public void login(String username, String password) {

       /* builder.append(url);
        builder.append("?").append("username=").append(username)
        .append("&").append("password=").append(password).append("&")
                .append("postkey=1503d");*/

        StringBuffer sb =new StringBuffer();
        sb.append(url).append("?")
                .append("username=").append(username)
                .append("&")
                .append("password=").append(password)
                .append("&").append("postkey=1503d");

        OkHttpClient okHttpClient =new OkHttpClient();

        Request request =new Request.Builder().url(sb.toString()).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.fail();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                //String result = response.body().toString();

                listener.success();
            }
        });
    }

    @Override
    public void forget(String phone) {

    }

    Listener listener;

    public MyModel(Listener listener){
        this.listener =listener;
    }

    public  interface  Listener{
        void success();
        void fail();
    }
}
