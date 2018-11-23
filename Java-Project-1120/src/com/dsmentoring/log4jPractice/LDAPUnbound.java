package com.dsmentoring.log4jPractice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.SearchResult;
import com.unboundid.ldap.sdk.SearchScope;

public class LDAPUnbound {

	private static final Logger LOG = LogManager.getLogger(LDAPUnbound.class);
	
	public LDAPConnection connectSDK(String ip, int port, String id, String pw) throws LDAPException {
			
		LDAPConnection ldap = new LDAPConnection(ip,port,id,pw);
		LOG.info("접속 성공");	
		return ldap;
	}
	    
	public SearchResult searchLdap(String baseDn, String filter, LDAPConnection ldap) throws LDAPException {
			
		SearchResult searchResult = ldap.search(baseDn,SearchScope.SUB,filter);
		LOG.info(searchResult.getSearchEntries());
		System.out.println(" 조회한 결과를 알려드리겠습니다." + searchResult.getSearchEntries());
		return searchResult;
	}

	public void closeLdap(LDAPConnection ldap) {
		
		ldap.close();
		LOG.info("사요나라");
	}
	
	public static void main(String[] args) throws LDAPException {
		LDAPUnbound unbound = new LDAPUnbound();
		LDAPConnection ldap = unbound.connectSDK("192.168.0.60",389,"cn=govmanager","GOVmoi!manager");
		unbound.searchLdap("c=kr","cn=lee",ldap);
		unbound.closeLdap(ldap);
	}	
} 

