package es.tipolisto.tresenraya;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

import es.tipolisto.tresenraya.Pantallas.MenuPrincipal;
import es.tipolisto.tresenraya.Pantallas.Nivel1;
import es.tipolisto.tresenraya.Pantallas.PantallaAbstracta;

public class Juego extends Game {
	public AssetManager assetManager;
    //Para almacenar las pantallas:
    private Map<Integer, PantallaAbstracta> hasMapPantalla;

	@Override
	public void create () {
		assetManager=Assets.getAssetManager();
        assetManager.load("jugar.png", Texture.class);
        hasMapPantalla=new HashMap<Integer, PantallaAbstracta>();
        hasMapPantalla.put(1, new MenuPrincipal(this));
        hasMapPantalla.put(2, new Nivel1(this));
        verPantalla(1);
	}
    public void verPantalla(int id){
       this.setScreen(hasMapPantalla.get(id));
    }

}
