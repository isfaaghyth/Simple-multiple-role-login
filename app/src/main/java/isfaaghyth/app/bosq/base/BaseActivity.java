package isfaaghyth.app.bosq.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by isfaaghyth on 8/10/17.
 * github: @isfaaghyth
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    protected P presenter;
    protected abstract P createPresenter();
    protected Unbinder unbinder;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void binding(int layout) {
        setContentView(layout);
        unbinder = ButterKnife.bind(this);
        presenter = createPresenter();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
        if (presenter != null) {
            presenter.dettachView();
        }
    }
}