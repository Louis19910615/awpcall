package louis.example.awpcall.alarm;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import java.util.Calendar;

/**
 * Created by louis on 16/5/31.
 */
public class AlarmController {

    //TODO instance
    //TODO viarable and behave detach



    private Context mContext;
    private AlarmManager mAlarmManager;


    private static AlarmController sInstance;

    public AlarmController(Context context) {
        this.mContext = context;
        if (mContext != null)
            mAlarmManager = (AlarmManager) mContext.getSystemService(Context.ALARM_SERVICE);
    }

    public static AlarmController getsInstance(Context context) {
        if(sInstance == null)
            sInstance = new AlarmController(context);
        return sInstance;
    }

    public void setAlarm(String action, Calendar calendar) {
        Intent intent = new Intent(action);
        intent.putExtra("ALARMTIME", calendar.getTimeInMillis());
        PendingIntent sender = PendingIntent.getBroadcast(
                mContext, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        if (Build.VERSION.SDK_INT < 19) {
            mAlarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
        } else {
            if (Build.VERSION.SDK_INT < 23) {
                setExact(calendar, sender);
            } else {
                mAlarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), sender);
            }
        }
    }

    public void setAlarm(String action, long mills) {
        Intent intent = new Intent(action);
        intent.putExtra("ALARMTIME", mills);
        PendingIntent sender = PendingIntent.getBroadcast(
                mContext, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        if (Build.VERSION.SDK_INT < 19) {
            mAlarmManager.set(AlarmManager.RTC_WAKEUP, mills, sender);
        } else {
            if (Build.VERSION.SDK_INT < 23) {
                setExact(mills, sender);
            } else {
                mAlarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, mills, sender);
            }
        }
    }

    @TargetApi(19)
    private void setExact(Calendar calendar, PendingIntent pendingIntent) {
        mAlarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);
    }

    @TargetApi(19)
    private void setExact(long mills, PendingIntent pendingIntent) {
        mAlarmManager.setExact(AlarmManager.RTC_WAKEUP, mills, pendingIntent);
    }

    //TODO exact time after sdk version 19
    public void setRepeatingAlarm(String action, Calendar calendar, int interval) {
        Intent intent = new Intent(action);
        intent.putExtra("ALARMTIME", calendar.getTimeInMillis());
        PendingIntent sender = PendingIntent.getBroadcast(
                mContext, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), interval, sender);
    }

    //TODO exact time after sdk version 19
    public void setRepeatingAlarm(String action, long mills, int interval) {
        Intent intent = new Intent(action);
        intent.putExtra("ALARMTIME", mills);
        PendingIntent sender = PendingIntent.getBroadcast(
                mContext, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        mAlarmManager.setRepeating(AlarmManager.RTC_WAKEUP, mills, interval, sender);
    }

    public void cancelAlarm (String action, Calendar calendar) {
        Intent intent = new Intent(action);
        intent.putExtra("ALARMTIME", calendar.getTimeInMillis());
        PendingIntent sender = PendingIntent.getBroadcast(
                mContext, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        mAlarmManager.cancel(sender);
    }

    public void cancelAlarm (String action, long mills) {
        Intent intent = new Intent(action);
        intent.putExtra("ALARMTIME", mills);
        PendingIntent sender = PendingIntent.getBroadcast(
                mContext, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        mAlarmManager.cancel(sender);
    }


}
