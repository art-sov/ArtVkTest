package com.art.artvktest.ui.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.art.artvktest.R;
import com.art.artvktest.model.view.NewsItemHeaderViewModel;
import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class NewsItemHeaderHolder extends BaseViewHolder<NewsItemHeaderViewModel> {
   //переменные для аватара и имени пользователя
    private CircleImageView civProfileImage;
    private TextView tvName;

    //переменные для аватара и имени отправителя репоста
    private ImageView ivRepostedIcon;
    private TextView tvRepostedPrifileName;

    public NewsItemHeaderHolder(View itemView){
        super(itemView);
        civProfileImage = (CircleImageView) itemView.findViewById(R.id.civ_profile_image);
        tvName = (TextView) itemView.findViewById(R.id.tv_profile_name);
        ivRepostedIcon = (ImageView) itemView.findViewById(R.id.iv_reposted_icon);
        tvRepostedPrifileName = (TextView) itemView.findViewById(R.id.tv_reposted_profile_name);
    }
    @Override
    public void bindViewHolder(NewsItemHeaderViewModel item) {
        Context context = itemView.getContext();

        //подгружаем и устанавливаем аватар отправителя
        Glide.with(context)
                .load(item.getProfilePhoto())
                .into(civProfileImage);

        tvName.setText(item.getProfileName());

        if (item.isRepost()) {
            ivRepostedIcon.setVisibility(View.VISIBLE);
            tvRepostedPrifileName.setText(item.getRepostProfileName());
        }
        else {
            ivRepostedIcon.setVisibility(View.GONE);
            tvRepostedPrifileName.setText(null);
        }
    }

    //очищаем аватарки и текстовые поля
    @Override
    public void unbindViewHolder() {
        civProfileImage.setImageBitmap(null);
        tvName.setText(null);
        tvRepostedPrifileName.setText(null);
    }
}
