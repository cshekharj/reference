package com.chandra.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
You are in charge of a display advertising program. 
Your ads are displayed on websites all over the internet. 
You have some CSV input data that counts how many times 
that users have clicked on an ad on each individual domain. 
Every line consists of a click count and a domain name, like this:

counts = [ "900,google.com",
     "60,mail.yahoo.com",
     "10,mobile.sports.yahoo.com",
     "40,sports.yahoo.com",
     "300,yahoo.com",
     "10,stackoverflow.com",
     "20,overflow.com",
     "2,en.wikipedia.org",
     "1,m.wikipedia.org",
     "1,mobile.sports",
     "1,google.co.uk"]

Write a function that takes this input as a parameter and 
returns a data structure containing the number of clicks that 
were recorded on each domain AND each subdomain under it. 
For example, a click on "mail.yahoo.com" counts toward 
the totals for "mail.yahoo.com", "yahoo.com", and "com". 
(Subdomains are added to the left of their parent domain. 
So "mail" and "mail.yahoo" are not valid domains. 
Note that "mobile.sports" appears as a separate domain near the bottom of the input.)

Sample output (in any order/format):

calculateClicksByDomain(counts)
1340    com
 900    google.com
  10    stackoverflow.com
  20    overflow.com
 410    yahoo.com
  60    mail.yahoo.com
  10    mobile.sports.yahoo.com
  50    sports.yahoo.com
   3    org
   3    wikipedia.org
   2    en.wikipedia.org
   1    m.wikipedia.org
   1    mobile.sports
   1    sports
   1    uk
   1    co.uk
   1    google.co.uk

*/


public class ClicksByDomain {

	public static void main(String[] args) {
		String[] domainCounts  = {"10,mobile.sports.yahoo.com"
				/*,"60,mail.yahoo.com",
		                         "900,google.com",
                                 "40,sports.yahoo.com",
                                 "300,yahoo.com",
                                 "10,stackoverflow.com",
                                 "20,overflow.com",
                                 "2,en.wikipedia.org",
                                 "1,m.wikipedia.org",
                                 "1,mobile.sports",
                                 "1,google.co.uk"*/
                                 };
		ClicksByDomain domainClicks=new ClicksByDomain();
		List<Domain> domains= domainClicks.getDomainCount(domainCounts);
		
	}
	
	public List<Domain>getDomainCount(String[] inputStrings){
	    Map<String,Domain> domainMap = new HashMap<>();
	    String subDomainstr="";
	    
	    int subDomainCount = 0;
	    for(String str:inputStrings){
	    // split the string based on "," to get domain and count
	      String[] domaString=str.split(",");
	    
	    // get domain string and count
	      subDomainstr=domaString[domaString.length-1];
	      subDomainCount=Integer.parseInt(domaString[0]);
	      System.out.println("subdomain:-"+subDomainstr+" count:-"+subDomainCount);
	      
	    // get subdomains in domain string
	      List<String> subDomains= new ArrayList<>();
	      String root= subDomainstr.substring(subDomainstr.lastIndexOf('.')+1, subDomainstr.length());
	      String sub=subDomainstr;
	      System.out.println("root:-"+root);
	      while(!sub.equalsIgnoreCase(root)){
	    	  sub=sub.substring(sub.indexOf('.')+1, sub.length());
	    	  subDomains.add(sub);
	      }
	      System.out.println("subDomainstr:- "+subDomainstr);
	      for(String s:subDomains)
	    	  System.out.println(s);
	      
	      //  if root domain object exists in domain map
	      if(domainMap.containsKey(root)){
	    	  Domain domain=domainMap.get(root);
	    	  SubDomain dom;
	    	  // if subdomain exists update subdomain and domain count
			  for(Entry e:domain.subDomainMap.entrySet()){
				   dom = (SubDomain) e.getValue();
				   if((dom.domainString.equalsIgnoreCase(subDomainstr)
						   ||(dom.domainString.endsWith(subDomainstr)))){
					   dom.count = dom.count+subDomainCount;
					   domain.addtoclicks(subDomainCount);
				   }
			  }
	      }
	      else
	      {
	    	  //create new domain object, add details
	    	  Domain domain = new Domain();
	    	  domain.addtoclicks(subDomainCount);
	    	  // add sub domains and their counts
			  // add the first subdomain
	    	  SubDomain first = new SubDomain(subDomainCount, subDomainstr);
	    	  domain.subDomainMap.put(subDomainstr,first);
	    	  for(String s:subDomains){
	    		  SubDomain domsub = new SubDomain(subDomainCount,s);
	    		  domain.subDomainMap.put(s, domsub);
	    	  }
	    	  //set the domain object in the map
	    	  domainMap.put(root, domain);
	      }
	     
	      
	      // print domain map
	      
	      for(Entry<String, Domain> e:domainMap.entrySet()){
	    	  System.out.println("---------");
	    	  System.out.println("Root-:"+e.getKey());
	    	  System.out.println("RootDomain Total-:"+e.getValue().totalDomainCount);
	    	  for(Entry<String, SubDomain> es:e.getValue().subDomainMap.entrySet()){
	    		  
	    		  System.out.println(es.getKey());
	    		  System.out.println(es.getValue().count);
	    		  System.out.println(es.getValue().domainString);
	    	  }
	    	  
	    	  
	      }
	    }
	    List<Domain> resultList = new ArrayList<>();
	    
	    return resultList;
	  }
}

  
  class Domain{
  int totalDomainCount=0;
  Map<String,SubDomain> subDomainMap = new HashMap<>();
  
	public void addtoclicks(int subDomainCount) {
		this.totalDomainCount+=subDomainCount;
	}
}

  class SubDomain{
    int count=0;
    String domainString;
    
    public SubDomain(int count, String str){
    	this.count=count;
    	this.domainString=str;
    }
  }

