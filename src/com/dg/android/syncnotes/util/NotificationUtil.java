package com.dg.android.syncnotes.util;

import com.dg.android.syncnotes.R;

import android.content.Context;
import android.widget.Toast;

public class NotificationUtil {
	
	public static void makeText(Context c, String text){
		Toast.makeText(c, text, Toast.LENGTH_SHORT).show();
	}
	
	public static void makeText(Context c, int stringId){
		makeText(c, c.getString(stringId));
	}

}
