package louis.example.awpcall.alarm;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

/**
 * Created by louis on 16/5/31.
 */
public class AlarmReceiver extends BroadcastReceiver implements AlarmBehave {

    public final static String ACTION_CALL = "louis.example.awp.call";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (ACTION_CALL.equals(intent.getAction())) {
            if (isNeedFirstExecute(intent.getLongExtra("ALARMTIME", 0))) {
                Log.d("AlarmReceiver", "Response call.");
                onAlarmBehaveCall(context, "");
            }
        }
    }


    private boolean isNeedFirstExecute(long millis) {
        long timeDiff = System.currentTimeMillis() - millis;
        if (timeDiff > 30 * 60 && timeDiff < 24 * 60 * 60) {
            return false;
        }
        return true;
    }

    @Override
    public void onAlarmBehaveCall(Context context, String telphone) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + telphone);
        intent.setData(data);

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Log.e("AlarmReceiver", "This application cannot check the CALL_PHONE permission.");
            return;
        }
        context.startActivity(intent);
    }
}
