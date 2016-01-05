package com.factrus.main.scrapper.interfaces;

import java.util.Iterator;
import java.io.FileNotFoundException;

import com.factrus.main.scrapper.model.Data;

/**
 * 
 * @author edmond_j
 *
 */
public interface IReader
{
	void openLocation(String location) throws FileNotFoundException;
	Iterator<Data> getData();
	void closeLocation();
}