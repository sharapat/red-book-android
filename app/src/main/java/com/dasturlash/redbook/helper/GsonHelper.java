package com.dasturlash.redbook.helper;

import android.content.Context;

import com.dasturlash.redbook.models.AnimalDbModel;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

/**
 * Created by QAREKEN on 05.03.18.
 */

public class GsonHelper {

    private final Context context;
    private final String fileName;

    public GsonHelper(Context context, String fileName) {
        this.context = context;
        this.fileName = fileName;
    }

    private String loadJsonFromAsset() {
        String json;
        try {
            InputStream is = context.getAssets().open(fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public List<AnimalDbModel> getListFromLocalAssets() {
        String json = loadJsonFromAsset();
        if (json == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<AnimalDbModel>>() { }.getType();
        return new GsonBuilder().create().fromJson(json, listType);
    }
}
