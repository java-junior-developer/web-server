package ru.itmo.web.server.service;

import org.springframework.stereotype.Component;
import ru.itmo.web.server.entity.Cat;
import ru.itmo.web.server.entity.Category;
import ru.itmo.web.server.entity.Color;
import ru.itmo.web.server.entity.Habit;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CatService {
    private ArrayList<Cat> cats;

    public CatService() {
        this.cats = getCats();
    }

    public ArrayList<Cat> allCats(){
        ArrayList<Cat> catArrayList = new ArrayList<>();
        cats.forEach(cat -> {
            if (!cat.isReserved()) {
                catArrayList.add(cat);
            }
        });
        return catArrayList;
    }

    public boolean reserve(Cat userRequest){
        for (Cat cat : cats) {
            if (cat.equals(userRequest) && !userRequest.isReserved()) {
                cat.setReserved(true);
                return true;
            }
        }
        return false;
    }

    private static ArrayList<Cat> getCats(){
        Category category01 = new Category("purebred", "are relatively rare");
        Category category02 = new Category("mestizos", "are less aggressive than many purebred cats");

        Habit habit01 = new Habit("outside", "must go outside every day", true);
        Habit habit02 = new Habit("children", "likes children", true);
        Habit habit03 = new Habit("other cats", "doesn't like other cats", false);

        Cat cat01 = new Cat(1, "Roxxy", LocalDate.now().minusYears(2).minusMonths(2), Color.GRAY, category02);
        cat01.setHabits(new ArrayList<>(Arrays.asList(habit02, habit03)));

        Cat cat02 = new Cat(2, "Luna", LocalDate.now().minusMonths(4), Color.WHITE, category01);
        cat02.setHabits(new ArrayList<>(List.of(habit03)));

        Cat cat03 = new Cat(3, "Tom", LocalDate.now().minusYears(1).minusMonths(8), Color.BLACK, category01);
        cat03.setHabits(new ArrayList<>(Arrays.asList(habit01, habit02)));

        Cat cat04 = new Cat(3, "Loki", LocalDate.now().minusYears(3).minusMonths(1), Color.GRAY, category02);
        cat04.setHabits(new ArrayList<>(Arrays.asList(habit01, habit03)));

        Cat cat05 = new Cat(4, "Abbey", LocalDate.now().minusYears(3).minusMonths(6), Color.WHITE, category02);
        cat05.setHabits(new ArrayList<>(Arrays.asList(habit01, habit02)));

        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(cat01);
        cats.add(cat02);
        cats.add(cat03);
        cats.add(cat04);
        cats.add(cat05);

        return cats;
    }
}
