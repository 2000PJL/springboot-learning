package com.hunau.controller;

import com.hunau.bluetooth228.BluetoothService;
import com.hunau.entity228.CollData;
import com.hunau.service228.CollDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.management.Sensor;

import java.io.IOException;
import java.util.List;

/**
 * @author TanXY
 * @date 2020/12/31 - 15:43
 */
@Controller
public class CollDataController {
    @Autowired
    CollDataService collDataService;
    BluetoothService bluetoothService=new BluetoothService();
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/showChart")
    public String showChart(){
        return "chart";
    }

    @ResponseBody
    @GetMapping("/selectAllCollData")
    public List<CollData> selectAllCollData(){
        return collDataService.selectAllCollData();
    }

    @ResponseBody
    @GetMapping("/countCollData")
    public int countCollData(){
        return collDataService.countCollData();
    }

    @ResponseBody
    @GetMapping("/deleteCollDataById")
    public int deleteCollDataById(int id){
        return collDataService.deleteCollDataById(id);
    }

    @ResponseBody
    @PostMapping("/insertCollData")
    public int insertCollData(@RequestBody CollData collData){
        return collDataService.insertCollData(collData);
    }

    @ResponseBody
    @PostMapping("/updateCollDataById")
    public int updateCollDataById(@RequestBody CollData collData){
        return collDataService.updateCollDateById(collData);
    }



}
