package com.themega.lesson18;

import java.util.Date;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class UploadService extends Service {
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		String url="http://192.168.1.82/lesson18/save.php";
		RequestParams params = new RequestParams();
		String date = (new Date()).toString();
		params.put("data", "This was loaded at "+date);
		AsyncHttpClient client = new AsyncHttpClient();
		client.post(url, params, new AsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] response) {
				String data = new String(response);
				Log.d("DATA", data);
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				Log.e("ERROR", "Failed to upload");
				stopSelf();
				
			}
		});
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO: Return the communication channel to the service.
		throw new UnsupportedOperationException("Not yet implemented");
	}
}
