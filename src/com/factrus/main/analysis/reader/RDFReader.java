package com.factrus.main.analysis.reader;

import java.util.ArrayList;
import java.util.List;

import com.factrus.main.model.Application;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResIterator;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.rdf.model.impl.StatementImpl;

public class RDFReader
{
	public static List<Application> parseFile(String location)
	{
		List<Application> output = new ArrayList<Application>();
		Model model = ModelFactory.createDefaultModel();
		Property nameProp = model.createProperty("http://factrus/prop#AppName");
		Property devProp = model.createProperty("http://factrus/prop#AppDevelopper");
		Property iconProp = model.createProperty("http://factrus/prop#AppIcon");
		Property ratingProp = model.createProperty("http://factrus/prop#AppRating");
		Property priceProp = model.createProperty("http://factrus/prop#AppPrice");
		Property downloadProp = model.createProperty("http://factrus/prop#Downloads");
		Property starOneProp = model.createProperty("http://factrus/prop#StarOne");
		Property starTwoProp = model.createProperty("http://factrus/prop#StarTwo");
		Property starThreeProp = model.createProperty("http://factrus/prop#StarThree");
		Property starFourProp = model.createProperty("http://factrus/prop#StarFour");
		Property starFiveProp = model.createProperty("http://factrus/prop#StarFive");

		model.read(location);
		
		ResIterator it = model.listSubjects();
		
		while (it.hasNext())
		{
			Resource subject = it.next();
			
			if (!subject.getLocalName().isEmpty())
			{
				output.add(new Application(
						subject.getProperty(nameProp).getString(),
						subject.getProperty(devProp).getString(),
						subject.getProperty(iconProp).getString(),
						subject.getProperty(ratingProp).getString(),
						subject.getProperty(priceProp).getString(),
						subject.getProperty(downloadProp).getString(),
						subject.getProperty(starOneProp).getString(),
						subject.getProperty(starTwoProp).getString(),
						subject.getProperty(starThreeProp).getString(),
						subject.getProperty(starFourProp).getString(),
						subject.getProperty(starFiveProp).getString()
						));
				//System.out.println(subject.getProperty(iconProp).getString());
			}
		}
		
		return output;
	}
}
