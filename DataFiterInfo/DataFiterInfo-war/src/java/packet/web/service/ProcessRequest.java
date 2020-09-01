package packet.web.service;

import java.util.Date;


/**
 * Интерфейс определяет методы для работы с коллекциями обрабатываемых данных.
 * 
 * @author Aleks
 */


 interface ProcessRequest {
    /**
     * метод позволяет добавить к коллекции данных новые данные расписания
     * @param groupId
     * @param dateStart
     * @param dateTime
     * @return 
    */
    
    public boolean addData(Integer groupId, Date dateStart, Date dateTime);
    
    /**
     * метод позволяет получить по заданному параметру grupID 
     * список образовательной программы
     * 
     * @param groupId
     * @return 
     */
    
    public String getData(Integer groupId);
    
    /**
     * метод позволяет удалить выбранные данные по параметру grupID
     * 
     * @param groupId
     * @return 
     */
    
    public String deleteData(Integer groupId);
    
}
