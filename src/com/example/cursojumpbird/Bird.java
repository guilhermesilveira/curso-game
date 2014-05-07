package com.example.cursojumpbird;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Bird {

	private int alturaDaBolinha;
	private Paint paint = new Paint();
	private ScreenHelper helper;
	private int raioDaBolinha;
	
	public Bird(ScreenHelper helper) {
		this.helper = helper;
		paint.setColor(0xFFFF0000);
		alturaDaBolinha = 100;
		raioDaBolinha = 50;
	}
	
	public void drawOn(Canvas canvas) {
		canvas.drawCircle(100, alturaDaBolinha, raioDaBolinha, paint);
	}
	
	public void cai() {
		if(alturaDaBolinha < helper.getHeight() - raioDaBolinha) {
			alturaDaBolinha += 5;
		}
	}

	public void pula() {
		if(alturaDaBolinha > raioDaBolinha) {
			alturaDaBolinha -= 150;
		}
	}
}
