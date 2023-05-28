package com.shopme.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateNewUserWithOneRole() {
		Role roleAdmin = entityManager.find(Role.class, 1);
		User userdheeraj = new User("dheeru17777@gmail.com","dheeru2023","dheeraj","dubey");
		userdheeraj.addRole(roleAdmin);
		
		User savedUser = repo.save(userdheeraj);
		
		assertThat(savedUser.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void testCreateNewUserWithTwoRole() {
	
		User userRavi = new User("dheeru177@gmail.com","ravi2023","Ravi","Dubey");
		
		Role roleEditor = new Role(3);
		Role roleAssistant = new Role(5);
		Role roleAssistant1 = new Role(2);
	
		userRavi.addRole(roleEditor);
		userRavi.addRole(roleAssistant);
		userRavi.addRole(roleAssistant1);
		
		User savedUser = repo.save(userRavi);
		
		assertThat(savedUser.getId()).isGreaterThan(0);
		
	}

	@Test
	public void testListAllUsers()
	{
		
		Iterable<User> listUsers = repo.findAll();
		listUsers.forEach(user -> System.out.println(user));
	
		
	}
	
	@Test
	public void testGetUserById() {
		
                   User userName = repo.findById(1).get();	
                   System.out.println(userName);
                   assertThat(userName).isNotNull();
                   
		
	}
	
	@Test
	public void testUpdateUserDetails()
{

	    User userName = repo.findById(1).get();	
	    userName.setEnabled(true);
	    userName.setEmail("namejavaprogrammer@gmail.com");
	    repo.save(userName);
	    
		
}
	
	
	@Test
	public void testUpdateUserRoles() {
		
	User userRavi  = repo.findById(14).get();
	Role roleEditor = new Role(3);
	Role roleSalesPerson = new Role(2);
	
	userRavi.getRoles().remove(userRavi);
	userRavi.addRole(roleSalesPerson);
	
	repo.save(userRavi);
		
	}
	
	
	@Test
	public void testDeleteUser() {
		
		Integer userId = 3;
		repo.deleteById(userId);
		
		
		
	}
	
	@Test
	public void testGetUserByEmail()
	{
		
		String email = "dheeru177@gmail.com";
		User user = repo.getUserByEmail(email);
		
		assertThat(user).isNotNull();
		
		
	}
	
}
