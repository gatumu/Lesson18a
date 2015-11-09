package com.themega.lesson18;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class InternetReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info =  cm.getActiveNetworkInfo();
		if(info!=null && info.isConnected()){
			Intent s = new Intent(context, UploadService.class);
			context.startService(s);
		}
	}
}
