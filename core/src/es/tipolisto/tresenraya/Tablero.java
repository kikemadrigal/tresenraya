package es.tipolisto.tresenraya;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;


import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;


import es.tipolisto.tresenraya.Pantallas.FondoNivel1;
import es.tipolisto.tresenraya.Pantallas.Nivel1;


public class Tablero extends Group {
    private Texture texture;
    private Nivel1 nivel1;
    //private int numeroDeBola;
    private ArrayList<Ficha> fichas;
    private int[][] arrayFichas;
    Ficha ficha;
    public Tablero(Nivel1 screen){
        this.nivel1=screen;
        texture= new Texture(Gdx.files.internal("fondotablero.png"));
        //this.numeroDeBola=0;
        FondoNivel1 fondoNivel1=new FondoNivel1(this);
        addActor(fondoNivel1);

        System.out.println("Dentro del tablero");
        fichas=new ArrayList<Ficha>(9);
        //Rellenar con 0 el array
        arrayFichas=new int[3][3];

        crearPulsacionesTecladoYRaton();
        dibujarFichasEnTablero(arrayFichas);

    }



    int contadorDeFichas=0;
    private void crearPulsacionesTecladoYRaton(){
       addListener(new InputListener() {
           @Override
           public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               Ficha ficha = new Ficha(1, x, y);
               contadorDeFichas++;
               System.out.println("ficha añadida: x:" + ficha.getX() + ", y:" + ficha.getY()+", llevamos: "+fichas.size()+" fichas");

               //numeroDeBola++;
              //setAsgnada lo he puesto porque en el draw solo dibuja las fichas asgnadas
               ficha.setAsignada(true);
               ficha.setContadorFicha(contadorDeFichas);
               addActor(ficha);

               fichas.add(ficha);
               ajustarFichasEnTablero(ficha);
               dibujarFichasEnTableroArrayList();
               comprobarGanador();
              // verLasFichas(fichas);
              // comprobarColisiones(ficha);
               return true;
           }
       });
    }

    public void dibujarFichasEnTablero(int[][] fichas){
        for(int y=0;y<fichas.length;y++){
            for(int x=0;x<fichas[y].length;x++) {
                System.out.print(fichas[y][x]);
            }
            System.out.println(" ");
        }
    }
    int contadorDePOsicionFicha=0;
    public void dibujarFichasEnTableroArrayList(){
        contadorDePOsicionFicha=0;
       for(Ficha ficha: fichas){
           System.out.println("Ficha: "+ficha.getContadorFicha()+", fila" + ficha.getFila() + ", columna: " + ficha.getColumna());
       }
    }
    public void asignarBolaEnTresEnRaya(int fila, int columna){

       for(Ficha fichaDeFilaYComuna: fichas){
            if(fichaDeFilaYComuna.getFila()==fila && fichaDeFilaYComuna.getColumna()==columna){
                fichaDeFilaYComuna.setActivarFichaEnTresEnRaya(true);
            }


       }

    }


    public void comprobarGanador(){
       // int numeroDeFila=0;
       // int sumaColumnas=0;
        //for(int y=0;y<arrayFichas.length;y++){

           // for(int x=0;x<arrayFichas[y].length;x++) {

                //ver si las comunnas suman tres
               // sumaColumnas=sumaColumnas+arrayFichas[y][x];
                if(arrayFichas[0][0]==1&& arrayFichas[0][1]==1 && arrayFichas[0][2]==1){
                    System.out.println("la fila: 3 tiene 3 en raya");
                    asignarBolaEnTresEnRaya(0,0);
                    asignarBolaEnTresEnRaya(0,1);
                    asignarBolaEnTresEnRaya(0,2);
                }
                if(arrayFichas[1][0]==1&& arrayFichas[1][1]==1 && arrayFichas[1][2]==1){
                    System.out.println("la fila: 2 tiene 3 en raya");
                    asignarBolaEnTresEnRaya(1,0);
                    asignarBolaEnTresEnRaya(1,1);
                    asignarBolaEnTresEnRaya(1, 2);

                }
                if(arrayFichas[2][0]==1&& arrayFichas[2][1]==1 && arrayFichas[2][2]==1) {
                    System.out.println("la fila: 1 tiene 3 en raya");
                    asignarBolaEnTresEnRaya(2,0);
                    asignarBolaEnTresEnRaya(2,1);
                    asignarBolaEnTresEnRaya(2,2);

                }
                if( arrayFichas[2][0]==1&& arrayFichas[1][1]==1 && arrayFichas[0][2]==1){
                    System.out.println("3 en raya diagonal de arriba izquierda a abajo derecha");
                    asignarBolaEnTresEnRaya(2,0);
                    asignarBolaEnTresEnRaya(1,1);
                    asignarBolaEnTresEnRaya(0, 2);

                }
                if( arrayFichas[2][2]==1&& arrayFichas[1][1]==1 && arrayFichas[0][0]==1){
                    System.out.println("3 en raya diagonal de arriba derecha a abajo izquierda");
                    asignarBolaEnTresEnRaya(2,2);
                    asignarBolaEnTresEnRaya(1,1);
                    asignarBolaEnTresEnRaya(0,0);
                }


                //ver si las filas suman 3

            //}
           // System.out.println(" ");
        //}
    }


    public void ajustarFichasEnTablero(Ficha ficha){

        //for(Ficha ficha: fichas) {
           // for (int i = 0; i < fichas.size(); i++) {
                //Fila 1, columna 1
                if (ficha.getY()>0 && ficha.getY() <= 150 && ficha.getX() > 0 && ficha.getX() < 150) {
                    arrayFichas[0][0]=1;
                    ficha.setFila(0);
                    ficha.setColumna(0);
                    ficha.cambiarPosicion(0,0);
                }
                //Fila 1, columna 2
                else if (ficha.getY()>0 && ficha.getY()<=150 && ficha.getX() > 150 && ficha.getX() < 300) {
                    arrayFichas[0][1]=1;
                    ficha.setFila(0);
                    ficha.setColumna(1);
                    ficha.cambiarPosicion(140,0);
                }
                //Fila 1, columna 3
                else if (ficha.getY()>0 && ficha.getY()<=150 && ficha.getX() > 300 && ficha.getX() < 500) {
                    arrayFichas[0][2]=1;
                    ficha.setFila(0);
                    ficha.setColumna(2);
                    ficha.cambiarPosicion(300,0);
                }


                //Fila 2, columna 1
                else if (ficha.getY()>150 && ficha.getY()<=300 && ficha.getX() > 0 && ficha.getX() < 150) {
                    arrayFichas[1][0]=1;
                    ficha.setFila(1);
                    ficha.setColumna(0);
                    ficha.cambiarPosicion(0,140);
                }
                //Fila 2, columna 2
                else if (ficha.getY()>150 && ficha.getY()<=300 && ficha.getX() > 150 && ficha.getX() < 300) {
                    arrayFichas[1][1]=1;
                    ficha.setFila(1);
                    ficha.setColumna(1);
                    ficha.cambiarPosicion(140,140);
                }
                //Fila 2,columna 3
                else  if (ficha.getY()>150 && ficha.getY()<=300 && ficha.getX() > 300 && ficha.getX() < 500) {
                    arrayFichas[1][2]=1;
                    ficha.setFila(1);
                    ficha.setColumna(2);
                    ficha.cambiarPosicion(300,140);
                }


                //Fila 3, columna 1
                if (ficha.getY()>300 && ficha.getY()<500 && ficha.getX() > 0 && ficha.getX() < 150) {
                    arrayFichas[2][0]=1;
                    ficha.setFila(2);
                    ficha.setColumna(0);
                    ficha.cambiarPosicion(0,300);
                }
                //Fila 3, columna 2
                if (ficha.getY()>300 && ficha.getY()<500 && ficha.getX() > 150 && ficha.getX() < 300) {
                    arrayFichas[2][1]=1;
                    ficha.setFila(2);
                    ficha.setColumna(1);
                    ficha.cambiarPosicion(140,300);
                }
                //Fila 3,columna 3
                if (ficha.getY()>300 && ficha.getY()<500 && ficha.getX() > 300 && ficha.getX() < 500) {
                    arrayFichas[2][2]=1;
                    ficha.setFila(2);
                    ficha.setColumna(2);
                    ficha.cambiarPosicion(300,300);
                }
        Collections.sort(fichas);

        //  }
      //  }
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





    /*private boolean hayColision(Ficha a, Ficha b){
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
            //System.out.println("b esta encima de a, bola a numero: "+a.getNumeroDeBola()+", colision a: " + b.getNumeroColision() + ", a X.: "+a.getX()+", b X: " +b.getX());
            retorno=true;
        }
        if(b.getX()<=a.getX() && b.getX()+b.getWidth()>=a.getX()+a.getWidth()){
            //Colisiones verticales
            if(b.getY()<=a.getY()&&b.getY()+b.getHeight()>=a.getY()+a.getHeight()){
                //System.out.println("el eje y de b está encima del de a, bola a numero: "+a.getNumeroDeBola()+", colision a: " + b.getNumeroColision() + ", a X.: "+a.getX()+", b X: " +b.getX());

                retorno=true;
            }
        }
        if(a.getY()<=b.getX() && a.getX() +a.getWidth() >=b.getX()+b.getWidth()){
            if(a.getY()<=b.getY()&&a.getY()+a.getHeight()>=b.getY()+b.getHeight()){
                //System.out.println("a esta encima de b, bola a numero: "+a.getNumeroDeBola()+", colision a: " + b.getNumeroColision() + ", a X.: "+a.getX()+", b X: " +b.getX());
                retorno =true;
            }
        }
       // if(retorno)
           // a.setNumeroColision(a.getNumeroColision() + 1);
        return retorno;
    }



    private void comprobarColisiones(Ficha ficha){
        if(fichas.size()>=1) {
            for (int i = 0; i < fichas.size()-1; i++) {
                try{
                    Ficha a = fichas.get(i);
                   // Ficha b = fichas.get(i);

                    if (hayColision2(ficha, a) ){
                        //a.setNumeroColision(a.getNumeroColision()+1);

                }
                }catch (IndexOutOfBoundsException ex){
                    System.out.println("No ha funcionado: tamaño fichas: " + fichas.size());
                }

            }
        }
    }*/
}
