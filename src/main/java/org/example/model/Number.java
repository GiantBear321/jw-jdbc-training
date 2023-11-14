package org.example.model;

public class Number {
    private long id;
    private double number;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Number{" +
                "id=" + id +
                ", number=" + number +
                ", description='" + description + '\'' +
                '}';
    }
}
