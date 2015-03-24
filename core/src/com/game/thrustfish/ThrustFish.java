package com.game.thrustfish;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

/**
 * Created by Darshi on 3/23/2015.
 */
public class ThrustFish extends Game {
    private static final String TAG = "ThrustFish";

    SpriteBatch batch;
    Texture img;
    float touchX, touchY, imgX = 0f, imgY = 0f;
    boolean touchUp = true;


    InputProcessor inputProcessor;
    OrthographicCamera camera;

    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        setupInputListener();
        //  fpsLogger = new FPSLogger();
        img = new Texture("mario1.png");
        Gdx.input.setInputProcessor(inputProcessor);
    }


    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if (!touchUp) {
            if (imgX > touchX) imgX -= 10;
            if (imgX < touchX) imgX += 10;
            if (imgY > touchY) imgY -= 10;
            if (imgY < touchY) imgY += 10;
            Gdx.app.log("TAG", "moved to " + imgX + "," + imgY + " touched at " + touchX + "," + touchY);
        }
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.draw(img, imgX, imgY);
        //fpsLogger.log();
//        updateScene();
//        drawScene();
        batch.end();
    }


    private void setupInputListener() {
        inputProcessor = new InputProcessor() {
            @Override
            public boolean keyDown(int keycode) {
                return false;
            }

            @Override
            public boolean keyUp(int keycode) {
                return false;
            }

            @Override
            public boolean keyTyped(char character) {
                return false;
            }

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                touchUp = false;
                touchX = screenX;
                touchY = Gdx.graphics.getHeight() - screenY;
                Gdx.app.log("InputProcessor", " touched at " + touchX + "," + touchY);
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                touchUp = true;
                return true;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                return false;
            }

            @Override
            public boolean scrolled(int amount) {
                return false;
            }

        };
    }
}
