package isfaaghyth.app.bosq.base;

import isfaaghyth.app.bosq.network.BosqClient;
import isfaaghyth.app.bosq.network.RouteServices;

/**
 * Created by isfaaghyth on 8/10/17.
 * github: @isfaaghyth
 */

public class BasePresenter<V> {
    public V view;
    private RouteServices service;

    public void attachView(V view) {
        this.view = view;
        service = BosqClient.getClient().create(RouteServices.class);
    }

    public void dettachView() {
        this.view = null;
    }

    public RouteServices getService() {
        return service;
    }
    
    protected String getToken() {
        return CacheManager.grabString("token");
    }

}
