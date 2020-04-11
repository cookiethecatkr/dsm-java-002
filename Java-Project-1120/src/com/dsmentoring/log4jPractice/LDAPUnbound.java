package com.dsmentoring.log4jPractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.SearchRequest;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchScope;

public class LDAPUnbound {

	private static final Logger LOG = LogManager.getLogger(LDAPUnbound.class);
	
	public static LDAPConnection connectSDK(String ip, int port, String id, String pw) throws LDAPException {
			
		LDAPConnection ldap = new LDAPConnection(ip,port,id,pw);
		LOG.info("접속 성공");	
		return ldap;
	}
	    
	public static void searchSDK(String filter, LDAPConnection ldap) throws LDAPException {
			
		SearchResult searchResult = ldap.search("c=kr",SearchScope.SUB,filter);
		LOG.info(searchResult);
		LOG.info(searchResult.getEntryCount());
		LOG.info(searchResult.getSearchEntries());
	}

	public static void closeSDK(LDAPConnection ldap) {
		
		ldap.close();
		LOG.info("사요나라");
	}
	
	public static void main(String[] args) throws LDAPException {
		
		LDAPConnection ldap = connectSDK("192.168.0.60",389,"1r","2r");
		searchSDK("cn=lee",ldap);
		closeSDK(ldap);
	}	
} 

