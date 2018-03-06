package com.art.artvktest.model.view;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.art.artvktest.R;
import com.art.artvktest.ui.holder.BaseViewHolder;

public abstract class BaseViewModel {

    //метод для того, чтобы отличать модели разного типа, а также для inflate необходимого макета
    public abstract LayoutTypes getType();

    public BaseViewHolder createViewHolder(ViewGroup parent){
        return onCreateViewHolder(LayoutInflater.from(parent.getContext()).inflate(getType().getValue(),
                parent, false));
    }

    //метод, чтобы переложить ответственность за создание конкретного ViewHolder на дочерние классы
    protected abstract BaseViewHolder onCreateViewHolder (View view);

    //метод для получения Layout
    public enum LayoutTypes {
        NewsFeedItemHeader (R.layout.item_news_header),
        NewsFeedItemBody (R.layout.item_news_body),
        NewsFeedItemFooter (R.layout.item_news_footer);

        private final int id;

        LayoutTypes(int resId){
            this.id = resId;
        }

        @LayoutRes
        public int getValue() {
            return id;
        }
    }
}
