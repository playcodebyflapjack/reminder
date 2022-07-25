package service;

import java.util.List;

import dao.ConfigDAO;
import model.Config;

public class ConfigService 
{
	private ConfigDAO configDAO;
	
	public ConfigService(ConfigDAO configDAO)
	{
		this.configDAO = configDAO;
	}
	
	public Config getConfig() throws Exception
	{
		List<Config> listConfig = configDAO.getConfig();
		int size = listConfig.size();
		
		if (size == 0 || size  > 1)
		{
			throw new Exception("check table 'config' in database");
		}
		else
		{
			return listConfig.get(0);
		}	
	}
}
