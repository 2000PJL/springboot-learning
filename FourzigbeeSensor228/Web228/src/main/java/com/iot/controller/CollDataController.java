package com.iot.controller;
/*
 * @Systemname: FourSensor228
 * @author:彭俊龙 201941882228
 * @Description:
 * @Date:Created  8:58 2021/12/1
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */

import com.iot.bluetooth228.BluetoothServer;
import com.iot.entity.CollData;
import com.iot.service228.CollDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

@Controller
public class CollDataController {

    @Autowired
    CollDataService collDataService;

    @Autowired
    BluetoothServer bluetoothServer;

    @GetMapping("")
    private String index()
    {
        return "index";
    }

    @GetMapping("/chart")
    private String chart()
    {
        return "chart";
    }


    @ResponseBody
    @GetMapping("/selectAllCollData")
    public List<CollData> selectAllCollData(){
        return collDataService.selectAllCollData();

    }

}
