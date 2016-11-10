package com.enn.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.log4j.Logger;

/**
 * json解析
 * Created by yjr on 2016/8/2.
 */
public class Analysis {

   Logger logger = Logger.getLogger(Analysis.class);

    private static Analysis analy;

    public static Analysis GetAnalysis()
    {
        if (analy == null)
        {
            analy = new Analysis();
        }
        return analy;
    }

    /**
     * 解析距离
     * {"status":"1","info":"OK","infocode":"10000",
     * "results":[{"origin_id":"1","dest_id":"1","distance":"270430","duration":"14760"}]}
     *
     */
    public  Float analysisdistancejson(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        Float results=null;
        try{
            if(jsonObject!=null&&jsonObject.get("status").equals("1")&&jsonObject.get("info").equals("OK"))
            {
                results = jsonObject.getJSONArray("results").getJSONObject(0).getFloat("distance");
            }
            else
            {
                logger.info("距离查询错误");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        return results;
    }

    /**
     * 解析位置
     *只需要 市和区县
     */
    public  String namejson(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String city=null;
        String district=null;
        try{
            if(jsonObject!=null&&jsonObject.get("status").equals("1")&&jsonObject.get("info").equals("OK"))
            {
                city= jsonObject.getJSONObject("regeocode").getJSONObject("addressComponent").getString("city");
                district= jsonObject.getJSONObject("regeocode").getJSONObject("addressComponent").getString("district");
            }
            else
            {
                logger.info("地理位置查询错误");
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

        city="[]".equals(city)?"":(city==null?"":city);
        district="[]".equals(district)?"":(district==null?"":district);
        //district=district.equals("[]")?"":district;
        return city+district;
    }
}
