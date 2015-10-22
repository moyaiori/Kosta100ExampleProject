package kr.or.kosta.shopping.common.controller;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

/**
 * Singleton 패턴 및 Factory 메소드 패턴이 적용된 ControllerFactory
 * @author 김기정
 *
 */
public class ControllerFactory {
	
	// 매핑파일 경로
	private String controllerMappingPath;
	
	// 요청에 대한 세부 컨트롤러 클래스 생성 및 관리
	private HashMap<String, Controller> controllerMap; 
	
	private static ControllerFactory controllerFactory;
	
	private ControllerFactory(){}
	
	private ControllerFactory(String configFilePath){
		this.controllerMappingPath = configFilePath;
		controllerMap = new HashMap<String, Controller>();
		// 매핑정보를 저장할 Properties 객체 생성
		Properties prop = new Properties();
		FileInputStream fis = null;
		try{
			
			fis = new FileInputStream(configFilePath);
			prop.load(fis);
			Iterator keyIter = prop.keySet().iterator();
			while(keyIter.hasNext()){
				String controllerName = (String)keyIter.next();
				String controllerClass = prop.getProperty(controllerName);
				// 컨트롤러 생성
				Controller controllerObject = (Controller)Class.forName(controllerClass).newInstance();
				controllerMap.put(controllerName, controllerObject);
				System.out.println("[Debug] controllerName(ControllerFactory) : " + controllerName);
				System.out.println("[Debug] controllerClass(ControllerFactory) : " + controllerClass);
			}
		}catch(Exception ex){}		
	}
	
	/** 싱글톤 패턴 적용을 위한 공개 메소드 */
	public static ControllerFactory getInstance(String controllerMappingPath){
		if(controllerFactory == null){
			synchronized (ControllerFactory.class) {
				controllerFactory = new ControllerFactory(controllerMappingPath);
			}
		}
		return controllerFactory;
	}
	
	public Controller getController(String controllerName){
		return controllerMap.get(controllerName);		
	}
}
