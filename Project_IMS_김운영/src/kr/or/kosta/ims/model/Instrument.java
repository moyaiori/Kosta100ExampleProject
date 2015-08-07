package kr.or.kosta.ims.model;

import kr.or.kosta.ims.model.InstrumentSpecification.Instruments;



public class Instrument {
    private Instruments name;
    private String serialNumber;
    private double price;
    private InstrumentSpecification spec;
    
    // 초기 생성자
    
    public Instrument (){
        this(null, null, 0d, null);
    }
    public Instrument (Instruments name, String serialNumber, double price, InstrumentSpecification spec){
        this.name = name;
        this.serialNumber = serialNumber;
        this.price = price;
        this.spec = spec;
                
    }
    
    // 검색을 위한 setter, getter 메소드
    
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
    
    // 기능 
    // spec 호출
    
    public InstrumentSpecification getSpecification (){
        return spec;
        
    }
    
    // toString() 오버라이드
    
    @Override
    public String toString() {
        return "instrument [name =" + name + ", serialNumber = "+ serialNumber + ", price= " + String.format("%,d", (int)price)
                + ", " + spec.toString() + "]";
    }
    
    // equals() 오버라이드
    
    @Override
    public boolean equals(Object obj) {
        boolean equal = false;
        if(obj instanceof Instrument){
            equal = toString().equals(obj.toString());
        }
        return equal;
    }
    
    
    
    
    
    
    
}
