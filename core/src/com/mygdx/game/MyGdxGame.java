package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private Sprite s[] = new Sprite[10];
	private InputController controls ;

	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("GHexTile.png" );
		controls = new InputController();
		Gdx.input.setInputProcessor(controls);

        for (int i = 0; i < 10; i++) {
			s[i] = new Sprite(img);
        }
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(29/255f, 85/255f,173/255f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.graphics.setTitle("FPS: " + Gdx.graphics.getFramesPerSecond());

		for (int i = 0; i < 10; i++) {
			float scale = controls.getZoom();
			Vector2 drag = controls.getdPoint();
            s[i].setScale(scale);
			//s[i].setPosition((s[i].getX()*scale)-drag.x, (s[i].getY()*scale)-drag.y);

			if(i<5)
				s[i].setPosition(0-drag.x ,i*s[0].getHeight()*scale + drag.y);
			else
				s[i].setPosition((s[0].getWidth()*3/4f)*scale -drag.x,((i-5)*s[0].getHeight()+s[0].getHeight()/2)*scale +drag.y);
		}


		batch.begin();
		for (int i = 0; i < 10; i++)
			s[i].draw(batch);
		//batch.draw(img, 0, 0);
		//batch.draw(img, img.getWidth()*3/2f,0);
		//batch.draw(img, img.getWidth()3/2f,(img.getHeight()*3)/4f);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
