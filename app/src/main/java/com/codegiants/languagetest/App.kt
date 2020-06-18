package com.codegiants.languagetest

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.Intent
import com.yariksoffice.lingver.Lingver


class App : Application() {
    private val prefs by lazy { getSharedPreferences("app", Context.MODE_PRIVATE) }

    companion object {
        const val LANGUAGE_CODE = "language_code"

        fun changeLanguage(languageCode: String, currentActivity: Activity, intent: Intent) {
            val sharedPreferences =
                currentActivity.getSharedPreferences("app", Context.MODE_PRIVATE)
            val currentLanguageCode = sharedPreferences.getString(LANGUAGE_CODE, "en")
            if (currentLanguageCode == languageCode)
                return

            Lingver.getInstance().setLocale(currentActivity.applicationContext, languageCode)
            sharedPreferences.edit().apply {
                putString(LANGUAGE_CODE, languageCode)
            }.apply()
            currentActivity.finish()
            currentActivity.startActivity(intent)
        }
    }


    override fun onCreate() {
        super.onCreate()
        val languageCode = prefs.getString(LANGUAGE_CODE, "en")!!
        Lingver.init(this, languageCode)
    }

//    override fun onConfigurationChanged(newConfig: Configuration?) {
//        super.onConfigurationChanged(newConfig!!)
//        LocaleUtils.updateConfig(ContextThemeWrapper(this, null))
//    }

}