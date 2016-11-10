package com.enn.service;

import com.enn.domain.RealtimeCar;
import com.enn.domain.TankCar;
import com.enn.util.FormatTime;
import com.enn.util.GeographyPoint;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * 对车辆的信息进行计算
 * Created by yjr on 2016/8/2.
 *
 *
 */
public class UpdateCar {

    private static UpdateCar upCar;
    Logger logger = Logger.getLogger(UpdateCar.class);

    public static UpdateCar GetUpdateCar()
    {
        if (upCar == null)
        {
            upCar = new UpdateCar();
        }
        return upCar;
    }


    MapServiceImpl mapservice =MapServiceImpl.GetMapServiceImpl();
    FormatTime format =FormatTime.GetFormatTime();
    Date date=new Date();//作为统计日期

    /**
     * 更新车辆信息
     * @param realtimecars  车辆的当前位置信息和当前执行任务信息
     * @param tankCarlist  用于获取车辆的温度/液位/压力/库存及是否正常数据
     * @param historylist  一个小时之前的槽车量数据
     */
    public List<RealtimeCar>  upcarinfo(List<RealtimeCar> realtimecars,List<TankCar> tankCarlist,List<RealtimeCar> historylist)
    {
        List<RealtimeCar> updatecar=new ArrayList<RealtimeCar>();
        if(realtimecars!=null &&realtimecars.size()>0)
        {
            logger.info("更新车辆实时数据");
            for (RealtimeCar car : realtimecars) {
                if(car!=null)
                {
                    logger.info("更新车辆:"+car.getTRUCK_TOU_NO());
                    this.setlocation(car);
                    this.setinfo(car);
                    this.setloadnuloadinfo(car);
                    this.setrealtimeinfo(car,tankCarlist);
                    this.setSaboteur(car,historylist);
                    car.setTIME(format.timetostring2(date));
                    updatecar.add(car);
                }
            }
            logger.info("车辆数据更新完成");
        }
        return  updatecar;
    }

