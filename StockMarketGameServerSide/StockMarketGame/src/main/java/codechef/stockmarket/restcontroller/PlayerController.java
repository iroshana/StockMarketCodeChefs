/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.restcontroller;

import codechef.stockmarket.common.CommonUtil;
import codechef.stockmarket.common.ViewModels.PlayerViewModel;
import codechef.stockmarket.entity.Player;
import codechef.stockmarket.repository.*;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thari
 */
@RestController
@RequestMapping("/Player")
public class PlayerController {
    @Autowired
    PlayerRepository playerRepository = null;

    
    @CrossOrigin
    @RequestMapping(value = "/Create", method = RequestMethod.POST, consumes = CommonUtil.APPLICATION_JSON, produces = CommonUtil.APPLICATION_JSON)
    public ResponseEntity saveTest(@RequestBody PlayerViewModel playerView){
        Player response = null;
        if(playerView != null){
            Player player = new Player();
            player.setName(playerView.getName());
            player.setEmail(playerView.getEmail());
            player.setRating(0);
            response = playerRepository.save(player);

        }
        if(response == null){
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }
    
    @GetMapping("/GetPlayer/{id}")
    public PlayerViewModel getNoteById(@PathVariable(value = "id") Long id) {
         PlayerViewModel playerView = new PlayerViewModel();
         Optional<Player> player = playerRepository.findById(id);
         
         if(player != null){
             playerView.setId(player.get().getId());
             playerView.setName(player.get().getName());
             playerView.setEmail(player.get().getEmail());
             playerView.setRating(player.get().getRating());
         }
         return playerView;
    }
}
