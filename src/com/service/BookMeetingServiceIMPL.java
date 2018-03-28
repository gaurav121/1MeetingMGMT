package com.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.DAO.MeetingRoomDAO;
import com.DAO.MeetingRoomDAOImpl;
import com.app.dto.MeetingDto;
import com.model.BookedMeeting;
import com.model.MeetingRoom;
import com.model.MeetingTimings;


public class BookMeetingServiceIMPL implements BookMeetingService {

	MeetingRoomDAO meetingRoomDAO = new MeetingRoomDAOImpl();

	@Override
	public String addMeeting(String userID, String roomID, String startDate1, String endDate1) {
		// TODO Auto-generated method stub
		// String target = "27-09-1991 20:29:30";
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = df.parse(startDate1);
			endDate = df.parse(endDate1);

			System.out.println("Parsed is " + startDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (Stub.checkmeetingConflict(meetingRoomDAO, roomID, startDate, endDate)) {
			System.out.println("Meeting conflict");
			return "conflict";
		} else {
			System.out.println("No Conflict");
		}

		String result = meetingRoomDAO.addnewMeeting(userID, roomID, startDate, endDate);

		System.out.println("Result:" + result);
		return null;
	}

	@Override
	public String deleteMeeting(String meetingId) {
		 meetingRoomDAO.deleteMeeting(meetingId);

		//System.out.println("Result:" + result);
		return "deleted";
	}

	@Override
	public String updateMeeting(String userID, String roomID, String startDate1, String endDate1) {

		DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date startDate = null;
		Date endDate = null;
		try {
			startDate = sdf.parse(startDate1);
			endDate = sdf.parse(endDate1);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(Stub.checkmeetingConflict(meetingRoomDAO, roomID, startDate, endDate))
		{
			System.out.println("Update meeting timings conflict");
			return "conflict";
			
		}
		String result = meetingRoomDAO.updateMeeting(userID, roomID, startDate, endDate);

		System.out.println("Result:" + result);
		return null;
	}

	@Override
	public ArrayList<MeetingRoom> getAllMeeting() {
		// TODO Auto-generated method stub

		List<MeetingRoom> meetings = meetingRoomDAO.getAllMeetingfromDB();

		return (ArrayList<MeetingRoom>) meetings;
	}

	@Override
	public List<MeetingDto> getAllBookedMeeting() {
		
		List<BookedMeeting> meetings = meetingRoomDAO.getAllBookedMeetingfromDB();
		
		List<MeetingDto> meetingsDto = new ArrayList<>();
		for(BookedMeeting meeting : meetings) {
			
			MeetingDto dto = new MeetingDto();
			dto.setBookingID(meeting.getBookingID());
			dto.setUser(meeting.getUser());
			dto.setMeetingRoom(meeting.getMeetingRoom());
			dto.setStartTime(meeting.getStartTime());
			dto.setEndTime(meeting.getEndTime());
			meetingsDto.add(dto);
		}
		return meetingsDto;
	}

	@Override
	public ArrayList<MeetingTimings> getMeetingSchedule(String roomID) {
		ArrayList<MeetingTimings> meetings = (ArrayList<MeetingTimings>) meetingRoomDAO.getMeetingSchedule(roomID);

		return  meetings;
	
	}

}
