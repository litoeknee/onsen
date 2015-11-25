package org.toeknee.signUp.message.req;

/**
 * Created by toeknee on 11/25/15.
 */
public class BaseMessage {
    // the weChat account of the admin platform
    private String ToUserName;
    // the weChat account of the user
    private String FromUserName;
    // time of creating the message
    private long CreateTime;
    // type of the message
    private String MsgType;
    // ID number of the message
    private long MsgId;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public long getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(long createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
