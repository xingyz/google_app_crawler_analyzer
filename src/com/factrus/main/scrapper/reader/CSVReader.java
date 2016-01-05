package com.factrus.main.scrapper.reader;

import java.util.Iterator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

import com.factrus.main.scrapper.interfaces.IReader;
import com.factrus.main.scrapper.model.Data;


public class CSVReader implements IReader
{
	private BufferedReader _buffer;
	private String[] _columnHeaders;

	@Override
	public void openLocation(String location) throws FileNotFoundException
	{
		_buffer = new BufferedReader(new FileReader(location));
	}
	
	@Override
	public Iterator<Data> getData()
	{
		ArrayList<Data> output = new ArrayList<Data>();
		String line;

		try
		{
			String _line = _buffer.readLine();
			String _l2 = _line.substring(1, _line.length()-1);
			//System.out.println(_l2);
			_columnHeaders = _l2.split(";");
			for (int i = 1; i < _columnHeaders.length; ++i)
			{
				_columnHeaders[i] = _columnHeaders[i].substring(2, _columnHeaders[i].length()-2);
				//System.out.println(_columnHeaders[i]);
			}
			
			while ((line = _buffer.readLine()) != null)
			{	
				output.add(parseCSVLine(line));
			}
		}
		catch (Exception e)
		{}
		return output.listIterator();
	}
	
	@Override
	public void closeLocation()
	{
		try
		{
			_buffer.close();
		}
		catch (Exception e)
		{}
		_buffer = null;
		_columnHeaders = null;
	}
	
	private Data parseCSVLine(String line)
	{	
		Data output = new Data();
		String stripped ="";
		stripped = line.substring(1,line.length()-1);
		String[] values = stripped.split(";");
	
		for (int i = 0; i < values.length && i < _columnHeaders.length; ++i)
		{	
			if (_columnHeaders[i].compareTo("Url") == 0){
				output.Url = values[i];
			}
			else{
				values[i] = values[i].substring(1, values[i].length()-1);
				output.setAttribute(_columnHeaders[i], values[i]);
			}
			//System.out.println(values[i]);
		}
		return output;
	}
}