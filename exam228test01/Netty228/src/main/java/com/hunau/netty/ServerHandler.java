package com.hunau.netty;/*
 * @Systemname: exam228test01
 * @author:彭俊龙 201941882228
 * @Description:
 * @Date:Created  9:47 2022/1/4
 * @Copyright: 彭俊龙
 * @Rewriting:彭俊龙
 */

import com.hunau.service228.CollDataService;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;
import com.hunau.entity.CollData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

//@Slf4j
@Component
public class ServerHandler extends ChannelInboundHandlerAdapter {
    @Autowired
    CollDataService collDataService;

    static ServerHandler serverHandler;

    private static final String FRAME_HEAD = "#";

    private static final String FRAME_TAIL = "$";

    private static final int FRAME_LEN = 6;

    public ServerHandler() {
    }

    @PostConstruct
    public void init() {
        serverHandler = this;
        serverHandler.collDataService = this.collDataService;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        InetSocketAddress inetSocketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = inetSocketAddress.getAddress().getHostAddress();
        System.err.println(ctx.channel());
     //   log.info("client【" + clientIp + "】connected......");
        System.err.println("client【" + clientIp + "】connected......");

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        InetSocketAddress inetSocketAddress = (InetSocketAddress) ctx.channel().remoteAddress();
        String clientIp = inetSocketAddress.getAddress().getHostAddress();

        String received = msg.toString();
      //  log.info("received data from【" + clientIp + "】==>" + received);
        System.out.println("received data from【" + clientIp + "】==>" + received);

        String[] split = received.split(",");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = new Date();
        CollData collData = new CollData();
        if (split.length == 6 && FRAME_HEAD.equals(split[0]) && FRAME_TAIL.equals(split[5])) {
            collData.setSupersonic((split[1]));
            collData.setLight((split[2]));
            collData.setHum((split[3]));
            collData.setTemp((split[4]));
            // collData.setIp(clientIp);
            collData.setColltime(df.format(time));

            serverHandler.collDataService.insertCollData(collData);
        }
        }


        @Override
        public void channelInactive (ChannelHandlerContext ctx){
            // log.info("客户端【" + ctx.channel() + "】断开连接！");
            System.err.println("客户端【" + ctx.channel() + "】断开连接！");
        }

}
