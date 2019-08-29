package `in`.co.trapps.droid_dive.components.activities

import `in`.co.trapps.droid_dive.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRV.setOnClickListener(this)
        btnService.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnRV -> startActivity(Intent(this, RVMultiTypeActivity::class.java))
            R.id.btnService -> startActivity(Intent(this, ServiceActivity::class.java))
        }
    }
}
