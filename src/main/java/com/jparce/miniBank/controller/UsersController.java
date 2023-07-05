package com.jparce.miniBank.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jparce.miniBank.model.UsersModel;
import com.jparce.miniBank.repository.UsersRepository;
import com.jparce.miniBank.service.UsersService;

@RestController
@RequestMapping("/miniBank")
public class UsersController {
	@Autowired
	private UsersService usersService;
	

	
	@GetMapping("/hello")
	public String  hello() {		
		return  "Still alive!";
	}
	
	
	
	@GetMapping("/totalUsers")
	public String  getTotalUsers() {		
		return  usersService.getTotalUsers();
	}
	
    @PostMapping("/{accountId}/deposit")
    public UsersModel deposit(@PathVariable Integer accountId, @RequestBody Double amount) throws NotFoundException {
        return usersService.deposit(accountId, amount);
    }
    
    @PostMapping("/{accountId}/withdraw")
    public UsersModel withdraw(@PathVariable Integer accountId, @RequestBody Double amount) throws NotFoundException {
        return usersService.withdraw(accountId, amount);
    }
    
    @PostMapping("/transfer")
    public void transfer(@RequestParam Integer sourceAccountId, @RequestParam Integer targetAccountId, @RequestParam Double amount) throws NotFoundException {

    	usersService.transfer(sourceAccountId, targetAccountId, amount);
    }
}