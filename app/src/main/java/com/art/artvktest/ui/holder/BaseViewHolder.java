package com.art.artvktest.ui.holder;


import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseViewHolder<Item> extends RecyclerView.ViewHolder{

    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    //для заполнения макета данными с модели item
    public abstract void bindViewHolder(Item item);

    //для разгрузки макета, когда он не используется
    public abstract void unbindViewHolder();
}
