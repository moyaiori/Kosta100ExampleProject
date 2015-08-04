package ko.or.kosta.ims.model;

public class Guitar {
	
	private String serialNumber; 	 /** 일련번호, 고유한값 */
	private double price; 			 /** 가격 */
	private GuitarSpecification spec;/** 기타스팩 */
	
	public Guitar(){
		this(null, 0.0, null);
	}

	public Guitar(String serialNumber, double price, GuitarSpecification spec){
		super();
		this.serialNumber = serialNumber;
		this.price = price;
		this.spec = spec;
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
	
	public GuitarSpecification getSpecification(){
		return spec;
	}

	@Override
	public String toString() {
		return "Guitar [serialNumber=" + serialNumber + ", price=" + price + ", " + spec + "]";
	}
	
	

}
