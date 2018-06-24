/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.service;

import codechef.stockmarket.common.ViewModels.*;
import codechef.stockmarket.entity.*;
import codechef.stockmarket.repository.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author thari
 */
public class GameService {
    GameRepository gameRepository = null;
    
    GameCompanyRepository gameCompanyRepository = null;
    
    GamePlayerRepository gamePlayerRepository = null;
    
    GameRoundRepository gameRoundRepository = null;
    
    GameRoundPlayerRepository gameRoundPlayerRepository = null;
    
    BankRepository bankRepository = null;
    
    BrokerRepository brokerRepository = null;
    
    PlayerRepository playerRepository = null;
    
    CompanyRepository companyRepository = null;
    
    RoundRepository roundRepository = null;
    
    GameRoundCompanyRepository gameRoundCompanyRepository = null;
    
    WatchListRepository watchListRepository = null;
    
    PlayerPurchaseRepository playerPurchaseRepository = null;
    
    PlayerTransactionRepository playerTransactionRepository = null;
    public GameService(GameRepository _gameRepository,GameCompanyRepository _gameCompanyRepository,GamePlayerRepository _gamePlayerRepository,PlayerRepository _playerRepository,RoundRepository _roundRepository,
            GameRoundRepository _gameRoundRepository,GameRoundPlayerRepository _gameRoundPlayerRepository,BankRepository _bankRepository,BrokerRepository _brokerRepository,CompanyRepository _companyRepository,
            GameRoundCompanyRepository _gameRoundCompanyRepository,WatchListRepository _watchListRepository,PlayerPurchaseRepository _playerPurchaseRepository,PlayerTransactionRepository _playerTransactionRepository)
    {
        gameRepository=_gameRepository;
        gameCompanyRepository=_gameCompanyRepository;
        gamePlayerRepository=_gamePlayerRepository;
        gameRoundRepository=_gameRoundRepository;
        gameRoundPlayerRepository=_gameRoundPlayerRepository;
        bankRepository=_bankRepository;
        brokerRepository=_brokerRepository;
        playerRepository=_playerRepository;
        companyRepository=_companyRepository;
        roundRepository=_roundRepository;
        gameRoundCompanyRepository=_gameRoundCompanyRepository;
        watchListRepository=_watchListRepository;
        playerPurchaseRepository=_playerPurchaseRepository;
        playerTransactionRepository=_playerTransactionRepository;
    }
    BOTService botService = null;
    AnalizeService analizeService = null;
    public GameCompleteResponseViewModel CompleteGame(Game game ,GameRound gRound){
        botService = new BOTService(gameRepository,gameCompanyRepository,gamePlayerRepository,playerRepository,roundRepository,
            gameRoundRepository,gameRoundPlayerRepository,bankRepository,brokerRepository,companyRepository,
            gameRoundCompanyRepository,watchListRepository,playerPurchaseRepository,playerTransactionRepository);
        analizeService = new AnalizeService(gameRepository,gameCompanyRepository,gamePlayerRepository,playerRepository,roundRepository,
            gameRoundRepository,gameRoundPlayerRepository,bankRepository,brokerRepository,companyRepository,
            gameRoundCompanyRepository,watchListRepository,playerPurchaseRepository,playerTransactionRepository);
        GameCompleteResponseViewModel responseData = new GameCompleteResponseViewModel();
        boolean increase = true;
        if(game != null){
            GameRound responseGR = null;
            Set<GamePlayer> players = game.getGamePlayers();
            
            Set<GameRoundCompany> gRoundCompanies = gRound.getGameRoundCompany();
            
            Round round = new Round();
            int rundId = 1;
            switch(gRound.getRound().getRoundNo()){
                case 1:
                    round = roundRepository.findByRoundNo(2);
                    increase = true;
                    break;
                case 2:
                    round = roundRepository.findByRoundNo(3);
                    increase = true;
                    break;
                case 3:
                    round = roundRepository.findByRoundNo(4);
                    increase = false;
                    break;
                case 4:
                    round = roundRepository.findByRoundNo(5);
                    increase = false;
                    break;
            }
            
            GameRound ground = new GameRound();
            ground.setGame(game);
            ground.setRound(round);
            ground.setRoundLeaderId(null);
            ground.setRoundLeaderPoint(0);
            
            responseGR = gameRoundRepository.save(ground);
            
            for(GameRoundCompany grCompany : gRoundCompanies){
                
                double val = analizeService.ChangeCompany(increase, grCompany.getGameCompany().getShareValue());
                GameCompany company = grCompany.getGameCompany();
                
                GameRoundCompany roundCompany = new GameRoundCompany();
                roundCompany.setGameCompany(company);
                roundCompany.setGameRound(responseGR);
                roundCompany.setShareValue(val);
                
                gameRoundCompanyRepository.save(roundCompany);
                
                company.setShareValue(val);
                gameCompanyRepository.save(company);
                
            }
            
            for(GamePlayer player : players){
                GameRoundPlayer roundPlayer = new GameRoundPlayer();
                roundPlayer.setGameRound(responseGR);
                roundPlayer.setPlayer(player.getPlayer());
                roundPlayer.setScore(0);
                
                roundPlayer = gameRoundPlayerRepository.save(roundPlayer);
                if(!player.getPlayer().isAi()){
                    responseData.setGamePlayerId(player.getId());
                    responseData.setGameRoundPlayerId(roundPlayer.getId());
                }
                
            }
            
            game.setCurrentRounds(round.getRoundNo());
            gameRepository.save(game);
            
            responseData.setGameId(game.getId());
            
            responseData.setGameRoundId(responseGR.getId());
            responseData.setRoundId(ground.getRound().getId());
            responseData.setRoundNo(round.getRoundNo());

        }
        
        return responseData;
    }
    
