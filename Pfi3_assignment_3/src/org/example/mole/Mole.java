package org.example.mole;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;

public class Mole implements Drawable2 {

	Context ctx;
	Bitmap iconImage;
	
	public Mole(Context ctx, int posX, int posY) {
		super();
		this.ctx = ctx;
		this.posX = posX;
		this.posY = posY;
		
		iconImage = BitmapFactory.decodeResource(ctx.getResources(), R.drawable.icon);            

		//Resources res = ctx.getResources();
		//iconImage = res.getDrawable(R.drawable.icon);
	}

	private int posX, posY;
	private double radius = 30;

	int life = 100;

	public int getLife() {
		return life;
	}

	@Override
	public void draw(Canvas canvas) {
		if (life > 0) {
			Paint paint = new Paint();
			paint.setColor(Color.BLUE);
			//canvas.drawCircle(posX, posY, (float) radius, paint); 
			//iconImage.draw(canvas);
			canvas.drawBitmap(iconImage, posX - iconImage.getWidth()/2, posY - iconImage.getHeight()/2, paint);
		}
	}

	@Override
	public boolean press(MotionEvent evt) {
		float dx = evt.getX() - posX;
		float dy = evt.getY() - posY;

		double dist = Math.sqrt(dx * dx + dy * dy);
		if (life > 0)
		if (dist < radius) {
			Log.i("TEST", "HIT");
			life = 0;
			
			
		return true;
		}
		return false;
		
	}

	@Override
	public void decreaseLife() {
		if(life > 0)
		life = life - 1;

	}

	@Override
	public void updatelife() {
		if (life <= 0) {
			if (Math.random() * 100 < 3)
				life = 100;
			Log.i("TEST" , "UPDATELIFE");

		}

	}
}
