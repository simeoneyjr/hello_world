package com.enn.service;

import com.enn.Singleton.MybatisHelper;
import com.enn.domain.RealtimeCar;
import com.enn.domain.TankCar;
import com.enn.mapping.CarMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by yjr on 2016/8/2.
 */
public class SqlSentence {

    private static SqlSentence sql;
    SqlSession session =MybatisHelper.getSession();
    Logger logger = Logger.getLogger(SqlSentence.class);

    public static SqlSentence GetSqlSentence()
    {
        if (sql == null)
        {
            sql = new SqlSentence();
        }
        return sql;
    }

    /**
     * 查询
     *
     */
    public List<RealtimeCar> select(){
        logger.info("查询车辆及任务的信息");
        SqlSession session =MybatisHelper.getSession();
        List<RealtimeCar> car=null;
        try{
             car = session.getMapper(CarMapper.class).getrealtimeCar();
        }catch (Exception e){
            logger.error("查询车辆及任务的信息："+e.toString());
            e.printStackTrace();
        }

        //System.out.println(car);
        if(session!=null){
            session.close();
        }
        return car;
    }
    /**
     * 查询历史的车辆数据
     *
     */
    public List<RealtimeCar> selecthistory(){
        logger.info("查询一个小时之前的车辆数据");
        SqlSession session =MybatisHelper.getSession();
        List<RealtimeCar> car=null;
        try{
            car = session.getMapper(CarMapper.class).gethistoryrealtimeCar();
        }catch (Exception e){
            logger.error("查询一个小时之前的车辆数据："+e.toString());
            e.printStackTrace();
        }

        if(session!=null){
            session.close();
        }
        return car;
    }

    /**
     * 查询tankcar
     *
     */
    public List<TankCar> selecttankcar(){
        logger.info("查询车辆的温度，液位，压力，库存等数据");
        List<TankCar> car=null;
        SqlSession session =MybatisHelper.getSession();
        try{
             car = session.getMapper(CarMapper.class).getTankcar();
        }catch (Exception e){
            logger.error("查询车辆的温度，液位，压力，库存等数据"+e.toString());
            e.printStackTrace();
        }

        if(session!=null){
            session.close();
        }
        return car;
    }

    public void insert(List<RealtimeCar> cars){
        SqlSession session =MybatisHelper.getSession();
        if(cars!=null&& cars.size()>0)
        {
            session.getMapper(CarMapper.class).insertCar(cars);
            session.commit();
        }
        if(session!=null){
            session.close();
        }
    }

    /**
     * 插入到历史表
     *
     */
    public void inserthistory(List<RealtimeCar> cars){
        logger.info("将车辆数据插入历史数据表");
        SqlSession session =MybatisHelper.getSession();
        try{
            if(cars!=null&& cars.size()>0)
            {
                session.getMapper(CarMapper.class).insertHistoryCar(cars);
                session.commit();
            }
        }catch (Exception e){
            logger.error("将车辆数据插入历史数据表"+e.toString());
            e.printStackTrace();
        }
        if(session!=null){
            session.close();
        }
    }

    /**
     * 删除并插入
     *
     */
    public void DeleteandInsert(List<RealtimeCar> cars){
        logger.info("更新车辆实时监控数据");
        SqlSession session =MybatisHelper.getSession();
        try{
            session.getMapper(CarMapper.class).deleteCar();
            session.getMapper(CarMapper.class).insertCar(cars);
            session.commit();
        }catch (Exception e){
            logger.error("更新车辆实时监控数据"+e.toString());
            e.printStackTrace();
        }

        if(session!=null){
            session.close();
        }
    }

    /**
     * 删除
     *
     */
    public void Delete(){
        SqlSession session =MybatisHelper.getSession();
        session.getMapper(CarMapper.class).deleteCar();
        session.commit();
        if(session!=null){
            session.close();
        }
    }

    /**
     * 删除旧的数据
     *
     */
    public void DeleteOld() {
        logger.info("删除车辆旧的数据");
        SqlSession session =MybatisHelper.getSession();
        try{
            session.getMapper(CarMapper.class).deleteold();
            session.commit();
        }catch (Exception e){
            logger.error("删除车辆旧的数据"+e.toString());
            e.printStackTrace();
        }

        if(session!=null){
            session.close();
        }
    }

}
