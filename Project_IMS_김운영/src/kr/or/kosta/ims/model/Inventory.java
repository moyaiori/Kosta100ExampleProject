package kr.or.kosta.ims.model;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import kr.or.kosta.ims.model.InstrumentSpecification.Builders;
import kr.or.kosta.ims.model.InstrumentSpecification.Instruments;
import kr.or.kosta.ims.model.InstrumentSpecification.Styles;
import kr.or.kosta.ims.model.InstrumentSpecification.Types;
import kr.or.kosta.ims.model.InstrumentSpecification.Woods;

public class Inventory {

    private Vector<Instrument> instruments;

    public Inventory(){
        this(10, 2);
    }    
    
    public Inventory(int count, int increment) {
        instruments = new Vector<Instrument>(count, increment);      
    }

    public int getCount() {
        return instruments.size();
    }

    
    // 기타 재고 입고
    // #1. 개별 정보를 입력받아 재고 입고
    // 시리얼넘버가 중복되지 않으면 재고 입고
    public boolean add (Instruments name, String serialNumber, double price, InstrumentSpecification spec) {
        Instrument instrument = new Instrument(name, serialNumber, price, spec);
        instruments.addElement(instrument);
        return true;
    }

    // #2. 완제품 정보를 입력받아 재고 입고
    // 시리얼넘버가 중복되지 않으면 재고 입고
    public boolean add (Instrument instrument) {
        instruments.addElement(instrument);
        return true;
    }

    // 시리얼 넘버로 기타 조회
    public Instrument get(String serialNum) {
        Enumeration<Instrument> e = instruments.elements();
        while (e.hasMoreElements()) {
            Instrument instrument = (Instrument) e.nextElement();
            if (instrument.getSerialNumber().equals(serialNum)) {
                return instrument;
            }
        }
        return null;
    }

    // 입력받은 정보를 토대로 기타조회
    // 부분 입력 가능
    // 입력받은 정보
    
    public List<Instrument> search(Object input1, Object input2) {
        List<Instrument> list = new ArrayList<Instrument>();
        list.addAll(instruments);
        Object[] input = { input1, input2};
        for (int i = 0; i < input.length; i++) {
            for(Instrument instrument : instruments) {
                if (!input[i].equals(instrument.getSpecification().getProperty("제조사"))
                        && !input[i].equals(instrument.getSpecification().getProperty("모델명"))) {
                    list.remove(instrument);
                }

            }
        }
        return list;
    }

    // 전체 악기목록 출력
    
    public List<Instrument> searchAll() {
        List<Instrument> list = new ArrayList<Instrument>();
        list.addAll(instruments);
        return list;
    }
    
    
    // 테스트를 위한 초기화
    
    public void init(){
        InstrumentSpecification spec1 = new InstrumentSpecification();
        spec1.setProperties("악기종류", Instruments.GUITAR);
        spec1.setProperties("제조사", Builders.FENDER);
        spec1.setProperties("모델명", "IVY420");
        spec1.setProperties("유형",Types.ACOUSTIC);
        spec1.setProperties("재질(앞)", Woods.ALDER);
        spec1.setProperties("재질(뒤)", Woods.MAHOGANY);
        
        
        
        InstrumentSpecification spec2 = new InstrumentSpecification();
        spec2.setProperties("악기종류", Instruments.MANDOLIN);
        spec2.setProperties("제조사", Builders.GIBSON);
        spec2.setProperties("모델명", "IVY430");
        spec2.setProperties("유형",Types.ACOUSTIC);
        spec2.setProperties("재질(앞)", Woods.MAPLE);
        spec2.setProperties("재질(뒤)", Woods.ROSEWOOD);
        spec2.setProperties("스타일", Styles.A);

        add(Instruments.GUITAR, "121-496", 4000000d, spec1);
        add(Instruments.MANDOLIN, "123-456", 3000000d, spec2);
        add(new Instrument(Instruments.MANDOLIN, "124-456", 2000000d, spec2));
        add(Instruments.GUITAR, "122-436", 3000000d, spec1);
    }

}
