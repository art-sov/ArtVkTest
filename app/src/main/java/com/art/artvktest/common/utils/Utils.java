package com.art.artvktest.common.utils;

import android.content.Context;

import com.art.artvktest.model.attacment.ApiAttachment;
import com.vk.sdk.api.model.VKAttachments;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

    public static String parseDate(long initialDate, Context context) {
        Locale currentLocale = context.getResources().getConfiguration().locale;

        Date date = new Date(initialDate * 1000);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy в HH:mm", currentLocale);

        if (calendar.get(Calendar.DAY_OF_YEAR) == Calendar.getInstance().get(Calendar.DAY_OF_YEAR) &&
                calendar.get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)) {
            sdf = new SimpleDateFormat("сегодня в H:mm", currentLocale);
        } else if (calendar.get(Calendar.YEAR) == Calendar.getInstance().get(Calendar.YEAR)){
            sdf = new SimpleDateFormat("d MM в H:mm", currentLocale);
        }
        return sdf.format(date);
    }
}
