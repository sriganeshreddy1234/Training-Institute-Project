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
import com.nttdata.training.domain.Institute;


	public class AdminDAO {
//		//inmapper and outmapper for admin
//		public static List adminLogin(final String Userid,final String Password) // 22 INDIA// 
//		{
//			ConnectionHolder ch=null;
//			Connection con=null;
//			List admin=null;
//			
//			try {
//					ch=ConnectionHolder.getInstance();
//					con=ch.getConnection();
//					
//				 final ParamMapper ADMINPMAPPER=new ParamMapper() {
//					
//					
//					public void mapParams(PreparedStatement pStmt) throws SQLException {
//						pStmt.setString(1,Userid);
//						pStmt.setString(2,Password);		
//						
//					}
//				};  // select id, name  from user where id=? password=?  //ananymous class
//				
//			admin=DBHelper.executeSelect(con,SqlMapper.FETCHADMINID,SqlMapper.ADMINMAPPER, ADMINPMAPPER );		
//		
//			} catch (DBConnectionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return admin;
//			
//		}//getAdmin
	//=====================================================================================================
		//OutMapper Of institutes
		static Logger log=Logger.getLogger(AdminDAO.class);
		public static List getInstitutes() throws DBFWException, DAOAppException,DBConnectionException
		{
			
			List institutes=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				log.debug("fetching"); //
				
				institutes=DBHelper.executeSelect(con,SqlMapper.FETCH_ALL_INSTITUTES,SqlMapper.INSTITUTEMAPPER);
						
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
			
			
			return institutes;
		}
	//==================================================================================================================================		
			//DeleteInstitute
			public static int deleteInstitute(final Institute d)  
			{
				
				
				ConnectionHolder ch=null;
				Connection con=null;
				int result=0;
				
				try {
					ch=ConnectionHolder.getInstance(); // initialized datasource .// ds 
					con=ch.getConnection(); // get database connection ..
					final ParamMapper DELETEPINSTITUTE=new ParamMapper() {
						
						
						public void mapParams(PreparedStatement pStmt) throws SQLException {
							pStmt.setString(1, d.getInstitute_Name());
							
						}
					};
					 
					 
				result=DBHelper.executeUpdate(con,SqlMapper.DELETEINSTITUTE,DELETEPINSTITUTE);// insert / delete/ update    
				
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
			}//deleteInstitute	
	//===========================================================================================================================================		
			//OutMapper Of Students
			static Logger log1 =Logger.getLogger(AdminDAO.class);
			public static List getStudents() throws DBFWException,  DAOAppException, DBConnectionException
			{
				
				List students=null;
				ConnectionHolder ch=null;
				Connection con=null;
				try {
					ch=ConnectionHolder.getInstance();
					con=ch.getConnection();
					log1.debug("fetching"); //
					
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
			}
	//===================================================================================================================================		
			
			static Logger log2=Logger.getLogger(AdminDAO.class);
			public static List getComplaints() throws DBFWException, DAOAppException, DBConnectionException
			{
				
				List complaints=null;
				ConnectionHolder ch=null;
				Connection con=null;
				try {
					ch=ConnectionHolder.getInstance();
					con=ch.getConnection();
					log2.debug("fetching"); //
					
					complaints=DBHelper.executeSelect(con,SqlMapper.FETCHCOMPLAINT,SqlMapper.COMPLAINTMAPPER);
							
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
				
				
				return complaints;
			}
	//=======================================================================================================================================================
		
}