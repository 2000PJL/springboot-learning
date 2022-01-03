package com.hunau.service228.impl;/*
 * @Systemname: exam228test01
 * @author:彭俊龙 201941882228
 * @Description:
 * @Date:Created  14:36 2022/1/3
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */

import com.hunau.entity.CollData;
import com.hunau.service228.CollDataService;
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
