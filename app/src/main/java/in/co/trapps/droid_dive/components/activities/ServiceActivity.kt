package `in`.co.trapps.droid_dive.components.activities

import `in`.co.trapps.droid_dive.R
import `in`.co.trapps.droid_dive.components.services.StartedService
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        btnStartNormalService.setOnClickListener(this)
        btnStopNormalService.setOnClickListener(this)
        btnBindService.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnStartNormalService -> handleNormalService(true)
            R.id.btnStopNormalService -> handleNormalService(false)
            R.id.btnBindService -> startBindService()
        }
    }

    private fun handleNormalService(flag: Boolean) {
        if (flag) {
            startService(Intent(this, StartedService::class.java))
        } else {
            stopService(Intent(this, StartedService::class.java))
        }
    }

    private fun startBindService() {
//        bindService(Intent(this, BindService::class.java))
    }
}
