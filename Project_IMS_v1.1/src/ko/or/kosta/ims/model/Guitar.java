package ko.or.kosta.ims.model;

public class Guitar {
	
	private String serialNumber; 	/** 일련번호, 고유한값 */
	private double price; 			/** 가격 */
	private Builders builder; 		/** 제조사*/
	private String model; 			/** 모델명*/
	private Types type; 			/** 종류 (통기타, 일렉기타, 베이스기타)*/
	private Woods topWood; 		/** 앞 나무 제질*/
	private Woods backWood; 		/** 뒷 나무 제질*/
	
	public enum Builders{
		FENDER, MARTIN, GIBSON, COLLINGS, OLSON, SAMIC
	}
	
	public enum Types{
		ACOUSTIC, CLASSIC, ELECTRIC
	}
	
	public enum Woods{
		ROSEWOOD, MAPLE, MAHOGANY, COCOBOLO, ALDER
	}
	
	public Guitar(){
		this(null, 0.0, null, null, null, null, null);
	}

	public Guitar(String serialNumber, double price, Builders builder, String model, Types type, Woods topWood,
			Woods backWood) {
		super();
		this.serialNumber = serialNumber;
		this.price = price;
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.topWood = topWood;
		this.backWood = backWood;
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
	public Builders getBuilder() {
		return builder;
	}
	public void setBuilder(Builders builder) {
		this.builder = builder;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Types getType() {
		return type;
	}
	public void setType(Types type) {
		this.type = type;
	}
	public Woods getTopWood() {
		return topWood;
	}
	public void setTopWood(Woods topWood) {
		this.topWood = topWood;
	}
	public Woods getBackWood() {
		return backWood;
	}
	public void setBackWood(Woods backWood) {
		this.backWood = backWood;
	}

	@Override
	public String toString() {
		return "Guitar [serialNumber=" + serialNumber + ", price=" + price + ", builder=" + builder + ", model=" + model
				+ ", type=" + type + ", topWood=" + topWood + ", backWood=" + backWood + "]";
	}
	

}
