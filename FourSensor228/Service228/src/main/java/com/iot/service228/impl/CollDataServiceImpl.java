package com.iot.service228.impl;/*
 * @Systemname: FourSensor228
 * @author:彭俊龙 201941882228
 * @Description:
 * @Date:Created  8:53 2021/12/1
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */

import com.iot.entity.CollData;
import com.iot.service228.CollDataService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollDataServiceImpl implements CollDataService {

    @Override
    public List<CollData> selectAllCollData() {
        return null;
    }

    @Override
    public int countCollData() {
        return 0;
    }

    @Override
    public int deleteCollDataById(int id) {
        return 0;
    }

    @Override
    public int insertCollData(CollData collData) {
        return 0;
    }

    @Override
    public int updateCollDateById(CollData collData) {
        return 0;
    }
}
