package com.example.cursojumpbird;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends Activity {

	private Game game;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		FrameLayout container = (FrameLayout) findViewById(R.id.container);

		game = new Game(this);
		game.setKeepScreenOn(true);
		
		container.addView(game);
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		game.stopThread();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		game.resume();
		new Thread(game).start();
	}
}
