package ru.itmo.web.server.service;

import org.springframework.stereotype.Component;
import ru.itmo.web.server.Data;
import ru.itmo.web.server.entity.Category;

import java.util.ArrayList;

@Component
public class CategoryService {

    public ArrayList<Category> allCategories(){
        return Data.getCategories();
    }

}
