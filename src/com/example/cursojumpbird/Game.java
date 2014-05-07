package com.example.cursojumpbird;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Game extends SurfaceView implements Runnable{

	private SurfaceHolder holder;
	private boolean isRunning;
	private Canvas canvas;
	private Bitmap backgroundAumentado;
	private ScreenHelper screenHelper;
	private Bird bird;

	public Game(MainActivity activity) {
		super(activity);
		holder = getHolder();
		isRunning = true;
		screenHelper = new ScreenHelper(activity);
		
		setOnTouchListener(activity);
		
		criaBackground();
		
		init();
		
	}
	
	private void criaBackground() {
		Bitmap back = BitmapFactory.decodeResource(getResources(),R.drawable.back);
		this.backgroundAumentado = Bitmap.createScaledBitmap(back, back.getWidth(), screenHelper.getHeight(), false);
	}
	
	private void init() {
		bird = new Bird(screenHelper);
	}

	@Override
	public void run() {
		while(isRunning) {
			if(!holder.getSurface().isValid()) continue;
			
			canvas = holder.lockCanvas();
			
			// Aqui desenharemos nossos elementos do jogo...
			canvas.drawBitmap(backgroundAumentado, 0, 0, null);
			bird.drawOn(canvas);
			bird.cai();
			
			holder.unlockCanvasAndPost(canvas);
		}
	}
	
	public void resume() {
		isRunning = true;
	}
	
	public void stopThread() {
		isRunning = false;
	}

	public void jumpBird() {
		bird.pula();
	}

}
