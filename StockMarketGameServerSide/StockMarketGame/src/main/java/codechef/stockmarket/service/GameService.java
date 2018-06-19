/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.service;

import codechef.stockmarket.common.ViewModels.*;
import codechef.stockmarket.entity.*;
import codechef.stockmarket.repository.*;
import java.util.List;
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
    public void CompleteGame(CompanyViewModel companyView){
        botService = new BOTService(gameRepository,gameCompanyRepository,gamePlayerRepository,playerRepository,roundRepository,
            gameRoundRepository,gameRoundPlayerRepository,bankRepository,brokerRepository,companyRepository,
            gameRoundCompanyRepository,watchListRepository,playerPurchaseRepository,playerTransactionRepository);
        
        if(companyView != null){
            GameRound responseGR = null;
            
            Game game = gameRepository.findById(companyView.getId()).get();
            GameRound gRound = gameRoundRepository.findById(companyView.getId()).get();
            Set<GamePlayer> players = game.getGamePlayers();
            
            botService.play(game, gRound);
            List<GamePlayer> gamePlayers = botService.SetScore(game, gRound, players);
            
            Set<GameRoundCompany> gRoundCompanies = gRound.getGameRoundCompany();
            
            Round round = new Round();
            int rundId = 1;
            switch(rundId){
                case 1:
                    round = roundRepository.findByRoundNo(2);
                    break;
                case 2:
                    round = roundRepository.findByRoundNo(3);
                    break;
                case 3:
                    round = roundRepository.findByRoundNo(4);
                    break;
                case 4:
                    round = roundRepository.findByRoundNo(5);
                    break;
            }
            
            GameRound ground = new GameRound();
            ground.setGame(game);
            ground.setRound(round);
            ground.setRoundLeaderId(null);
            ground.setRoundLeaderPoint(0);
            
            responseGR = gameRoundRepository.save(ground);
            
            for(GameRoundCompany grCompany : gRoundCompanies){
                GameCompany company = grCompany.getGameCompany();
                
                GameRoundCompany roundCompany = new GameRoundCompany();
                roundCompany.setGameCompany(company);
                roundCompany.setGameRound(responseGR);
                roundCompany.setShareValue(company.getShareValue() + company.getShareValue() * (10/100));
                
                gameRoundCompanyRepository.save(roundCompany);
                
                company.setShareValue(company.getShareValue() + company.getShareValue() * (10/100));
                gameCompanyRepository.save(company);
                
            }
            
            for(GamePlayer player : players){
                GameRoundPlayer roundPlayer = new GameRoundPlayer();
                roundPlayer.setGameRound(responseGR);
                roundPlayer.setPlayer(player.getPlayer());
                roundPlayer.setScore(0);
            }
            
            game.setCurrentRounds(round.getRoundNo());
            gameRepository.save(game);
        }
    }
}
