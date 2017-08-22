package isfaaghyth.app.bosq.core.bigboss;

import isfaaghyth.app.bosq.model.MainModel;

/**
 * Created by isfaaghyth on 8/10/17.
 * github: @isfaaghyth
 */

public interface BigbossView {
    void onSuccess(MainModel body);
    void onError(String message);
}
