package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import model.Note;

public class NoteDAO {
	public List<Note> getNoteAll(Note note)  {

		String sql = " select * from note ";

		List<Note> list = new ArrayList<Note>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;

		if (note != null && !"".equals(note.getName())) {
			sql += "and name = ? ";
		}

		if (note != null && !"".equals(note.getMessage())) {
			sql += "and message = ? ";
		}

		sql = sql.replaceFirst("and", "where");

		try {

			con = DB.getInstance().getConnection();

			ps = con.prepareStatement(sql);
			
			if (note != null && !"".equals(note.getName())) {
				ps.setString(++i, note.getName());
			}

			if (note != null && !"".equals(note.getMessage())) {
				ps.setString(++i, note.getMessage());
			}

			
			rs = ps.executeQuery();

			while (rs.next()) 
			{
				Note item = new Note();

				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setMessage(rs.getString("message"));
				item.setCreateDate(rs.getTimestamp("createdate"));
				item.setDateNoti(rs.getTimestamp("datenoti"));
				item.setUpdateDate(rs.getTimestamp("updatedate"));
				item.setSendNoti(rs.getBoolean("sendnoti"));

				list.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.getInstance().closeConnection(con, rs, ps);
		}

		return list;
	}

	public int insert(Note note) throws Exception {

		Connection con = null;
		PreparedStatement ps = null;

		String sql = "insert into note ";
		String field = "";
		String value = "";
		int i = 0;

		if (note != null && !"".equals(note.getName())) {
			field += ",name";
			value += ",?";
		}

		if (note != null && !"".equals(note.getMessage())) {
			field += ",message";
			value += ",?";
		}

		if (note != null && note.getDateNoti() != null) {
			field += ",datenoti";
			value += ",?";
		}

		if (note != null && note.getCreateDate() != null) {
			field += ",createdate";
			value += ",?";
		}

		if (note != null && note.getUpdateDate() != null) {
			field += ",updatedate";
			value += ",?";
		}

		field = field.replaceFirst(",", "");
		value = value.replaceFirst(",", "");

		sql += "(" + field + ")" + " values " + "(" + value + ")";

		try {
			con = DB.getInstance().getConnection();

			ps = con.prepareStatement(sql);

			if (note != null && !"".equals(note.getName())) {
				ps.setString(++i, note.getName());
			}

			if (note != null && !"".equals(note.getMessage())) {
				ps.setString(++i, note.getMessage());
			}

			if (note != null && note.getDateNoti() != null) {
				ps.setTimestamp(++i, new Timestamp(note.getDateNoti().getTime()));
			}

			if (note != null && note.getCreateDate() != null) {
				ps.setTimestamp(++i, new Timestamp(note.getCreateDate().getTime()));
			}

			if (note != null && note.getUpdateDate() != null) {
				ps.setTimestamp(++i, new Timestamp(note.getUpdateDate().getTime()));
			}

			return ps.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			DB.getInstance().closeConnection(con, null, ps);
		}

	}

	public int update(Note note, int id) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;

		String sql = "update note ";
		String field = "";
		int i = 0;

		if (note != null && !"".equals(note.getName())) {
			field += ",name = ?";
		}

		if (note != null && !"".equals(note.getMessage())) {
			field += ",message = ?";
		}

		if (note != null && note.getDateNoti() != null) {
			field += ",datenoti = ?";
		}

		if (note != null && note.getCreateDate() != null) {
			field += ",createdate = ?";
		}

		if (note != null && note.getUpdateDate() != null) {
			field += ",updatedate = ?";
		}
		
		field = field.replaceFirst(",", "set");

		sql += field + "where id = ?";

		try {
			con = DB.getInstance().getConnection();

			ps = con.prepareStatement(sql);

			if (note != null && !"".equals(note.getName())) {
				ps.setString(++i, note.getName());
			}

			if (note != null && !"".equals(note.getMessage())) {
				ps.setString(++i, note.getMessage());
			}

			if (note != null && note.getDateNoti() != null) {
				ps.setTimestamp(++i, new Timestamp(note.getDateNoti().getTime()));
			}

			if (note != null && note.getCreateDate() != null) {
				ps.setTimestamp(++i, new Timestamp(note.getCreateDate().getTime()));
			}

			if (note != null && note.getUpdateDate() != null) {
				ps.setTimestamp(++i, new Timestamp(note.getUpdateDate().getTime()));
			}

			ps.setInt(++i, id);

			return ps.executeUpdate();

		} catch (Exception e) {
			throw e;
		} finally {
			DB.getInstance().closeConnection(con, null, ps);
		}

	}
	
	
	public List<Note> getNoteLikeByNameAndMessage(Note note)  {

		String sql = " select * from note ";

		List<Note> list = new ArrayList<Note>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement ps = null;
		int i = 0;

		if (note != null && !"".equals(note.getName())) {
			sql += "and name like ? ";
		}

		if (note != null && !"".equals(note.getMessage())) {
			sql += "and message like ? ";
		}

		sql = sql.replaceFirst("and", "where");

		try {

			con = DB.getInstance().getConnection();

			ps = con.prepareStatement(sql);
			
			if (note != null && !"".equals(note.getName())) {
				ps.setString(++i,"%" + note.getName() + "%");
			}

			if (note != null && !"".equals(note.getMessage())) {
				ps.setString(++i,"%" + note.getMessage() + "%");
			}

			
			rs = ps.executeQuery();

			while (rs.next()) 
			{
				Note item = new Note();

				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setMessage(rs.getString("message"));
				item.setCreateDate(rs.getTimestamp("createdate"));
				item.setDateNoti(rs.getTimestamp("datenoti"));
				item.setUpdateDate(rs.getTimestamp("updatedate"));
				item.setSendNoti(rs.getBoolean("sendnoti"));

				list.add(item);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.getInstance().closeConnection(con, rs, ps);
		}

		return list;
	}
	
}
