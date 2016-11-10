package com.enn.domain;

/**
 * 车辆的位置信息 以及 运输任务信息
 * Created by yjr on 2016/8/2.
 *
 */
public class RealtimeCar {

    private String  TASK_ID;
    private String  TASK_STATE;
    private String  IS_TASK;
    private String  CAR_STATUS;
    private String  LOCATION;
    private String  CAR_LOCATION_X;
    private String  CAR_LOCATION_Y;
    private int     SPEED;
    private float   DISTANCE;
    private float   SOURCE_DISTANCE;

    private String TEMPERATURE;
    private String TEMPERATRUE_IS_OK;
    private String LIQUID_LEVEL;
    private String LIQUID_IS_OK;
    private String PRESSURE;
    private String PRESSURE_IS_OK;
    private String STORAGES;
    private String STORAGES_IS_OK;
    private String IS_SABOTEUR;
    private String IS_STEALGAS;

    private String  PLAN_LOAD_TIME;
    private String  PREDICT_LOAD_TIME;
    private String  LOAD_BEGIN_TIME;
    private String  LOAD_END_TIME;
    private String  LOADWARN;
    private String  LOADWARNTIME;

    private String  PLAN_UNLOAD_TIME;
    private String  PREDICT_ARRIVE_TIME;
    private String  UNLOAD_BEGIN_TIME;
    private String  UNLOAD_END_TIME;

    private String  ARRIVEWARN;
    private String  ARRIVEWARNTIME ;

    private String  PROVIDER_ID;
    private String  PROVIDER_NAME;
    private String  DRIVER_NAME;
    private String  DRIVER_PHONE;
    private String  TRUCK_TOU_NO;
    private String  TRUCK_PAI_NO;
    private String  SOURCE_NAME;
    private String  SOURCE_LOCATION_X;
    private String  SOURCE_LOCATION_Y;
    private String  STATION_NAME;
    private String  STATION_LOCATION_X;
    private String  STATION_LOCATION_Y;
    private String  TIME;


    public String getLOADWARNTIME() {
        return LOADWARNTIME;
    }

    public void setLOADWARNTIME(String LOADWARNTIME) {
        this.LOADWARNTIME = LOADWARNTIME;
    }

    public String getARRIVEWARNTIME() {
        return ARRIVEWARNTIME;
    }

    public void setARRIVEWARNTIME(String ARRIVEWARNTIME) {
        this.ARRIVEWARNTIME = ARRIVEWARNTIME;
    }

    public String getLOAD_END_TIME() {
        return LOAD_END_TIME;
    }

    public void setLOAD_END_TIME(String LOAD_END_TIME) {
        this.LOAD_END_TIME = LOAD_END_TIME;
    }

    public String getUNLOAD_END_TIME() {
        return UNLOAD_END_TIME;
    }

    public void setUNLOAD_END_TIME(String UNLOAD_END_TIME) {
        this.UNLOAD_END_TIME = UNLOAD_END_TIME;
    }

    public String getPROVIDER_ID() {
        return PROVIDER_ID;
    }

    public void setPROVIDER_ID(String PROVIDER_ID) {
        this.PROVIDER_ID = PROVIDER_ID;
    }

    public float getSOURCE_DISTANCE() {
        return SOURCE_DISTANCE;
    }

    public void setSOURCE_DISTANCE(float SOURCE_DISTANCE) {
        this.SOURCE_DISTANCE = SOURCE_DISTANCE;
    }

    public String getTEMPERATURE() {
        return TEMPERATURE;
    }

    public void setTEMPERATURE(String TEMPERATURE) {
        this.TEMPERATURE = TEMPERATURE;
    }

    public String getTEMPERATRUE_IS_OK() {
        return TEMPERATRUE_IS_OK;
    }

    public void setTEMPERATRUE_IS_OK(String TEMPERATRUE_IS_OK) {
        this.TEMPERATRUE_IS_OK = TEMPERATRUE_IS_OK;
    }

    public String getLIQUID_LEVEL() {
        return LIQUID_LEVEL;
    }

    public void setLIQUID_LEVEL(String LIQUID_LEVEL) {
        this.LIQUID_LEVEL = LIQUID_LEVEL;
    }

    public String getLIQUID_IS_OK() {
        return LIQUID_IS_OK;
    }

    public void setLIQUID_IS_OK(String LIQUID_IS_OK) {
        this.LIQUID_IS_OK = LIQUID_IS_OK;
    }

    public String getPRESSURE() {
        return PRESSURE;
    }

    public void setPRESSURE(String PRESSURE) {
        this.PRESSURE = PRESSURE;
    }

    public String getPRESSURE_IS_OK() {
        return PRESSURE_IS_OK;
    }

    public void setPRESSURE_IS_OK(String PRESSURE_IS_OK) {
        this.PRESSURE_IS_OK = PRESSURE_IS_OK;
    }

    public String getSTORAGES() {
        return STORAGES;
    }

    public void setSTORAGES(String STORAGES) {
        this.STORAGES = STORAGES;
    }

    public String getSTORAGES_IS_OK() {
        return STORAGES_IS_OK;
    }

