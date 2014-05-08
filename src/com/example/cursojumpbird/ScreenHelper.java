package br.com.alura.passarinhoquercantar?

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class ScreenHelper {

	private final DisplayMetrics resolucao = new DisplayMetrics();;

	public ScreenHelper(Context context) {
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		display.getMetrics(resolucao);
	}
	
	public int getHeight() {
		return resolucao.heightPixels;
	}

	public int getWidth() {
		return resolucao.widthPixels;
	}

}
