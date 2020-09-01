
package packet.ejb.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

/**
 *
 * @author Aleks
 */
@Stateless
@LocalBean
public class HandlerBean implements HandlerBeanLocal {

  @Resource(name="5432/raspisanie")
   private DataSource ds;
   @PersistenceContext
    private EntityManager em;
   
   
}
