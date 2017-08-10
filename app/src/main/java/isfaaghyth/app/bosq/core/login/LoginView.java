package isfaaghyth.app.bosq.core.login;

import isfaaghyth.app.bosq.model.LoginModel;

/**
 * Created by isfaaghyth on 8/10/17.
 * github: @isfaaghyth
 */

public interface LoginView {
    void onSuccess(LoginModel result);
    void onError(String message);
}
