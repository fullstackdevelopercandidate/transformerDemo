package com.aequilibrium.transformertest.common;


import android.content.Context;

import com.aequilibrium.transformertest.R;
import com.aequilibrium.transformertest.databinding.ActivityItemsBinding;
import com.aequilibrium.transformertest.model.TransfomerEntity;

public class TransformerAdapter extends BaseBindingAdapter<TransfomerEntity, ActivityItemsBinding>
{
    public TransformerAdapter(Context context)
    {
        super(context);
    }

    @Override
    protected int getLayoutResId(int viewType)
    {
        return R.layout.activity_items;
    }

    @Override
    protected void onBindItem(ActivityItemsBinding binding, TransfomerEntity entity)
    {
        binding.setEntity(entity);
        binding.executePendingBindings();
    }
}