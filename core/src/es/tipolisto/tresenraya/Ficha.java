package es.tipolisto.tresenraya;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class Ficha extends Actor {
    private Texture textureRojo1, textureRojo2,textureRojo3;
    //La ficha tiene una posición x e y
    private float x;
    private float y;
    private int colorFicha;
    private  String nombreFicha;
    private int numeroColision;
    private boolean asignada;
    private int numeroDeBola;
    public Ficha(int numeroColor, float x, float y){
        this.x=x;
        this.y=y;
        this.numeroColision=0;
        this.asignada=false;
        this.setSize(160,160);
        this.numeroDeBola=0;

        if(numeroColor==1) {
            textureRojo1 = new Texture(Gdx.files.internal("bola_grande1.png"));
            textureRojo2 = new Texture(Gdx.files.internal("bola_grande2.png"));
            textureRojo3 = new Texture(Gdx.files.internal("bola_grande3.png"));
            colorFicha=1;
        }
        if(numeroColor==2) {
            textureRojo1 = new Texture(Gdx.files.internal("fichaverde.png"));
            colorFicha=2;
        }

        nombreFicha="ninguno";
        switch (colorFicha){
            case 1:
                nombreFicha="roja";
                break;
            case 2:
                nombreFicha="verde";
        }
        addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("has hecho click en la bola: "+ nombreFicha);
                return true;
            }
        });
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(numeroColision==0)
            batch.draw(textureRojo1, x, y, getWidth(), getHeight());
        if(numeroColision==1)
            batch.draw(textureRojo2, x, y, getWidth(), getHeight());
        if(numeroColision==2)
            batch.draw(textureRojo3, x, y, getWidth(), getHeight());
    }

    public void cambiarPosicion(float x, float y){
        this.x=x;
        this.y=y;
    }

    public String getNombreFicha(){
        return this.nombreFicha;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void setX(float x) {
        this.x = x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public void setY(float y) {
        this.y = y;
    }

    public int getNumeroColision() {
        return numeroColision;
    }

    public void setNumeroColision(int numeroColision) {
        this.numeroColision = numeroColision;
    }

    public boolean isAsignada() {
        return asignada;
    }

    public void setAsignada(boolean asignada) {
        this.asignada = asignada;
    }


    public int getNumeroDeBola() {
        return numeroDeBola;
    }

    public void setNumeroDeBola(int numeroDeBola) {
        this.numeroDeBola = numeroDeBola;
    }
}
