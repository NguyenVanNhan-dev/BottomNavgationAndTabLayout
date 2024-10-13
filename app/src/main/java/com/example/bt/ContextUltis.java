package com.example.bt;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.os.LocaleList;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

public class ContextUltis extends ContextWrapper {
    public static String language = "en";

    public ContextUltis(Context base) {
        super(base);
    }

    public static ContextWrapper updateLocale(Context context, Locale localeToSwitch) {
        Context newContext = context;
        Resources resources = context.getResources();
        Configuration config = resources.getConfiguration();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            LocaleList localeList = new LocaleList(localeToSwitch);
            LocaleList.setDefault(localeList);
            config.setLocales(localeList);
        } else {
            config.locale = localeToSwitch;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            newContext = context.createConfigurationContext(config);
        } else {
            resources.updateConfiguration(config, resources.getDisplayMetrics());
        }

        return new ContextUltis(newContext);
    }
}
