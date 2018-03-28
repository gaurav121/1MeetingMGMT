package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
public class MeetingRoom 
{

	public MeetingRoom() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@Column
	private String mRoomID;
	 
	
	
	public String getmRoomID() {
		return mRoomID;
	}
	public void setmRoomID(String mRoomID) {
		this.mRoomID = mRoomID;
	}
	
	/*
	@Column
	private Date startTime;
	@Column
	private Date endTime;
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	 */
	
	  


	
	
}
