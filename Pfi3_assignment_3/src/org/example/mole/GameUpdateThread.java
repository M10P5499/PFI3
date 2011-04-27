package org.example.mole;

import android.os.Handler;




public class GameUpdateThread extends Thread {

	
	private boolean running = true;
	Handler handler;
	public GameUpdateThread( Handler _handler ) {
		handler = _handler;
		}
	
	@Override
	public void run() {
		while ( running ) {
			try {
				handler.sendEmptyMessage(20);
				Thread.sleep(100);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				//uppdatera GameEngine
				
		
		// TODO Auto-generated method stub
		super.run();
	}



	}}
