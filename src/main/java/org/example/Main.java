package org.example;

import org.example.dao.NumberDao;
import org.example.dao.NumberDaoImpl;
import org.example.model.Number;

public class Main {
    public static void main(String[] args) {
        NumberDao numberDao = new NumberDaoImpl();
        System.out.println(numberDao.get(3L));

        Number number = new Number();
        number.setNumber(1000);
        number.setDescription("wow");
        Number saved = numberDao.save(number);
        System.out.println(saved);
    }
}