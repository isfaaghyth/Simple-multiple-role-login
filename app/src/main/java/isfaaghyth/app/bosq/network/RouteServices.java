package isfaaghyth.app.bosq.network;

import isfaaghyth.app.bosq.model.LoginModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
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
    
    //@GET("/test/test.php") //done
    //Call<Model> getDataTest(
    //        @Header("Authorization") String token //set param token for oauth
    //);

}
