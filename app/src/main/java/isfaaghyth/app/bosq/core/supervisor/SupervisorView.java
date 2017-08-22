package isfaaghyth.app.bosq.core.supervisor;

import isfaaghyth.app.bosq.model.MainModel;

/**
 * Created by isfaaghyth on 8/10/17.
 * github: @isfaaghyth
 */

public interface SupervisorView {
    void onSuccess(MainModel body);
    void onError(String message);
}
