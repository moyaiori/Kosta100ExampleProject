package kr.or.kosta.ims.model;
/**
 * 악기 객체 추상화 클래스
 * @author 신영선
 *
 */
public class Instrument {
	
	private Instruments name;
	private String serialNumber;
	private double price;
	private InstrumentSpecification instSpec;
	
	/** 악기 객체 생성을 위한 생성자 */
	public Instrument(){}
	
	public Instrument(Instruments name, String serialNumber, double price, InstrumentSpecification instSpec){
		this.name = name;
		this.serialNumber = serialNumber;
		this.price = price;		
		this.instSpec = instSpec;
	}

	/** 악기의 속성을 얻거나, 넣기 위한 setter/getter 메소드 */
	
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
	
	public InstrumentSpecification getInstrumentSpecification(){
		return instSpec;
	}
	
	public void setInstrumentSpecification(InstrumentSpecification instSpec){
		this.instSpec = instSpec;
	}
	
	
	/** 모든 속성 출력을 위한 toString()메소드 */
	@Override
	public String toString() {
		 
		return name+"\t"+serialNumber+"\t"+ price+"\t"+ instSpec.toString();
	}	
	
}
