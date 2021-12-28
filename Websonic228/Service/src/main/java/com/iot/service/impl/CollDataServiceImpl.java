package com.iot.service.impl;

import com.iot.domain.CollData;
import com.iot.mapper.CollDataMapper;
import com.iot.service.CollDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * @Systemname: Websonic228
 * @author:彭俊龙 201941882228
 * @Description:
 * @Date:Created  9:22 2021/11/22
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
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
