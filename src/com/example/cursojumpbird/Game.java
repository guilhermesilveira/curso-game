package com.example.cursojumpbird;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Game extends SurfaceView implements Runnable{

	private SurfaceHolder holder;
	private boolean isRunning = true;
	private final Canvas canvas;
	private final Bitmap backgroundAumentado;
	private ScreenHelper screenHelper;
	private GameEngine engine;

	public Game(MainActivity activity) {
		super(activity);
		holder = getHolder();
		screenHelper = new ScreenHelper(activity);
		setOnTouchListener(activity);
		this.backgroundAumentado = criaBackground();
		engine = new GameEngine(screenHelper);
	}
	
	@Override
	public void run() {
		while(isRunning) {
			if(!holder.getSurface().isValid()) continue;
			
			canvas = holder.lockCanvas();
			engine.nextRound(canvas);
			
			
			holder.unlockCanvasAndPost(canvas);
		}
	}
	
	public void resume() {
		estaRodando = true;
	}
	
	public void stopThread() {
		isRunning = false;
	}

	public void jumpBird() {
		engine.pula();
	}

}
