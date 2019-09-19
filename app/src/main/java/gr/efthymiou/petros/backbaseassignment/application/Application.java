package gr.efthymiou.petros.backbaseassignment.application;

import android.content.Context;

public class Application extends android.app.Application {

    private static Context applicationContext;
    private static Application mInstance;

    public void onCreate() {
        super.onCreate();
        mInstance = this;
        applicationContext = this.getBaseContext();
    }

    public static synchronized Application getInstance() {
        return mInstance;
    }

    public Context getApplicationContext() {
        return applicationContext;
    }
}
