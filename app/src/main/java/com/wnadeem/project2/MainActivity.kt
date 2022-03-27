package com.wnadeem.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wnadeem.project2.ui.main.ConfigFragment
import com.wnadeem.project2.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ConfigFragment.newInstance())
                .commitNow()
        }
        }
    }
