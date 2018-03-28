package com.service;

import java.util.ArrayList;
import java.util.List;

import com.app.dto.MeetingDto;
import com.model.BookedMeeting;
import com.model.MeetingRoom;
import com.model.MeetingTimings;

public interface BookMeetingService {

	public String addMeeting(String userID,String roomID,String startDate,String endDate);
	public String deleteMeeting(String deleteMeeting);
	public String updateMeeting(String userID,String roomID,String startDate,String endDate);
	public ArrayList<MeetingRoom> getAllMeeting();
	public List<MeetingDto> getAllBookedMeeting();
	public ArrayList<MeetingTimings> getMeetingSchedule(String roomID);
	
	
	
}
