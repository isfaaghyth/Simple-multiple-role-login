package isfaaghyth.app.bosq.core.login;

import android.support.annotation.NonNull;

import isfaaghyth.app.bosq.base.BasePresenter;
import isfaaghyth.app.bosq.core.bigboss.BigbossActivity;
import isfaaghyth.app.bosq.core.supervisor.SupervisorActivity;
import isfaaghyth.app.bosq.model.LoginModel;
import isfaaghyth.app.bosq.util.ActivitiesUtil;
import isfaaghyth.app.bosq.util.CacheManager;
import isfaaghyth.app.bosq.util.Consts;
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
            @Override public void onResponse(@NonNull Call<LoginModel> result, @NonNull Response<LoginModel> response) {
                if (response.isSuccessful()) {
                    view.onSuccess(response.body());
                }
            }
            @Override public void onFailure(@NonNull Call<LoginModel> result, @NonNull Throwable t) {
                view.onError(t.getMessage());
            }
        });
    }

    public void isLoginChecked() {
        if (!CacheManager.checkExist("login")) return;
        if (CacheManager.grabBoolean("login")) {
            isRole(CacheManager.grabInt("type"));
        }
    }

    public void onSuccessLogin(LoginModel result) {
        CacheManager.save("login", true);
        CacheManager.save("name", result.getName());
        CacheManager.save("type", result.getRole());
        CacheManager.save("token", result.getToken());
        isRole(result.getRole());
    }

    private void isRole(int role) {
        switch (role) {
            case Consts.BIGBOSS_ROLE: //bigboss
                ActivitiesUtil.start(view.getActivity(), BigbossActivity.class);
                break;
            case Consts.SUPERVISOR_ROLE: //supervisor
                ActivitiesUtil.start(view.getActivity(), SupervisorActivity.class);
                break;
        }
    }

}
