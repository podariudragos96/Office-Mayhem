package com.podariudragos.officemayhem;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.EdgeShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Dragos Podariu on 2/9/2016.
 */
public class Player extends Sprite {
    public World world;
    public Body b2body;

    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;
    private Texture texture;


    private TextureRegion playerStand;

    public Player (PlayScreen screen){
        this.world = screen.getWorld();

        playerStand = new TextureRegion(screen.getAtlas().findRegion("book"),0, 0, 60, 60);

        definePlayer();

        setBounds(0,0, 60, 60);
        setRegion(playerStand);
    }

    public void update(float dt){
            setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2 - 6 );
        setRegion(playerStand);
    }

    public void definePlayer(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(32 , 32);
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(6 );
        fdef.filter.categoryBits = OfficeMayhem.PLAYER_BIT;
        fdef.filter.maskBits =
                OfficeMayhem.GROUND_BIT |
                OfficeMayhem.ENEMY_BIT;


        fdef.shape = shape;
        b2body.createFixture(fdef).setUserData(this);

        fdef.isSensor = true;
        b2body.createFixture(fdef).setUserData(this);
    }
}
