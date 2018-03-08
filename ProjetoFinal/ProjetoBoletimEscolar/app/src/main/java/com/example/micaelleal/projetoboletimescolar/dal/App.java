package com.example.micaelleal.projetoboletimescolar.dal;

import android.app.Application;
import android.util.Log;

import com.example.micaelleal.projetoboletimescolar.BuildConfig;
import com.example.micaelleal.projetoboletimescolar.model.MyObjectBox;

import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;

/**
 * Created by micaelleal on 18/02/18.
 */

public class App extends Application {

    public static final String TAG = "ObjectBoxExample";
    public static final boolean EXTERNAL_DIR = false;

    BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();

        boxStore = MyObjectBox.builder().androidContext(App.this).build();

        if (BuildConfig.DEBUG) {
            new AndroidObjectBrowser(boxStore).start(this);
        }

        Log.d("App", "Using ObjectBox "+ BoxStore.getVersion() +" ("+ BoxStore.getVersionNative() +")");
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}
