/**
 * 
 * @author edmond_j
 *

package com.factrus.main.scrapper.test;
 
public class TestCSV
{
	public static Scanner sc;
	public static String fileLoc;
	
	public static void main(String[] args)
	
	{

		sc = new Scanner(System.in);
		
		try
		{
			CSVReader reader = new CSVReader();
			Iterator<Data> i;
			
			System.out.println("Enter file location: ");
			fileLoc = sc.nextLine();

			reader.openLocation(fileLoc);
			i = reader.getData();

			while (i.hasNext())
			{
				Data d = i.next();

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
*/