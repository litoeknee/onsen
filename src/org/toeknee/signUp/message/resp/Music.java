package org.toeknee.signUp.message.resp;

/**
 * Created by toeknee on 11/25/15.
 */
public class Music {
	// Music title
	private String Title;
	// Music description
	private String Description;
	// URL for music
	private String MusicUrl;
	// URL that WeChat accesses on Wi-Fi for high quality music
	private String HQMusicUrl;
	// The thumb multimedia ID that is obtained by uploading a multimedia file
	private String ThumbMediaId;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMusicUrl() {
		return MusicUrl;
	}

	public void setMusicUrl(String musicUrl) {
		MusicUrl = musicUrl;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String musicUrl) {
		HQMusicUrl = musicUrl;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
}
