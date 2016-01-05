package com.factrus.main.scrapper.test;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;

import com.factrus.main.analysis.reader.RDFReader;
import com.factrus.main.model.Application;
import com.factrus.main.scrapper.scrapper.ScrapperFacade;

public class TestScrapper
{
	public static void main(String[] args)
	
	{
		ScrapperFacade scrapper = new ScrapperFacade();
		Scanner sc = new Scanner(System.in);
		String in;
		String out;
		
		try
		{
			System.out.println("Enter input location: ");
			in = sc.nextLine();

			System.out.println("Enter output location: ");
			out = sc.nextLine();
			
			scrapper.scrapeData(in, out);
			
			List<Application> applications = RDFReader.parseFile("d:/_Class/FactrUs/src/com/factrus/resources/output.rdf");
			
			System.out.println(applications.size());
			
			System.out.println("Done!");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		sc.close();
	}	
}
