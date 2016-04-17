package com.niks.scrollviewsticky;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements CustomScrollView.ScrollViewListener
{


    CustomScrollView scrollView;
	LinearLayout inner_view, bottom_view;
	Toast toast;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		inner_view = (LinearLayout) findViewById(R.id.activity_main_innerview);
		bottom_view = (LinearLayout) findViewById(R.id.activity_main_bottomview);
		scrollView = (CustomScrollView) findViewById(R.id.activitymain_scrollview);
		scrollView.setScrollViewListener(this);
	}


	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onScrollChanged(int current_horizontal_scroll, int current_vertical_scroll, int previous_horizontal_scroll, int previous_vertical_scroll)
	{
 
		int[] inner_arrayOfInt1 = new int[2];
		int[] bottom_arrayOfInt2 = new int[2];
		this.inner_view.getLocationOnScreen(inner_arrayOfInt1);
		this.bottom_view.getLocationOnScreen(bottom_arrayOfInt2);
 
		if (inner_arrayOfInt1[1] <= bottom_arrayOfInt2[1])
	    {
			bottom_view.setVisibility(View.GONE);
			
	    }else
	    {
	    	bottom_view.setVisibility(View.VISIBLE);
	    }
 
	}

	private void myToast(String msg)
	{
		if (toast != null && toast.getView().getVisibility() == View.VISIBLE)
		{
			toast.cancel();
		}
		toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG);
		toast.show();

		// TODO Auto-generated method stub

	}
}
