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
import com.nttdata.training.domain.Article;
import com.nttdata.training.domain.Faculty;
import com.nttdata.training.domain.Institute;


public class InstituteDAO {
	
	//inmapper and outmapper for Institute
//		public static List instituteLogin(final String Institute_Name,final String Password) // 22 INDIA// 
//		{
//			ConnectionHolder ch=null;
//			Connection con=null;
//			List institute=null;
//			
//			try {
//					ch=ConnectionHolder.getInstance();
//					con=ch.getConnection();
//					
//				 final ParamMapper INSTITUTEPMAPPER = new ParamMapper() {
//					
//					
//					public void mapParams(PreparedStatement pStmt) throws SQLException {
//						pStmt.setString(1,Institute_Name);
//						pStmt.setString(2,Password);
//						
//					}
//				};//ananymous class
//				
//			institute=DBHelper.executeSelect(con,SqlMapper.FETCHINSTITUTEID,SqlMapper.INSTITUTEMAPPER, INSTITUTEPMAPPER );		
//		
//			} catch (DBConnectionException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			return institute;
//			
//		}//getInstitute
	//=============================================================================================================================
		static Logger log1 =Logger.getLogger(InstituteDAO.class);
		public static List getStudents() throws DBFWException, DAOAppException, DBConnectionException
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
//=================================================================================================================================================
		
		 
		public static int insertArticle(final Article a)  
		{
			
			
			ConnectionHolder ch=null;
			Connection con=null;
			int result=0;
			
			try {
				ch=ConnectionHolder.getInstance(); // initialized datasource .// ds 
				con=ch.getConnection(); // get database connection ..
				final ParamMapper INSERTPARTICLE=new ParamMapper() {
					
					
					public void mapParams(PreparedStatement pStmt) throws SQLException {
						pStmt.setString(1, a.getInstitute_Name());
						pStmt.setString(2, a.getArticle_Title());
						pStmt.setString(3, a.getArticle_Text());
						
						
					}
				};				 
			result=DBHelper.executeUpdate(con,SqlMapper.INSERTARTICLE,INSERTPARTICLE);// insert / delete/ update 
				
			// insert into tbl_country values(?,?) :   
			
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
			
			
		}//insert Article
//=====================================================================================================================================================		
		public static int insertFaculty(final Faculty f)  
		{
			
			
			ConnectionHolder ch=null;
			Connection con=null;
			int result=0;
			
			try {
				ch=ConnectionHolder.getInstance(); // initialized datasource .// ds 
				con=ch.getConnection(); // get database connection ..
				final ParamMapper INSERTPFACULTY=new ParamMapper() {
					
					
					public void mapParams(PreparedStatement pStmt) throws SQLException {
						pStmt.setString(1, f.getName());
						pStmt.setString(2, f.getQualification());
						pStmt.setString(3, f.getExperience());
						pStmt.setString(4, f.getContact_Number());
						pStmt.setInt(5, f.getSalary());
						
					}
				};
				 
				 
			result=DBHelper.executeUpdate(con,SqlMapper.INSERTFACULTY,INSERTPFACULTY);// insert / delete/ update 
				
			// insert into tbl_country values(?,?) :   
			
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
			
			
		}//insert Faculty
//============================================================================================================================================================
		static Logger log2 =Logger.getLogger(InstituteDAO.class);
		public static List getFaculty() throws DBFWException, DAOAppException, DBConnectionException
		{
			
			List faculty=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				log2.debug("fetching"); //
				
				faculty=DBHelper.executeSelect(con,SqlMapper.FETCHFACULTY,SqlMapper.FACULTYMAPPER);
						
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
			
			
			return faculty;
		}
//=========================================================================================================================================================
		public static int updateInstitute(final Institute inst)  
		{
			
			
			ConnectionHolder ch=null;
			Connection con=null;
			int result=0;
			
			try {
				ch=ConnectionHolder.getInstance(); // initialized datasource .// 
				con=ch.getConnection(); // get database connection ..
				final ParamMapper UPDATEPINSTITUTE=new ParamMapper() {
					
					
					public void mapParams(PreparedStatement pStmt) throws SQLException {
						
						
						
						pStmt.setString(1, inst.getAffiliation_Date());
						pStmt.setString(2, inst.getAddress());
						pStmt.setInt(3, inst.getNumber_Of_Seats());
						pStmt.setInt(4, inst.getNumber_Of_Course());
						pStmt.setString(5, inst.getPassword());
						pStmt.setString(6, inst.getInstitute_Name());
						
						
						
					}
				};
				 
				 
			result=DBHelper.executeUpdate(con,SqlMapper.UPDATEINSTITUTE,UPDATEPINSTITUTE);// insert / delete/ update 
				
			// update into tbl_country values(?,?) :   
			
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
			
			
		}//Update Institute
//===========================================================================================================================================================
		static Logger log3 =Logger.getLogger(InstituteDAO.class);
		public static List getFeedback() throws DBFWException, DAOAppException, DBConnectionException
		{
			
			List feedback=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				log3.debug("fetching"); //
				
				feedback=DBHelper.executeSelect(con,SqlMapper.FETCHFEEDBACK,SqlMapper.FEEDBACKMAPPER);
						
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
			
			
			return feedback;
		}
//=============================================================================================================================================================
		public static int insertInstitute(final Institute inst3)  
		{
			
			
			ConnectionHolder ch=null;
			Connection con=null;
			int result=0;
			
			try {
				ch=ConnectionHolder.getInstance(); // initialized datasource .// 
				con=ch.getConnection(); // get database connection ..
				final ParamMapper INSERTPINSTITUTE=new ParamMapper() {
					
					@Override
					public void mapParams(PreparedStatement pStmt) throws SQLException {
						pStmt.setString(1, inst3.getInstitute_Name());
						pStmt.setString(2, inst3.getPassword());
						pStmt.setString(3, inst3.getAffiliation_Date());
						pStmt.setString(4, inst3.getAddress());
						pStmt.setInt(5, inst3.getNumber_Of_Seats());
						pStmt.setInt(6, inst3.getNumber_Of_Course());
						
					}
				};
				 
			result=DBHelper.executeUpdate(con,SqlMapper.INSERTINSTITUTE,INSERTPINSTITUTE);// insert / delete/ update 
				
			// insert into institute_details values(?,?,?,?,?,?) :   
			
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
			
		}//insert Faculty
//====================================================================================================================================================
		//OutMapper Of institutes
		static Logger log=Logger.getLogger(InstituteDAO.class);
		public static List getInstitutes() throws DBFWException, DAOAppException, DBConnectionException
		{
			
			List institutes=null;
			ConnectionHolder ch=null;
			Connection con=null;
			try {
				ch=ConnectionHolder.getInstance();
				con=ch.getConnection();
				log.debug("fetching"); //
				
				institutes=DBHelper.executeSelect(con,SqlMapper.FETCH_INSTITUTE,SqlMapper.INSTITUTEMAPPER);
						
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
}
