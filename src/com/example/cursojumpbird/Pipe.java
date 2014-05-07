package com.example.cursojumpbird;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Pipe {
	
	private Paint paint;
	private ScreenHelper helper;
	private int tamanhoDoPipe = 250;
	private int larguraDoPipe = 100;

	public Pipe(ScreenHelper helper) {
		this.helper = helper;
		paint = new Paint();
		paint.setColor(0xFF00FF00);
	}
	
	public void drawOn(Canvas canvas) {
		canvas.drawRect(0, 0, larguraDoPipe, tamanhoDoPipe, paint);
		canvas.drawRect(0, helper.getHeight() - tamanhoDoPipe , larguraDoPipe, helper.getHeight(), paint);
	}

}
