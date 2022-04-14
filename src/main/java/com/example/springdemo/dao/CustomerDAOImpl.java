package com.example.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.springdemo.entity.Customer;

// "Repository" is a special annotation provided by Spring for DAO classes
@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	// Injecting the SessionFactory dependency
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> myQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		List<Customer> customers = myQuery.getResultList();
		
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.save(customer);
	}

}
