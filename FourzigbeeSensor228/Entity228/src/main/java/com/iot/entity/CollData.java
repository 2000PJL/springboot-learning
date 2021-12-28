package com.iot.entity;/*
 * @Systemname: FourSensor228
 * @author:彭俊龙 201941882228
 * @Description:
 * @Date:Created  8:33 2021/12/1
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */

import lombok.Data;

@Data
public class CollData {

    private long id;

    private String temp;

    private String hum;

    private String supersonic;

    private String light;

    private String colltime;

    private String address;

}
