package isfaaghyth.app.bosq.network;

import isfaaghyth.app.bosq.model.LoginModel;
import isfaaghyth.app.bosq.model.MainModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by isfaaghyth on 8/10/17.
 * github: @isfaaghyth
 */

public interface RouteServices {

    @FormUrlEncoded @POST("/test/login.php") //change it!
    Call<LoginModel> doLogin(
            @Field("email") String email,
            @Field("password") String password
    );
    
    /*
        example implementation for ouath from token
        @param: token
    */
    
    @GET("/test/test.php") //done
    Call<MainModel> getDataTest(
            @Header("oauth") String token //set param token for oauth
    );

}
