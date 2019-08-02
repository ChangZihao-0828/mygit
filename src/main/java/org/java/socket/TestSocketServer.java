package org.java.socket;

import com.alibaba.fastjson.JSON;
import org.java.entity.Info;
import org.java.entity.Message;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 昌子豪
 * @Date: 2019/7/31 15:45
 * @Description: Frighting!!!
 */


@ServerEndpoint("/chat")
@Component
public class TestSocketServer {

    private static List<Session> listSession = new ArrayList<>();

    private static List<String> users = new ArrayList<>();     //用于保存所有进入的用户名

    private String user;        //当前用户

    private static Map<String,Session> mapSes = new HashMap<>();


    @OnOpen
    public void open(Session session) throws IOException {

        System.out.println("通道已连接，编号为"+session.getId());

        String queryString = session.getQueryString();

        queryString= URLDecoder.decode(queryString, "UTF-8");

        user = queryString.split("=")[1];

        users.add(user);

        listSession.add(session);

        mapSes.put(user,session);

        String welcome = "<b>欢迎<span style='color:red'>"+user+"</span>来到聊天室</b>";

        Message message = new Message();

        message.setWelcome(welcome);

        message.setNames(users);

        broadCast(JSON.toJSONString(message));
    }


    public void broadCast(String json) throws IOException {

        for (Session ses:listSession){

            ses.getBasicRemote().sendText(json);
        }
    }



    @OnMessage
    public void showMsg(Session session,String json) throws IOException {

        Info info = JSON.parseObject(json,Info.class);

        System.out.println("========================");

        if (info.getType()==1){

            session.getBasicRemote().sendText("服务器已收到发送的消息"+json);

            Message message = new Message();

            message.setMsg(info.getMsg(),user);

            broadCast(JSON.toJSONString(message));

        }else {

            String toUser = info.getToUser();

            String[] toUsers = toUser.split(",");

            Message message = new Message();

            String msg = "<b><span style='color:red'>["+user+"]</span>说："+info.getMsg()+"</b>";

            message.setMsg(msg);

            message.setType(2);

            message.setFromUser(user);

            for (String user:toUsers){

                Session toSession =  mapSes.get(user);

                toSession.getBasicRemote().sendText(JSON.toJSONString(message));
            }

            session.getBasicRemote().sendText(JSON.toJSONString(message));


        }



    }


    @OnClose
    public void close(Session session) throws IOException {

        listSession.remove(session);

        users.remove(user);

        Message message = new Message();

        String welcome = "<b><span style='color:red'>"+user+"</span>退出聊天室</b>";

        message.setWelcome(welcome);

        message.setNames(users);

        broadCast(JSON.toJSONString(message));

    }
}
