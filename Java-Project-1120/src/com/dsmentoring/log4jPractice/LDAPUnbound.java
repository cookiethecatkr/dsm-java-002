package com.dsmentoring.log4jPractice;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.SearchRequest;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchScope;

public class LDAPUnbound {

	public static LDAPConnection connectSDK(String ip, Integer port, String id, String pw) throws LDAPException    {
			
		LDAPConnection ldap = new LDAPConnection(ip,port,id,pw);
		System.out.println("접속 성공");	
		return ldap;
			
	}
	    
	public static void searchSDK(String filter, LDAPConnection ldap) throws LDAPException {
			
		SearchRequest searchRequest = new SearchRequest("c=kr",SearchScope.SUB,filter);
		SearchResult searchResult = ldap.search(searchRequest);
		System.out.println(searchResult);
			
	}

	public static void closeSDK(LDAPConnection ldap) {
		
		ldap.close();
		System.out.println("사요나라");
	}
	
	public static void main(String[] args) throws LDAPException {
		
		LDAPConnection ldap = connectSDK("192.168.0.60",389,"cn=govmanager","GOVmoi!manager");
		
		searchSDK("cn=007이진형001",ldap);
		
		//closeSDK(ldap);
	}	

} 

