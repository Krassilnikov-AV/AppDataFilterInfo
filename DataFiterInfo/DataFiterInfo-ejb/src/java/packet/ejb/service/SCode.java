
package packet.ejb.service;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import jdk.nashorn.internal.objects.annotations.Getter;


/**
 * Класс позволяет добавлять код группы в БД
 * @author Aleks
 */

@Entity  // аннотация говорит JPA о работе клкасса с БД
  /** @Table описывает главную таблицу, в которой сохранены данные класса
   * 
   */

@Table(name="raspisanie")

public class SCode implements Serializable {  
 
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SCode other = (SCode) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SCode{" + "code=" + code + '}';
    }
    
    }
