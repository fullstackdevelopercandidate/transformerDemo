package com.aequilibrium.transformertest.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Transformers {

    @SerializedName("transformers")
    private List<TransfomerEntity> transformers = new ArrayList();

    public List<TransfomerEntity> getTransformers() {
        return transformers;
    }

    public void setTransformers(List<TransfomerEntity> transformers) {
        this.transformers = transformers;
    }
}
