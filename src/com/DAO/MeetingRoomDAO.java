package com.DAO;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.model.BookedMeeting;
import com.model.MeetingRoom;
import com.model.MeetingTimings;
import com.model.User;


public interface MeetingRoomDAO {

	public List<MeetingRoom> getAllMeetingfromDB();
	
	public List<BookedMeeting> getAllBookedMeetingfromDB();
	
	public List<User> getallUserDB();
	
	
	public String addnewMeeting(String userID,String roomID,Date startDate,Date endDate);
	
	public String updateMeeting(String userID,String roomID,Date startDate,Date endDate);
	
	public String deleteMeeting(String meetingID);

	public List<MeetingTimings> getMeetingSchedule(String roomID);




}
