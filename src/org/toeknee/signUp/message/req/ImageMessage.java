package org.toeknee.signUp.message.req;

/**
 * Created by toeknee on 11/25/15.
 */

public class ImageMessage extends BaseMessage {
	// link of the picture resource
	private String PicUrl;
    // ID number of the picture message
    private String MediaId;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
