package com.art.artvktest.model.attacment;

//класс служит контейнером для самих аттачментов

import com.vk.sdk.api.model.Identifiable;

public interface Attachment extends Identifiable{

    String getType();
}
