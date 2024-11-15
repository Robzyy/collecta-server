package com.robzyy.Collecta_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.robzyy.Collecta_server.api.Memberships;
import com.robzyy.Collecta_server.api.Users;

@SpringBootApplication
public class CollectaServerApplication {
	Memberships memberships = null;
	Users users = null;

	public CollectaServerApplication(Memberships memberships, Users users)
	{
		this.memberships = memberships;
		this.users = users;
	}

	public static void main(String[] args) {
		SpringApplication.run(CollectaServerApplication.class, args);
	}
}
