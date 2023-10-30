package org.example;

import org.example.business.CarManager;
import org.example.core.logging.DatabaseLogger;
import org.example.core.logging.FileLogger;
import org.example.core.logging.Logger;
import org.example.core.logging.MailLogger;
import org.example.dataAccess.HibernateCarDao;
import org.example.dataAccess.JdbcCarDao;
import org.example.entities.Car;

public class Main {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car(44, "Toyota", "Corolla", 2017, 10);
        Car car2 = new Car(06, "Fiat", "Doblo", 2020, 7);
        Car car3 = new Car(34, "BMW", "M3", 2023, 12);
        Car car4 = new Car(02, "Volkswagen", "Passat", 2019, 45);

        Logger[] loggers = {new DatabaseLogger(), new FileLogger(), new MailLogger()};
        CarManager carManager = new CarManager(new HibernateCarDao(), loggers);
        carManager.add(car1);
        carManager.add(car2);
        carManager.add(car3);
        carManager.add(car4);
    }
}