    public void setSTORAGES_IS_OK(String STORAGES_IS_OK) {
        this.STORAGES_IS_OK = STORAGES_IS_OK;
    }

    public String getIS_SABOTEUR() {
        return IS_SABOTEUR;
    }

    public void setIS_SABOTEUR(String IS_SABOTEUR) {
        this.IS_SABOTEUR = IS_SABOTEUR;
    }

    public String getIS_STEALGAS() {
        return IS_STEALGAS;
    }

    public void setIS_STEALGAS(String IS_STEALGAS) {
        this.IS_STEALGAS = IS_STEALGAS;
    }

    public String getTASK_ID() {
        return TASK_ID;
    }

    public void setTASK_ID(String TASK_ID) {
        this.TASK_ID = TASK_ID;
    }

    public String getTASK_STATE() {
        return TASK_STATE;
    }

    public void setTASK_STATE(String TASK_STATE) {
        this.TASK_STATE = TASK_STATE;
    }

    public String getIS_TASK() {
        return IS_TASK;
    }

    public void setIS_TASK(String IS_TASK) {
        this.IS_TASK = IS_TASK;
    }

    public String getCAR_STATUS() {
        return CAR_STATUS;
    }

    public void setCAR_STATUS(String CAR_STATUS) {
        this.CAR_STATUS = CAR_STATUS;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public String getCAR_LOCATION_X() {
        return CAR_LOCATION_X;
    }

    public void setCAR_LOCATION_X(String CAR_LOCATION_X) {
        this.CAR_LOCATION_X = CAR_LOCATION_X;
    }

    public String getCAR_LOCATION_Y() {
        return CAR_LOCATION_Y;
    }

    public void setCAR_LOCATION_Y(String CAR_LOCATION_Y) {
        this.CAR_LOCATION_Y = CAR_LOCATION_Y;
    }

    public int getSPEED() {
        return SPEED;
    }

    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    }

    public float getDISTANCE() {
        return DISTANCE;
    }

    public void setDISTANCE(float DISTANCE) {
        this.DISTANCE = DISTANCE;
    }

    public String getPLAN_LOAD_TIME() {
        return PLAN_LOAD_TIME;
    }

    public void setPLAN_LOAD_TIME(String PLAN_LOAD_TIME) {
        this.PLAN_LOAD_TIME = PLAN_LOAD_TIME;
    }

    public String getPREDICT_LOAD_TIME() {
        return PREDICT_LOAD_TIME;
    }

    public void setPREDICT_LOAD_TIME(String PREDICT_LOAD_TIME) {
        this.PREDICT_LOAD_TIME = PREDICT_LOAD_TIME;
    }

    public String getLOAD_BEGIN_TIME() {
        return LOAD_BEGIN_TIME;
    }

    public void setLOAD_BEGIN_TIME(String LOAD_BEGIN_TIME) {
        this.LOAD_BEGIN_TIME = LOAD_BEGIN_TIME;
    }

    public String getLOADWARN() {
        return LOADWARN;
    }

    public void setLOADWARN(String LOADWARN) {
        this.LOADWARN = LOADWARN;
    }

    public String getPLAN_UNLOAD_TIME() {
        return PLAN_UNLOAD_TIME;
    }

    public void setPLAN_UNLOAD_TIME(String PLAN_UNLOAD_TIME) {
        this.PLAN_UNLOAD_TIME = PLAN_UNLOAD_TIME;
    }

    public String getPREDICT_ARRIVE_TIME() {
        return PREDICT_ARRIVE_TIME;
    }

    public void setPREDICT_ARRIVE_TIME(String PREDICT_ARRIVE_TIME) {
        this.PREDICT_ARRIVE_TIME = PREDICT_ARRIVE_TIME;
    }

    public String getUNLOAD_BEGIN_TIME() {
        return UNLOAD_BEGIN_TIME;
    }

    public void setUNLOAD_BEGIN_TIME(String UNLOAD_BEGIN_TIME) {
        this.UNLOAD_BEGIN_TIME = UNLOAD_BEGIN_TIME;
    }

    public String getARRIVEWARN() {
        return ARRIVEWARN;
    }

    public void setARRIVEWARN(String ARRIVEWARN) {
        this.ARRIVEWARN = ARRIVEWARN;
    }

    public String getPROVIDER_NAME() {
        return PROVIDER_NAME;
    }

    public void setPROVIDER_NAME(String PROVIDER_NAME) {
        this.PROVIDER_NAME = PROVIDER_NAME;
    }

    public String getDRIVER_NAME() {
        return DRIVER_NAME;
    }

    public void setDRIVER_NAME(String DRIVER_NAME) {
        this.DRIVER_NAME = DRIVER_NAME;
    }

    public String getDRIVER_PHONE() {
        return DRIVER_PHONE;
    }

    public void setDRIVER_PHONE(String DRIVER_PHONE) {
        this.DRIVER_PHONE = DRIVER_PHONE;
    }

    public String getTRUCK_TOU_NO() {
        return TRUCK_TOU_NO;
    }

    public void setTRUCK_TOU_NO(String TRUCK_TOU_NO) {
        this.TRUCK_TOU_NO = TRUCK_TOU_NO;
    }

