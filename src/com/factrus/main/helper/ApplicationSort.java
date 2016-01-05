package com.factrus.main.helper;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.factrus.main.model.Application;

public class ApplicationSort {
	
	public enum Field {NAME, DEV, DATE, RATING, PRICE};
	
	public static void sortByField(List <Application> apps, final Field field, final boolean ascending)
	{
		Collections.sort(apps, new Comparator<Application>() {
			public int compare(Application a, Application b) 
			{ 
				switch (field)
				{
				case NAME:
					return (ascending ? a.getName().compareTo(b.getName()) : b.getName().compareTo(a.getName())); 
				case DEV:
					return (ascending ? a.getDeveloper().compareTo(b.getDeveloper()) : b.getDeveloper().compareTo(a.getDeveloper()));
				case RATING:
					return (ascending ? a.getRating().compareTo(b.getRating())  : b.getRating().compareTo(a.getRating()));
				case PRICE:
					return (ascending ? a.getPrice().compareTo(b.getPrice())  : b.getPrice().compareTo(a.getPrice()));
				default:
					return 0;
				}			
			}
		});
	}
}
