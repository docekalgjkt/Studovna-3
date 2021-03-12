package cz.gjkt.model;

import java.util.List;

public class StudentiKurzuDAO /*extends StudentiDAOJDBC*/ implements IModelDao<Student> {

    private Kurz kurz;

    public StudentiKurzuDAO() {this.kurz = kurz;}
    public StudentiKurzuDAO(int kurzID){

    }

    @Override
    public int insert(Student object) {
        return 0;
    }

    @Override
    public int update(Student object) {
        return 0;
    }

    @Override
    public int delete(Student object) {
        return 0;
    }

    @Override
    public int[] insert(List<Student> objects) {
        return new int[0];
    }

    @Override
    public int update(List<Student> objects) {
        return 0;
    }

    @Override
    public int delete(List<Student> objects) {
        return 0;
    }

    @Override
    public Student getObject(int id) {

        return null;
    }

    @Override
    public List<Student> getObjects(int[] ids) {
        DBManager dbManager = new DBManager();
        String table = "Navstevuje";
        String[] columns = {"student"};
        String[] aCon = {"kurz="+ids[0]};
        String[] oCon = null;
        List<List<Object>> studentiIds = dbManager.select(table,columns,aCon,oCon);
        int[] studentiIDs = new int[studentiIds.size()];
        int i = 0;
        for(List<Object> id : studentiIds){
            studentiIDs[i++] = (int)id.get(0);
        }
        StudentiDAOJDBC studentiDAOJDBC = new StudentiDAOJDBC();
        List<Student> studenti = studentiDAOJDBC.getStudenti(studentiIDs);
        return studenti;
    }

    @Override
    public List<Student> getAll() {
//        List<Student> studenti = getObjects(getIDsStudentu());
//        return studenti;
        return null;
    }
}
