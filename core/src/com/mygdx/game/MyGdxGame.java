package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Sprite s;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Hex-Tile.png");
		s = new Sprite(img);
		s.setScale(0.1f);
		s.setPosition(1,1);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(29/255f, 85/255f,173/255f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		s.draw(batch);
		//batch.draw(img, 0, 0);
		//batch.draw(img, img.getWidth(),0);
		//batch.draw(img, img.getWidth()/2f,(img.getHeight()*3)/4f);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
