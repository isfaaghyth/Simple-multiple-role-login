package isfaaghyth.app.bosq.core.bigboss;

import android.support.annotation.NonNull;

import isfaaghyth.app.bosq.base.BasePresenter;
import isfaaghyth.app.bosq.model.MainModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by isfaaghyth on 8/10/17.
 * github: @isfaaghyth
 */
public class BigbossPresenter extends BasePresenter<BigbossView> {

    public BigbossPresenter(BigbossView view) {
        super.attachView(view);
    }

    public void getData() {
        getService().getDataTest(getToken()).enqueue(new Callback<MainModel>() {
            @Override public void onResponse(@NonNull Call<MainModel> result, @NonNull Response<MainModel> response) {
                if (response.isSuccessful()) {
                    view.onSuccess(response.body());
                }
            }
            @Override public void onFailure(@NonNull Call<MainModel> result, @NonNull Throwable t) {
                view.onError(t.getMessage());
            }
        });
    }
}