/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.restcontroller;

import codechef.stockmarket.common.CommonUtil;
import codechef.stockmarket.common.ViewModels.*;
import codechef.stockmarket.entity.*;
import codechef.stockmarket.repository.*;
import codechef.stockmarket.service.PasswordEncryptionService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
    @Autowired
    GameRepository gameRepository = null;
    @CrossOrigin
    @RequestMapping(value = "/Register", method = RequestMethod.POST, consumes = CommonUtil.APPLICATION_JSON, produces = CommonUtil.APPLICATION_JSON)
    public ResponseEntity savePlayer(@RequestBody PlayerViewModel playerView){
        GameResponseDateViewModel response = new GameResponseDateViewModel();
        if(playerView != null){
            Player player = new Player();
            player.setName(playerView.getName());
            player.setEmail(playerView.getEmail());
            player.setRating(0);
            player.setUserName(playerView.getUserName());
            player.setPassword(PasswordEncryptionService.Encryption(playerView.getPassword()));
            player.setIsActive(true);
            player.setIsPlaying(false);
            player.setAi(false);
            
            playerRepository.save(player);
            response.setStatusCode(1);
            response.setMessage("Registration Complete");
        }else{
            response.setStatusCode(1);
            response.setMessage("Registration Failed");
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
    
    @GetMapping("/GetallPlayer/{gameId}")
    public List<PlayerListViewModel> getAllGamePlayers(@PathVariable(value = "gameId") Long gameId) {
         List<PlayerListViewModel> playerListView = new ArrayList<>();
         Game game = gameRepository.findById(gameId).get();
         
         Set<GamePlayer> players = game.getGamePlayers();
         
         for(GamePlayer player : players){
             PlayerListViewModel playerView = new PlayerListViewModel();
             playerView.setGamePlayerId(player.getId());
             playerView.setPlayerName(player.getPlayer().getName());
             playerView.setRating(player.getPlayer().getRating());
             playerView.setScore(player.getScore());
             
             playerListView.add(playerView);
         }
         
         return playerListView;
    }
    
    @CrossOrigin
    @RequestMapping(value = "/Authenticate", method = RequestMethod.POST, consumes = CommonUtil.APPLICATION_JSON, produces = CommonUtil.APPLICATION_JSON)
    public ResponseEntity ValidateUser(@RequestBody LoginViewModel loginView){
        LoginResponseViewModel userResponse = new LoginResponseViewModel();
        if(loginView != null){
            Player player = playerRepository.findByUserName(loginView.getUserName());
            if(player != null){
                if(player.getPassword().equals(PasswordEncryptionService.Encryption(loginView.getPassword()))){
                    userResponse.setStatusCode(1);
                    userResponse.setMessage("Login Sucessfull");
                    userResponse.setPlayerId(player.getId());
                }else{
                    userResponse.setStatusCode(0);
                    userResponse.setMessage("Incorrect Password Please Try Again");
                }
            }else{
                userResponse.setStatusCode(0);
                userResponse.setMessage("Invalid User Name");
            }
        }
        if(userResponse.getStatusCode() == 0){
            return new ResponseEntity(userResponse, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity(userResponse, HttpStatus.OK);
        }
    }
}
