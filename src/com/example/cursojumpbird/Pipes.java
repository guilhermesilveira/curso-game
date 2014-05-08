package com.example.cursojumpbird;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

public class Canos {

	private static final int DISTANCIA_ENTRE_PIPES = 250;
	private final List<Pipe> pipes = new ArrayList<Pipe>();
	private int ultimoCano = 0;
	
	public Canos(ScreenHelper helper) {
		criaCenarioComCanos(5, helper.getWidth());
	}
	
	private void criaCenarioComCanos(int quantidade, int posicaoAtual) {
		for(int i=0; i< quantidade; i++) {
			posicaoAtual += DISTANCIA_ENTRE_PIPES;
			pipes.add(new Pipe(helper, posicaoAtual));
		}
			ultimoCano = posicaoAtual;
	}

	public void drawOn(Canvas canvas) {
		for (Pipe pipe : pipes) {
			pipe.move();
			pipe.drawOn(canvas);
			ultimoCano -= Cano.MOVIMENTO; // (5 né?)
		}
		voltaProFimSeSairDaTela();
	}

	public void voltaProFimSeSairDaTela() {
		for (Pipe pipe : pipes) {
			if(pipe.saiuDaTela()) {
				ultimoCano = ultimoCano + DISTANCIA_ENTRE_PIPES; 
				pipe.setX(ultimoCano);
			}
		}
	}
}
