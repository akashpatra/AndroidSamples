package in.co.trapps.droid_dive.components.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import static in.co.trapps.droid_dive.views.recyclerview.multipletype.Constants.TAG;

/**
 * @author Akash Patra
 */
public class StartedService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand >> " + startId);

        /*if (startId == 12) {
            stopSelf();
        }

        try {
            Thread.sleep(3000);
            stopSelf();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        new Thread(new CustomRunnable(startId)).start();

        return super.onStartCommand(intent, flags, startId);
    }

    class CustomRunnable implements Runnable {

        private int id;

        CustomRunnable(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            try {
                Log.d(TAG, "Wrk is in Progress >> " + id);
                Thread.sleep(5000);
                Log.d(TAG, "Wrk ended >> " + id);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // As it is a bind Service, so returning instance of IBinder to create
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind");
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}
