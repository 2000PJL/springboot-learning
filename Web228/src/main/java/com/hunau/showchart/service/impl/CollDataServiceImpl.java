package com.hunau.showchart.service.impl;


import com.hunau.showchart.entity.CollData;
import com.hunau.showchart.mapper.CollDataMapper;
import com.hunau.showchart.service.CollDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CollDataServiceImpl
 * @Description:
 * @Author: 薛莎莎
 * @Date: 2021/3/26 10:54
 * @Version:1.0
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright:综合训练系统V1.0
 * @ReWriting: Justina
 */
@Service
public class CollDataServiceImpl implements CollDataService {

    @Autowired
    CollDataMapper collDataMapper;

    public List<CollData> selectAllCollData() {
        return collDataMapper.selectAllCollData();
    }

    public int countCollData() {
        return collDataMapper.countCollData();
    }

    public int deleteCollDataById(int id) {
        return collDataMapper.deleteCollDataById(id);
    }

    public int insertCollData(CollData collData) {
        return collDataMapper.insertCollData(collData);
    }

    public int updateCollDateById(CollData collData) {
        return collDataMapper.updateCollDateById(collData);
    }
}

