package es.tipolisto.tresenraya.Pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

import es.tipolisto.tresenraya.Tablero;


public class FondoNivel1 extends Actor {
    private Texture texture;
    private Tablero tablero;

    public FondoNivel1(Tablero tablero) {
        this.tablero = tablero;
        texture = new Texture(Gdx.files.internal("fondotablero.png"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(texture,0,0,tablero.getWidth(),tablero.getHeight());
    }
}
