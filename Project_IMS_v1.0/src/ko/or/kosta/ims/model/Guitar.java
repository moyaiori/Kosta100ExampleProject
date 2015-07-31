package ko.or.kosta.ims.model;

public class Guitar {
	
	private String serialNumber; 	/** 일련번호, 고유한값 */
	private double price; 			/** 가격 */
	private String builder; 		/** 제조사*/
	private String model; 			/** 모델명*/
	private String type; 			/** 종류 (통기타, 일렉기타, 베이스기타)*/
	private String topWood; 		/** 앞 나무 제질*/
	private String backWood; 		/** 뒷 나무 제질*/
	
	public Guitar(){
		this(null, 0.0, null, null, null, null, null);
	}

	public Guitar(String serialNumber, double price, String builder, String model, String type, String topWood,
			String backWood) {
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
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTopWood() {
		return topWood;
	}
	public void setTopWood(String topWood) {
		this.topWood = topWood;
	}
	public String getBackWood() {
		return backWood;
	}
	public void setBackWood(String backWood) {
		this.backWood = backWood;
	}

	@Override
	public String toString() {
		return "Guitar [serialNumber=" + serialNumber + ", price=" + price + ", builder=" + builder + ", model=" + model
				+ ", type=" + type + ", topWood=" + topWood + ", backWood=" + backWood + "]";
	}
	

}
