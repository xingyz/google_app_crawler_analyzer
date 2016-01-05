package com.factrus.main.scrapper.scrapper;

import java.io.FileNotFoundException;
import java.util.Iterator;

import com.factrus.main.scrapper.interfaces.IReader;
import com.factrus.main.scrapper.interfaces.IWebParser;
import com.factrus.main.scrapper.interfaces.IWriter;
import com.factrus.main.scrapper.model.Data;
import com.factrus.main.scrapper.parser.JSoupWebParser;
import com.factrus.main.scrapper.reader.CSVReader;
import com.factrus.main.scrapper.writer.JenaRDFWriter;

public class ScrapperFacade
{
	private IReader _reader = new CSVReader();
	private IWebParser _parser = new JSoupWebParser();
	private IWriter _writer = new JenaRDFWriter();
	
	public void scrapeData(String inputLocation, String outputLocation) throws FileNotFoundException
	{
		System.out.println("Opening " + inputLocation);
		_reader.openLocation(inputLocation);
		System.out.println("Opening " + outputLocation);
		_writer.openLocation(outputLocation);
		Iterator<Data> i = _reader.getData();
		
		while (i.hasNext())
		{
			Data d = i.next();

			System.out.println("Parsing " + d.Url);
			_parser.scrapeData(d);
			System.out.println("Writing" + d.Url);
			_writer.writeData(d);
		}
		System.out.println("Closing " + outputLocation);
		_writer.closeLocation();
		System.out.println("Closing " + inputLocation);
		_reader.closeLocation();
	}
}
