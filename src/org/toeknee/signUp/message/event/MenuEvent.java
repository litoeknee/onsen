package org.toeknee.signUp.message.event;

/**
 * Created by toeknee on 11/25/15.
 */
public class MenuEvent extends BaseEvent {
	// key value of the menu event, if
	//  1.it's a pulling message event, the event type will be "click"
	//      and the event key will correspond to the KEY value in the user-defined menu API
	//  2.it'a URL redirection event, the event type will be "view"
	//      and the event key will corresponds to the URL to be redirected to
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
