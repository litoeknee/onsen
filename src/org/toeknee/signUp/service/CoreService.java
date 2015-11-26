package org.toeknee.signUp.service;

/**
 * Created by toeknee on 11/26/15.
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.toeknee.signUp.message.resp.Article;
import org.toeknee.signUp.message.resp.NewsMessage;
import org.toeknee.signUp.message.resp.TextMessage;
import org.toeknee.signUp.util.MessageUtil;

public class CoreService {
    /**
     * build the response XMl for the request from weChat server
     *
     * @param request
     * @return xml
     */
    public static String processRequest(HttpServletRequest request) {
        String respXml = null;
        // default response content
        String respContent = "unknown message type";
        try {
            // using parseXMl method to parse the request
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            String fromUserName = requestMap.get("FromUserName");
            String toUserName = requestMap.get("ToUserName");
            String msgType = requestMap.get("MsgType");

            // build a text message to respond
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                respContent = "Get a text message!";
            }
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "Get an image message!";
            }
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "Get a voice message!";
            }
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
                respContent = "Get a video message!";
            }
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_SHORT_VIDEO)) {
                respContent = "Get a short video message!";
            }
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "Get a location message!";
            }
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "Get a link message!";
            }

            textMessage.setContent(respContent);
            respXml = MessageUtil.messageToXml(textMessage);

            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                String eventType = requestMap.get("Event");
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    textMessage.setContent("Thank you for subscribe!");
                    respXml = MessageUtil.messageToXml(textMessage);
                }
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO no need to respond
                }
                else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
                    // TODO scan event
                }
                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
                    // TODO location event
                }
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    String eventKey = requestMap.get("EventKey");
                    if (eventKey.equals("enrollClass")) {
                        Article article = new Article();
                        article.setTitle("enroll test");
                        article.setDescription("if you want to enroll this class\n\njust wait\n\nfor the next version");
                        article.setPicUrl("");
                        article.setUrl("http://www.baidu.com");
                        List<Article> articleList = new ArrayList<Article>();
                        articleList.add(article);

                        NewsMessage newsMessage = new NewsMessage();
                        newsMessage.setToUserName(fromUserName);
                        newsMessage.setFromUserName(toUserName);
                        newsMessage.setCreateTime(new Date().getTime());
                        newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                        newsMessage.setArticleCount(articleList.size());
                        newsMessage.setArticles(articleList);
                        respXml = MessageUtil.messageToXml(newsMessage);
                    } else {
                        textMessage.setContent("that's only the demo version for click!");
                        respXml = MessageUtil.messageToXml(textMessage);
                    }
                }
                else if (eventType.equals(MessageUtil.EVENT_TYPE_VIEW)) {
                    textMessage.setContent("that's only the demo version for view!!");
                    respXml = MessageUtil.messageToXml(textMessage);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }
}
