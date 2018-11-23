package com.dsmentoring.log4jPractice;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Dog {

	/*JDBC와 UnboundID LDAP sdk는 인스턴스를 생성해서 처리하는 방법이 잘 생각이 나지 않아
	인스턴스 생성 후 메소드를 호출하는 방법을 이렇게 사용해 보았습니다. */
	
	static Logger LOG = LogManager.getLogger(Dog.class);
	
	String name;
	String type;
	
	Dog(String name, String type) {
		
		this.name = name;
		this.type = type;
	}
	
	public void dogBark() {
		LOG.info(type +"인 " + name+"가 멍멍멍");
	}
	
	public static void main(String[] args) {
		
		Dog dog1 = new Dog("멍멍이","푸들");
		Dog dog2 = new Dog("돌쇠","허스키");
		Dog dog3 = new Dog("달님이","도사");
		dog1.dogBark();
		dog2.dogBark();
		dog3.dogBark();
	}
}
