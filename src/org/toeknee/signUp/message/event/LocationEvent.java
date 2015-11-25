package org.toeknee.signUp.message.event;

/**
 * Created by toeknee on 11/25/15.
 */
public class LocationEvent extends BaseEvent {
	// latitude of the location
	private String Latitude;
	// longitude of the location
	private String Longitude;
	// precision of the location
	private String Precision;

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}
}
