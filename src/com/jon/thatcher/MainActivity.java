package com.jon.thatcher;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

/**
 * This is the main activity.
 * It contains all of the tabs.
 * 
 * @author Jonathan Sterling
 *
 */
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Gets the ActionBar.
		ActionBar actionbar = getActionBar();

		// Sets the ActionBar to tabs mode.
		actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// Creates the tabs.
		ActionBar.Tab infoTab = actionbar.newTab().setText("Event Info");
		ActionBar.Tab bioTab = actionbar.newTab().setText("Bio");
		ActionBar.Tab mapTab = actionbar.newTab().setText("Map");

		// Creates the fragments.
		InfoFragment infoFragment = new InfoFragment();
		BioFragment bioFragment = new BioFragment();
		MapFragment mapFragment = new MapFragment();

		// Adds the tab listener to the tabs to make them interactive.
		infoTab.setTabListener(new CustomTabListener(infoFragment));
		bioTab.setTabListener(new CustomTabListener(bioFragment));
		mapTab.setTabListener(new CustomTabListener(mapFragment));

		// Adds the tabs to the ActionBar.
		actionbar.addTab(infoTab);
		actionbar.addTab(bioTab);
		actionbar.addTab(mapTab);   
	}

	/**
	 * As the name implies, this is a custom TabListener.
	 * It tells the app what to do when tabs are selected and left.
	 * 
	 * @author Jonathan Sterling
	 *
	 */
	class CustomTabListener implements ActionBar.TabListener {
		public Fragment fragment;

		public CustomTabListener(Fragment fragment) {
			this.fragment = fragment;
		}

		/**
		 * This is called when a new tab is selected.
		 */
		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			// Replaces the current fragment with the new one that was selected.
			ft.replace(R.id.fragment_container, this.fragment);
		}

		/**
		 * This is called when a new tab is selected.
		 */
		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// Removes the current fragment so a new one can be shown.
			ft.remove(fragment);

		}

		/**
		 * This is called when a tab that was previously open is reopened.
		 * Nothing special needs to be done when this happens for this app,
		 * so the method is empty.
		 */
		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {}	 
	}

	/**
	 * This is the method called when the user clicks the button
	 * in the maps tab.  It opens up Google Maps.
	 * 
	 * @param view The button being pressed.  It's not used, but has to be here because I used "android:onClick" in the xml file.
	 */
	public void openMaps(View view){
		// This is the uri that will be opened.  The numbers are the latitude and longitude of St. Paul's Cathedral.
		String uri = "https://maps.google.com/maps?q=51.5138,+-0.0980+(Margaret Thatcher's Funeral)&iwloc=A&hl=en";
		// Make a new intent to open the uri.
		Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(uri));
		// Open it in Google Maps.
		intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
		// Open Google Maps.
		startActivity(intent);  
	}

	/**
	 * I had to override this method so that when the screen is rotated, the tab is saved.
	 * Otherwise on screen rotation, the app would always just open the first tab.
	 */
	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
		super.onSaveInstanceState(savedInstanceState);

		// Get the action bar.
		ActionBar actionbar = getActionBar();

		// Save the current tab on the action bar.
		savedInstanceState.putInt("Active Tab", actionbar.getSelectedNavigationIndex());
	}

	/**
	 * I had to override this method so that when the screen is rotated, the tab is saved.
	 * Otherwise on screen rotation, the app would always just open the first tab.
	 */
	@Override
	public void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		
		// Get the active tab that was saved earlier.
		int activeTab = savedInstanceState.getInt("Active Tab");

		// If the active tab is 1 or 2.
		if (activeTab > 0 && activeTab < 3){
			// Get the action bar
			ActionBar actionbar = getActionBar();

			// Set the current tab to the one saved.
			actionbar.setSelectedNavigationItem(activeTab);
		}
	}

}
