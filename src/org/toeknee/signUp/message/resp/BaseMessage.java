package org.toeknee.signUp.message.resp;

/**
 * Created by toeknee on 11/25/15.
 */
public class BaseMessage {
	// the weChat account of the user (openID)
	private String ToUserName;
	// the weChat account of the admin platform
	private String FromUserName;
	// Message creation time (Integer)
	private long CreateTime;
	// Text
	private String MsgType;

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
}
