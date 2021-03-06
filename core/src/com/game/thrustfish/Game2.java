package com.game.thrustfish;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Game2 extends ApplicationAdapter {
	public static final String TITLE = "THRUST FISH";
    public static final int V_WIDTH = 320;
    public static final int V_HEIGHT = 240;
    public static final int SCALE = 2;

    SpriteBatch batch;
	Texture img;
    //FPSLogger fpsLogger ;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
      //  fpsLogger = new FPSLogger();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		//batch.draw(img, 0, 0);
        //fpsLogger.log();
        updateScene();
        drawScene();
		batch.end();
	}

    public void updateScene(){

    };

    public void drawScene(){

    };
}

