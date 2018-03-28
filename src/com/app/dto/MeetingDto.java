package com.app.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.model.MeetingRoom;
import com.model.User;

@XmlRootElement
public class MeetingDto {
	
	private String bookingID;
	
	

	 private MeetingRoom meetingRoom;
	 private User user;
	 private Date startTime;
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
	
	
	public String getBookingID() {
		return bookingID;
	}

	public void setBookingID(String bookingID) {
		this.bookingID = bookingID;
	}

	public MeetingRoom getMeetingRoom() {
		return meetingRoom;
	}

	public void setMeetingRoom(MeetingRoom meetingRoom) {
		this.meetingRoom = meetingRoom;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "BookedMeeting [bookingID=" + bookingID + ", meetingRoom=" + meetingRoom + ", user=" + user + "]";
	}


}
