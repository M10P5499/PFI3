package org.example.mole;


import java.util.ArrayList;
import java.util.List;

import android.R.color;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

public class GameEngine extends View implements Callback {
	
	private static final String Points = null;
	private List<Drawable2> drawables = new ArrayList<Drawable2>() ;
	Handler mHandler;
	public GameEngine(Context context) {
		super(context);
		mHandler = new Handler(this);
		
		new GameUpdateThread(mHandler).start();
	
		drawables.add ( new Mole(context,50,50) );
		drawables.add ( new Mole(context,150,50) );
		drawables.add ( new Mole(context,250,50) );
		drawables.add ( new Mole(context,50,150) );
		drawables.add ( new Mole(context,150,150) );
		drawables.add ( new Mole(context,250,150) );
		drawables.add ( new Mole(context,50,250) );
		drawables.add ( new Mole(context,150,250) );
		drawables.add ( new Mole(context,250,250) );
	}
		
	
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		//TODO Auto-generated method stub
		super.onDraw(canvas);
		
		Paint bg = new Paint();
		bg.setColor( Color.DKGRAY);
		canvas.drawRect(0, 0, 900, 900, bg);
		
		for (Drawable2 d : drawables) {
			d.draw(canvas);
		}
		
		
		Paint white = new Paint();
		white.setARGB(255, 255, 255, 255);
		canvas.drawText("Score: " + points, 50, 350, white);
		
	    
	    
		
	}
		



	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		for (Drawable2 d : drawables) {
		if 	(d.press(event))
			points++;
			
		}
		return super.onTouchEvent(event);
	}


		int points;
		

	@Override
	public boolean handleMessage(Message arg0) {
		// TODO Auto-generated method stub
		
		for(Drawable2 d : drawables) 
			{
				d.decreaseLife();
				Log.i("test","life :"+ ((Mole) d).getLife());
			}
		for(Drawable2 d : drawables)
			{
				d.updatelife();
			}
		invalidate();
		return false;
	}
}
