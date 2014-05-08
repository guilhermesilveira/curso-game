package com.example.cursojumpbird;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Pipe {
	
	private final static Paint roxo = Cores.roxo();
	private ... ScreenHelper dimensoes;
	private ... int tamanho = 250;
	private int altura = 100;
	private int posicao;

	public Pipe(ScreenHelper helper, int posicaoInicial) {
		this.helper = helper;
		this.posicaoInicial = posicaoInicial;
	}
	
	public void drawOn(Canvas canvas) {
		canvas.drawRect(posicaoInicial, 0, posicaoInicial + larguraDoPipe, tamanhoDoPipe, roxo);
		canvas.drawRect(posicaoInicial, helper.getHeight() - tamanhoDoPipe , posicaoInicial + larguraDoPipe, helper.getHeight(), roxo);
	}
	
	public void move() {
		posicaoInicial -= 5;
	}

	public int getPosicaoAtual() {
		return posicaoInicial;
	}

	public void setX(int posicao) {
		posicaoInicial = posicao;
	}

	public int getLargura() {
		return larguraDoPipe;
	}

}
