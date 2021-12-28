package com.hunau.service228.impl;

import com.hunau.entity228.CollData;
import com.hunau.mapper228.CollDataMapper;
import com.hunau.service228.CollDataService;
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


    @Override
    public List<CollData> selectAllCollData() {
        return collDataMapper.selectAllCollData();
    }

    @Override
    public int countCollData() {
        return collDataMapper.countCollData();
    }

    @Override
    public int deleteCollDataById(int id) {
        return collDataMapper.deleteCollDataById(id);
    }

    @Override
    public int insertCollData(CollData collData) {
        return collDataMapper.insertCollData(collData);
    }

    @Override
    public int updateCollDateById(CollData collData) {
        return collDataMapper.updateCollDateById(collData);
    }
}
