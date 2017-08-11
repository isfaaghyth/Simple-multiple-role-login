package isfaaghyth.app.bosq.core.login;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import isfaaghyth.app.bosq.R;
import isfaaghyth.app.bosq.base.BaseActivity;
import isfaaghyth.app.bosq.core.bigboss.BigbossActivity;
import isfaaghyth.app.bosq.core.supervisor.SupervisorActivity;
import isfaaghyth.app.bosq.model.LoginModel;
import isfaaghyth.app.bosq.util.CacheManager;
import isfaaghyth.app.bosq.util.Consts;

/**
 * Created by isfaaghyth on 8/10/17.
 * github: @isfaaghyth
 */
public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginView {

    @BindView(R.id.edt_email) EditText edtEmail;
    @BindView(R.id.edt_password) EditText edtPassword;

    @Override protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_login);
        presenter.isLoginChecked();
    }

    @OnClick(R.id.btn_login)
    public void onLoginClicked() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        presenter.doLogin(email, password);
    }

    @Override public void onSuccess(LoginModel result) {
        if (result.isStatus()) {
            presenter.onSuccessLogin(result);
        } else {
            showError("Akun tidak terdaftar.");
        }
    }

    @Override public void onError(String message) {
        Log.e("onError:", message);
        showError(message);
    }

    @Override public AppCompatActivity getActivity() {
        return this;
    }

    private void showError(String message) {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.app_name))
                .setMessage(message)
                .setNegativeButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override public void onClick(DialogInterface dialog, int which) {}
                })
                .show();
    }

}