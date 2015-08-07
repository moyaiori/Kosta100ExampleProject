package kr.or.kosta.ims.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

/**
 *  악기 목록 관리 추상화 클래스
 *  - 새로운 악기를 등록, 원하는 조건의 악기를 조회하고 악기 목록을 출력
 *  
 * @author 신영선
 */
public class Inventory {
	
	//속성
	private Vector<Instrument> instruments;
	
	//생성자
	public Inventory(){
		this(10,2);
		
	}
	public Inventory(int count, int increment){
		this.instruments = new Vector<Instrument>(count, increment);
	}
	
	/** 전체 악기의 수  */
	public int getCounts(){
		return instruments.size();
	}
	
	/** 사용자 정의 메소드 */
		
	/**
	 * #1. 신규 악기 등록 메소드(1)
	 * - 악기의 속성들을 입력받아 새로운 악기를 등록
	 */
	public void add(Instruments instrument, String serialNumber, double price, InstrumentSpecification instSpec){
		instruments.addElement(new Instrument(instrument, serialNumber, price, instSpec));
	}
	
	/**
	 * #2. 신규 악기 등록 메소드(2) 
	 * - 악기 자체를 받아서 악기를 등록
	 */
	public void add(Instrument instrument){
		instruments.addElement(instrument);
	}
	
	/**
	 * #3. 등록된 악기를 serialNumber로 조회하는 메소드
	 */
	public Instrument getInstrument(String serialNumber){
		Enumeration<Instrument> e = instruments.elements();
		while (e.hasMoreElements()) {
			Instrument instrument = (Instrument) e.nextElement();
			if(instrument.getSerialNumber().equals(serialNumber)){
				return instrument;
			}
		}
		return null;
	}
		
	/**
	 * #4. 악기의 일부 속성(제조사, 모델명)으로만 악기 조회하는 메소드
	 * 
	 */
	public List<Instrument> search(InstrumentSpecification instrumentSpec){

 		Builders builder = (Builders)instrumentSpec.getProperty("builder");
		String model = (String)instrumentSpec.getProperty("model");
		
		List<Instrument> list = new ArrayList<Instrument>();
		
		Enumeration<Instrument> e = instruments.elements();
			
		while(e.hasMoreElements()){ //e에 원소가 없을때까지 계속 비교
			Instrument isntr1 = (Instrument)e.nextElement();	
			
			if(builder != null && !isntr1.getInstrumentSpecification().getProperty("builder").equals(builder)){continue;}
			if(!(model.isEmpty()) && !isntr1.getInstrumentSpecification().getProperty("model").equals(model)){continue;}
			list.add(isntr1);
			
		}if(list.size() ==0){
			return null;
		}
		return list;
	}
	
	/**
	 * #5. 등록된 악기 전체 목록 조회 메소드
	 */
	
	public List<Instrument> searchAll(){
		List<Instrument> list = new ArrayList<Instrument>(instruments.size());
		list.addAll(instruments);
		return list;	
	}
	

}
