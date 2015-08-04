package ko.or.kosta.ims.model;

public class GuitarSpecification {

	private Builders builder; 		/** 제조사*/
	private String model; 			/** 모델명*/
	private Types type; 			/** 종류 (통기타, 일렉기타, 베이스기타)*/
	private Woods topWood; 			/** 앞 나무 제질*/
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

	public GuitarSpecification(Builders builder, String model, Types type, Woods topWood, Woods backWood) {
		super();
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.topWood = topWood;
		this.backWood = backWood;
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
		return "GuitarSpecification [builder=" + builder + ", model=" + model + ", type=" + type + ", topWood="
				+ topWood + ", backWood=" + backWood + "]";
	}
	
	
}
