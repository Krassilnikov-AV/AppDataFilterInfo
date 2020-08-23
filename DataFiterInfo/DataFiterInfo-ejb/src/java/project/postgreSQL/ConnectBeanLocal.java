
package project.postgreSQL;

import javax.ejb.Local;


@Local
public interface ConnectBeanLocal  {
    
    Integer[] getGruop();
    Integer[] addGruop();
    String[] getTeacherList();
    String[] addTeacherList();
   
}
