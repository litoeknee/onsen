package org.toeknee.signUp.message.req;

/**
 * Created by toeknee on 11/25/15.
 */

public class LinkMessage extends BaseMessage {
	// title of the link
	private String Title;
	// description of the link
	private String Description;
	// url of the link
	private String Url;

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

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
}
