package org.example.business;
import org.example.core.logging.Logger;
import org.example.dataAccess.CarDao;
import org.example.dataAccess.JdbcCarDao;
import org.example.entities.Car;
import java.util.List;

public class CarManager {
    private CarDao carDao;
    private Logger[] loggers;
    public CarManager(CarDao carDao, Logger[] loggers) {
        this.carDao = carDao;
        this.loggers = loggers;
    }

    public void add(Car car) throws Exception {
        if(car.getUnitPrice()>100000){
            throw new Exception("Ürün fiyatı 100000 den küçük olamaz");
        }
        //CarDao carDao = new JdbcCarDao();
        carDao.add(car);

        for (Logger logger : loggers){
            logger.log(car.getBrand());
            logger.log(car.getModel());
        }
    }
}