    public Player GetHighestScore(GameRound round){
        
        Set<GameRoundPlayer> player = round.getGameRoundPlayer();
        List<GameRoundPlayer> playerList=new ArrayList<>(player);
        GameRoundPlayer highestScored = playerList.get(0);
        
        for(GameRoundPlayer play : playerList){
            if(play.getScore() > highestScored.getScore()){
                highestScored = play;
            }
        }
        
        return highestScored.getPlayer();
    }
    
    public void AssignScore(GameRound round,Game game){
        Set<GameRoundPlayer> grPlayer = round.getGameRoundPlayer();
        Set<PlayerTransactions> tran = round.getPlayerTransactions();
        HashMap<Long,Double> list = new HashMap<>();
        
        for(GameRoundPlayer player : grPlayer){
           
            Player play = player.getPlayer();
            double score = 0;
            for(PlayerTransactions transac : tran){
                if(Objects.equals(transac.getGamePlayer().getPlayer().getId(), play.getId())){
                    score += (transac.getAmount());
                }
            }
            list.put(player.getPlayer().getId(), score);
            player.setScore(score);
            gameRoundPlayerRepository.save(player);
        }
        Set<GamePlayer> plays = game.getGamePlayers();
        for(GamePlayer pl : plays){
            pl.setScore(list.get(pl.getPlayer().getId()));
            if(pl.getHighScore() < list.get(pl.getPlayer().getId()))
                pl.setHighScore(list.get(pl.getPlayer().getId()));
            
            gamePlayerRepository.save(pl);
        }
    }
    
    public Player GetGameHighestScore(Game game){
        
        Set<GamePlayer> player = game.getGamePlayers();
        List<GamePlayer> playerList=new ArrayList<>(player);
        GamePlayer highestScored = playerList.get(0);
        
        for(GamePlayer play : playerList){
            if(play.getScore() > highestScored.getScore()){
                highestScored = play;
            }
        }
        game.setGameLeaderPoint(highestScored.getScore());
        game.setGameLeaderId(highestScored.getId());
        gameRepository.save(game);
        return highestScored.getPlayer();
    }
    
    public GameCompleteResponseViewModel EndGame(Game game ,GameRound gRound){
        botService = new BOTService(gameRepository,gameCompanyRepository,gamePlayerRepository,playerRepository,roundRepository,
            gameRoundRepository,gameRoundPlayerRepository,bankRepository,brokerRepository,companyRepository,
            gameRoundCompanyRepository,watchListRepository,playerPurchaseRepository,playerTransactionRepository);
        GameCompleteResponseViewModel responseData = new GameCompleteResponseViewModel();
        if(game != null){
            GameRound responseGR = null;
            Set<GamePlayer> players = game.getGamePlayers();
            
            responseData.setGameId(game.getId());
            responseData.setGameRoundId(gRound.getId());
            
            for(GamePlayer gPlayer : game.getGamePlayers()){
                Player player = gPlayer.getPlayer();
                player.setIsPlaying(false);
                player.setIsActive(false);
                player.setRating(player.getRating() + 1);
            }

        }
        
        return responseData;
    }
}
