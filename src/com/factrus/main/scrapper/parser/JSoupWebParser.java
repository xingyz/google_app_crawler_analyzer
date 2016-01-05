package com.factrus.main.scrapper.parser;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.factrus.main.scrapper.interfaces.IWebParser;
import com.factrus.main.scrapper.model.Data;

public class JSoupWebParser implements IWebParser
{
	@Override
	public void scrapeData(Data data)
	{
		try {
			Document doc = Jsoup.connect(data.Url).get();
			
			data.setAttribute("AppName", doc.select("h1[itemprop=name] > div").text());
			data.setAttribute("AppDevelopper", doc.select("div[itemprop=author] > a").text());
			data.setAttribute("AppRating", doc.select("div.score").text());
			data.setAttribute("AppPrice", doc.select("button.price.buy").select("meta[itemprop=price]").attr("content"));
			data.setAttribute("AppIcon", doc.select("img.cover-image").attr("src"));
			data.setAttribute("StarFive", doc.select("div.five > span.bar-number").text());
			data.setAttribute("StarFour", doc.select("div.four > span.bar-number").text());
			data.setAttribute("StarThree", doc.select("div.three > span.bar-number").text());
			data.setAttribute("StarTwo", doc.select("div.two > span.bar-number").text());
			data.setAttribute("StarOne", doc.select("div.one > span.bar-number").text());
			data.setAttribute("Downloads", doc.select("div.reviews-stats > span.reviews-num").text());
			
		} catch (IOException e) {
			System.out.println("Warning: unable to reach " + data.Url);
		}
	}

}
