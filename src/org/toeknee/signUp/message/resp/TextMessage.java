package org.toeknee.signUp.message.resp;

/**
 * Created by toeknee on 11/25/15.
 */
public class TextMessage extends BaseMessage {
	// Reply message content (Wrap: can show as a new line in WeChat client if you can wrap in content here.)
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
