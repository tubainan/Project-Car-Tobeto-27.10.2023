package org.example.dataAccess;

import org.example.entities.Car;

public class JdbcCarDao implements CarDao {
    public void add(Car car) {
        System.out.println("JDBC Car ile veritabanına aklendi");
    }
}

