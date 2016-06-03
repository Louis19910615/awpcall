package louis.example.awpcall;

import android.app.Application;

/**
 * Created by louis on 16/6/1.
 */
public class AwpCallApplication extends Application{

    private static AwpCallApplication sInstance;
    public static AwpCallApplication getInstance() {

        return sInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;
    }
}
