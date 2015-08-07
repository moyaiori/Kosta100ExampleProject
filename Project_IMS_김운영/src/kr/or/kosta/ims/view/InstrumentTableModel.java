package kr.or.kosta.ims.view;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import kr.or.kosta.ims.model.Instrument;

public class InstrumentTableModel extends AbstractTableModel {

    Vector<String> headerNames;
    Vector<Instrument> instrumentList;

    public InstrumentTableModel() {
        headerNames = new Vector<String>();
        headerNames.addElement("악기종류");
        headerNames.addElement("일련번호");
        headerNames.addElement("모델명");
        headerNames.addElement("가격");
        headerNames.addElement("제조사");

        instrumentList = new Vector<Instrument>();

    }

    @Override
    public int getRowCount() {
        return instrumentList.size();
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return headerNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object cellData = null;
        switch (columnIndex) {
        case 0:
            cellData = instrumentList.elementAt(rowIndex).getSpecification()
                    .getProperty("악기종류");
            break;
        case 1:
            cellData = instrumentList.elementAt(rowIndex).getSerialNumber();
            break;
        case 2:
            cellData = instrumentList.elementAt(rowIndex).getSpecification()
                    .getProperty("모델명");
            break;
        case 3:
            cellData = instrumentList.elementAt(rowIndex).getPrice();
            break;
        case 4:
            cellData = instrumentList.elementAt(rowIndex).getSpecification()
                    .getProperty("제조사");
            break;
        }
        return cellData;
    }

    @Override
    public String getColumnName(int column) {
        return headerNames.elementAt(column);
    }

    @Override
    public Class<?> getColumnClass(int column) {
        return getValueAt(0, column).getClass();
    }

    // 검색한 악기목록 출력

    public void print(Instrument instrument) {
        instrumentList.clear();
        instrumentList.addElement(instrument);
        fireTableStructureChanged();
    }

    // 전체 목록 출력

    public void allPrint(List<Instrument> List) {
        instrumentList.clear();
        for (Instrument instrument : List) {
            instrumentList.addElement(instrument);
        }
        fireTableStructureChanged();
    }
}
