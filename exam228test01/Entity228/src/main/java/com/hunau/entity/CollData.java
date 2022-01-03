package com.hunau.entity;/*
 * @Systemname: exam228test01
 * @author:彭俊龙 201941882228
 * @Description:
 * @Date:Created  14:27 2022/1/3
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
