package com.enn.mapping;

import com.enn.domain.RealtimeCar;
import com.enn.domain.TankCar;

import java.util.List;

/**
 * Created by yjr on 2016/8/2.
 */
public interface CarMapper {
    List<RealtimeCar> getrealtimeCar();
    void  insertCar(List<RealtimeCar> cars);
    void  deleteCar();
    List<TankCar> getTankcar();
    List<RealtimeCar> gethistoryrealtimeCar();
    void  insertHistoryCar(List<RealtimeCar> cars);
    void deleteold();
}
