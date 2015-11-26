package org.toeknee.signUp.message.resp;

/**
 * Created by toeknee on 11/25/15.
 */
public class Article {
	// Title of the rich media message
	private String Title;
	// Description of the rich media message
	private String Description;
	// URL of images in rich media messages.
	// Recommended image size: 360*200 (large image); 200*200 (small image)
    // Image format supported: JPG and PNG
	private String PicUrl;
	// Redirection link of the rich media message
	private String Url;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
        if (null != Description) {
            return Description;
        } else {
            return "";
        }
    }

	public void setDescription(String description) {
		Description = description;
	}

	public String getPicUrl() {
        if (null != PicUrl) {
            return PicUrl;
        } else {
            return "";
        }
    }

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getUrl() {
        if (null != Url) {
            return Url;
        } else {
            return "";
        }
    }

	public void setUrl(String url) {
		Url = url;
	}
}
