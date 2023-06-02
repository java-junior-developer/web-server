package ru.itmo.web.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

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

    public Cat(long uniqueId, String name, LocalDate birth, Color color, Category category) {
        this.uniqueId = uniqueId;
        this.name = name;
        this.birth = birth;
        this.color = color;
        this.category = category;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Category getCategory() {
        return category;
    }


    public void setCategory(Category category) {
        this.category = category;
    }

    public ArrayList<Habit> getHabits() {
        return habits;
    }

    public void setHabits(ArrayList<Habit> habits) {
        this.habits = habits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return uniqueId == cat.uniqueId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueId);
    }
}
