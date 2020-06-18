package com.codegiants.languagetest;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;

import com.yariksoffice.lingver.Lingver;

import java.util.Locale;

public class MyApp extends Application {


    @Override
    public void onCreate() {

        super.onCreate();
        Lingver.init(this, "en");
    }


}