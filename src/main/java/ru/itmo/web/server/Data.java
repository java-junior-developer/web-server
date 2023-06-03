package ru.itmo.web.server;

import ru.itmo.web.server.entity.Cat;
import ru.itmo.web.server.entity.Category;
import ru.itmo.web.server.entity.Color;
import ru.itmo.web.server.entity.Habit;

import java.time.LocalDate;
import java.util.ArrayList;

public class Data {
    private Data(){}

    private final static ArrayList<Category> CATEGORIES;
    private final static ArrayList<Habit> HABITS;
    private final static ArrayList<Cat> CATS;

    static {
        CATEGORIES = new ArrayList<>();
        loadCategories();

        HABITS = new ArrayList<>();
        loadHabits();

        CATS = new ArrayList<>();
        loadCats();
    }

    private static void loadCategories(){
        CATEGORIES.add(new Category("purebred", "are relatively rare"));
        CATEGORIES.add(new Category("mestizos", "are less aggressive than many purebred cats"));
    }

    private static void loadHabits(){
        HABITS.add(new Habit("outside", "must go outside every day", true));
        HABITS.add(new Habit("children", "likes children", true));
        HABITS.add(new Habit("other cats", "doesn't like other cats", false));
    }

    private static void loadCats(){
        CATS.add(new Cat(1, "Roxxy", LocalDate.now().minusYears(2).minusMonths(2), Color.GRAY,
                getCategoryByName("mestizos"), getHabitByName("children"), getHabitByName("other cats")));
        CATS.add(new Cat(2, "Luna", LocalDate.now().minusMonths(4), Color.WHITE,
                getCategoryByName("purebred"), getHabitByName("outside"), getHabitByName("other cats")));
        CATS.add(new Cat(3, "Tom", LocalDate.now().minusYears(1).minusMonths(8), Color.BLACK,
                getCategoryByName("purebred"), getHabitByName("outside"), getHabitByName("children")));
        CATS.add(new Cat(4, "Loki", LocalDate.now().minusYears(3).minusMonths(1), Color.GRAY,
                getCategoryByName("mestizos"), getHabitByName("children")));
        CATS.add(new Cat(5, "Abbey", LocalDate.now().minusYears(3).minusMonths(6), Color.WHITE,
                getCategoryByName("mestizos"), getHabitByName("outside"), getHabitByName("children")));
    }

    private static Category getCategoryByName(String name){
        return CATEGORIES.stream()
                .filter(category -> category.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    private static Habit getHabitByName(String name){
        return HABITS.stream()
                .filter(habit -> habit.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public static ArrayList<Category> getCategories(){
        return CATEGORIES;
    }

    public static ArrayList<Habit> getHabits(){
        return HABITS;
    }

    public static ArrayList<Cat> getCats(){
        return CATS;
    }
}
