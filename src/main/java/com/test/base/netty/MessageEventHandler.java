package com.test.base.netty;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import com.test.entity.ClientInfo;
import com.test.entity.MessageInfo;
import com.test.entity.Scrap;
import com.test.entity.User;
import com.test.repository.ClientInfoDao;
import com.test.repository.ScrapDao;
import com.test.repository.UserDao;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Component
public class MessageEventHandler {
    private final SocketIOServer server;

    @Autowired
    private ClientInfoDao clientInfoDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private ScrapDao scrapDao;

    @Autowired
    public MessageEventHandler(SocketIOServer server) {
        this.server = server;
    }

    @OnConnect
    public void onConnect(SocketIOClient client) {
        String clientId = client.getHandshakeData().getSingleUrlParam("userName");
        System.out.println();
        System.out.println("连接事件");
        System.out.println(clientId+"链接上服务器了");
        System.out.println();
//        ClientInfo clientInfo = clientInfoDao.findClientInfoByClientId(clientId);
        User clientInfo = userDao.getByName(clientId);
        if (clientInfo != null) {
            Date nowTime = new Date(System.currentTimeMillis());
            clientInfo.setConnected((short) 1);
            clientInfo.setLeastconnectedDate(nowTime);
            clientInfo.setSessionId(client.getSessionId());
            userDao.save(clientInfo);
        }
    }

    @OnDisconnect
    public void onDisConnect(SocketIOClient client) {
        System.out.println();
        System.out.println("断开连接事件");
        System.out.println();
        String clientId = client.getHandshakeData().getSingleUrlParam("userName");
        User clientInfo = userDao.getByName(clientId);
        if (clientInfo != null) {
            clientInfo.setConnected((short) 0);
            clientInfo.setSessionId(null);
            userDao.save(clientInfo);
        }
    }

    @OnEvent(value = "messageevent")
    public void onEvent(SocketIOClient client, MessageInfo data, AckRequest request) {
        System.out.println();
        System.out.println("消息事件");
        System.out.println();
        String targetClientId = data.getTargetClientId();
        User clientInfo = userDao.getByName(targetClientId);
        if (clientInfo != null && clientInfo.getConnected() != 0) {
            MessageInfo sendData = new MessageInfo();
            sendData.setSourceClientId(data.getSourceClientId());
            sendData.setTargetClientId(data.getTargetClientId());
            sendData.setMsgType("chat");
            sendData.setMsgContext(data.getMsgContext());
            client.sendEvent("messageevent", sendData);
            Collection<SocketIOClient> collection = server.getAllClients();
            for (int i = 0; i < collection.size(); i++) {
                SocketIOClient indexClient = (SocketIOClient)collection.toArray()[i];
                System.out.println(indexClient.getSessionId().toString());
                if (indexClient.equals(client)){
                    continue;
                }
                indexClient.sendEvent("messageevent", sendData);
            }
        }
    }

/**
  *  @OnEvent(value="")
  *  public void sendBoost(SocketIOClient client, MessageInfo data, AckRequest request){
  *      System.out.println();
  *      System.out.println("推送事件");
  *      System.out.println();
  *      ClientInfo clientInfo = clientInfoDao.findClientInfoByClientId(data.getTargetClientId());
  *      if (clientInfo != null && clientInfo.getConnected() != 0) {
  *             List<Scrap> list = scrapDao.getOneByScrapCreator(clientInfo.getClientId());
  *             if ()
  *          server.getClient(clientInfo.getSessiongId()).sendEvent("messageevent",);
  *      }
  *  }
*/

    public boolean isNew(Scrap newScrap,Scrap oldScrap){
        if (newScrap!=null && oldScrap!=null){
            if (newScrap.getScrapCreatime().before(oldScrap.getScrapCreatime())){
                return true;
            }
        }
        return false;
    }
}
