package isfaaghyth.app.bosq.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by isfaaghyth on 8/10/17.
 * github: @isfaaghyth
 */

public class BosqClient {

    public static Retrofit getClient() {
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl("http://10.0.2.2") //change it!
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

}
