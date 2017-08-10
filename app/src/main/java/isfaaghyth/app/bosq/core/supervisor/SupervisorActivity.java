package isfaaghyth.app.bosq.core.supervisor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import isfaaghyth.app.bosq.R;
import isfaaghyth.app.bosq.base.BaseActivity;
import isfaaghyth.app.bosq.core.login.LoginActivity;
import isfaaghyth.app.bosq.util.CacheManager;

/**
 * Created by isfaaghyth on 8/10/17.
 * github: @isfaaghyth
 */
public class SupervisorActivity extends BaseActivity<SupervisorPresenter> implements SupervisorView {

    @BindView(R.id.txt_name) TextView txtName;

    @Override protected SupervisorPresenter createPresenter() {
        return new SupervisorPresenter(this);
    }

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding(R.layout.activity_supervisor);
        txtName.setText(CacheManager.grabString("name"));
    }

    @OnClick(R.id.btn_logout)
    public void onLogoutClicked() {
        CacheManager.save("login", false);
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}