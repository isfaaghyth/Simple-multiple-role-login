package isfaaghyth.app.bosq.core.login;

import android.support.v7.app.AppCompatActivity;

import isfaaghyth.app.bosq.model.LoginModel;

/**
 * Created by isfaaghyth on 8/10/17.
 * github: @isfaaghyth
 */

public interface LoginView {
    void onSuccess(LoginModel result);
    void onError(String message);
    AppCompatActivity getActivity();
}
