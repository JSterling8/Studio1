package com.jon.thatcher;

import android.app.Fragment;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * This is the Java file that inflates the "Info" tab.
 * 
 * @author Jonathan Sterling
 *
 */
public class InfoFragment extends Fragment {

	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// This gets the View that will be returned.  I also need it to call findViewById().
		View v = inflater.inflate(com.jon.thatcher.R.layout.activity_info_fragment, container, false);
		
		TextView tvWhatToExpectInfo = (TextView)v.findViewById(R.id.tvWhatToExpectInfo);
		tvWhatToExpectInfo.setMovementMethod(new ScrollingMovementMethod());
		
		// Inflate the layout for this fragment
        return (v);
	}

}