    public String getTRUCK_PAI_NO() {
        return TRUCK_PAI_NO;
    }

    public void setTRUCK_PAI_NO(String TRUCK_PAI_NO) {
        this.TRUCK_PAI_NO = TRUCK_PAI_NO;
    }

    public String getSOURCE_NAME() {
        return SOURCE_NAME;
    }

    public void setSOURCE_NAME(String SOURCE_NAME) {
        this.SOURCE_NAME = SOURCE_NAME;
    }

    public String getSOURCE_LOCATION_X() {
        return SOURCE_LOCATION_X;
    }

    public void setSOURCE_LOCATION_X(String SOURCE_LOCATION_X) {
        this.SOURCE_LOCATION_X = SOURCE_LOCATION_X;
    }

    public String getSOURCE_LOCATION_Y() {
        return SOURCE_LOCATION_Y;
    }

    public void setSOURCE_LOCATION_Y(String SOURCE_LOCATION_Y) {
        this.SOURCE_LOCATION_Y = SOURCE_LOCATION_Y;
    }

    public String getSTATION_NAME() {
        return STATION_NAME;
    }

    public void setSTATION_NAME(String STATION_NAME) {
        this.STATION_NAME = STATION_NAME;
    }

    public String getSTATION_LOCATION_X() {
        return STATION_LOCATION_X;
    }

    public void setSTATION_LOCATION_X(String STATION_LOCATION_X) {
        this.STATION_LOCATION_X = STATION_LOCATION_X;
    }

    public String getSTATION_LOCATION_Y() {
        return STATION_LOCATION_Y;
    }

    public void setSTATION_LOCATION_Y(String STATION_LOCATION_Y) {
        this.STATION_LOCATION_Y = STATION_LOCATION_Y;
    }

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }

    @Override
    public String toString() {
        return "RealtimeCar{" +
                "TASK_ID='" + TASK_ID + '\'' +
                ", TASK_STATE='" + TASK_STATE + '\'' +
                ", IS_TASK='" + IS_TASK + '\'' +
                ", CAR_STATUS='" + CAR_STATUS + '\'' +
                ", LOCATION='" + LOCATION + '\'' +
                ", CAR_LOCATION_X='" + CAR_LOCATION_X + '\'' +
                ", CAR_LOCATION_Y='" + CAR_LOCATION_Y + '\'' +
                ", SPEED=" + SPEED +
                ", DISTANCE=" + DISTANCE +
                ", TEMPERATURE='" + TEMPERATURE + '\'' +
                ", TEMPERATRUE_IS_OK='" + TEMPERATRUE_IS_OK + '\'' +
                ", LIQUID_LEVEL='" + LIQUID_LEVEL + '\'' +
                ", LIQUID_IS_OK='" + LIQUID_IS_OK + '\'' +
                ", PRESSURE='" + PRESSURE + '\'' +
                ", PRESSURE_IS_OK='" + PRESSURE_IS_OK + '\'' +
                ", STORAGES='" + STORAGES + '\'' +
                ", STORAGES_IS_OK='" + STORAGES_IS_OK + '\'' +
                ", IS_SABOTEUR='" + IS_SABOTEUR + '\'' +
                ", IS_STEALGAS='" + IS_STEALGAS + '\'' +
                ", PLAN_LOAD_TIME='" + PLAN_LOAD_TIME + '\'' +
                ", PREDICT_LOAD_TIME='" + PREDICT_LOAD_TIME + '\'' +
                ", LOAD_BEGIN_TIME='" + LOAD_BEGIN_TIME + '\'' +
                ", LOADWARN='" + LOADWARN + '\'' +
                ", PLAN_UNLOAD_TIME='" + PLAN_UNLOAD_TIME + '\'' +
                ", PREDICT_ARRIVE_TIME='" + PREDICT_ARRIVE_TIME + '\'' +
                ", UNLOAD_BEGIN_TIME='" + UNLOAD_BEGIN_TIME + '\'' +
                ", ARRIVEWARN='" + ARRIVEWARN + '\'' +
                ", PROVIDER_NAME='" + PROVIDER_NAME + '\'' +
                ", DRIVER_NAME='" + DRIVER_NAME + '\'' +
                ", DRIVER_PHONE='" + DRIVER_PHONE + '\'' +
                ", TRUCK_TOU_NO='" + TRUCK_TOU_NO + '\'' +
                ", TRUCK_PAI_NO='" + TRUCK_PAI_NO + '\'' +
                ", SOURCE_NAME='" + SOURCE_NAME + '\'' +
                ", SOURCE_LOCATION_X='" + SOURCE_LOCATION_X + '\'' +
                ", SOURCE_LOCATION_Y='" + SOURCE_LOCATION_Y + '\'' +
                ", STATION_NAME='" + STATION_NAME + '\'' +
                ", STATION_LOCATION_X='" + STATION_LOCATION_X + '\'' +
                ", STATION_LOCATION_Y='" + STATION_LOCATION_Y + '\'' +
                ", TIME='" + TIME + '\'' +
                '}';
    }
}
