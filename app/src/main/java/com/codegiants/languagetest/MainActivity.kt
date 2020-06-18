package com.codegiants.languagetest

import android.content.ComponentName
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val intent = Intent()

            val cls = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                "com.android.settings.Settings\$LanguageAndInputSettingsActivity"
            } else {
                "com.android.settings.Settings\$InputMethodAndLanguageSettingsActivity"
            }

            intent.component = ComponentName("com.android.settings", cls)

            startActivity(intent)
        }
    }
}
