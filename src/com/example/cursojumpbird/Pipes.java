package com.example.cursojumpbird;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

public class Pipes {

	List<Pipe> pipes = new ArrayList<Pipe>();
	
	public Pipes(ScreenHelper helper) {
		int posicaoInicial = helper.getWidth();
		for(int i=0; i<5; i++) {
			pipes.add(new Pipe(helper, posicaoInicial));
			posicaoInicial += 250;
		}
	}

	public void drawOn(Canvas canvas) {
		for (Pipe pipe : pipes) {
			pipe.move();
			pipe.drawOn(canvas);
		}
	}
}
