package com.example.cursojumpbird;

import android.app.Activity;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Game extends SurfaceView implements Runnable{

	private SurfaceHolder holder;
	private boolean isRunning;
	private Canvas canvas;

	public Game(Activity activity) {
		super(activity);
		holder = getHolder();
		isRunning = true;
	}

	@Override
	public void run() {
		while(isRunning) {
			if(!holder.getSurface().isValid()) continue;
			
			canvas = holder.lockCanvas();
			
			// Aqui desenharemos nossos elementos do jogo...
			
			holder.unlockCanvasAndPost(canvas);
		}
	}
	
	public void resume() {
		isRunning = true;
	}
	
	public void stopThread() {
		isRunning = false;
	}

}
