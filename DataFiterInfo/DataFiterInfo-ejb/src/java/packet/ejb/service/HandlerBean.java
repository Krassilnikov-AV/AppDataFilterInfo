
package packet.ejb.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.sql.DataSource;

/**
 * Класс HandlerBean
 * - непосредственно взаимодействует с БД
 * - обрабатывает запросы БД (переопределяя методы интерфейса HandlerBeanLocal)
 * 
 * @author Aleks
 */
@Entity
@Table(name="raspisanie")
@LocalBean
public class HandlerBean implements HandlerBeanLocal {

  @Resource(name="5432/raspisanie")
    @Id
   private DataSource ds;
   @PersistenceContext
    private EntityManager em;

    public DataSource getDs() {
        return ds;
    }

    public void setDs(DataSource ds) {
        this.ds = ds;
    }
   
   
}
