package isfaaghyth.app.bosq;

import android.app.Application;
import android.content.Context;

/**
 * Created by isfaaghyth on 8/10/17.
 * github: @isfaaghyth
 */

public class BosqApp extends Application {

    private static Context context;

    @Override public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
