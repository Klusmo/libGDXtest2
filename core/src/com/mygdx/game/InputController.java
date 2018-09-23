package com.mygdx.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

public class InputController implements InputProcessor {
    private float zoom =1;
    private Vector2 point = new Vector2();
    private Vector2 dPoint = new Vector2();
    private Vector2 selected = new Vector2();

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
        point.x = screenX;
        point.y = screenY;
        System.out.println(point);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        selected.x = screenX;
        selected.y = screenY;
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        dPoint.x= point.x - screenX;
        dPoint.y= point.y - screenY;
        System.out.println("drag: " + dPoint);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        if(amount==1 && zoom<1){
            zoom+=0.05f;
        }else if(amount==-1 && zoom>0.1f){
            zoom-=0.05f;
        }
        return false;
    }

    float getZoom() {
        return zoom;
    }

    public Vector2 getdPoint() {
        return dPoint;
    }

    public Vector2 getSelected() {
        return selected;
    }
}
