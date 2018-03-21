package com.art.artvktest.ui.holder;

import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;

import com.art.artvktest.MyApplication;
import com.art.artvktest.R;
import com.art.artvktest.model.view.NewsItemBodyViewModel;
import javax.inject.Inject;

public class NewsItemBodyHolder extends BaseViewHolder<NewsItemBodyViewModel> {

    private TextView mText;
    private TextView tvAttachments;

    @Inject
    protected Typeface mFontGoogle;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        MyApplication.getsApplicationComponent().inject(this);

        mText = (TextView) itemView.findViewById(R.id.tv_text);
        tvAttachments = (TextView) itemView.findViewById(R.id.tv_attachments);

        if (tvAttachments != null) {
            tvAttachments.setTypeface(mFontGoogle);
        }
    }

    @Override
    public void bindViewHolder(NewsItemBodyViewModel item) {
        //устанавливаем текст для TextView, который берем из NewsItemBodyViewModel
        mText.setText(item.getText());
        tvAttachments.setText(item.getmAttachmentString());
    }

    @Override
    public void unbindViewHolder() {
    //обнуляем текс
        mText.setText(null);
        tvAttachments.setText(null);
    }
}
