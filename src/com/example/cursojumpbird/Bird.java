package com.example.cursojumpbird;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Bird {

	private int alturaDaBolinha;
	private Paint paint = new Paint();
	
	public Bird() {
		paint.setColor(0xFFFF0000);
		alturaDaBolinha = 100;
	}
	
	public void drawOn(Canvas canvas) {
		canvas.drawCircle(100, alturaDaBolinha, 50, paint);
	}
	
	public void cai() {
		alturaDaBolinha += 5;
	}

	public void pula() {
		alturaDaBolinha -= 150;
	}
}
