package com.hunau.service228;

import com.hunau.entity228.CollData;


import java.util.List;

/**
 * @ClassName: CollDataService
 * @Description:
 * @Author: 薛莎莎
 * @Date: 2021/3/26 10:33
 * @Version:1.0
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright:综合训练系统V1.0
 * @ReWriting: Justina
 */
public interface CollDataService {
    /**
     * @Author xss
     * @Description //TODO 查询采集到的所有数据
     * @Date 10:35 2021/3/26
     * @Param []
     * @return java.util.List<com.hunau.entity228.CollData>
     **/
    List<CollData> selectAllCollData();

    /**
     * @Author xss
     * @Description //TODO 查询数据总量，用于分页
     * @Date 10:36 2021/3/26
     * @Param []
     * @return int
     **/
    int countCollData();

    /**
     * @Author xss
     * @Description //TODO 根据id删除数据
     * @Date 10:40 2021/3/26
     * @Param [id]
     * @return int
     **/
    int deleteCollDataById(int id);

    /**
     * @Author xss
     * @Description //TODO 插入采集到的数据
     * @Date 10:41 2021/3/26
     * @Param [collData]
     * @return int
     **/
    int insertCollData(CollData collData);

    /**
     * @Author xss
     * @Description //TODO 根据id修改数据
     * @Date 10:45 2021/3/26
     * @Param [collData]
     * @return int
     **/
    int updateCollDateById(CollData collData);

}
