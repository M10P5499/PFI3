package org.example.mole;

import android.graphics.Canvas;
import android.view.MotionEvent;

public interface Drawable2 {
	
	public void draw( Canvas canvas);
	public boolean press (MotionEvent evt);
	public void decreaseLife();
	public void updatelife();
	
}
