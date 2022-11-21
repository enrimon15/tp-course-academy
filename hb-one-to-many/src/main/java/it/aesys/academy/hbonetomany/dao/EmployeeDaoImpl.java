package it.aesys.academy.hbonetomany.dao;

import it.aesys.academy.hbonetomany.entity.Employee;
import it.aesys.academy.hbonetomany.entity.EmployeeDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
// transactional read only posso metterla a lv. di classe e verrà presa da ogni metodo all'interno della classe
// N.B. per i metodi di scrittura devo sovrascrivere
public class EmployeeDaoImpl implements EmployeeDao {
    
}
