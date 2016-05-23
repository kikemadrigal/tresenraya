package es.tipolisto.tresenraya;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import java.util.ArrayList;


import es.tipolisto.tresenraya.Pantallas.FondoNivel1;
import es.tipolisto.tresenraya.Pantallas.Nivel1;


public class Tablero extends Group {
    private Texture texture;
    private Nivel1 nivel1;
    private int numeroDeBola;
    private ArrayList<Ficha> fichas;
    Ficha ficha;
    public Tablero(Nivel1 screen){
        this.nivel1=screen;
        texture= new Texture(Gdx.files.internal("fondotablero.png"));
        this.numeroDeBola=0;
        FondoNivel1 fondoNivel1=new FondoNivel1(this);
        addActor(fondoNivel1);

        System.out.println("Dentro del tablero");
        fichas=new ArrayList<Ficha>();
        crearPulsacionesTecladoYRaton();

    }



    private void crearPulsacionesTecladoYRaton(){
       addListener(new InputListener() {
           @Override
           public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               Ficha ficha = new Ficha(1, x, y);
               System.out.println("ficha añadida: " + ficha.getX() + ", " + ficha.getY());
               ficha.setAsignada(true);
               numeroDeBola++;
               ficha.setNumeroDeBola(numeroDeBola);
               addActor(ficha);
               fichas.add(ficha);
               ajustarFichasEnTablero();
               verLasFichas(fichas);
               comprobarColisiones();
               return true;
           }
       });
   }


    private void verLasFichas(ArrayList<Ficha> fichas){
        if(fichas.isEmpty()){
            System.out.print("El tablero está vacío.");
        }else{
            for(Ficha ficha: fichas){
                float ancho=ficha.getWidth();
                float alto=ficha.getHeight();
                System.out.println(ficha.getNombreFicha()+", "+ficha.getX()+", "+ficha.getY()+", ancho: "+ancho+", alto: "+alto);

            }
        }
    }



    public void ajustarFichasEnTablero(){
        for(Ficha ficha: fichas) {
            for (int i = 0; i < fichas.size(); i++) {
                //Fila 1, columna 1
                if (ficha.getY()>0 && ficha.getY() < 150 && ficha.getX() > 0 && ficha.getX() < 150) {
                    ficha.cambiarPosicion(0,0);
                }
                //Fila 1, columna 2
                if (ficha.getY()>0 && ficha.getY()<150 && ficha.getX() > 150 && ficha.getX() < 300) {
                    ficha.cambiarPosicion(140,0);
                }
                //Fila 1, columna 3
                if (ficha.getY()>0 && ficha.getY()<150 && ficha.getX() > 300 && ficha.getX() < 500) {
                    ficha.cambiarPosicion(300,0);
                }


                //Fila 2, columna 1
                if (ficha.getY()>150 && ficha.getY()<300 && ficha.getX() > 0 && ficha.getX() < 150) {
                    ficha.cambiarPosicion(0,140);
                }
                //Fila 2, columna 2
                if (ficha.getY()>150 && ficha.getY()<300 && ficha.getX() > 150 && ficha.getX() < 300) {
                    ficha.cambiarPosicion(140,140);
                }
                //Fila 2,columna 3
                if (ficha.getY()>150 && ficha.getY()<300 && ficha.getX() > 300 && ficha.getX() < 500) {
                    ficha.cambiarPosicion(300,140);
                }



                //Fila 3, columna 1
                if (ficha.getY()>300 && ficha.getY()<500 && ficha.getX() > 0 && ficha.getX() < 150) {
                    ficha.cambiarPosicion(0,300);
                }
                //Fila 3, columna 2
                if (ficha.getY()>300 && ficha.getY()<500 && ficha.getX() > 150 && ficha.getX() < 300) {
                    ficha.cambiarPosicion(140,300);
                }
                //Fila 3,columna 3
                if (ficha.getY()>300 && ficha.getY()<500 && ficha.getX() > 300 && ficha.getX() < 500) {
                    ficha.cambiarPosicion(300,300);
                }


            }
        }
    }







    private boolean hayColision(Ficha a, Ficha b){
        boolean hit=false;
        //Colisiones horizontales
        if(b.getX()+b.getWidth()>=a.getX() && b.getX()<a.getX()+a.getWidth()){
            //Colisiones verticales
            if(b.getY()+b.getHeight()>=a.getY() && b.getY() <  a.getY()+a.getHeight()){
                hit=true;
            }
        }
        //Colision de a con b
        if(b.getX()<=a.getX() && b.getX()+b.getWidth()>=a.getX()+a.getWidth()){
            //Colisiones verticales
            if(b.getY()<=a.getY()&&b.getY()+b.getHeight()>=a.getY()+a.getHeight()){
                hit=true;
            }
        }
        //Colision de b con a
        if(a.getY()<=b.getX() && a.getX() +a.getWidth() >=b.getX()+b.getWidth()){
            if(a.getY()<=b.getY()&&a.getY()+a.getHeight()>=b.getY()+b.getHeight()){
                hit =true;
            }
        }
        return hit;
    }




    private boolean hayColision2(Ficha a, Ficha b){
        boolean retorno=false;
        if(b.getX()+b.getWidth()>=a.getX() && b.getX()<a.getX()+a.getWidth()){

            retorno=true;
        }
        if(b.getX()<=a.getX() && b.getX()+b.getWidth()>=a.getX()+a.getWidth()){
            //Colisiones verticales
            if(b.getY()<=a.getY()&&b.getY()+b.getHeight()>=a.getY()+a.getHeight()){
               retorno=true;
            }
        }
        if(a.getY()<=b.getX() && a.getX() +a.getWidth() >=b.getX()+b.getWidth()){
            if(a.getY()<=b.getY()&&a.getY()+a.getHeight()>=b.getY()+b.getHeight()){
               retorno =true;
            }
        }
        return retorno;
    }



    private void comprobarColisiones(){
        if(fichas.size()>=1) {
            for (int i = 1; i < fichas.size(); i++) {
                try{
                    Ficha a = fichas.get(i);
                    Ficha b = fichas.get(i -1);

                    if (hayColision2(a, b) ){
                        //a.setNumeroColision(a.getNumeroColision()+1);
                        a.setNumeroColision(b.getNumeroColision()+1);
                        System.out.println("b esta encima de a, bola a numero: "+a.getNumeroDeBola()+", colision a: " + a.getNumeroColision() + ", bola b numero: "+b.getNumeroDeBola()+", colsision b: " + b.getNumeroColision());
                    }
                }catch (IndexOutOfBoundsException ex){
                    System.out.println("No ha funcionado: tamaño fichas: " + fichas.size());
                }

            }
        }
    }
}
