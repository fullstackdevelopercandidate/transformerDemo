package com.aequilibrium.transformertest.common;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.databinding.ObservableArrayList;
import androidx.recyclerview.widget.RecyclerView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import java.util.List;

public abstract class BaseBindingAdapter<M, B extends ViewDataBinding> extends RecyclerView.Adapter
{
    protected Context context;
    protected ObservableArrayList<M> items;
    protected ListChangedCallback itemsChangeCallback;
    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    private OnItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }


    public BaseBindingAdapter(Context context)
    {
        this.context = context;
        this.items = new ObservableArrayList<>();
        this.itemsChangeCallback = new ListChangedCallback();
    }

    public ObservableArrayList<M> getItems()
    {
        return items;
    }

    @Override
    public int getItemCount()
    {
        return this.items.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        B binding = DataBindingUtil.inflate(LayoutInflater.from(this.context), this.getLayoutResId(viewType), parent, false);
        return new BaseBindingViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position)
    {
        B binding = DataBindingUtil.getBinding(holder.itemView);
        this.onBindItem(binding, this.items.get(position));
        if(mOnItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView,position); // 2
                }
            });
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView)
    {
        super.onAttachedToRecyclerView(recyclerView);
        this.items.addOnListChangedCallback(itemsChangeCallback);
    }

    @Override
    public void onDetachedFromRecyclerView(RecyclerView recyclerView)
    {
        super.onDetachedFromRecyclerView(recyclerView);
        this.items.removeOnListChangedCallback(itemsChangeCallback);
    }

    protected void onChanged(ObservableArrayList<M> newItems)
    {
        resetItems(newItems);
        notifyDataSetChanged();
    }

    protected void onItemRangeChanged(ObservableArrayList<M> newItems, int positionStart, int itemCount)
    {
        resetItems(newItems);
        notifyItemRangeChanged(positionStart,itemCount);
    }

    protected void onItemRangeInserted(ObservableArrayList<M> newItems, int positionStart, int itemCount)
    {
        resetItems(newItems);
        notifyItemRangeInserted(positionStart,itemCount);
    }

    protected void onItemRangeMoved(ObservableArrayList<M> newItems)
    {
        resetItems(newItems);
        notifyDataSetChanged();
    }

    protected void onItemRangeRemoved(ObservableArrayList<M> newItems, int positionStart, int itemCount)
    {
        resetItems(newItems);
        notifyItemRangeRemoved(positionStart,itemCount);
    }

    protected void resetItems(ObservableArrayList<M> newItems)
    {
        this.items = newItems;
    }
    //endregion

    protected abstract @LayoutRes
    int getLayoutResId(int viewType);

    protected abstract void onBindItem(B binding, M item);

    class ListChangedCallback extends ObservableArrayList.OnListChangedCallback<ObservableArrayList<M>>
    {
        @Override
        public void onChanged(ObservableArrayList<M> newItems)
        {
            BaseBindingAdapter.this.onChanged(newItems);
        }

        @Override
        public void onItemRangeChanged(ObservableArrayList<M> newItems, int i, int i1)
        {
            BaseBindingAdapter.this.onItemRangeChanged(newItems,i,i1);
        }

        @Override
        public void onItemRangeInserted(ObservableArrayList<M> newItems, int i, int i1)
        {
            BaseBindingAdapter.this.onItemRangeInserted(newItems,i,i1);
        }

        @Override
        public void onItemRangeMoved(ObservableArrayList<M> newItems, int i, int i1, int i2)
        {
            BaseBindingAdapter.this.onItemRangeMoved(newItems);
        }

        @Override
        public void onItemRangeRemoved(ObservableArrayList<M> sender, int positionStart, int itemCount)
        {
            BaseBindingAdapter.this.onItemRangeRemoved(sender,positionStart,itemCount);
        }
    }
}
