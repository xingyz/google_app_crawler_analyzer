package com.factrus.main.scrapper.interfaces;

import java.io.FileNotFoundException;

import com.factrus.main.scrapper.model.Data;

public interface IWriter 
{
	void openLocation(String location) throws FileNotFoundException;
	void writeData(Data data);
	void closeLocation();
}
