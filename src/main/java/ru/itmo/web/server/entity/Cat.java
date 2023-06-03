package ru.itmo.web.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;


@Getter
@Setter
public class Cat {
    private long uniqueId;
    private String name;
    private LocalDate birth;
    private Color color;
    private Category category;
    private ArrayList<Habit> habits;
    @JsonIgnore
    private boolean reserved;

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public Cat(long uniqueId, String name, LocalDate birth, Color color, Category category, Habit... habits) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.birth = birth;
        this.color = color;
        this.category = category;
        this.habits = new ArrayList<>(Arrays.asList(habits));
    }
}
