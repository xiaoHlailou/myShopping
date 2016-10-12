package com.example.shoppingdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPreferences方法
 */
public class SpUtils {

    public static void save(Context context,String key,Object object){

        //sp
        SharedPreferences sp=context.getSharedPreferences("config",Context.MODE_PRIVATE);
        //保存要用编辑器
        SharedPreferences.Editor editor = sp.edit();

        if (object instanceof String) {
            editor.putString(key, (String) object);
        } else if (object instanceof Boolean){
            editor.putBoolean(key, (Boolean) object);
        }

        editor.commit();

    }

    public static SharedPreferences get(Context context) {
        SharedPreferences sp = context.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp;
    }

}
