package in.co.trapps.droid_dive.components.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Random;

import static in.co.trapps.droid_dive.views.recyclerview.multipletype.Constants.TAG;

/**
 * Binding Service using IBinder
 *
 * @author Akash Patra
 */
public class BindService extends Service {

    private final String CLASS_NAME = this.getClass().getSimpleName();

    // Binder for Clients
    private final IBinder binder = new LocalBinder();

    // Random Number Generator
    private final Random mGenerator = new Random();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, CLASS_NAME + " >> onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, CLASS_NAME + " >> onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, CLASS_NAME + " >> onBind");
        return binder;
    }

    /**
     * Share Local Binder for Clients
     */
    public class LocalBinder extends Binder {
        public Service getService() {
            return BindService.this;
        }
    }

    /**
     * Method exposed to Clients
     *
     * @return a Random Number
     */
    public int getRandomNumber() {
        return mGenerator.nextInt(100);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, CLASS_NAME + " >> onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onRebind(Intent intent) {
        Log.d(TAG, CLASS_NAME + " >> onRebind");
        super.onRebind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, CLASS_NAME + " >> onDestroy");
    }
}
