package com.DAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import com.model.BookedMeeting;
import com.model.MeetingRoom;
import com.model.MeetingTimings;
import com.model.User;

public class MeetingRoomDAOImpl implements MeetingRoomDAO{

	private SessionFactory factory;
	
	
	public MeetingRoomDAOImpl() {
	try {
			
			System.out.println("creating factory");
			
	        factory = new AnnotationConfiguration().
	                  configure().
	                  buildSessionFactory();
			System.out.println("created factory");
			System.out.println(factory);

	        
	     } catch (Throwable ex) { 
	        System.err.println("Hey it failed to create factory \n\n\n\n" + ex);
	        throw new ExceptionInInitializerError(ex); 
	     }
	    
		
	}
	
	@Override
	public String addnewMeeting(String userID, String roomID, Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		
		
		System.out.println("in addition");
		Session session = factory.openSession();
		session.beginTransaction();
		
		
		User user=new User();
		user.setUserID(userID);

		MeetingRoom meetingRoom=new MeetingRoom();
		meetingRoom.setmRoomID(roomID);
		
		MeetingTimings meetingTimings=new MeetingTimings();
		meetingTimings.setEndTime(endDate);
		meetingTimings.setStartTime(startDate);
		
		meetingTimings.setMeetingRoom(meetingRoom);
		
		BookedMeeting meeting=new BookedMeeting();
		meeting.setEndTime(endDate);
		meeting.setStartTime(startDate);
		meeting.setBookingID(userID+"-"+roomID+"-"+meetingTimings.getStartTime().hashCode()+"-"+meetingTimings.getEndTime().hashCode());
		meeting.setMeetingRoom(meetingRoom);
		meeting.setUser(user);
		
		//uncomment to add new user or meeting room
		//session.save(user);
		//session.save(meetingRoom);
		
		try {
			session.save(meetingTimings);
		}
		catch(HibernateException E) {
			System.out.println("Exception caught while saving meeting timings"+E);
		}
		
		try{
			session.save(meeting);
		}
		catch(HibernateException E) {
			System.out.println("Exception caught while saving meeting booked"+E);
			
		}
		// session.persist(entity);
		try{
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception E) {
			System.out.println("Exception caught while saving and closing session"+E);
			
		}

		
		
	    return "success";

	}


	@Override
	public String deleteMeeting(String meetingID) {
		Session session = factory.openSession();
		session.beginTransaction();
		
		BookedMeeting bookedMeeting = null;
		MeetingRoom meetingRoom;
		MeetingTimings meetingTimings = null;
		try {
			//bookedMeeting = session.de
			session.delete(meetingID);
			//session.delete(meetingTimings);
			session.getTransaction().commit();

			session.close();
		}
		finally {
			
		}
		
		return "sucess";
	}


	@Override
	public String updateMeeting(String userID, String roomID, Date startDate, Date endDate) {
	
		Session session = factory.openSession();
		session.beginTransaction();
		
		MeetingRoom meetingRoom=(MeetingRoom) session.get(MeetingRoom.class, roomID);
		MeetingTimings meetingTimings=(MeetingTimings) session.get(MeetingTimings.class, roomID);
		System.out.println("Meeitingtime "+meetingTimings);
		BookedMeeting bookedMeeting=(BookedMeeting) session.get(BookedMeeting.class, (userID+"-"+roomID+"-"+meetingTimings.getStartTime().hashCode()+"-"+meetingTimings.getEndTime().hashCode()) );
		
		System.out.println("found booked meeting"+bookedMeeting.getBookingID());
		System.out.println("in update DAO "+userID+"-"+roomID+"-"+meetingTimings.getStartTime().hashCode()+"-"+meetingTimings.getEndTime().hashCode());
		bookedMeeting.setEndTime(endDate);
		bookedMeeting.setStartTime(startDate);
		
		meetingTimings.setEndTime(endDate);
		meetingTimings.setStartTime(startDate);
		session.update(meetingTimings);
		session.update(bookedMeeting);
		session.getTransaction().commit();
		System.out.println("Updated tme are :"+bookedMeeting.getStartTime()+" -"+ bookedMeeting.getEndTime());
		
		session.close();
		return "success";
	}


	@Override
	public List<BookedMeeting> getAllBookedMeetingfromDB() {
		// TODO Auto-generated method stub
		
		Session session = factory.openSession();
		//session.beginTransaction();
		
		ArrayList<BookedMeeting> bookedMeeting=(ArrayList<BookedMeeting>) session.createQuery("from BookedMeeting").list();
		
		session.close();
		return bookedMeeting;
	}


	@Override
	public List<User> getallUserDB() {
	
		Session session = factory.openSession();
		session.beginTransaction();
		
		ArrayList<User> users=(ArrayList<User>) session.createQuery("from User").list();
		
		session.close();
		
		
		// TODO Auto-generated method stub
		return users;
	}




	@Override
	public List<MeetingRoom> getAllMeetingfromDB() {
		Session session = factory.openSession();
		session.beginTransaction();
		
		ArrayList<MeetingRoom> Meetings=(ArrayList<MeetingRoom>) session.createQuery("from MeetingRoom").list();
		
		session.close();
			return Meetings;
	}

	@Override
	public ArrayList<MeetingTimings> getMeetingSchedule(String roomID) {
		Session session = factory.openSession();
		session.beginTransaction();
		
		ArrayList<MeetingTimings> Meetings=(ArrayList<MeetingTimings>) session.createQuery("from MeetingTimings").list();		
		session.close();
			return Meetings;
	}

	
}
