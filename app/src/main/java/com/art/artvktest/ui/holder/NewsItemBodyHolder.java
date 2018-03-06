package com.art.artvktest.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.art.artvktest.R;
import com.art.artvktest.model.view.NewsItemBodyViewModel;

public class NewsItemBodyHolder extends BaseViewHolder<NewsItemBodyViewModel> {

    public TextView mText;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        mText = (TextView) itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bindViewHolder(NewsItemBodyViewModel newsItemBodyViewModel) {
        //устанавливаем текст для TextView, который берем из NewsItemBodyViewModel
        mText.setText(newsItemBodyViewModel.getText());
    }

    @Override
    public void unbindViewHolder() {
    //обнуляем текс
        mText.setText(null);
    }
}
