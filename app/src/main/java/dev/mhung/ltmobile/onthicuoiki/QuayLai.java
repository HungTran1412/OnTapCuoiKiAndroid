package dev.mhung.ltmobile.onthicuoiki;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;

public class QuayLai {
    public static void quayLai(Activity activity, Class<?> targetActivity) {
        Intent intent = new Intent(activity, targetActivity);
        activity.startActivity(intent);
        activity.finish();
    }
}
