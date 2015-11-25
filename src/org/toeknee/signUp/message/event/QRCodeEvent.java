package org.toeknee.signUp.message.event;

/**
 * Created by toeknee on 11/25/15.
 */
public class QRCodeEvent extends BaseEvent {
	// key value of the QRCode event, if
    //  1.the user is not a follower, the event type will be "subscribe"
    //      and the event key will start by "qrscene_" as a prefix followed by the parameter value ​​for the QR Code
    //  2.the user is a follower, the event type will be "scan"
    //      and the event key will be a 32-bit unsigned integer which is the QR Code scene_id
	private String EventKey;
	// ticket of the QRCode which can be exchanged a QR Code image
	private String Ticket;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}
}
