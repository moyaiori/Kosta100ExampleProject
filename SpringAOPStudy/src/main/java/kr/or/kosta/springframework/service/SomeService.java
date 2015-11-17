package kr.or.kosta.springframework.service;

import org.springframework.stereotype.Service;

@Service("someService")
public class SomeService {
	
	public void someMethod(){
		System.out.println("Database 처리함...");
	}	

	
	public void someMethod2(){
		System.out.println("Database 처리함2...");
	}	

}
