package com.spring.boot.jdbc.SpringBootJDBC.ServiceLayer;

import com.spring.boot.jdbc.SpringBootJDBC.Entity.Player;
import com.spring.boot.jdbc.SpringBootJDBC.ErrorResponse.PlayerNotFoundException;
import com.spring.boot.jdbc.SpringBootJDBC.Repository.PlayerRepository;
import com.spring.boot.jdbc.SpringBootJDBC.Repository.PlayerSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.lang.reflect.Field;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    PlayerSpringDataRepository repo;

    //getAllPlayers
    public List<Player> getAllPlayers(){
        return repo.findAll();
    }

    //find by id
    public Player findPlayerByID(@PathVariable("id") int id){
        Optional<Player> tempPlayer = repo.findById(id);

        Player p = null;

        if(tempPlayer.isPresent())
            p = tempPlayer.get();
        else
            throw new PlayerNotFoundException("Player with id : " + id + " not found");
//            throw new RuntimeException("Player with id : " + id + " not found");
        return p;
    }

    //addPlayer
    public Player addPlayer(Player player){
        return repo.save(player);
    }

    //update player(put)
    public Player updatePlayerById(@PathVariable("id") int id, Player player){
        Optional<Player> tempPlayer = repo.findById(id);
        //repo.getOne(id) --> Deprecated

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player with id : " + id + " not found");
//            throw new RuntimeException("Player with id : " + id + " not found.");
        return repo.save(player);
    }

    //update partial (Patch)
    public Player patchPlayerById(@PathVariable("id") int id, Map<String, Object> partialPlayer){
        Optional<Player> tempPlayer = repo.findById(id);// just to capture null pointer exception if present

        if(tempPlayer.isPresent()){
            // iterate through map and make desired changes in player object
            partialPlayer.forEach( (key, value) -> {
                System.out.println("key : "+key+" , value : "+value);
                // findField-> finds the field of an object (class, key (attribute)) => returns field object
                Field field = ReflectionUtils.findField(Player.class, key);
                ReflectionUtils.makeAccessible(field); // make the private variables in use (toggles)
                if(key=="dob") ReflectionUtils.setField(field, tempPlayer.get(), Date.valueOf((String) value));
                else ReflectionUtils.setField(field, tempPlayer.get(), value); // set the field with the updated/ patched data
            });
        }

        else{
            throw new PlayerNotFoundException("Player with id : " + id + " not found");
//            throw new RuntimeException("Player with id : "+id+" not found ");
        }
        return repo.save(tempPlayer.get());
    }

    //partial update (using queries/entity)
    @Transactional  // to make transactions b/w java classes and database
    public void updateNationality(int id, String nat){

        Optional<Player> tempPlayer = repo.findById(id);

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player with id : " + id + " not found");
//            throw new RuntimeException("Player with id : " + id + " not found");

        repo.updateNationality(id, nat);
    }


    //delete operation
    public void deletePlayer(int id){
        Optional<Player> tempPlayer = repo.findById(id);

        if(tempPlayer.isEmpty())
            throw new PlayerNotFoundException("Player with id : " + id + " not found");
//            throw new RuntimeException("Player with id : " + id + " not found");

        repo.delete(tempPlayer.get());
    }

}

