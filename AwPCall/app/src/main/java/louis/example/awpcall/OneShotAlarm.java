package louis.example.awpcall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by louis on 16/5/31.
 */
public class OneShotAlarm extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("OneShotAlarm", "杀死应用后系统时钟依然起作用！");
    }
}
