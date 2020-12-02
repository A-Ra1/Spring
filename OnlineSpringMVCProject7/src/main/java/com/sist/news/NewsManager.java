package com.sist.news;

import java.util.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import java.net.*;

import org.springframework.stereotype.Component;

@Component
public class NewsManager {

	public List<Item> newsAllData(String fd) {
		
		List<Item> list=new ArrayList<Item>();
		
		try {
			
			String strUrl="http://newssearch.naver.com/search.naver?where=rss&query="
					+URLEncoder.encode(fd, "UTF-8");
			URL url=new URL(strUrl);
			JAXBContext jb=JAXBContext.newInstance(Rss.class);
			// 최상위 태그
			// xml을 Java클래스화 
			Unmarshaller un=jb.createUnmarshaller();
			// <rss> => Rss
			
			Rss rss=(Rss)un.unmarshal(url);
			list=rss.getChannel().getItem();                                                                                                    
		} catch (Exception e) {
		}
		
		return list;
	}
}
