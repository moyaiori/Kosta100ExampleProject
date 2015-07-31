package ko.or.kosta.ims.model;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public class Inventory {

	private Vector<Guitar> inventory;

	public Inventory() {
		inventory = new Vector<Guitar>();
		testData();
	}

	/**
	 * 속성을 받아서 기타 객체생성 및 저장
	 * 
	 * @param serialNumber
	 * @param price
	 * @param builder
	 * @param model
	 * @param type
	 * @param topWood
	 * @param backWood
	 */
	public void add(String serialNumber, double price, String builder, String model, String type, String topWood,
			String backWood) {
		inventory.addElement(new Guitar(serialNumber, price, builder, model, type, topWood, backWood));

	}

	/**
	 * 테스트를 위한 임시 데이터
	 */
	public void testData() {
		add(new Guitar("111", 1000, "kosta01", "모델02", "베이스기타", "통나무", "벚나무"));
		add(new Guitar("222", 2000, "kosta02", "모델02", "일렉기타", "사과나무", "소나무"));
		add(new Guitar("333", 3000, "kosta03", "모델03", "베이스기타", "통나무", "느티나무"));
		add(new Guitar("444", 2000, "kosta03", "모델04", "통기타", "배나무", "아낌없이주는나무"));
	}

	/**
	 * 기타 객체로 바로 생성한다.
	 * 
	 * @param guitar
	 */
	public void add(Guitar guitar) {
		inventory.addElement(guitar);
	}

	/**
	 * 기타 일련번호로 기타를 찾는다.
	 * 
	 * @param serialNumber
	 * @return
	 */
	public Guitar get(String serialNumber) {
		Enumeration<Guitar> e = inventory.elements();
		while (e.hasMoreElements()) {
			Guitar guitar = e.nextElement();
			if (guitar.getSerialNumber().equals(serialNumber)) {
				return guitar;
			}
		}
		return null;
	}

	/**
	 * 검색 속성으로 기타를 찾는다. AND 조건으로 검색한다.(주어진 속성이 모두같은 객체만 찾는다.) serialNumber를 제외한
	 * 속성값으로 검색한다.
	 * 
	 * @param guitar
	 * @return
	 */
	public List<Guitar> search(Guitar guitar) {
		
		ArrayList<Guitar> result = new ArrayList<Guitar>();
		Hashtable<String, Object> value = getSearchValue(guitar);
		Set<String> tempSet = value.keySet();
		String[] keyArray = new String[tempSet.size()]; //검색하고자하는 속성타입
		tempSet.toArray(keyArray);
		
		List<Guitar> list = searchAll();
		for (int i = 0; i < keyArray.length; i++) {
			Object keyByValue = value.get(keyArray[i]); // 각 속성에 해당되는 검색어
			for (int j = 0; j < list.size(); j++) {
				Guitar g = list.get(j);
				if (keyByValue.equals(callMethodName(keyArray[i], g))) {
					result.add(g);
				}
				callMethodName(keyArray[i], g);
			}
		}
		
		return result;
	}
	
	public Object callMethodName(String methodName, Guitar guitar){
		Object result = "";
		switch (methodName) {
		case "price":
			result = guitar.getPrice();
			break;
		case "builder":
			result = guitar.getBuilder();
			break;
		case "model":
			result = guitar.getModel();
			break;
		case "type":
			result = guitar.getType();
			break;
		case "topWood":
			result = guitar.getTopWood();
			break;
		case "backWood":
			result = guitar.getBackWood();
			break;
		}
		return result;
	}

	/**
	 * 검색조건 검출
	 * 
	 * @param guitar
	 * @return
	 */
	public Hashtable<String, Object> getSearchValue(Guitar guitar) {
		// System.out.println(guitar);
		// System.out.println(guitar.getBuilder());
		Hashtable<String, Object> result = new Hashtable<String, Object>();

		if (guitar.getPrice() != 0.0) {
			result.put("price", guitar.getPrice());

		}
		if (guitar.getBuilder() != "") {
			result.put("builder", guitar.getBuilder());

		}
		if (guitar.getModel() != "") {
			result.put("model", guitar.getModel());

		}
		if (guitar.getType() != "") {
			result.put("type", guitar.getType());

		}
		if (guitar.getTopWood() != "") {
			result.put("topWood", guitar.getTopWood());

		}
		if (guitar.getBackWood() != "") {
			result.put("backWood", guitar.getBackWood());
		}

		// result.put("test1", "test2");

		return result;
	}

	/**
	 * 현재 보유하고있는 모든기타를 보여준다.
	 * 
	 * @return
	 */
	public List<Guitar> searchAll() {
		List<Guitar> list = new ArrayList<Guitar>(inventory.size());
		list.addAll(inventory);
		return list;
	}

}
