package com.art.artvktest.common.utils;

import com.art.artvktest.model.attacment.ApiAttachment;
import com.vk.sdk.api.model.VKAttachments;

import java.util.List;

public class Utils {
    //конвертирует строку из аттачментов в строку шрифтов иконок
    public static String convertAttachmentsToFontIcons (List<ApiAttachment> attachments) {
        String attachmentString = "";

        for (ApiAttachment attachment : attachments) {
            switch (attachment.getType()){
                case VKAttachments.TYPE_PHOTO:
                    attachmentString += new String(new char[]{0xE251}) + " ";
                    break;
                case VKAttachments.TYPE_AUDIO:
                    attachmentString += new String(new char[]{0xE310}) + " ";
                    break;
                case VKAttachments.TYPE_VIDEO:
                    attachmentString += new String(new char[]{0xE02c}) + " ";
                    break;
                case VKAttachments.TYPE_LINK:
                    attachmentString += new String(new char[]{0xE250}) + " ";
                    break;
                case VKAttachments.TYPE_DOC:
                    attachmentString += new String(new char[]{0xE24D}) + " ";
                    break;
            }
        }
        return attachmentString;
    }
}
