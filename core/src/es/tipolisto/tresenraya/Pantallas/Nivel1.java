package es.tipolisto.tresenraya.Pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;


import es.tipolisto.tresenraya.Juego;
import es.tipolisto.tresenraya.Tablero;


public class Nivel1 extends PantallaAbstracta {
    private Stage stage;
    private Tablero tablero;
    public String texto;

    public Nivel1(Juego juego) {
        super(juego);
    }

    @Override
    public void show() {

        stage=new Stage();
        tablero=new Tablero(this);
        tablero.setSize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.addActor(tablero);

        texto="Sin mensaje";
        /**********Controles de teclado**********/
        Gdx.input.setInputProcessor(stage);
        stage.addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                //System.out.println("Has pulsado la tecla: " + keycode);
                texto = "Has pulsado la tecla: " + keycode;
                switch (keycode) {
                    case 61:
                        juego.verPantalla(1);
                        break;
                }
                return true;
            }

            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
               // System.out.println("Has pulsado el ratón, posición x " + x + ", y: " + y);
                texto = "Has pulsado el ratón, posición x " + x + ", y: " + y;
                return true;
            }

        });
        /*******Fin de controles de teclado*********/

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       // Gdx.gl.glClearColor(0,0,0.8f,1);
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }
}
