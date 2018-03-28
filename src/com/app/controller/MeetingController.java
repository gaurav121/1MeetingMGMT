package com.app.controller;



import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.MeetingDto;
import com.google.gson.Gson;
import com.service.BookMeetingService;
import com.service.BookMeetingServiceIMPL;

/**
 * @author gyadav
 *
 */
@RestController

public class MeetingController {
	/*
	Methods:
		1. /meetings: to get all booked meeting details
		2. post: /meeting/{userid}/{roomid}?startdate&endDate to add a new meeting
		3. put: /meeting/{userid}/{roomid}?startdate&endDate to updtae a  meeting
		4. delete: /meeting/{userid}/{userid} : to delete a existing meeting
		5. /schedule/meeting/{roomid} : to get schedule of that particular meeting room
	 */
	
	
	
	
	public MeetingController() {
		// TODO Auto-generated constructor stub
	}
	
	BookMeetingService mmsService=new BookMeetingServiceIMPL();
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String welcomePage()
	{
		
		return "success"; 
	}

	
	@RequestMapping(value="/meetings",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON)
	public List<MeetingDto> getAallMeeting(
								) {
		System.out.println("Showing all meetings");
		
		 //mmsService.getAllMeeting();
	
		//Gson gson=new Gson();
		
	//	return gson.toJson(mmsService.getAllBookedMeeting());
		return mmsService.getAllBookedMeeting();
	}
	
	@RequestMapping(value="/schedule/meeting/{roomID}",method=RequestMethod.GET)
	public String getAallMeeting(@PathVariable("roomID") String roomID) {
		System.out.println("Showing all meetings");
		
		mmsService.getMeetingSchedule(roomID);
	
		Gson gson=new Gson();
		
		return gson.toJson(mmsService.getMeetingSchedule(roomID));
	}

	
	
	@RequestMapping(value="/meeting/{userID}/{roomID}",method=RequestMethod.POST)
	public String addnewMeeting(
								@PathVariable("userID") String userID,
								@PathVariable("roomID") String roomID,
								@RequestParam(value="startTime",required=false) String startDate,
								@RequestParam(value="endTime",required=false) String endDate ) {
		System.out.println("add userid is "+userID+" roomid is "+roomID);
		mmsService.addMeeting(userID, roomID, startDate, endDate);
		return "success";
	}
	
	
	@RequestMapping(value="/meeting/{userID}/{roomID}",method=RequestMethod.PUT)
	public String updateMeeting(
								@PathVariable("userID") String userID,
								@PathVariable("roomID") String roomID,
								@RequestParam(value="startTime",required=false) String startDate,
								@RequestParam(value="endTime",required=false) String endDate ) {
		
		System.out.println("update userid is "+userID+" roomid is "+roomID);
		
		return mmsService.updateMeeting(userID, roomID, startDate, endDate);
	}
	
	@RequestMapping(value="/meeting/{meetingID}",method=RequestMethod.DELETE)
	public String deleteMeeting(
								@PathVariable("meetingID") String meetingID
								) {

		
		return mmsService.deleteMeeting(meetingID);
	}
	
	

}
