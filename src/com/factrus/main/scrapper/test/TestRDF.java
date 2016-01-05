package com.factrus.main.scrapper.test;

import java.util.Iterator;
import com.factrus.main.scrapper.model.Data;
import com.factrus.main.scrapper.reader.CSVReader;
import com.factrus.main.scrapper.writer.JenaRDFWriter;

public class TestRDF {

	public static void main(String[] args)
	{
		if (args.length >= 2)
		{
			try
			{
				CSVReader reader = new CSVReader();
				JenaRDFWriter writer = new JenaRDFWriter();
				Iterator<Data> i;
				
				reader.openLocation(args[0]);
				writer.openLocation(args[1]);
				i = reader.getData();
				while (i.hasNext())
				{
					writer.writeData(i.next());
				}
				writer.closeLocation();
				reader.closeLocation();
			}
			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}

}
