package `in`.co.trapps.droid_dive.components.activities

import `in`.co.trapps.droid_dive.R
import `in`.co.trapps.droid_dive.components.services.BindService
import `in`.co.trapps.droid_dive.components.services.StartedIntentService
import `in`.co.trapps.droid_dive.components.services.StartedService
import `in`.co.trapps.droid_dive.views.recyclerview.multipletype.Constants
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_service.*

/**
 * Activity related to only Service
 *
 * @author Akash Patra
 */
class ServiceActivity : AppCompatActivity(), View.OnClickListener {

    private val CLASS_NAME = this.javaClass.simpleName

    private lateinit var mService: BindService
    private var mBound = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(Constants.TAG, "$CLASS_NAME >> onCreate")
        setContentView(R.layout.activity_service)

        // Started Service
        btnStartService.setOnClickListener(this)
        btnStopService.setOnClickListener(this)

        // Bound Service
        btnStartBoundService.setOnClickListener(this)
        btnStopBoundService.setOnClickListener(this)
        btnFetchData4mBound.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnStartService -> startStopService(true)
            R.id.btnStopService -> startStopService(false)
            R.id.btnStartBoundService -> startStopBoundService(true)
            R.id.btnStopBoundService -> startStopBoundService(false)
            R.id.btnFetchData4mBound -> fetchData4mBoundService()
        }
    }

    /**
     * To start/stop Service
     */
    private fun startStopService(isStart: Boolean) {
        if (isStart) {
            // The startService() method returns immediately, and the Android system calls the service's onStartCommand() method.
            for (i in 1 until 4) {
                startService(Intent(this, StartedService::class.java))
            }
            Log.d(Constants.TAG, "$CLASS_NAME >> StartService called in Loop")
        } else {
            stopService(Intent(this, StartedService::class.java))
        }
    }

    /**
     * To start/stop Bound Service
     */
    private fun startStopBoundService(isStart: Boolean) {
        if (isStart) {
            for (i in 1 until 4) {
                val intent = Intent(this, BindService::class.java)
                bindService(intent, connection, Context.BIND_AUTO_CREATE)
            }
            Log.d(Constants.TAG, "$CLASS_NAME >> BindService called in Loop")
        } else {
            releaseBoundService()
        }
    }

    private fun releaseBoundService() {
        if (mBound) {
            unbindService(connection)
            mBound = false
        }
    }

    /**
     * Fetch data from Bound Service
     */
    private fun fetchData4mBoundService() {
        if (mBound) {
            val number = mService.randomNumber
            Toast.makeText(this, "Random Number : $number", Toast.LENGTH_SHORT).show()
        }
    }

    private val connection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            Log.d(Constants.TAG, "$CLASS_NAME >> onServiceConnected")

            // Bound to BindService
            val binder = service as BindService.LocalBinder
            mService = binder.service as BindService
            mBound = true
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            Log.d(Constants.TAG, "$CLASS_NAME >> onServiceDisconnected")

            mBound = false
        }
    }

    override fun onStop() {
        super.onStop()
        Log.d(Constants.TAG, "$CLASS_NAME >> onStop")

        // Releasing different Resources
        releaseBoundService()
    }
}
