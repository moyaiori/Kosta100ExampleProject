package kr.or.kosta.ims.model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * 악기를 관리하기 위한 관리 구상 클래스
 * @author 손진영
 *
 * 작성일 : 2015-07-31
 */
public class Inventory {
	/** 악기를 관리한 목록 속성 */
	Vector<Instrument> instruments;

	/** Constructor */
	public Inventory() {
		this(10, 2);
	}

	public Inventory(int count, int increment) {
		instruments = new Vector<Instrument>(count, increment);
		
		/** 생성시 데이터 추가 */
		initInventoryData();
	}

	/** 저장된 데이터 개수 */
	public int getCount() {
		return instruments.size();
	}

	/** 악기 목록을 관리하는 Method */

	/** 각각의 속성을 입력하여 목록에 추가 */
	public boolean add(Instruments name, String serialNumber, double price, InstrumentSpecification spec) {
		Instrument instrument = new Instrument(name, serialNumber, price, spec);
		return checkSerialNumber(instrument);
	}

	/** 악기 객체를 받아 목록에 추가 */
	public boolean add(Instrument instrument) {
		return checkSerialNumber(instrument);
	}

	/** 악기 리스트에 같은 SerialNumer가 있는지 판별 */
	public boolean checkSerialNumber(Instrument checkSerial) {
		/** 현재 목록에 악기 리스트를 가져옴 */
		String serialNum = checkSerial.getSerialNumber();
		Enumeration<Instrument> e = instruments.elements();
		while (e.hasMoreElements()) {
			Instrument instrument = e.nextElement();
			/** 목록에 SerialNumber가 존재하고 있으면 추가하지 않음 */
			if (instrument.getSerialNumber().equals(serialNum)) {
				return false;
			}
		}
		instruments.addElement(checkSerial);
		return true;
	}

	/** 고유 번호를 입력하여 악기 정보 가져오기 */
	public Instrument get(String serialNumber) {
		Enumeration<Instrument> e = instruments.elements();
		while (e.hasMoreElements()) {
			Instrument instrument = e.nextElement();
			/** 악기리스트 목록에서 SerialNumber가 동일한 객체를 찾음 */
			if (instrument.getSerialNumber().equals(serialNumber)) {
				return instrument;
			}
		}
		/** 조회된 악기 정보가 없을 경우 null 반환 */
		return null;
	}

	/** 검색하고자 하는 악기 명세 객체를 받아 일치하는 악기 정보 가져오기 */
	public List<Instrument> search(InstrumentSpecification spec) {
		Builders builder = (Builders)spec.getProperty("builder");
		String model = (String)spec.getProperty("model");
		
		List<Instrument> searchList = new ArrayList<Instrument>();
		Enumeration<Instrument> e = instruments.elements();
		while (e.hasMoreElements()) {
			Instrument instrument = e.nextElement();
			/** 
			 * 검색 내용이 있고 저장되어 있는 내용과 일치하지 않으면 continue
			 * 검색 내용이 있고 저장되어 있는 내용과 일치하면 모두 비교 후 검색 리스트에 저장
			 * 검색 내용이 없으면 다음 기타 속성 검색
			 */
			if (builder != null && !instrument.getSpecification().getProperty("builder").equals(builder)){ continue; }
			if (!model.equals("") && !instrument.getSpecification().getProperty("model").equals(model)){ continue; }
			searchList.add(instrument);
		}
		/** 검색된 내용이 없으면 null 반환 */
		if(searchList.size() == 0){
			return null;
		}
		return searchList;
	}

	/** 등록되어 있는 악기 전체 목록 가져오기 */
	public List<Instrument> searchAll() {
		/** 등록된 기타가 없을 경우 */
		if (getCount() == 0) {
			return null;
		}
		List<Instrument> allList = new ArrayList<Instrument>();
		allList.addAll(instruments);
		return allList;
	}
	
	/** 테스트를 위한 데이터 초기화 */
	public void initInventoryData(){
		InstrumentSpecification spec = new InstrumentSpecification();
		spec.setProperty("builder", Builders.FENDER);
		spec.setProperty("model", "aaaaaa");
		spec.setProperty("type", Types.ACOUSTIC);
		spec.setProperty("topwood", Woods.MAHOGANY);
		spec.setProperty("backwood", Woods.MAPLE);
		add(Instruments.GUITAR, "a11b3c", 100000.0, spec);
		
		spec = new InstrumentSpecification();
		spec.setProperty("builder", Builders.OLSON);
		spec.setProperty("model", "bbbbb");
		spec.setProperty("type", Types.ELECTRIC);
		spec.setProperty("topwood", Woods.ROSEWOOD);
		spec.setProperty("backwood", Woods.COCOBOLO);
		add(Instruments.GUITAR, "111cca", 400000.0, spec);
		
		spec = new InstrumentSpecification();
		spec.setProperty("builder", Builders.FENDER);
		spec.setProperty("model", "ssssss");
		spec.setProperty("style", Styles.A);
		spec.setProperty("topwood", Woods.ROSEWOOD);
		spec.setProperty("backwood", Woods.MAPLE);
		add(Instruments.MANDOLIN, "pp15fd", 1000000.0, spec);
		
		spec = new InstrumentSpecification();
		spec.setProperty("builder", Builders.MARTIN);
		spec.setProperty("model", "ffffff");
		spec.setProperty("style", Styles.F);
		spec.setProperty("topwood", Woods.ROSEWOOD);
		spec.setProperty("backwood", Woods.ROSEWOOD);
		add(Instruments.MANDOLIN, "u4k2l1", 500000.0, spec);
	}

}
