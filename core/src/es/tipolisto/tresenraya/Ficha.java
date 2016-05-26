package es.tipolisto.tresenraya;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import java.util.Comparator;

public class Ficha extends Actor implements Comparable<Ficha> {
    private Texture textureRojo0 ,textureRojo1,bola_grande_tres_en_raya;
    //La ficha tiene una posición x e y
    private float x;
    private float y;
    private int colorFicha;
    private  String nombreFicha;
   // private int numeroColision;
    private boolean asignada;
    private int fila;
    private int columna;
    private boolean activarFichaEnTresEnRaya;
    private int contadorFicha;

    public int getContadorFicha() {
        return contadorFicha;
    }

    public void setContadorFicha(int contadorFicha) {
        this.contadorFicha = contadorFicha;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isActivarFichaEnTresEnRaya() {
        return activarFichaEnTresEnRaya;
    }

    public void setActivarFichaEnTresEnRaya(boolean activarFichaEnTresEnRaya) {
        this.activarFichaEnTresEnRaya = activarFichaEnTresEnRaya;
    }

    // private int numeroDeBola;
    public Ficha(int numeroColor, float x, float y){
        this.x=x;
        this.y=y;
        this.asignada=false;
        this.activarFichaEnTresEnRaya=false;
        this.contadorFicha=0;
        //this.numeroColision=0;

        this.setSize(160,160);
        //this.numeroDeBola=0;
       // textureRojo1 = new Texture(Gdx.files.internal("bola_grande1.png"));
        bola_grande_tres_en_raya=new Texture(Gdx.files.internal(("bola_grande_tres_en_raya.png")));
        if(numeroColor==1) {
            textureRojo0 = new Texture(Gdx.files.internal("bola_grande0.png"));
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
        if(activarFichaEnTresEnRaya)
           batch.draw(bola_grande_tres_en_raya,x,y,getWidth(),getHeight());
        else {
            if (asignada)
                batch.draw(textureRojo0, x, y, getWidth(), getHeight());
        }
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

//    public int getNumeroColision() {
//        return numeroColision;
//    }

//    public void setNumeroColision(int numeroColision) {
//        this.numeroColision = numeroColision;
//    }
    public boolean isAsignada() {
        return asignada;
    }

    public void setAsignada(boolean asignada) {
        this.asignada = asignada;
    }

    @Override
    public int compareTo(Ficha ficha) {
        return this.fila-ficha.getFila();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ficha ficha = (Ficha) o;

        if (fila != ficha.fila) return false;
        if (columna != ficha.columna) return false;
        return contadorFicha == ficha.contadorFicha;

    }

    @Override
    public int hashCode() {
        int result = fila;
        result = 31 * result + columna;
        result = 31 * result + contadorFicha;
        return result;
    }

//    public int getNumeroDeBola() {
//        return numeroDeBola;
//    }

//    public void setNumeroDeBola(int numeroDeBola) {
//        this.numeroDeBola = numeroDeBola;
//    }
}
