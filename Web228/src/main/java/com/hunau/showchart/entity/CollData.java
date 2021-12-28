package com.hunau.showchart.entity;

import lombok.Data;

/**
 * @ClassName: CollData
 * @Description:
 * @Author: 薛莎莎
 * @Date: 2021/3/26 10:21
 * @Version:1.0
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright:综合训练系统V1.0
 * @ReWriting: Justina
 */
@Data
public class CollData {

    private long id;
    /*光敏*/
    private String supersonic;

    private String temp;

    private String hum;

    private String colltime;

    private String address;

    private String ispermit;

    public void setId(long id) {
        this.id = id;
    }

    public void setSupersonic(String supersonic) {
        this.supersonic = supersonic;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public void setHum(String hum) {
        this.hum = hum;
    }

    public void setColltime(String colltime) {
        this.colltime = colltime;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIspermit(String ispermit) {
        this.ispermit = ispermit;
    }
}
