package com.factrus.main.scrapper.writer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.factrus.main.scrapper.interfaces.IWriter;
import com.factrus.main.scrapper.model.Data;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Resource;

public class JenaRDFWriter implements IWriter
{
	private FileOutputStream _file;
	private Model _model;
	private Resource _root;

	private static final String _rootUrl = "http://factrus/app#";
	private static final String _propUrl = "http://factrus/prop#";
	private static final Pattern _pattern = Pattern.compile(".*id=(?<id>.*)");
	
	@Override
	public void openLocation(String location) throws FileNotFoundException 
	{
		_file = new FileOutputStream(location, false);
		_model = ModelFactory.createDefaultModel();
		_root = _model.createResource(_rootUrl);
	}

	@Override
	public void writeData(Data data)
	{
		Matcher m = _pattern.matcher(data.Url);
		Resource app = _model.createResource(_rootUrl + (m.matches() ? m.group("id") : "Unknown"));

		for (Map.Entry<String, String> attribute : data.getAttributes())
		{
			try {
				app.addProperty(_model.createProperty(_propUrl + URLEncoder.encode(attribute.getKey(), "UTF-8").replace("+", "_")), attribute.getValue());
			} catch (UnsupportedEncodingException e) {
			}
		}
		_model.add(_root, _model.createProperty(_rootUrl + (m.matches() ? m.group("id") : "Unknown")), app);
	}

	@Override
	public void closeLocation()
	{
		_model.write(_file);
		_model.close();
		try {
			_file.close();
		} catch (IOException e) {
		}
		_model = null;
		_file = null;
	}

}
