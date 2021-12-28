package com.hunau.showchart.controller;

import com.hunau.showchart.entity.CollData;
import com.hunau.showchart.service.CollDataService;
import com.hunau.showchart.bluetooth.BluetoothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.microedition.io.StreamConnection;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: CollDataController
 * @Description:
 * @Author: 薛莎莎
 * @Date: 2021/3/26 11:16
 * @Version:1.0
 * @Unitname:湖南农业大学信息学院物联网工程系
 * @Copyright:综合训练系统V1.0
 * @ReWriting: Justina
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

    @ResponseBody
    @GetMapping("/changeLED")
    public int changeStatus(boolean status) throws IOException {
        if (status){
            bluetoothService.str="#OLED$";
        } else {
            bluetoothService.str="#CLED$";
        }

        return 1;
    }

    @ResponseBody
    @GetMapping("/changeBeep")
    public int changeBeep(boolean status) throws IOException {
        if (status){
            bluetoothService.str="#OBEEP";
        } else {
            bluetoothService.str="#CBEEP";
        }

        return 1;
    }
//    @ResponseBody
//    @GetMapping("/changeBeep")
//    public int changeBeep(boolean status){
//        if (status){
//            NettyServer.equipmentChannel.writeAndFlush("#oBeep$");
//        } else {
//            NettyServer.equipmentChannel.writeAndFlush("#cBeep$");
//        }
//
//        return 1;
//    }
}
