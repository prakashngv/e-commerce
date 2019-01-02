package com.devil.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.devil.models.Authorities;
import com.devil.models.Customer;
import com.devil.models.User;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
private SessionFactory sessionFactory;
	public void registerCustomer(Customer customer) {
		Session session=sessionFactory.getCurrentSession();
		//Authorities and User object
		//authorities.user to refer user object
		Authorities authorities=customer.getUser().getAuthorities();
		User user=customer.getUser();
		authorities.setUser(user);
		session.save(customer);

	}

}

