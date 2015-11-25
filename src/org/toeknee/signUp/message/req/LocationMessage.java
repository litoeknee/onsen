package org.toeknee.signUp.message.req;

/**
 * Created by toeknee on 11/25/15.
 */

public class LocationMessage extends BaseMessage {
    // latitude of the location
	private String Location_X;
    // longitude of the location
	private String Location_Y;
    // scale of the map
	private String Scale;
    // label of the location
	private String Label;

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}
}
