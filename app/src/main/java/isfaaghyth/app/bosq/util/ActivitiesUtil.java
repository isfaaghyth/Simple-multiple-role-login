package isfaaghyth.app.bosq.util;

import android.app.Activity;
import android.content.Intent;

import isfaaghyth.app.bosq.BosqApp;

/**
 * Created by isfaaghyth on 8/11/17.
 * github: @isfaaghyth
 */

public class ActivitiesUtil {

    public static void start(Activity from, Class destination) {
        BosqApp.getContext().startActivity(new Intent(from, destination.getClass()));
        from.finish();
    }

}
