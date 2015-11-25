package org.toeknee.signUp.message.req;

/**
 * Created by toeknee on 11/25/15.
 */

public class VideoMessage extends BaseMessage {
	// ID number of the video message
	private String MediaId;
	// ID number of the video's thumbnail (picture)
	private String ThumbMediaId;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
}
