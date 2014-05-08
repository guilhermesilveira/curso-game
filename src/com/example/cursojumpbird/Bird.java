package com.example.cursojumpbird;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Bird {

	private int altura = 100;
	private ScreenHelper helper;
	private static final int RAIO = 50;
	
	public Bird(ScreenHelper helper) {
		this.helper = helper;
	}
	
	public void drawOn(Canvas canvas) {
		canvas.drawCircle(100, alturaDaBolinha, raioDaBolinha, Cores.azulChoque());
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
