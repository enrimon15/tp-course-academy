package it.aesys.academy.crudjpa.repository;

import it.aesys.academy.crudjpa.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // metodi crud già implementati

    /* non c'è bisogno di scriverla
    List<Employee> findAll();

    Employee findById(int id);

    void saveOrUpdate(Employee employee);

    void remove(Employee employeeToDelete);

    Employee searchByEmail(String email);
     */

    // searchByEmail --> Employee > EmployeeDetail > email
    Optional<Employee> findByEmployeeDetailEmail(String email);
    // select * from employee e, employee_detail ed where e.employee_detail_id = ed.id and ed.email = <input>
    // potrebbe tradursi in find by attributo che sta in Employee che si chiama EmployeeDetailEmail
    // oppure in Employee > employee > detail > email
    // oppure in Employee > employee > detailEmail

    // query custom con JPQL (usare solo se necessario)
    @Query("SELECT e FROM Employee e WHERE e.employeeDetail.email =: email")
    Optional<Employee> findByEmployeeDetailEmailCustom(@Param("email") String email);

    // query con SQL nativo (usare solo se necessario: non è portabile)
    @Query(value = "select e FROM EMPLOYEE e, EMPLOYEE_DETAIL ed WHERE e.employee_detail_id = ed.id AND ed.email = ?1", nativeQuery = true)
    Optional<Employee> findByEmployeeDetailEmailNative(String email);

    /*List<Employee> findAllByFirstNameOrderById(String firstName); // --> select * from employee where first_name = <input> order by id

    Employee findByCompany(String company); // --> select * from employee where company = <input>

    List<Employee> findByBirthBetween(Date startDate, Date endDate);

    boolean existsByCompanyIgnoreCase(String company);

    boolean existsByCompanyAndFirstName(String company, String firstName); // --> where company = x and firstName = y*/
}