    /**
     * 获取车辆的当前位置当前位置
     * @param car  车辆的当前位置信息和当前执行任务信息
     */
    private  void setlocation(RealtimeCar car)
    {
        try{
            GeographyPoint carpoint=new GeographyPoint();//当前车位置
            carpoint.setpointX(car.getCAR_LOCATION_X());
            carpoint.setpointY(car.getCAR_LOCATION_Y());
            car.setLOCATION(mapservice.geographyname(carpoint));
        }catch (Exception e){
            logger.error(car.getTRUCK_TOU_NO()+"获取车辆位置："+e.toString());
            e.printStackTrace();
        }

    }
    /**
     * 根据任务中的场站及气源地位置测算出距离到气源地距离和场站距离
     * @param  car 车辆的当前位置信息和当前执行任务信息
     */
    private void setinfo(RealtimeCar car)
    {
        try{
            GeographyPoint carpoint = new GeographyPoint();//当前车位置
            carpoint.setpointX(car.getCAR_LOCATION_X());
            carpoint.setpointY(car.getCAR_LOCATION_Y());
            GeographyPoint sourcepoint = new GeographyPoint(); //气源地位置
            sourcepoint.setpointX(car.getSOURCE_LOCATION_X());
            sourcepoint.setpointY(car.getSOURCE_LOCATION_Y());
            float sourcedistence = mapservice.distance(carpoint, sourcepoint) / 1000;
            car.setSOURCE_DISTANCE(sourcedistence);

            GeographyPoint stationpoint = new GeographyPoint();//场站位置
            stationpoint.setpointX(car.getSTATION_LOCATION_X());
            stationpoint.setpointY(car.getSTATION_LOCATION_Y());
            float stationdistence = mapservice.distance(carpoint, stationpoint) / 1000;
            car.setDISTANCE(stationdistence);
        }catch (Exception e){
            logger.error(car.getTRUCK_TOU_NO()+"获取车辆与装卸车点距离："+e.toString());
            e.printStackTrace();
        }
    }
    /**
     * 装卸车预警
     *
     * 默认为不预警
     * 装车预警：车辆状态为 0S或者为1并且装车开始时间为空
     * 预计装车时间=距离装车点距离/50km/h； 如果比预计时间小于一个小时则预警  如果距离装气点距离小于1 即为到达
     *
     * 卸车预警：车辆状态为 2并且卸车开始时间为空
     * 预计装车时间=距离装车点距离/50km/h； 如果比预计时间小于一个小时则预警  如果距离装气点距离小于1 即为到达
     *
     * @param car 车辆的当前位置信息及距离及加气点或者卸气点的距离的距离信息和当前执行任务信息及车辆状态
     *
     */
    private void setloadnuloadinfo(RealtimeCar car)
    {
        car.setLOADWARN("N");
        car.setARRIVEWARN("N");

        if (car.getTASK_ID() != null && car.getTASK_ID().length() != 0 && car.getTASK_STATE() != null && car.getTASK_STATE().length() > 0) {
            if((car.getTASK_STATE().equals("0S")||car.getTASK_STATE().equals("1"))&&car.getLOAD_BEGIN_TIME()==null)//还没装车
            {
                try{
                    float time=car.getSOURCE_DISTANCE()/car.getSPEED();//速度为50km/h
                    long currentTime = System.currentTimeMillis();
                    currentTime +=time*60*60*1000;
                    Date date=new Date(currentTime);
                    car.setPREDICT_LOAD_TIME(format.timetostring(date));//预计装车时间
                    if(car.getPLAN_LOAD_TIME()!=null)
                    {
                        long temp = format.stringtostime(car.getPLAN_LOAD_TIME()).getTime()-
                                format.stringtostime(car.getPREDICT_LOAD_TIME()).getTime();
                        long hours = Math.abs(temp / 1000 / 3600);
                        if(temp<-3600000)
                        {
                            car.setLOADWARN("Y");
                        }
                        if(car.getSOURCE_DISTANCE()<1)
                        {
                            car.setLOADWARNTIME("已抵达");
                        }else
                        {
                            car.setLOADWARNTIME(hours+"");
                        }

                    }
                }catch (Exception e){

                    logger.error(car.getTRUCK_TOU_NO()+"装车预警："+e.toString());
                    e.printStackTrace();
                }

            }//卸车预警
            else if(car.getTASK_STATE().equals("2"))//已装车
            {
                try{
                    float time=car.getDISTANCE()/car.getSPEED();
                    long currentTime = System.currentTimeMillis();
                    currentTime +=time*60*60*1000;
                    Date date=new Date(currentTime);
                    car.setPREDICT_ARRIVE_TIME(format.timetostring(date));//预计卸车时间
                    if(car.getPLAN_UNLOAD_TIME()!=null)
                    {
                        long temp = format.stringtostime(car.getPLAN_UNLOAD_TIME()).getTime()-
                                format.stringtostime(car.getPREDICT_ARRIVE_TIME()).getTime();
                        long hours = Math.abs(temp / 1000 / 3600);
                        if(temp<-3600000)
                        {
                            car.setARRIVEWARN("Y");
                        }
                        if(car.getSOURCE_DISTANCE()<1)
                        {
                            car.setARRIVEWARNTIME("已抵达");
                        }else
                        {
                            car.setARRIVEWARNTIME(""+hours);
                        }
                    }
                }catch (Exception e){
                    logger.error(car.getTRUCK_TOU_NO()+"卸车预警："+e.toString());
                    e.printStackTrace();
                }

            }
        }
    }
    /**
     * 槽车的实时信息 包括液位温度压力库存 是否偷气：槽车位置距离装车点>5公里并且进口温度<-50度
     * 温度液位压力库存，需要从实时数据获取
     * 默认不预警
     * @param car   车辆的当前位置信息及距离及加气点或者卸气点的距离的距离信息和当前执行任务信息及车辆状态
     * @param list  用于获取车辆的温度/液位/压力/库存及是否正常数据
     */
    private void setrealtimeinfo(RealtimeCar car, List<TankCar> list)
    {
        car.setIS_STEALGAS("N");
        try{
            for(TankCar tankCar:list)
            {
                long time=format.stringtostime2(car.getTIME()).getTime()-
                        format.stringtostime(tankCar.getSave_time()).getTime();
                if(tankCar.getCar_no().equals(car.getTRUCK_TOU_NO())&&time>=-3600000&&time<=3600000 ){//判断一下时间
                    if (tankCar.getLiquid() != null) {
                        if(tankCar.getLiquid().equals("0.00001"))
                        {
                            car.setLIQUID_LEVEL("0");
                        }else{
                            car.setLIQUID_LEVEL(tankCar.getLiquid());
                        }
                    }
                    if (tankCar.getLiquid_is_ok()!=null) {
                        car.setLIQUID_IS_OK(tankCar.getLiquid_is_ok());
                    }
                    if(tankCar.getTemperatrue_is_ok()!=null)
                    {
                        car.setTEMPERATRUE_IS_OK(tankCar.getTemperatrue_is_ok());
                    }
                    if(tankCar.getStorages()!=null)
                    {
                        if(tankCar.getStorages().equals("0.0001"))
                        {
                            car.setSTORAGES("0");
                        }else
                        {
                            car.setSTORAGES(tankCar.getStorages());
                        }
                    }
                    if(tankCar.getStorages_is_ok()!=null)
                    {
                        car.setSTORAGES_IS_OK(tankCar.getStorages_is_ok());
                    }
                    if(tankCar.getPressure()!=null)
                    {
                        car.setPRESSURE(tankCar.getPressure());
                    }
                    if(tankCar.getPressure_is_ok()!=null)
                    {
                        car.setPRESSURE_IS_OK(tankCar.getPressure_is_ok());
                    }
                    if(tankCar.getTemperatrue()!=null)
                    {
                        car.setTEMPERATURE(tankCar.getTemperatrue());
                        if(Float.parseFloat(tankCar.getTemperatrue())<-50&&car.getDISTANCE()>5&&car.getSOURCE_DISTANCE()>5)
                        {
                            car.setIS_STEALGAS("Y");
                        }
                    }
                }
            }
        }catch (Exception e){

            logger.error(car.getTRUCK_TOU_NO()+"车辆司机偷气："+e.toString());
            e.printStackTrace();
        }

    }

