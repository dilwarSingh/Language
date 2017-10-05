package koi.com.language;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Vibrant1 on 21-Sep-17.
 */

public class appPrefs {

    Context mContext;
    SharedPreferences mPrefs;

    public appPrefs(Context mContext) {
        this.mContext = mContext;
        this.mPrefs = mContext.getSharedPreferences("data Values", Context.MODE_PRIVATE);
    }

    public void saveLanguage(String language) {

        Log.i("saveLang", language);
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString("language", language);
        editor.commit();
    }

    public String getLanguage() {

        String language = mPrefs.getString("language", "en");
        Log.i("get Lang", language);
        return language;

    }

}
