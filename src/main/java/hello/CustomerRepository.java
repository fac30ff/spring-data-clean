package hello;

import java.util.Iterator;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

//public interface CustomerRepository extends JpaRepository<Customer, Long> {
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
//public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
    List<Customer> findByLastNameIgnoreCase(String lastName);
    List<Customer> findByFirstNameIgnoreCase(String lastName);
    List<Customer> findByFirstNameContainingIgnoreCase(String lastName);
}