package kr.or.kosta.ims.model;

import java.util.HashMap;

public class InstrumentSpecification {
    public enum Instruments {
        전체, GUITAR, MANDOLIN
    };

    public enum Builders {
        FENDER, MARTIN, GIBSON, COLLINGS, OLSON, SAMIC
    };

    public enum Types {
        ACOUSTIC, CLASSIC, ELECTRIC
    };

    public enum Woods {
        ROSEWOOD, MAPLE, MAHOGANY, ALDER, COCOBOLO
    };

    public enum Styles {
        A, F
    };

    private HashMap<String, Object> properties;

    // 초기 생성자

    public InstrumentSpecification() {
        this(null);
    }

    public InstrumentSpecification(HashMap<String, Object> properties) {
        properties = new HashMap<String, Object>();
        this.properties = properties;
    }

    // 검색을 위한 setter, getter 메소드

    // 기능
    // properties 추가

    public void setProperties(String key, Object value) {
        properties.put(key, value);
    }

    // 키값에 대응하는 value 값 호출

    public Object getProperty(String key) {
        return properties.get(key);
    }

    // properties 호출

    public HashMap<String, Object> getProperties() {
        return properties;
    }

    // equals 오버라이딩

    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if (obj instanceof Instruments) {
            equal = toString().equals(obj.toString());
        }
        return equal;
    }

    @Override
    public String toString() {
        if (getProperty("악기종류") == Instruments.GUITAR) {
            return " builder=" + getProperty("제조사") + ", type="
                    + getProperty("유형") + ", topWood=" + getProperty("재질(앞)")
                    + ", backWood=" + getProperty("재질(뒤)") + ", Model="
                    + getProperty("모델명") + "]";
        }
        return " builder=" + getProperty("제조사") + ", type=" + getProperty("유형")
                + ", topWood=" + getProperty("재질(앞)") + ", backWood="
                + getProperty("재질(뒤)") + ", style=" + getProperty("스타일")
                + ", Model=" + getProperty("모델명") + "]";

    }

}
