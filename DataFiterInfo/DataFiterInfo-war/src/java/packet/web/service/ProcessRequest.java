package packet.web.service;

import java.util.Date;


/**
 * Интерфейс определяет методы для работы с коллекциями обрабатываемых данных.
 * 
 * @author Aleks
 */


public interface ProcessRequest {
    /**
     * метод позволяет добавить к коллекции группы 
     * @param groupId
     * @param dateStart
     * @param dateTime
    */
    
    public boolean addData(Integer groupId, Date dateStart, Date dateTime);
    
    /**
     * метод позволяет получить по заданному параметру GrupID 
     * список образовательной программы
     * 
     * @param groupId
     * @return 
     */
    
    public String getData(Integer groupId);
    
}
