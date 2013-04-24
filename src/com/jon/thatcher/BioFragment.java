package com.jon.thatcher;

import android.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * This is the Java file that inflates the "Bio" tab.
 * 
 * @author Jonathan Sterling
 *
 */
public class BioFragment extends Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// This is the View that will be returned.  I'll need it to call findViewById().
		View v = inflater.inflate(com.jon.thatcher.R.layout.activity_bio_fragment, container, false);
		
		// This makes the TextView scrollable.
		TextView tvAccomplishmentsInfo = (TextView) v.findViewById(R.id.tvAtAGlanceInfo);
		tvAccomplishmentsInfo.setMovementMethod(new ScrollingMovementMethod());

        return (v);
	}
}
