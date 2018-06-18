/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.service;

import codechef.stockmarket.common.ViewModels.*;
import codechef.stockmarket.entity.*;
import codechef.stockmarket.repository.*;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author thari
 */
public class GameService {
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
    
    BOTService botService = null;
    public void CompleteGame(CompanyViewModel companyView){
        botService = new BOTService();
        
        if(companyView != null){
            GameRound responseGR = null;
            
            Game game = gameRepository.findById(companyView.getId()).get();
            GameRound gRound = gameRoundRepository.findById(companyView.getId()).get();
            Set<GamePlayer> players = game.getGamePlayers();
            
            botService.play(game, gRound);
            int hs = botService.SetHighestScore(game, gRound);
            
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
