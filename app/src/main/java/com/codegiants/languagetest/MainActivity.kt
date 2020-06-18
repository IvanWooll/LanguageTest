package com.codegiants.languagetest

import android.content.ComponentName
import android.content.Intent
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.ConfigurationCompat
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val appLanguage = Locale.getDefault()
        println("app language=$appLanguage")

        val locales = ConfigurationCompat.getLocales(Resources.getSystem().configuration)

        println("device language=${locales[0]}")

        button.setOnClickListener {
            PopupMenu(this, button).apply {
                menuInflater.inflate(R.menu.main, menu)
                setOnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.en -> {
                            App.changeLanguage(
                                "en",
                                this@MainActivity,
                                Intent(this@MainActivity, MainActivity::class.java)
                            )
                            true
                        }
                        R.id.fr -> {
                            App.changeLanguage(
                                "fr",
                                this@MainActivity,
                                Intent(this@MainActivity, MainActivity::class.java)
                            )

                            true
                        }
                        else -> false
                    }
                }
            }.show()
        }

        buttonOpenActivity.setOnClickListener {
            val intent = Intent()

            val cls = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                "com.android.settings.Settings\$LanguageAndInputSettingsActivity"
            } else {
                "com.android.settings.Settings\$InputMethodAndLanguageSettingsActivity"
            }

            intent.component = ComponentName(
                "com.android.settings",
                cls
            )

            startActivity(intent)
        }
    }
}
