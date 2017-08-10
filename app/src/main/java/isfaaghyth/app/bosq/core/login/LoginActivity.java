package isfaaghyth.app.bosq.core.login;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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

        //check isLogin
        isLoginChecked();
    }

    @OnClick(R.id.btn_login)
    public void onLoginClicked() {
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        presenter.doLogin(email, password);
    }

    @Override public void onSuccess(LoginModel result) {
        if (result.isStatus()) {
            CacheManager.save("login", true);
            CacheManager.save("name", result.getName());
            CacheManager.save("type", result.getRole());
            switch (result.getRole()) {
                case Consts.BIGBOSS_ROLE: //bigboss
                    startActivity(new Intent(this, BigbossActivity.class));
                    finish();
                    break;
                case Consts.SUPERVISOR_ROLE: //supervisor
                    startActivity(new Intent(this, SupervisorActivity.class));
                    finish();
                    break;
            }
        } else {
            showError("Akun tidak terdaftar.");
        }
    }

    @Override public void onError(String message) {
        Log.e("onError:", message);
        showError(message);
    }

    private void isLoginChecked() {
        if (!CacheManager.checkExist("login")) return;
        if (CacheManager.grabBoolean("login")) {
            switch (CacheManager.grabInt("type")) {
                case Consts.BIGBOSS_ROLE:
                    startActivity(new Intent(this, BigbossActivity.class));
                    finish();
                    break;
                case Consts.SUPERVISOR_ROLE:
                    startActivity(new Intent(this, SupervisorActivity.class));
                    finish();
                    break;
            }
        }
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