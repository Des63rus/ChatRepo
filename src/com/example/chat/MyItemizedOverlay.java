package com.example.chat;

import android.app.AlertDialog;
import android.content.Context;
import android.view.MotionEvent;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.List;

public class MyItemizedOverlay extends ItemizedIconOverlay<OverlayItem> {

	protected Context mContext;

	public MyItemizedOverlay(final Context context,
                             final List<OverlayItem> aList) {
		super(context, aList, new OnItemGestureListener<OverlayItem>() {
			@Override
			public boolean onItemSingleTapUp(final int index,
					final OverlayItem item) {
				return false;
			}

			@Override
			public boolean onItemLongPress(final int index,
					final OverlayItem item) {
				return false;
			}
		});
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	@Override
	public boolean addItem(OverlayItem item) {
		// TODO Auto-generated method stub
		return super.addItem(item);
	}
	@Override
	protected boolean onSingleTapUpHelper(final int index,
			final OverlayItem item, final MapView mapView) {
		// Toast.makeText(mContext, "Item " + index + " has been tapped!",
		// Toast.LENGTH_SHORT).show();
		AlertDialog.Builder dialog = new AlertDialog.Builder(mContext);
		dialog.setTitle(item.getTitle());
		dialog.setMessage(item.getSnippet());
		dialog.show();
		return true;
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e, MapView mapView) {
		float x = e.getRawX();
		float y = e.getRawY();
		//GeoPoint gp = (GeoPoint) mapView.getProjection().fromPixels(x,y);
		return super.onSingleTapUp(e, mapView);
	}



}