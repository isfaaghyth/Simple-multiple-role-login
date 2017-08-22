package isfaaghyth.app.bosq.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by isfaaghyth on 8/10/17.
 * github: @isfaaghyth
 */

public class LoginModel {
    @SerializedName("status") private boolean status;
    @SerializedName("name") private String name;
    @SerializedName("role") private int role;
    @SerializedName("token") private String token;

    public boolean isStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public int getRole() {
        return role;
    }
    
    public String getToken() {
        return token;
    }
}
