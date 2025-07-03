package vn.com.minh_nguyen.vkey.switchcustom

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import vn.com.minh_nguyen.vkey.customswitch.R
import vn.com.minh_nguyen.vkey.customswitch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnSwitch.setThumbDrawable(R.drawable.custom_thumb)
        binding.btnSwitch.setTrackDrawable(R.drawable.custom_track)
        binding.btnSwitch.setChecked(true)
        binding.btnSwitch.setOnCheckedChangeListener { check ->
            Log.d("TAG_LOG", "onCreate: $check")
        }
    }
}