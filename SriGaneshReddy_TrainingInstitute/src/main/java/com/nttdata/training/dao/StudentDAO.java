package com.nttdata.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.nttdata.dbcon.ConnectionHolder;
import com.nttdata.dbcon.DBConnectionException;
import com.nttdata.dbfw.DBFWException;
import com.nttdata.dbfw.DBHelper;
import com.nttdata.dbfw.ParamMapper;
import com.nttdata.training.domain.Complaint;
import com.nttdata.training.domain.Feedback;
import com.nttdata.training.domain.Student;

public class StudentDAO {
	//inmapper and outmapper for Student
//	public static List studentLogin(final int Userid,final String Password) // 22 INDIA// 
//	{
//		ConnectionHolder ch=null;
//		Connection con=null;
//		List student=null;
//		
//		try {
//				ch=ConnectionHolder.getInstance();
//				con=ch.getConnection();
//				
//			 final ParamMapper STUDENTPMAPPER = new ParamMapper() {
//				
//				
//				public void mapParams(PreparedStatement pStmt) throws SQLException {
//					pStmt.setInt(1,Userid);
//					pStmt.setString(2,Password);
//					
//				}
//			};
//			
//		student=DBHelper.executeSelect(con,SqlMapper.FETCHSTUDENTID,SqlMapper.STUDENTMAPPER, STUDENTPMAPPER );		
//	
//		} catch (DBConnectionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return student;
//		
//	}//getInstitute
//====================================================================================================================================================
	static Logger log =Logger.getLogger(StudentDAO.class);
	public static List getStudents() throws DBFWException, DAOAppException, DBConnectionException
	{
		
		List students=null;
		ConnectionHolder ch=null;
		Connection con=null;
		try {
			ch=ConnectionHolder.getInstance();
			con=ch.getConnection();
			log.debug("fetching"); //
			
			students=DBHelper.executeSelect(con,SqlMapper.FETCHSTUDENT,SqlMapper.STUDENTMAPPER);
					
		} catch (DBConnectionException e) {
			throw new DBConnectionException("Unable to connect to db"+e);
		
		}
		finally {

			try {

				if (con != null)
					con.close();

			} catch (SQLException e) {
			}
		}
		
		
		return students;
	} //Select students details
//============================================================================================================================================================
	public static int updateStudent(final Student st)  
	{
		
		
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance(); // initialized datasource .// 
			con=ch.getConnection(); // get database connection ..
			final ParamMapper UPDATEPSTUDENT=new ParamMapper() {
				
				
				public void mapParams(PreparedStatement pStmt) throws SQLException {
					
					pStmt.setString(1, st.getName());
					pStmt.setString(2, st.getQualification());
					pStmt.setString(3, st.getPassword());
					pStmt.setString(4, st.getContact_Number());
					pStmt.setString(5, st.getAddress());
					pStmt.setInt(6, st.getUserid());
					pStmt.setString(7, st.getEmail_id());
				
					
				}
			};
			 
		result=DBHelper.executeUpdate(con,SqlMapper.UPDATESTUDENT,UPDATEPSTUDENT);// insert / delete/ update 
			
		// update into student values(?,?,?,?) :   
		
		} 
		
		
		catch (DBFWException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e)
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}//Update Student
//================================================================================================================================================
	public static int insertFeedback(final Feedback fb2)  
	{
		
		
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance(); // initialized datasource .// ds 
			con=ch.getConnection(); // get database connection ..
			final ParamMapper INSERTPFEEDBACK=new ParamMapper() {
				
				
				public void mapParams(PreparedStatement pStmt) throws SQLException {
					pStmt.setInt(1, fb2.getUserid());
					pStmt.setString(2, fb2.getName());
					pStmt.setString(3, fb2.getFeedback());
					
				}
			};			 
			 
		result=DBHelper.executeUpdate(con,SqlMapper.INSERTFEEDBACK,INSERTPFEEDBACK);// insert / delete/ update 
			
		// insert into feedback values(?,?,?);   
		
		} 
		
		
		catch (DBFWException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e)
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}//insert Feedback
//=========================================================================================================================================================
	public static int insertComplaint(final Complaint c2)  
	{
		
		
		ConnectionHolder ch=null;
		Connection con=null;
		int result=0;
		
		try {
			ch=ConnectionHolder.getInstance(); // initialized datasource .// ds 
			con=ch.getConnection(); // get database connection ..
			final ParamMapper INSERTPCOMPLAINT=new ParamMapper() {
				
				
				public void mapParams(PreparedStatement pStmt) throws SQLException {
					pStmt.setString(1, c2.getInstitute_Name());
					pStmt.setString(2, c2.getComplaint_Raise());
					
				}
			};
			 
			 
		result=DBHelper.executeUpdate(con,SqlMapper.INSERTCOMPLAINT,INSERTPCOMPLAINT);// insert / delete/ update 
			
		// insert into Complaint values(?,?);   
		
		} 
		
		
		catch (DBFWException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DBConnectionException e)
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}//insert Complaint
//====================================================================================================================================================
	   public static int insertStudent(final Student std4)  
		{
			
			
			ConnectionHolder ch=null;
			Connection con=null;
			int result=0;
			
			try {
				ch=ConnectionHolder.getInstance(); // initialized datasource .// 
				con=ch.getConnection(); // get database connection ..
				final ParamMapper INSERTPSTUDENT=new ParamMapper() {
					
					
					public void mapParams(PreparedStatement pStmt) throws SQLException {
						pStmt.setString(1, std4.getName());
						pStmt.setString(2, std4.getQualification());
						pStmt.setString(3, std4.getPassword());
						pStmt.setString(4, std4.getContact_Number());
						pStmt.setString(5, std4.getAddress());
						pStmt.setString(6, std4.getEmail_id());
						pStmt.setInt(7, std4.getUserid());
						
					}
				};
				 
			result=DBHelper.executeUpdate(con,SqlMapper.INSERTSTUDENT,INSERTPSTUDENT);// insert / delete/ update 
				
			// insert into student_details values(?,?,?,?,?,?) :   
			
			} 
			
			
			catch (DBFWException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DBConnectionException e)
			
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
			
			
		}//insert Student
//===================================================================================================================================================
}
