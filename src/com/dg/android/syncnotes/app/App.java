package com.dg.android.syncnotes.app;

import android.app.Application;

import com.dg.libs.rest.authentication.AuthenticationProvider;
import com.dg.libs.rest.client.BaseRestClient;

public class App extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		
		BaseRestClient.setDefaultAuthenticationProvider(new AuthenticationProvider() {
			
			@Override
			public void authenticateRequest(BaseRestClient client) {
			}
		});

	}
}
