package com.example.dadriaunna01.inclassassignment08_dadriaunnaw2;

/**
 * Created by cmltdstudent on 4/4/17.
 */

public class Children {

    private boolean daycare;
    private String name;
    private int age;

    public Children(boolean daycare, String name, int age) {
        this.daycare = daycare;
        this.name = name;
        this.age = age;
    }

    public boolean isDaycare() {
        return daycare;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Children{" +
                "daycare=" + daycare +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
