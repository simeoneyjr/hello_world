package com.enn.main;

import com.enn.domain.RealtimeCar;
import com.enn.service.SqlSentence;
import com.enn.service.UpdateCar;
import com.enn.util.Analysis;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.List;

/**
 * Created by yjr on 2016/8/2.
 */
public class Main {
    static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args)  {
        logger.info("start ----: 程序开始执行   ");
        try{
            UpdateCar upcar=UpdateCar.GetUpdateCar();
            SqlSentence sql= SqlSentence.GetSqlSentence();
            sql.DeleteOld();
            List<RealtimeCar> carlist= upcar.upcarinfo(sql.select(),sql.selecttankcar(),sql.selecthistory());
            sql.DeleteandInsert(carlist);
            sql.inserthistory(carlist);
            logger.info("end ----:success    ");
        }catch (Exception e){
            logger.error("程序出错");
            logger.error("end  ----:  error  ");
        }
    }
}
