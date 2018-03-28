package com.model;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.ManyToAny;

@Entity
public class BookedMeeting {

	
	public BookedMeeting() {

	}
	
	@Id
	@Column(name="MeetingRoomID")

	private String bookingID;
	
	
	 @ManyToOne
	 @JoinColumn(name = "mRoomID")
	 private MeetingRoom meetingRoom;

	
	 @ManyToOne
	 @JoinColumn(name = "userID")
	 private User user;

	 
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
