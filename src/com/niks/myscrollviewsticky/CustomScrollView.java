package com.niks.myscrollviewsticky;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

public class CustomScrollView extends ScrollView
{
	private ScrollViewListener scrollViewListener;

	public CustomScrollView(Context paramContext)
	{
		super(paramContext);
	}

	public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet)
	{
		super(paramContext, paramAttributeSet);
	}

	public CustomScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
	{
		super(paramContext, paramAttributeSet, paramInt);
	}

	public ScrollViewListener getScrollViewListener()
	{
		return this.scrollViewListener;
	}

	protected void onScrollChanged(int current_horizontal_scroll  , int current_vertical_scroll  , int previous_horizontal_scroll , int previous_vertical_scroll)
	{
		super.onScrollChanged(current_horizontal_scroll, current_vertical_scroll, previous_horizontal_scroll, previous_vertical_scroll);
		this.scrollViewListener.onScrollChanged(current_horizontal_scroll, current_vertical_scroll,previous_horizontal_scroll, previous_vertical_scroll);
	}

	public void setScrollViewListener(ScrollViewListener paramScrollViewListener)
	{
		this.scrollViewListener = paramScrollViewListener;
	}

	public static abstract interface ScrollViewListener
	{
		public abstract void onScrollChanged(int current_horizontal_scroll  , int current_vertical_scroll  , int previous_horizontal_scroll , int previous_vertical_scroll);
	}
}
 