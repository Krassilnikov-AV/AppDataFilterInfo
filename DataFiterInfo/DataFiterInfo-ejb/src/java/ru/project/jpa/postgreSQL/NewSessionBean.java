
package ru.project.jpa.postgreSQL;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.Entity;
import javax.persistence.Id;


@Stateless
@LocalBean

@Entity
public class NewSessionBean {

    @Id
    private Long идентификатор;

    public Long getИдентификатор() {
        return идентификатор;
    }

    public void setИдентификатор(Long идентификатор) {
        this.идентификатор = идентификатор;
    }


}
