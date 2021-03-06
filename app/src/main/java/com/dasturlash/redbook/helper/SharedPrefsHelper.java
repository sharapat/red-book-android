package com.dasturlash.redbook.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by QAREKEN on 5/26/2018.
 */

public class SharedPrefsHelper {
    private static final String FILE_NAME = "preferences";
    private static final String IS_FIRST_LAUNCH = "is_first_launch";

    private SharedPreferences preferences;

    public SharedPrefsHelper(Context context) {
        preferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    }

    public void setFirstLaunch() {
        preferences.edit().putBoolean(IS_FIRST_LAUNCH, false).apply();
    }

    public boolean isFirstLaunch() {
        return preferences.getBoolean(IS_FIRST_LAUNCH, true);
    }
}
