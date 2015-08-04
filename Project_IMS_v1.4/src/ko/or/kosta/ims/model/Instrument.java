package ko.or.kosta.ims.model;

import ko.or.kosta.ims.model.InstrumentSpecification.Instruments;
/**
 * 5단계 적용
 * @author Lee Gwangyong
 * 2015. 08. 03
 */
public class Instrument {
	
	private Instruments name; 		/** 악기 종류 */
	private String serialNumber; 	/** 일련번호, 고유한값 */
	private double price; 			 /** 가격 */
	private InstrumentSpecification spec; /** 악기정보 */
	
	public Instrument(){
		this(null, null, 0.0, null);
	}
	public Instrument(Instruments name, String serialNumber, double price, InstrumentSpecification spec) {
		super();
		this.name = name;
		this.serialNumber = serialNumber;
		this.price = price;
		this.spec = spec;
	}


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
	
	public InstrumentSpecification getSpecification(){
		return spec;
	}


	@Override
	public String toString() {
		return "Instrument [name=" + name + ", serialNumber=" + serialNumber + ", price=" + price + ", ="+ spec + "]";
	}

}
