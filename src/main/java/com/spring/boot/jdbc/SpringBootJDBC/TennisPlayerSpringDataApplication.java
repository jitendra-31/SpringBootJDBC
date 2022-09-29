package com.spring.boot.jdbc.SpringBootJDBC;


import com.spring.boot.jdbc.SpringBootJDBC.Entity.Player;
import com.spring.boot.jdbc.SpringBootJDBC.Repository.PlayerSpringDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class TennisPlayerSpringDataApplication implements CommandLineRunner {

    @Autowired
    PlayerSpringDataRepository repo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(TennisPlayerSpringDataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Inserting a player
//        logger.info("\nInserting a player\n", repo.save(new Player(23, "Jack", 20, "Arabian", Date.valueOf("2012-12-12"), 35)));
//        logger.info("\nInserting a player\n", repo.save(new Player(52, "Krish", 21, "Bolivia", Date.valueOf("2022-12-12"), 36)));
//        logger.info("\nInserting a player\n", repo.save(new Player(33, "Lucy", 22, "Czech", Date.valueOf("2032-12-12"), 39)));


        //Finding a player by ID
//        logger.info("\nFinding a player by ID\n", repo.findById(1));
//        logger.info("\nDelete by ID\n");
//        repo.deleteById(2);
//        logger.info("\nFind all method\n", repo.findAll());

    }
}
