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
	private Bird bird;
	private Pipes pipes;

	public Game(MainActivity activity) {
		super(activity);
		holder = getHolder();
		screenHelper = new ScreenHelper(activity);
		setOnTouchListener(activity);
		this.backgroundAumentado = criaBackground();
		init();
	}
	
	private Bitmap criaBackground() {
		Bitmap back = BitmapFactory.decodeResource(getResources(),R.drawable.back);
		return Bitmap.createScaledBitmap(back, back.getWidth(), screenHelper.getHeight(), false);
	}
	
	private void init() {
		bird = new Bird(screenHelper);
		pipes = new Pipes(screenHelper);
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
			pipes.drawOn(canvas);
			
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
		bird.pula();
	}

}
