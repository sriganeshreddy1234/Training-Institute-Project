package com.nttdata.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.nttdata.dbcon.ConnectionHolder;
import com.nttdata.dbcon.DBConnectionException;
import com.nttdata.dbfw.DBFWException;
import com.nttdata.dbfw.DBHelper;
import com.nttdata.dbfw.ParamMapper;
import com.nttdata.training.domain.Institute;
import com.nttdata.training.domain.Student;

// EmployeeDao
// employee login
// register,
// deletion
// updation .. 

public class RegisterDAO {
	

//=========================================================================================
	public int registerInstitute(final Institute institute) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		
		ParamMapper mapper = new ParamMapper() 
		{
			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException
			{
				pStmt.setString(1, institute.getInstitute_Name());
				pStmt.setString(2, institute.getAffiliation_Date());
				pStmt.setString(3, institute.getAddress());
				pStmt.setInt(4, institute.getNumber_Of_Seats());
				pStmt.setInt(5, institute.getNumber_Of_Course());
				pStmt.setString(6, institute.getPassword());
				
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_INSTITUTE, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}

	
	public boolean validateInstitute(final String Institute_Name) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		List institutes = null;

		ParamMapper paramMapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setString(1, Institute_Name);
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			institutes = DBHelper.executeSelect(con, SqlMapper.FETCH_INSTITUTE,
					paramMapper, SqlMapper.MAP_INSTITUTE);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}

		return (institutes != null && institutes.size() > 0);

	}
	
//===================================================================================================================
	public int registerStudent(final Student student) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		int res = -1;
		
		ParamMapper mapper = new ParamMapper() 
		{
			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException
			{
				pStmt.setString(1, student.getName());
				pStmt.setString(2, student.getQualification());
				pStmt.setString(3, student.getPassword());
				pStmt.setString(4, student.getContact_Number());
				pStmt.setString(5, student.getAddress());
				pStmt.setString(6, student.getEmail_id());
				pStmt.setInt(7, student.getUserid());
				
			}
		};
		  		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			res = DBHelper.executeUpdate(con, SqlMapper.ADD_STUDENT, mapper);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;
	}

	
	public boolean validateStudent(final int Userid) throws DAOAppException {
		ConnectionHolder ch = null;
		Connection con = null;
		List students = null;

		ParamMapper paramMapper = new ParamMapper() {

			@Override
			public void mapParams(PreparedStatement pStmt) throws SQLException {
				pStmt.setInt(1, Userid);
			}
		};
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			students = DBHelper.executeSelect(con, SqlMapper.FETCH_STUDENT,
					paramMapper, SqlMapper.MAP_STUDENT);

		} catch (DBConnectionException e) {
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}

		return (students != null && students.size() > 0);

	}
	
}
