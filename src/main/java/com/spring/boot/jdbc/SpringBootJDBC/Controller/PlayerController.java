package com.spring.boot.jdbc.SpringBootJDBC.Controller;

import com.spring.boot.jdbc.SpringBootJDBC.Entity.Player;
import com.spring.boot.jdbc.SpringBootJDBC.Repository.PlayerDAO;
import com.spring.boot.jdbc.SpringBootJDBC.ServiceLayer.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class PlayerController {

//    @Autowired
//    PlayerDAO playerDAO;

//    @Autowired
//    PlayerDAO obj = new PlayerDAO();

    @Autowired
    PlayerService service;

//    @GetMapping("/players")
//    public List<Player> getAllPlayers(){
//        return playerDAO.getAllPlayer();
//    }

    @GetMapping("/playersInfo")
    public List<Player> getPlayersData(){
        return service.getAllPlayers();
    }

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to Player Entity";
    }

    @GetMapping("/player/{id}")
    public Player getPlayer(@PathVariable int id){
        return service.findPlayerByID(id);
    }

    @PostMapping("/addPlayer")
    public Player addPlayer(@RequestBody Player p){
//        p.setName("Sam");
        return service.addPlayer(p);
    }

    @PutMapping("/updatePlayer/{id}")
        public Player updatePlayer(@PathVariable int id, @RequestBody Player p){
            return service.updatePlayerById(id, p);
        }

        public Player patchPlayer(@PathVariable int id, @RequestBody Map<String, Object> playerPatch){
            return service.patchPlayerById(id, playerPatch);
        }

        //updating with query (only for nationality)
    @PatchMapping("/patchPlayer/{id}/nationality")
    public void patchNationality(@PathVariable int id, @RequestBody String nat){
        service.updateNationality(id, nat);
    }

    @DeleteMapping("/deletePlayer/{id}")
    public void deletePlayer(@PathVariable int id){
        service.deletePlayer(id);
    }

}
