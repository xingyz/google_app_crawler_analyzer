package com.factrus.main.scrapper.model;

import java.util.Hashtable;
import java.util.Map;

/**
 * 
 * @author edmond_j
 *
 */
public class Data
{
	public String Url = null;
	public Hashtable<String, String> _attributes = new Hashtable<String, String>();
	
	public boolean hasAttribute(String key)
	{
		return _attributes.containsKey(key);
	}
	
	public String getAttribute(String key)
	{
		return _attributes.get(key);
	}
	
	public void setAttribute(String key, String value)
	{
		_attributes.put(key, value);
	}
	
	public Iterable<Map.Entry<String, String>> getAttributes()
	{
		return _attributes.entrySet();
	}
}