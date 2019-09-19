package gr.efthymiou.petros.backbaseassignment.application;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import gr.efthymiou.petros.backbaseassignment.utils.LogUtils;

@SuppressLint({"CommitPrefEdits"})
public enum PreferenceDao {
    USER_IMPERIAL_SYSTEM(Boolean.class);

    private Class<?> type = null;

    private PreferenceDao(Class<?> type) {
        this.type = type;
    }

    public void setValue(Object value, Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        SharedPreferences.Editor editor = settings.edit();
        String key = this.name();
        if (this.type == String.class) {
            editor.putString(key, (String) value);
        } else if (this.type == Boolean.class) {
            editor.putBoolean(key, (Boolean) value);
        } else if (this.type == Integer.class) {
            editor.putInt(key, (Integer) value);
        }
        Log.d(LogUtils.PREFERENCES_TAG, "Saving setting, key[" + key + "] value[" + value + "]");
        editor.apply();
    }

    public Object getValue(Context context) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        Object value = null;
        String key = this.name();
        if (this.type == String.class) {
            value = settings.getString(key, (String) null);
        } else if (this.type == Boolean.class) {
            value = settings.getBoolean(key, false);
        } else if (this.type == Integer.class) {
            value = settings.getInt(key, 0);
        }

        Log.d(LogUtils.PREFERENCES_TAG, "Getting setting, key[" + key + "] value[" + value + "]");
        return value;
    }


}
