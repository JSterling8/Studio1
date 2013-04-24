package com.jon.thatcher;

import java.io.InputStream;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.touch.TouchImageView;

/**
 * This is the Java file that inflates the "Map" tab.
 * 
 * @author Jonathan Sterling
 *
 */
public class MapFragment extends Fragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// This is the View that will be returned.  I also need it to call findViewById().
		View v = inflater.inflate(R.layout.activity_map_fragment, container, false);
		
		// Gets the overhead map.
        InputStream is = getResources().openRawResource(R.drawable.overhead_map);
        
        // Turns the .png into a Bitmap.
        Bitmap bmp = BitmapFactory.decodeStream(is);
        
        // Gets the TouchImageView from the layout file.
        TouchImageView touch = (TouchImageView) v.findViewById(R.id.overheadMap);
        
        // Sets the image in the TouchImageView to be the Bitmap we just made.
        touch.setImageBitmap(bmp);
        
        // Sets the max zoom.  The default is 3f.
        touch.setMaxZoom(4f);
		
		return (v);
	}
	

}