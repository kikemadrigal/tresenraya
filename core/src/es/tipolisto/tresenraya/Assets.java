package es.tipolisto.tresenraya;

import com.badlogic.gdx.assets.AssetManager;


public class Assets {
    private static AssetManager assetManager;
    public static AssetManager getAssetManager(){
        if(assetManager==null)
            assetManager=new AssetManager();
        return assetManager;
    }
}