    /**
     * 是否怠工
     *槽车位置距离卸车点<1公里 and （当前温度-前一个小时温度）>-3度 and 并且液位小于1 and 位置没有改变一个小时
     *
     * @param car    车辆的当前位置信息及距离及加气点或者卸气点的距离的距离信息和当前执行任务信息及车辆状态
     * @param hlist  车辆一小时之前的数据
     */
    private void setSaboteur(RealtimeCar car, List<RealtimeCar> hlist)
    {
        car.setIS_SABOTEUR("N");
        try{

            for(RealtimeCar hcar: hlist)
            {
                if(hcar.getUNLOAD_END_TIME()!=null&&car.getUNLOAD_END_TIME()!=null&&hcar.getTASK_ID().equals(car.getTASK_ID())&&car.getLOCATION()!=null&&car.getLIQUID_LEVEL()!=null&&car.getTEMPERATURE()!=null&&car.getLIQUID_LEVEL().length()>0&&car.getTEMPERATURE().length()>0&&
                        hcar.getLOCATION()!=null&&hcar.getLIQUID_LEVEL()!=null&&hcar.getTEMPERATURE()!=null&&hcar.getTEMPERATURE().length()>0&&hcar.getLIQUID_LEVEL().length()>0)
                {
                    if(Float.parseFloat(hcar.getLIQUID_LEVEL())<1&&car.getLOCATION().equals(hcar.getLOCATION())&&car.getDISTANCE()<1&&Float.parseFloat(car.getLIQUID_LEVEL())<1&&(Float.parseFloat(car.getTEMPERATURE())-Float.parseFloat(hcar.getTEMPERATURE()))>-3)
                    {
                        car.setIS_SABOTEUR("Y");
                    }
                }
            }
        }catch (Exception e){

            logger.error(car.getTRUCK_TOU_NO()+"车辆司机怠工："+e.toString());
            e.printStackTrace();
        }

    }
}
