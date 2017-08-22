package isfaaghyth.app.bosq.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by isfaaghyth on 8/22/17.
 * github: @isfaaghyth
 */

public class MainModel {
    @SerializedName("status") private boolean status;
    @SerializedName("message") private String message;

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
