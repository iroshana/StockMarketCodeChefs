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
import java.util.Random;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author thari
 */
public class BOTService {
    
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
    
    DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    public BOTService(GameRepository _gameRepository,GameCompanyRepository _gameCompanyRepository,GamePlayerRepository _gamePlayerRepository,PlayerRepository _playerRepository,RoundRepository _roundRepository,
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

    public List<Player> CreatePlayers(){
        
        List<Player> players = playerRepository.findAll();
        List<Player> aiPlayers = new ArrayList<>();
        List<Player> newPlayers = new ArrayList<>();
        if(players != null){
            for(Player play : players){
            if(play.isAi() && !play.isIsPlaying()){
                aiPlayers.add(play);
            }
        }
        }
        players.clear();;
        if(aiPlayers.size() == 0){
            for(int i = 0; i < 2 ; i++){
                Player player = new Player();
                Date date = new Date();
                player.setName("Player" + dateFormat.format(date));
                player.setEmail("");
                player.setRating(0);
                player.setAi(true);
                player.setIsActive(true);
                player.setIsPlaying(true);
                
                newPlayers.add(player);
            }
        }else if(aiPlayers.size() == 1){
            Player player = new Player();
                Date date = new Date();
                player.setName("Player" + dateFormat.format(date));
                player.setEmail("");
                player.setRating(0);
                player.setAi(true);
                player.setIsActive(true);
                player.setIsPlaying(true);
                newPlayers.add(player);
            
        }else if(aiPlayers.size() > 2){
            players.add(aiPlayers.get(0));
            players.add(aiPlayers.get(1));
        }
        
        for(Player play : newPlayers){
           players.add(playerRepository.save(play));
        }
        return players;
    }
    
    public void AddPlayersToGame(Game game,GameRound round,PlayerRepository playerRep,GamePlayerRepository gamePlayerRep){
        playerRepository = playerRep;
        gamePlayerRepository = gamePlayerRep;
        List<Player> players = this.CreatePlayers();
        
        List<Bank> banks = bankRepository.findAll();
        List<Broker> brokers = brokerRepository.findAll();
        
        Bank bank = banks.get(0);
        Broker broker = brokers.get(0);
        
        for(Player player : players){
            if(player.isAi()){
                GamePlayer gamePlayer = new GamePlayer();
                gamePlayer.setBank(bank);
                gamePlayer.setBankBalance(1000);
                gamePlayer.setBroker(broker);
                gamePlayer.setGame(game);
                gamePlayer.setHighScore(0);
                gamePlayer.setPlayer(player);
                gamePlayer.setTotalPurchase(0);
                gamePlayer.setTotalSales(0);
                gamePlayerRepository.save(gamePlayer);
            }
            
        }  
    }
    
    public void play(Game game,GameRound round){
        AnalizeService analyze = new AnalizeService(gameRepository,gameCompanyRepository,gamePlayerRepository,playerRepository,roundRepository,
            gameRoundRepository,gameRoundPlayerRepository,bankRepository,brokerRepository,companyRepository,
            gameRoundCompanyRepository,watchListRepository,playerPurchaseRepository,playerTransactionRepository);
        List<Integer> givenList = new ArrayList();
        Random rand = new Random();
        int randomElement = 0;
        
        Random r = new Random();
        int Low = 200;
        int High = 600;
        int value = 0;
        int noOfShares = 0;
        int noOfCompanyShares = 0;
        Set<GamePlayer> players = game.getGamePlayers();
        Set<GameCompany> roundCompany = game.getGameCompany();
        Map<Long, List<Double>> CompanyHistory;
        CompanyHistory = new HashMap<>();
        
        
        CompanyHistory = analyze.AnalyzeCompanies(game);
        
        givenList = analyze.CalculateBest(CompanyHistory);
        
        for(GamePlayer player : players){
            if(player.getPlayer().isAi())
            {
                List<Playerpurchase> purchaseList = new ArrayList<>();
                List<Playerpurchase> newpurchaseList = new ArrayList<>();
                Double a = (player.getBankBalance());
                High = 500;
                Bank bank = bankRepository.findById(player.getBank().getId()).get();
                value = r.nextInt(High-Low) + Low;
                double bankBalance = player.getBankBalance();
                int lowShares = 0;
                int highShares = 200;
                    
                noOfShares = r.nextInt(highShares-lowShares) + lowShares;
                
                while(noOfShares > 0)
                {
                    if(givenList.size() > 0){
                    randomElement = givenList.get(rand.nextInt(givenList.size()));
                    givenList.remove(Integer.valueOf(randomElement));
                    GameCompany company = gameCompanyRepository.findById(Long.valueOf(randomElement)).get();
                    int lShares = 0;
                    int hShares = noOfShares;
                    noOfCompanyShares = r.nextInt(hShares-lShares) + lShares;
                    while(noOfCompanyShares * company.getShareValue() >= value){
                        noOfCompanyShares = r.nextInt(hShares-lShares) + lShares;
                    }
                            if(noOfShares != 0 && (noOfShares * company.getShareValue()) < value)
                            {
                                Playerpurchase playerpurchaseView = new Playerpurchase();
                                playerpurchaseView.setGameCompany(company);
                                playerpurchaseView.setGamePlayer(player);
                                playerpurchaseView.setNoOfShare(noOfShares);
                                playerpurchaseView.setShareValue(company.getShareValue());
                                playerpurchaseView.setIsSold(false);

                                purchaseList.add(playerpurchaseView);

                                value -= (company.getShareValue() * noOfShares);
                                bankBalance -= (company.getShareValue() * noOfShares);
                                noOfShares -= noOfCompanyShares;
                            }
                    }
                }
                
                Playerpurchase response = null;
                for(Playerpurchase p : purchaseList){
                    response = playerPurchaseRepository.save(p);
                            Date date = new Date();
                            PlayerTransactions Transaction = new PlayerTransactions();
                            Transaction.setBank(bank);
                            Transaction.setGamePlayer(player);
                            Transaction.setGameRound(round);
                            Transaction.setAmount((float) (response.getNoOfShare() * response.getShareValue()));
                            Transaction.setTime(dateFormat.format(date));
                            Transaction.setTransactionNo("T" + dateFormat.format(date));
                            playerTransactionRepository.save(Transaction);
                }
                
                player.setBankBalance(bankBalance);
                gamePlayerRepository.save(player);
            }
        }
    }
    
    public List<GamePlayer> SetScore(Game game,GameRound round,Set<GamePlayer> players){
        List<GamePlayer> gamePlayers=new ArrayList<>(players);
        
        return gamePlayers;
    }
}
