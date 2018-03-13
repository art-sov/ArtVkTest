package com.art.artvktest.common.utils;

import com.art.artvktest.model.Owner;
import com.art.artvktest.model.WallItem;
import com.art.artvktest.rest.model.response.ItemWithSendersResponse;

import java.util.List;

public class VkListHelper {

    //метод заполняет поля senderName and senderPhoto для отправителя записи,
    //а также для отправителя репоста, если запись является репостом
    public static List<WallItem> getWallList(ItemWithSendersResponse<WallItem> response) {
        List<WallItem> wallItemList = response.items;

        for (WallItem wallItem: wallItemList) {
            Owner sender = response.getSender(wallItem.getFromId());
            wallItem.setSenderName(sender.getFullName());
            wallItem.setSenderPhoto(sender.getPhoto());

            if (wallItem.haveSharedRepost()) {
                Owner repostSender = response.getSender(wallItem.getSharedRepost().getFromId());
                wallItem.getSharedRepost().setSenderName(repostSender.getFullName());
                wallItem.getSharedRepost().setSenderPhoto(repostSender.getPhoto());
            }
        }
        return wallItemList;
    }
}
