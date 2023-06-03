package ru.itmo.web.server.service;

import org.springframework.stereotype.Component;
import ru.itmo.web.server.Data;
import ru.itmo.web.server.entity.Cat;
import java.util.ArrayList;


@Component
public class CatService {

    public ArrayList<Cat> allCats(){
        ArrayList<Cat> catArrayList = new ArrayList<>();
        Data.getCats().forEach(cat -> {
            if (!cat.isReserved()) {
                catArrayList.add(cat);
            }
        });
        return catArrayList;
    }

    public boolean reserveCat(Cat userChoice){
        for (Cat cat : Data.getCats()) {
            if (cat.getUniqueId() == userChoice.getUniqueId() && !cat.isReserved()) {
                cat.setReserved(true);
                return true;
            }
        }
        return false;
    }
}
