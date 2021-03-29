package cz.gjkt.model;

import java.util.ArrayList;
import java.util.List;

public class DruhyZnamekKurzuDAO {

    private static final String TABLE = "DruhZnamky";
    private static final String[] ALL_COLUMNS = {"id","nazev","datum","popis","typZnamky","kurz"};
    private static final String[] UPDATE_COMUNS = {"nazev","datum","popis","typZnamky","kurz"};

    public DruhyZnamekKurzuDAO(Kurz kurz) {

    }

    public List<DruhZnamky> getAll() {
        DBManager dbManager = new DBManager();
        List<DruhZnamky> druhyZnamek = new ArrayList<>();
        List<List<Object>> recordSet = dbManager.select(TABLE,ALL_COLUMNS,null,null);
        for (List<Object> row : recordSet){
            DruhZnamky druhZnamky = new DruhZnamky();
            druhZnamky.setId((int)row.get(0));
            druhZnamky.setNazev((String)row.get(1));
            druhZnamky.setDatum((String) row.get(2));
            druhZnamky.setPopis((String) row.get(3));
            druhZnamky.setTypZnamky((int) row.get(4));
            druhZnamky.setKurz((int) row.get(5));
            druhyZnamek.add(druhZnamky);
        }
        return druhyZnamek;}
}
