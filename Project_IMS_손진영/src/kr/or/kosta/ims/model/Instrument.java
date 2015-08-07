package kr.or.kosta.ims.model;

import java.util.Formatter;

/**
 * 악기의 정보를 가지고 있는 구상클래스
 * 
 * @author 손진영
 *
 *         작성일 : 2015-08-03
 */
public class Instrument {
	/** 
	 * 악기의 정보 중 변경 가능성이 적은 Attribute
	 */
	private Instruments name;
	private String serialNumber;
	private double price;
	private InstrumentSpecification specification;

	/** Constructor */
	public Instrument() {
		this(null, null , 0.0, null);
	}

	/** GuitarSpecification은 Guitar와 집합관계이므로 생성자에서 같이 생성 */
	public Instrument(Instruments name, String serialNumber, double price, InstrumentSpecification spec) {
		this.name = name;
		this.serialNumber = serialNumber;
		this.price = price;
		this.specification = spec;
	}

	/** setter, getter */
	public Instruments getName() {
		return name;
	}

	public void setName(Instruments name) {
		this.name = name;
	}

	public String getSerialNumber() {
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public InstrumentSpecification getSpecification() {
		return specification;
	}
	
	/** 가격을 3자리마다 , 소수점 나오지 않게 포맷팅 */
	public String getFormatPrice(){
		Formatter format = new Formatter();
		return format.format("%,.0f원", price).toString();
	}

	/** Object의 toString() 오버라이딩 */
	@Override
	public String toString() {
		return "[악기종류 : " + name + ", 고유번호 : " + serialNumber + ", 가격 : " + price + ", " + specification + "]";
	}
	
	

}
