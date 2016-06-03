package louis.example.awpcall.alarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by louis on 16/5/31.
 */
public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            //重新计算闹铃时间，并调第一步的方法设置闹铃时间及闹铃间隔时间
        }

    }
}
