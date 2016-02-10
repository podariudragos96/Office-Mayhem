package com.podariudragos.officemayhem;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class OfficeMayhem extends Game {
	public static final int WIDTH = 480;
	public static final int HEIGHT = 800;
    public static final float PPM = 100;

    public static final short GROUND_BIT = 1;
    public static final short PLAYER_BIT = 2;
    public static final short ENEMY_BIT = 4;
    public static final short POWER_BIT = 8;

	public SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
        setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
    @Override
    public void dispose(){
        super.dispose();
        batch.dispose();
    }
}
