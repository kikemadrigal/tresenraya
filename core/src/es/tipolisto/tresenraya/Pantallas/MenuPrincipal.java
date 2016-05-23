package es.tipolisto.tresenraya.Pantallas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;


import es.tipolisto.tresenraya.Assets;
import es.tipolisto.tresenraya.Juego;


public class MenuPrincipal extends PantallaAbstracta {
    private SpriteBatch spriteBatch;
    private Stage stage;
    private Image imageJugar;
    public MenuPrincipal(Juego juego) {
        super(juego);
    }

    @Override
    public void show() {
        stage=new Stage();
        /*****************Implemento el botón jugar******************/
        Texture jugar=new Texture(Gdx.files.internal("ui/jugar.png"));
        imageJugar=new Image(jugar);
        imageJugar.setPosition(50, Gdx.graphics.getHeight() / 2);
        imageJugar.setSize(380,80);
        stage.addActor(imageJugar);
        /****************Fin de impleentar el botón jugar*************/


        stage.addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Vamos al primer nivel");
                juego.verPantalla(2);
                return true;
            }
        });

        Gdx.input.setInputProcessor(stage);


    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(delta);
        stage.draw();
    }
}
