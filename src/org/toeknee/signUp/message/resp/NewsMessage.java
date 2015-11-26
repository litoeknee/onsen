package org.toeknee.signUp.message.resp;

import java.util.List;

/**
 * Created by toeknee on 11/25/15.
 */
public class NewsMessage extends BaseMessage {
	// Quantity of rich media messages (up to 10)
	private int ArticleCount;
	// The content of rich media messages.
    // The first item is displayed as a large image by default.
    // No response is given if more than 10 messages exist.
	private List<Article> Articles;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return Articles;
	}

	public void setArticles(List<Article> articles) {
		Articles = articles;
	}
}
