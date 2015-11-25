package org.toeknee.signUp.message.req;

/**
 * Created by toeknee on 11/25/15.
 */
public class TextMessage extends BaseMessage {
    // content of the text message
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}