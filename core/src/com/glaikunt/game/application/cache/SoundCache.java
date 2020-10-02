package com.glaikunt.game.application.cache;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;

import java.util.HashMap;
import java.util.Map;

public class SoundCache implements Cache {

    private Map<String, Sound> sounds = new HashMap<>();
    private boolean loaded = false;

    @Override
    public void loadCache(AssetManager assetManager) {

    }

    @Override
    public boolean isLoaded(AssetManager assetManager) {
        if (sounds.isEmpty()) return false;

        for (String key : sounds.keySet()) {
            if (!assetManager.isLoaded(key)) {
                return false;
            }
        }

        if (!isLoaded()) {
            for (String key : sounds.keySet()) {
                getSounds().put(key, (Sound) assetManager.get(key));
            }
            setLoaded(true);
        }

        return true;
    }

    public void setLoaded(boolean loaded) {
        this.loaded = loaded;
    }

    public boolean isLoaded() {
        return loaded;
    }

    public Map<String, Sound> getSounds() {
        return sounds;
    }
}
