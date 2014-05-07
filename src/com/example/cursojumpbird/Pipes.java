package com.example.cursojumpbird;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;

public class Pipes {

	private static final int DISTANCIA_ENTRE_PIPES = 250;
	private List<Pipe> pipes = new ArrayList<Pipe>();
	private ScreenHelper helper;
	private int posicaoInicial;
	private int maximo = 0;
	
	public Pipes(ScreenHelper helper) {
		this.helper = helper;
		
		posicaoInicial = helper.getWidth();
		for(int i=0; i<5; i++) {
			posicaoInicial += DISTANCIA_ENTRE_PIPES;
			pipes.add(new Pipe(helper, posicaoInicial));
		}
	}

	public void drawOn(Canvas canvas) {
		for (Pipe pipe : pipes) {
			pipe.move();
			pipe.drawOn(canvas);
			voltaProFimSeSairDaTela();
		}
	}

	//Cuidado! Tou fazendo um for dentro do outro. Isso zoa MUITO a performance do jogo.
	public void voltaProFimSeSairDaTela() {
		for (Pipe pipe : pipes) {
			if(pipe.getPosicaoAtual() < 0 - pipe.getLargura()) {
				for (Pipe p : pipes) {
					if(p.getPosicaoAtual() > maximo) {
						maximo = p.getPosicaoAtual();
					}
				}
				pipe.setX(maximo + DISTANCIA_ENTRE_PIPES);
			}
		}
	}
}
