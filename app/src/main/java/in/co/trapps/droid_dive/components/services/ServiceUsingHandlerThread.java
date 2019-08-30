package in.co.trapps.droid_dive.components.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;

import androidx.annotation.Nullable;

import static in.co.trapps.droid_dive.views.recyclerview.multipletype.Constants.TAG;

/**
 * Started Service is a Service which runs indefinitely.
 *
 * @author Akash Patra
 */
public class ServiceUsingHandlerThread extends Service {

    private Looper serviceLooper;
    private ServiceHandler serviceHandler;

    // Handler that receives messages from the thread
    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "handleMessage >> " + msg.arg1);

            // Normally we would do some work here, like download a file.
            // For our sample, we just sleep for 5 seconds.
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // Restore interrupt status.
                Thread.currentThread().interrupt();
            }

            Log.d(TAG, "handleMessage completed >> " + msg.arg1);

            // Stop the service using the startId, so that we don't stop
            // the service in the middle of handling another job
            stopSelf();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");

        // Start up the thread running the service. Note that we create a
        // separate thread because the service normally runs in the process's
        // main thread, which we don't want to block. We also make it
        // background priority so CPU-intensive work doesn't disrupt our UI.
        HandlerThread thread = new HandlerThread("ServiceStartArguments", Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        // Get the HandlerThread's Looper and use it for our Handler
        serviceLooper = thread.getLooper();
        serviceHandler = new ServiceHandler(serviceLooper);
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

//        new Thread(new CustomRunnable(startId)).start();

        // For each start request, send a message to start a job and deliver the
        // start ID so we know which request we're stopping when we finish the job
        Message msg = serviceHandler.obtainMessage();
        msg.arg1 = startId;
        serviceHandler.sendMessage(msg);

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
