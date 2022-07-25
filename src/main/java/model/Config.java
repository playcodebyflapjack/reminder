package model;

import java.io.Serializable;

public class Config implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String tokenNoti;
	
	public String getTokenNoti() {
		return tokenNoti;
	}
	public void setTokenNoti(String tokenNoti) {
		this.tokenNoti = tokenNoti;
	}
}
