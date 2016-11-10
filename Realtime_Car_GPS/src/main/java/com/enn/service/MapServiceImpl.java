package com.enn.service;

import com.enn.util.Analysis;
import com.enn.util.GeographyPoint;
import com.enn.util.HttpClientUtil;
import org.apache.log4j.Logger;


/**
 * Created by yjr on 2016/8/2.
 */
public class MapServiceImpl implements MapService {

    private static MapServiceImpl service;
    Logger logger = Logger.getLogger(MapServiceImpl.class);


    public static MapServiceImpl GetMapServiceImpl()
    {
        if (service == null)
        {
            service = new MapServiceImpl();
        }
        return service;
    }

    private static final String key = "09cd5e36fd4fa6c6f8755eba2a2448ce"; //key
    private String  distanceurl="http://restapi.amap.com/v3/distance?";
    private String  nameurl="http://restapi.amap.com/v3/geocode/regeo?output=json&";
    Analysis an=Analysis.GetAnalysis();

    /**
     *  查询两点之间距离
     *  http://restapi.amap.com/v3/distance?origins=116.481028,39.989643|114.481028,39.989643|
     *  115.481028,39.989643&destination=114.465302,40.004717&output=xml&key=<用户的key>
     *
     */

    public Float distance(GeographyPoint point1, GeographyPoint point2) {
        String url=distanceurl+"origins="+point1.getpointX()+","+point1.getpointY()+
                "&destination="+point2.getpointX()+","+point2.getpointY()+"&output=json"+"&key="+
                key+"&type=1";
        //System.out.println("url:" + url);
        return an.analysisdistancejson(this.getInfo(url));
    }

    /**
     * 查询位置信息
     * http://restapi.amap.com/v3/geocode/regeo?output=json&
     * location=116.310003,39.991957&key=<用户的key>&radius=1000&extensions=all
     *
     */
    public String geographyname(GeographyPoint point) {
        String url=nameurl+"location="+point.getpointX()+","+point.getpointY()+
                "&key="+key+"&radius=1000&extensions=base&batch=false";
        //System.out.println("url:" + url);

        return an.namejson(this.getInfo(url));
    }

    /**
     *如果连接超时，就重复连接
     *
     */
    private String getInfo(String url)
    {
        String responseContent=null;
        int i=10;
        try{
            while (i>0){
                i--;
                responseContent = HttpClientUtil.getInstance()
                        .sendHttpGet(url);
                if(responseContent !=null)
                {
                    break;
                }
            }
        }catch (Exception e){
            logger.error("链接高德地图超时");
            e.printStackTrace();
        }

        return responseContent;
    }

}
