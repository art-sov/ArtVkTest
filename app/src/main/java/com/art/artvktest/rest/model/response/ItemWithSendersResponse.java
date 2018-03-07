package com.art.artvktest.rest.model.response;

import com.art.artvktest.model.Group;
import com.art.artvktest.model.Owner;
import com.art.artvktest.model.Profile;

import java.util.ArrayList;
import java.util.List;

/**для того, чтобы парсить не только item, но и другие: profiles, group*/
public class ItemWithSendersResponse<T> extends BaseItemResponse<T> {
    private List<Profile> profiles = new ArrayList<>();
    private List<Group> groups = new ArrayList<>();

    private List<Profile> getProfiles() {
        return profiles;
    }

    private List<Group> getGroups() {
        return groups;
    }

    //метод для получения списка отправителей
    public  List<Owner> getAllSenders() {
        List<Owner> all = new ArrayList<>();
        all.addAll(getProfiles());
        all.addAll(getGroups());
        return all;
    }

    //метод получения конкретного отправителя, где мы перебераем всех отправителей и находим
    // отправителя по id
    public Owner getSender (int id){
        for (Owner owner : getAllSenders()) {
            if (owner.getId() == Math.abs(id))
                return owner;
        }
        return null;
    }
}
