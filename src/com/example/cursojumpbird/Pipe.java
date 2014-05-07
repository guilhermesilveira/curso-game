package com.example.cursojumpbird;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Pipe {
	
	private Paint paint;
	private ScreenHelper helper;
	private int tamanhoDoPipe = 250;
	private int larguraDoPipe = 100;
	private float posicaoInicial;

	public Pipe(ScreenHelper helper) {
		this.helper = helper;
		paint = new Paint();
		paint.setColor(0xFF00FF00);
		this.posicaoInicial = helper.getWidth();
	}
	
	public void drawOn(Canvas canvas) {
		canvas.drawRect(posicaoInicial, 0, posicaoInicial + larguraDoPipe, tamanhoDoPipe, paint);
		canvas.drawRect(posicaoInicial, helper.getHeight() - tamanhoDoPipe , posicaoInicial + larguraDoPipe, helper.getHeight(), paint);
	}
	
	public void move() {
		posicaoInicial -= 5;
	}

}
