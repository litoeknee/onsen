package org.toeknee.signUp.message.req;

/**
 * Created by toeknee on 11/25/15.
 */

public class VoiceMessage extends BaseMessage {
	// ID number of the voice message
	private String MediaId;
	// format of the voice message, usually amr
	private String Format;
	// results of voice recognition, encoded UTF8
	private String Recognition;

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}
}
