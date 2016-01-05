package com.factrus.main.scrapper.test;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import com.factrus.main.scrapper.model.Data;
import com.factrus.main.scrapper.parser.JSoupWebParser;
import com.factrus.main.scrapper.reader.CSVReader;

public class TestParser
{
	public static Scanner sc;
	public static String fileLoc;
	
	public static void main(String[] args)
	
	{

		sc = new Scanner(System.in);
		
		try
		{
			CSVReader reader = new CSVReader();
			JSoupWebParser parser = new JSoupWebParser();
			Iterator<Data> i;
			
			System.out.println("Enter file location: ");
			fileLoc = sc.nextLine();

			reader.openLocation(fileLoc);
			i = reader.getData();

			while (i.hasNext())
			{
				Data d = i.next();
				parser.scrapeData(d);

				System.out.println("--------------------------------------------");
				System.out.println("Url: " + d.Url);

				Iterator<Map.Entry<String, String>> it = d._attributes.entrySet().iterator();

				while (it.hasNext()) 
				{
					Map.Entry<String, String> entry = it.next();
					System.out.println(entry.getKey() + ": " + entry.getValue());
				}
			}
		}
		catch (Exception e)
		{}

	}	
}
