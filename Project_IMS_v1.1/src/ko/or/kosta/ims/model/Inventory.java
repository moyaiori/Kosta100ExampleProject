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
	public void add(String serialNumber, double price, Guitar.Builders builder, String model, Guitar.Types type,
			Guitar.Woods topWood, Guitar.Woods backWood) {
		inventory.addElement(new Guitar(serialNumber, price, builder, model, type, topWood, backWood));

	}

	/**
	 * 테스트를 위한 임시 데이터
	 */
	public void testData() {
		add(new Guitar("111", 1000, Guitar.Builders.COLLINGS, "모델02", Guitar.Types.ACOUSTIC, Guitar.Woods.COCOBOLO,
				Guitar.Woods.ROSEWOOD));
		add(new Guitar("222", 2000, Guitar.Builders.FENDER, "모델02", Guitar.Types.ACOUSTIC, Guitar.Woods.ALDER,
				Guitar.Woods.MAHOGANY));
		add(new Guitar("333", 3000, Guitar.Builders.GIBSON, "모델03", Guitar.Types.ELECTRIC, Guitar.Woods.MAHOGANY,
				Guitar.Woods.COCOBOLO));
		add(new Guitar("444", 2000, Guitar.Builders.COLLINGS, "모델04", Guitar.Types.CLASSIC, Guitar.Woods.MAHOGANY,
				Guitar.Woods.ROSEWOOD));
		add(new Guitar("555", 2000, Guitar.Builders.COLLINGS, "모델04", Guitar.Types.CLASSIC, Guitar.Woods.MAHOGANY,
				Guitar.Woods.ROSEWOOD));
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
		ArrayList<Guitar> tempList = new ArrayList<Guitar>();

		Hashtable<String, Object> value = getSearchValue(guitar);// 검색어와 검색어의 타입
		Set<String> tempSet = value.keySet();
		String[] keyArray = new String[tempSet.size()]; // 검색하고자하는 속성타입
		tempSet.toArray(keyArray);

		List<Guitar> listAll = searchAll(); // 현재 인벤토리에 있는 모든 기타 객체들
		

		int loopNum = 0;

		for (int i = 0; i < keyArray.length; i++) { // 검색어 숫자만큼 루프문을 돈다
			Object keyByValue = value.get(keyArray[i]); // 각 속성에 해당되는 검색어
			
			// 여기까지헀음 3단계 해야된, 검색메서드 수정필요
			/*
			 * 각각의 검색어를 기준으로 모든객체들 돌면서 속성값이 맞는지 확인한다.
			 */
			for (int j = 0; j < listAll.size(); j++) {
				Guitar g = listAll.get(j);
				if (keyByValue.equals(getGuitarAttribute(keyArray[i], g))) {
					tempList.add(g);
				}
			}
			
//			tempList
			loopNum = tempList.size();
			System.out.println(loopNum);

			for (int j = 0; j < loopNum; j++) {
				
				Guitar g = tempList.get(j);
				if (keyByValue.equals(getGuitarAttribute(keyArray[i], g))) {
					tempList.add(g);
				}
			}
			
			System.out.println("111");
			
			
			
			
//			System.out.println("444");
//			if (i == 0) {
//				for (int j = 0; j < listAll.size(); j++) {
//					Guitar g = listAll.get(j);
//					if (keyByValue.equals(getGuitarAttribute(keyArray[i], g))) {
//						tempList.add(g);
//					}
//				}
//			} else {
//				System.out.println("333");
//				for (int j = 0; j < tempList.size(); j++) {
//					Guitar g = tempList.get(j);
//					if (keyByValue.equals(getGuitarAttribute(keyArray[i], g))) {
//						tempList.add(g);
//						System.out.println("222");
//					}
//				}
//			}
			
		}

		return result;
	}

	public Object getGuitarAttribute(String methodName, Guitar guitar) {
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
		Hashtable<String, Object> result = new Hashtable<String, Object>();
		// System.out.println(guitar.getModel());

		if (guitar.getPrice() != 0.0) {
			result.put("price", guitar.getPrice());

		}

		if (guitar.getBuilder() != null) {
			result.put("builder", guitar.getBuilder());

		}

		if (guitar.getModel() != null) {
			result.put("model", guitar.getModel());

		}

		if (guitar.getType() != null) {
			result.put("type", guitar.getType());

		}

		if (guitar.getTopWood() != null) {
			result.put("topWood", guitar.getTopWood());

		}

		if (guitar.getBackWood() != null) {
			result.put("backWood", guitar.getBackWood());
		}
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
