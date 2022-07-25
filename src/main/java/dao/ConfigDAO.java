package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import model.Config;

public class ConfigDAO 
{
	public List<Config> getConfig() 
	{
		String sql = "select * from config";

		List<Config> list = new ArrayList<Config>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement ps = null;

		try {

			con = DB.getInstance().getConnection();

			ps = con.prepareStatement(sql);

			rs = ps.executeQuery();

			while (rs.next()) 
			{
				Config item = new Config();

				item.setTokenNoti(rs.getString("TOKEN"));
				
				list.add(item);
			}

		} catch (Exception e) 
		{
			e.printStackTrace();
		} finally 
		{
			DB.getInstance().closeConnection(con, rs, ps);
		}

		return list;
	}
}
