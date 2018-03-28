package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MeetingTimings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@ManyToOne
	@JoinColumn(name = "mRoomID")
	private MeetingRoom meetingRoom;
	
	
	@Column
	private Date startTime;

	@Column
	private Date endTime;

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

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

	
	
}
