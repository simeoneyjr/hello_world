package com.enn.service;

import com.enn.util.GeographyPoint;

import java.io.UnsupportedEncodingException;

/**
 * Created by yjr on 2016/8/2.
 */
public interface MapService {

    /**
     * 地图距离测算 调用高德地图
     *
     * @param两个点的经纬度
     *
     * @return 两点之间的距离
     *
     */
    public Float distance(GeographyPoint pont1, GeographyPoint point2);

    /**
     * 地理逆地理编码  调用高德地图
     *
     * @param point(一个点的经纬度)
     *
     * @return 地理位置名称
     */
     public String geographyname(GeographyPoint point);
}
