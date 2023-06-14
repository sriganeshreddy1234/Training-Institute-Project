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

public class LoginDAO {
	static Logger log = Logger.getLogger(LoginDAO.class);

	
//============================================================================================
//INSTITUTE LOGIN....! 
	
	public List validateInstitute(final String Inst_Name) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setString(1, Inst_Name);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_INSTITUTE,paramMapper, SqlMapper.MAP_INSTITUTE);
			System.out.println(res);
			System.out.println("++++++++++++++++++++++++++++++++++++");
		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;

	}
//=======================================================================================================
	//STUDENT LOGIN
	public List validateStudent(final int uid) throws DAOAppException {
		List res = null;
		ConnectionHolder ch = null;
		Connection con = null;
		try {
			ch = ConnectionHolder.getInstance();
			con = ch.getConnection();
			ParamMapper paramMapper = new ParamMapper() {

				@Override
				public void mapParams(PreparedStatement pStmt)
						throws SQLException {
					pStmt.setInt(1, uid);
				}
			};
			res = DBHelper.executeSelect(con, SqlMapper.FETCH_STUDENT,paramMapper, SqlMapper.MAP_STUDENT);

		} catch (DBConnectionException e) {
			log.error(e);
			throw new DAOAppException(e);
		} catch (DBFWException e) {
			throw new DAOAppException(e);
		}
		return res;

	}
//================================================================================================================================
//===============================================================================================================================
//	public List AllInstitutes(final String Inst_Name) throws DAOAppException {
//		List res = null;
//		ConnectionHolder ch = null;
//		Connection con = null;
//		try {
//			ch = ConnectionHolder.getInstance();
//			con = ch.getConnection();
//			ParamMapper paramMapper = new ParamMapper() {
//
//				@Override
//				public void mapParams(PreparedStatement pStmt)
//						throws SQLException {
//					pStmt.setString(1, Inst_Name);
//				}
//			};
//			//res = DBHelper.executeSelect(con, SqlMapper.FETCH_ALL_INSTITUTES,paramMapper, SqlMapper.MAP_ALL_INSTITUTES);
//			res=DBHelper.executeSelect(con,SqlMapper.FETCH_ALL_INSTITUTES, null);
//			System.out.println(res);
//			System.out.println("++++++++++++++++++++++++++++++++++++");
//		} catch (DBConnectionException e) {
//			log.error(e);
//			throw new DAOAppException(e);
//		} catch (DBFWException e) {
//			throw new DAOAppException(e);
//		}
//		return res;
//
//	}
//	
}
