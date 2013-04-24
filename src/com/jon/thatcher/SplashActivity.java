package com.jon.thatcher;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {

	private ProgressDialog loading;								// The loading animation.
	private int loadingStatus = 0;								// The loading animations percentage.
	private Handler progressBarHandler = new Handler();			// Used to start the main activity after 4 seconds.

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);

		// Starts the main activity after 4000 milliseconds.
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				// Specify the intent to open the MainActivity.
				Intent intent = new Intent(SplashActivity.this, MainActivity.class);
				// Starts the main activity in the background.
				SplashActivity.this.startActivity(intent);
				// Closes the splash activity.
				SplashActivity.this.finish();
				// Makes it so the slash activity fades out and the main activity fades in (animation).
				overridePendingTransition(android.R.anim.fade_in,
						android.R.anim.fade_out);
			}
		}, 4000);


		// Makes a new loading bar.
		loading = new ProgressDialog(this);
		// Sets it so the user can hit back at any time to leave the screen.
		loading.setCancelable(true);
		// The message above the loading bar.
		loading.setMessage("Loading ...");
		// The style of the loading bar.
		loading.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		// Displays the loading bar on the screen.
		loading.show();

		// Set the progress dialogs status to 0.
		loadingStatus = 0;

		new Thread(new Runnable() {
			public void run() {
				// While the loading spinner is not at 100%
				while (loadingStatus < 100) {

					// Increment the percentage complete by 10%.
					loadingStatus = loadingStatus + 10;

					// Do nothing .5 seconds.
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					// Update the progress bar.
					progressBarHandler.post(new Runnable() {
						public void run() {
							loading.setProgress(loadingStatus);
						}
					});
				}

				// If the loading spinner is at 100%.
				if (loadingStatus >= 100) {
					// Close the loading spinner.
					loading.dismiss();
				}
			}
		}).start();

	}
}
