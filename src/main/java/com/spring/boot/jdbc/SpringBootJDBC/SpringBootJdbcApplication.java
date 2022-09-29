package com.spring.boot.jdbc.SpringBootJDBC;

import com.spring.boot.jdbc.SpringBootJDBC.Entity.Player;
import com.spring.boot.jdbc.SpringBootJDBC.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class SpringBootJdbcApplication implements CommandLineRunner {

//	@Autowired
//	PlayerDAO dao;

	@Autowired
	PlayerRepository repo;

	@Override
	public void run(String... args) throws Exception{

		//******CRUD OPERATIONS USING DATABASE QUERIES*******//

//		System.out.println("All players data : \n" + dao.getAllPlayer());
//
//		System.out.println(dao.getPlayerById(2));
//
//		System.out.println(dao.getPlayerById(2));
//
//		System.out.println(dao.insertPlayer(new Player(5, "Eugene", 30, "Indian", new Date(System.currentTimeMillis()), 13)));
//
//		System.out.println(dao.updatePlayerInfo(new Player(5, "Eugene",  30, "Spanish", new Date(System.currentTimeMillis()), 13)));
//
//		System.out.println(dao.deletePlayer((3)));


		//*****CRUD WITHOUT DATABASE QUERIES*****//

		//CREATE
		repo.insertPlayer(new Player(1, "ALICE", 24, "BRITISH", Date.valueOf("2002-12-12"), 1));
		repo.insertPlayer(new Player(2, "BOB", 23, "AFRICAN", Date.valueOf("2005-12-12"), 12));

		//UPDATE
		repo.updatePlayer(new Player(1, "ALICE", 24, "CANADIAN", Date.valueOf("2002-12-12"), 13));


		//READ
		System.out.println(repo.getPlayerById(2));

		//DELETE
		repo.deleteById(2);

		//get all players
		System.out.println(repo.getAllPlayers());

	}

	public static void main(String[] args) {

		SpringApplication.run(SpringBootJdbcApplication.class, args);

	}

}
