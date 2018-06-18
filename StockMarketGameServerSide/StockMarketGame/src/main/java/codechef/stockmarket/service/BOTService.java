/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.service;

import codechef.stockmarket.entity.*;
import codechef.stockmarket.repository.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author thari
 */
public class BOTService {
    @Autowired
    GameRepository gameRepository = null;
    @Autowired
    GameCompanyRepository gameCompanyRepository = null;
    @Autowired
    GamePlayerRepository gamePlayerRepository = null;
    @Autowired
    GameRoundRepository gameRoundRepository = null;
    @Autowired
    GameRoundPlayerRepository gameRoundPlayerRepository = null;
    @Autowired
    BankRepository bankRepository = null;
    @Autowired
    BrokerRepository brokerRepository = null;
    @Autowired
    PlayerRepository playerRepository = null;
    @Autowired
    CompanyRepository companyRepository = null;
    @Autowired
    RoundRepository roundRepository = null;
    @Autowired
    GameRoundCompanyRepository gameRoundCompanyRepository = null;
    @Autowired
    WatchListRepository watchListRepository = null;
    
    
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public List<Player> CreatePlayers(){
        
        List<Player> players = playerRepository.findAll();
        List<Player> aiPlayers = new ArrayList<>();
        List<Player> newPlayers = new ArrayList<>();
        for(Player play : players){
            if(play.isAi() && !play.isIsPlaying()){
                aiPlayers.add(play);
            }
        }
        
        if(aiPlayers.size() == 0){
            for(int i = 0; i < 2 ; i++){
                Player player = new Player();
                Date date = new Date();
                player.setName("Player" + dateFormat.format(date));
                player.setEmail("");
                player.setRating(0);
                
                newPlayers.add(player);
            }
        }else if(aiPlayers.size() == 1){
            Player player = new Player();
                Date date = new Date();
                player.setName("Player" + dateFormat.format(date));
                player.setEmail("");
                player.setRating(0);
                
                newPlayers.add(player);
            
        }else if(aiPlayers.size() > 2){
            players = new ArrayList<>();
            players.add(aiPlayers.get(0));
            players.add(aiPlayers.get(1));
        }
        
        for(Player play : newPlayers){
           players.add(playerRepository.save(play));
        }
        return players;
    }
    
    public void AddPlayersToGame(Game game,GameRound round){
        List<Player> players = this.CreatePlayers();
        
        List<Bank> banks = bankRepository.findAll();
        List<Broker> brokers = brokerRepository.findAll();
        
        Bank bank = banks.get(0);
        Broker broker = brokers.get(0);
        
        for(Player player : players){
            GamePlayer gamePlayer = new GamePlayer();
            gamePlayer.setBank(bank);
            gamePlayer.setBankBalance(0);
            gamePlayer.setBroker(broker);
            gamePlayer.setGame(game);
            gamePlayer.setHighScore(0);
            gamePlayer.setPlayer(player);
            gamePlayer.setTotalPurchase(0);
            gamePlayer.setTotalSales(0);
            gamePlayerRepository.save(gamePlayer);
        }  
    }
    
    public void play(Game game,GameRound round){
        Set<GameCompany> roundCompany = game.getGameCompany();
        Map<Long, List<Double>> CompanyHistory;
        CompanyHistory = new HashMap<>();
        
        AnalizeService analyze = new AnalizeService();
        CompanyHistory = analyze.AnalyzeCompanies(game);
        
        
    }
    
    public int SetHighestScore(Game game,GameRound round){
        return 0;
    }
}
