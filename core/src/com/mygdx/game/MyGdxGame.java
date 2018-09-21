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
	Sprite s[] = new Sprite[10];
	final float scale = 0.2f;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("Hex-Tile.png");
		for (int i = 0; i < 10; i++) {
			s[i] = new Sprite(img);
			s[i].setScale(scale);
			if(i<5)
				s[i].setPosition(i*s[0].getWidth()*scale, 0);
			else
				s[i].setPosition((i-5)*s[0].getWidth()*scale +s[0].getWidth()*scale/2, s[0].getHeight()*scale*3/4);
		}
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(29/255f, 85/255f,173/255f,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		for (int i = 0; i < 10; i++)
			s[i].draw(batch);
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
