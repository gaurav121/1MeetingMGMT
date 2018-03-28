package com.service;

import java.util.Date;
import java.util.List;

import com.DAO.MeetingRoomDAO;
import com.model.BookedMeeting;
import com.model.MeetingRoom;

public class Stub {

	 public static boolean checkmeetingConflict(MeetingRoomDAO daoObject,String room, Date startDate, Date endDate) {
		
		
		List<BookedMeeting> meetingrooms=daoObject.getAllBookedMeetingfromDB();
		if(meetingrooms==null)
			return true;
			
		for(BookedMeeting bk:meetingrooms) {
			
			if( bk.getMeetingRoom().toString().equals(room) &&
					(
							(	startDate.after(bk.getStartTime()) && startDate.before(bk.getEndTime()) )
							||
							(	endDate.after(bk.getStartTime()) && endDate.before(bk.getEndTime()) )
					)
				) {

				System.out.println("conflict meeitg"+bk.getStartTime()+" "+bk.getEndTime());

	
				System.out.println("Conflict");
				return true;
			}
				
				
			
		}
		
	
		
		return false;
	}

	
	
}
