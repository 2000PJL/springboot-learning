package com.hunau.controller;/*
 * @Systemname: exam228test01
 * @author:彭俊龙 201941882228
 * @Description:
 * @Date:Created  15:12 2022/1/3
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */

import com.hunau.bluetooth228.BluetoothServer;
import com.hunau.entity.CollData;
import com.hunau.service228.CollDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
