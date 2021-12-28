package com.hunau.entity228;

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

    private String temp;

    private String supersonic;

    private String hum;

    private String ip;

    private String colltime;

    private String address;

}
