package com.example.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

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
	// "Transactional" annotation will begin and end transaction automatically for us as this
	// method starts and stops.
	@Transactional
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Customer> myQuery = currentSession.createQuery("from Customer", Customer.class);
		
		List<Customer> customers = myQuery.getResultList();
		
		return customers;
	}

}
