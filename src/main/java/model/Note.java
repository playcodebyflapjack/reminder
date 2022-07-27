package model;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable 
{

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String message;
	private Date dateNoti;
	private Date createDate;
	private Date updateDate;
	private boolean sendNoti;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDateNoti() {
		return dateNoti;
	}
	public void setDateNoti(Date dateNoti) {
		this.dateNoti = dateNoti;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public boolean isSendNoti() {
		return sendNoti;
	}
	public void setSendNoti(boolean sendNoti) {
		this.sendNoti = sendNoti;
	}
	
	
}
