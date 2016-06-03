package louis.example.awpcall;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.Calendar;

import louis.example.awpcall.sharedpreferences.AwpCallSharedPreferences;

/**
 * Created by louis on 16/5/31.
 */
public class AlarmController extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.alarm_controller);

        // test sharedPreferences
        AwpCallSharedPreferences sp = AwpCallSharedPreferences.getInstance();
        sp.putBoolean("boolean", true);
        sp.putString("string", "String");
        sp.putLong("long", 34);
        sp.debugGetAll();

        //test Calendar
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 21);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 10);
        calendar.set(Calendar.MILLISECOND, 0);
        System.out.println("schedule calender:" + calendar.getTimeInMillis() + "currentTimeMills:" + System.currentTimeMillis());
//
//        // When the alarm goes off, we want to broadcast an Intent to our
//        // BroadcastReceiver. Here we make an Intent with an explicit class
//        // name to have our own receiver (which has been published in
//        // AndroidManifest.xml) instantiated and called, and then create an
//        // IntentSender to have the intent executed as a broadcast.
//        Intent intent = new Intent(AlarmController.this, OneShotAlarm.class);
//        PendingIntent sender = PendingIntent.getBroadcast(
//                AlarmController.this, 0, intent, 0);
//
//        // We want the alarm to go off 30 seconds from now.
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(System.currentTimeMillis());
//        calendar.add(Calendar.SECOND, 30);
//
//        // Schedule the alarm!
//        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
//        am.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);

//        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//        Intent intent = new Intent("android.alarm.demo.action");
//        PendingIntent sender = PendingIntent.getBroadcast(
//                AlarmController.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
//        int interval = 60 * 1000;//闹铃间隔， 这里设为1分钟闹一次，在第2步我们将每隔1分钟收到一次广播
//
//        // We want the alarm to go off 10 seconds from now.
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTimeInMillis(System.currentTimeMillis());
//        calendar.add(Calendar.SECOND, 30);
//
//        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), interval, sender);
//
//        am.cancel(sender);

//        private static final int INTERVAL = 1000 * 60 * 60 * 24;// 24h
//
////...
//
//
//        Intent intent = new Intent(context, RequestAlarmReceiver.class);
//        PendingIntent sender = PendingIntent.getBroadcast(context,
//                REQUEST_CODE, intent, PendingIntent.FLAG_CANCEL_CURRENT);
//
//        // Schedule the alarm!
//        AlarmManager am = (AlarmManager) context
//                .getSystemService(Context.ALARM_SERVICE);
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 21);
//        calendar.set(Calendar.MINUTE, 30);
//        calendar.set(Calendar.SECOND, 10);
//        calendar.set(Calendar.MILLISECOND, 0);
//
//        am.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
//                INTERVAL, sender);


        // >=19 setExact -> set
        // >= 23 setExactAndAllowWhileIdle -> set

        //TODO 过了定时时间，立即执行问题 记录时钟启动时间，若时钟启动时间比设定时间大，则第一次响应不执行
        // TODO setRepeating SystemClock.elapsedRealtime() + 24小时（）。 或 用setExact cancel后重新建
        //TODO 开机重启
        // TODO 自动拨打电话
//        Intent intent = new Intent(Intent.ACTION_CALL);
//        Uri data = Uri.parse("tel:" + "135xxxxxxxx");
//        intent.setData(data);
//        startActivity(intent);
    }
}
