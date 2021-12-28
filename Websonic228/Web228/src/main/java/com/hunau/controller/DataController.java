package com.hunau.controller;
/*
 * @Systemname: Websonic228
 * @author:彭俊龙 201941882228
 * @Description:
 * @Date:Created  9:22 2021/11/22
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */

import com.hunau.bluetooth.BluetoothServer;
import com.iot.service.CollDataService;
import com.iot.domain.CollData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;

/**
 * @author 19853
 */
@Controller
public class DataController {


    @Autowired
    CollDataService collDataService;

    @Autowired
    BluetoothServer bluetoothServer;


    @GetMapping("")
    private  String index() {
        return "index";
    }

    @GetMapping("/chart")
    private  String chart() {
        return "chart";
    }


    @ResponseBody
    @GetMapping("/selectAllCollData")
    public List<CollData> selectAllCollData(){
        return collDataService.selectAllCollData();

    }

    @ResponseBody
    @GetMapping("/changeLED")
    public int changeStatus(boolean status) throws IOException {
        if (status){
            BluetoothServer.str="#OLED$";
        } else {
            BluetoothServer.str="#CLED$";
        }

        return 1;
    }

    @ResponseBody
    @GetMapping("/changeBeep")
    public int changeBeep(boolean status) throws IOException {
        if (status){
            BluetoothServer.str="#OBEEP";
        } else {
            BluetoothServer.str="#CBEEP";
        }

        return 1;
    }

}
