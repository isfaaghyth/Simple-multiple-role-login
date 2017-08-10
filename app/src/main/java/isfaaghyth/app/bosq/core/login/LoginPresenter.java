package isfaaghyth.app.bosq.core.login;

import android.util.Log;

import isfaaghyth.app.bosq.base.BasePresenter;
import isfaaghyth.app.bosq.model.LoginModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by isfaaghyth on 8/10/17.
 * github: @isfaaghyth
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    public LoginPresenter(LoginView view) {
        super.attachView(view);
    }

    public void doLogin(String email, String password) {
        getService().doLogin(email, password).enqueue(new Callback<LoginModel>() {
            @Override public void onResponse(Call<LoginModel> result, Response<LoginModel> response) {
                if (response.isSuccessful()) {
                    view.onSuccess(response.body());
                }
            }
            @Override public void onFailure(Call<LoginModel> result, Throwable t) {
                view.onError(t.getMessage());
            }
        });
    }
}