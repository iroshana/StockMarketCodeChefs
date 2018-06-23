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
import codechef.stockmarket.service.BOTService;
import java.util.ArrayList;
import java.util.HashSet;
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
@RequestMapping("/Game")
public class GameController {
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
    @Autowired
    PlayerPurchaseRepository playerPurchaseRepository = null;
    @Autowired
    PlayerTransactionRepository playerTransactionRepository = null;
    BOTService botService = null;
    
    @CrossOrigin
    @RequestMapping(value = "/Create/", method = RequestMethod.POST, consumes = CommonUtil.APPLICATION_JSON, produces = CommonUtil.APPLICATION_JSON)
    public ResponseEntity saveTest(@RequestBody GameStartViewModel gamePlayer){
        botService = new BOTService(gameRepository,gameCompanyRepository,gamePlayerRepository,playerRepository,roundRepository,
            gameRoundRepository,gameRoundPlayerRepository,bankRepository,brokerRepository,companyRepository,
            gameRoundCompanyRepository,watchListRepository,playerPurchaseRepository,playerTransactionRepository);
        Game response1 = null;
        
        GamePlayer response3 = null;
        GameRound response4 = null;
        GameRoundPlayer response5 = null;
        ResponseViewModel responseData = new ResponseViewModel();
        if(gamePlayer != null){
            Game game = new Game();
            game.setNoOfPlayers(1);
            game.setGameLeaderPoint(0);
            game.setNoOfRounds(5);
            game.setCurrentRounds(1);
            response1 = gameRepository.save(game);
            
            Bank bank = bankRepository.findById(gamePlayer.getBankId()).get();
            Broker broker = brokerRepository.findById(gamePlayer.getBrokerId()).get();
            Player gplayer = playerRepository.findById(gamePlayer.getPlayerId()).get();
            List<Company> gCompanyList = companyRepository.findAll();
            
            GamePlayer player = new GamePlayer();
            player.setBank(bank);
            player.setBankBalance(gamePlayer.getBankBalance());
            player.setBroker(broker);
            player.setGame(response1);
            player.setHighScore(0);
            player.setPlayer(gplayer);
            player.setTotalPurchase(0);
            player.setTotalSales(0);
            response3 = gamePlayerRepository.save(player);
            
            Round roundOne = roundRepository.findByRoundNo(1);
            
            GameRound round = new GameRound();
            round.setGame(game);
            round.setRound(roundOne);
            round.setRoundLeaderId(null);
            round.setRoundLeaderPoint(0);
            
            response4 = gameRoundRepository.save(round);
            
            for(Company company : gCompanyList){
                
                GameCompany response2 = null;
                
                GameCompany gCompany = new GameCompany();
                gCompany.setGame(game);
                gCompany.setCompany(company);
                gCompany.setNoOfShares(company.getNoOfShares());
                gCompany.setShareValue(company.getShareValue());
                
                response2 = gameCompanyRepository.save(gCompany);
                
                GameRoundCompany roundCompany = new GameRoundCompany();
                roundCompany.setGameCompany(response2);
                roundCompany.setGameRound(response4);
                roundCompany.setShareValue(company.getShareValue());
                
                gameRoundCompanyRepository.save(roundCompany);
            }
            
            
            GameRoundPlayer roundPlayer = new GameRoundPlayer();
            roundPlayer.setGameRound(round);
            roundPlayer.setPlayer(gplayer);
            roundPlayer.setScore(0);
            
            response5 = gameRoundPlayerRepository.save(roundPlayer);
            
            gplayer.setIsPlaying(true);
            gplayer.setIsActive(true);
            gplayer.setIsPlaying(true);
            playerRepository.save(gplayer);
            
            botService.AddPlayersToGame(response1,response4,playerRepository,gamePlayerRepository);
            
            responseData.setGameId(response1.getId());
            responseData.setGameRoundId(response4.getId());
            responseData.setRoundId(response4.getId());
            responseData.setGamePlayerId(response3.getId());
            responseData.setGameRoundPlayerId(response5.getId());
            responseData.setRoundNo(response4.getRound().getRoundNo());
        }        
        
        if(response1 == null ||response3 == null||response4 == null||response5 == null){
            return new ResponseEntity(response1, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity(responseData, HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/GetAllGame/{gameId}", method = RequestMethod.GET, produces = CommonUtil.APPLICATION_JSON)
    public GameViewModel getGameById(@PathVariable(value = "gameId") Long gameId) {
        GameViewModel data = new GameViewModel();
        Game game = gameRepository.findById(gameId).get();
        
        data.setId(game.getId());
        data.setNoOfPlayers(game.getNoOfPlayers());
        data.setCurrentRounds(game.getCurrentRounds());
        data.setGameLeaderId(game.getGameLeaderId());
        data.setNoOfRounds(game.getNoOfRounds());
        
        Set<PlayerViewModel> gamePlayer = new HashSet<PlayerViewModel>();
        for(GamePlayer player : game.getGamePlayers()){
            PlayerViewModel play = new PlayerViewModel();
            play.setId(player.getId());
            play.setName(player.getPlayer().getName());
            play.setEmail(player.getPlayer().getEmail());
            play.setRating(player.getPlayer().getRating());
            
            gamePlayer.add(play);
        }
        
        data.setGamePlayer(gamePlayer);
        
        Set<CompanyViewModel> companyView = new HashSet<CompanyViewModel>();
        for(GameCompany company : game.getGameCompany()){
            CompanyViewModel comp = new CompanyViewModel();
            comp.setId(company.getId());
            comp.setName(company.getCompany().getName());
            comp.setNoOFShares(company.getNoOfShares());
            comp.setShareValue(company.getShareValue());
            
            companyView.add(comp);
        }
        data.setGameCompany(companyView);
        
        Set<RoundViewModel> roundView = new HashSet<RoundViewModel>();
        for(GameRound round : game.getGameRounds()){
            RoundViewModel roundViewModel = new RoundViewModel();
            roundViewModel.setId(round.getId());
            roundViewModel.setNo(round.getRound().getRoundNo());
            roundViewModel.setLeaderId(round.getRoundLeaderId() == null ? 0 : round.getRoundLeaderId());
            roundViewModel.setLeaderpoint(0);
            roundView.add(roundViewModel);
        }
        data.setGameRound(roundView);
        
        return data;
    }
    
    @RequestMapping(value = "/GetAllCompanies/{gameRoundId}", method = RequestMethod.GET, produces = CommonUtil.APPLICATION_JSON)
    public List<CompanyViewModel> getGameRoundCompantById(@PathVariable(value = "gameRoundId") Long gameRoundId) {
        GameViewModel data = new GameViewModel();
        
        GameRound game = gameRoundRepository.findById(gameRoundId).get();
        Set<GameRoundCompany> gameCompanyList = game.getGameRoundCompany();
        
        List<CompanyViewModel> companyList = new ArrayList<>();
        
        for(GameRoundCompany roundCompany : gameCompanyList){
            CompanyViewModel company = new CompanyViewModel();
            
            company.setId(roundCompany.getGameCompany().getId());
            company.setName(roundCompany.getGameCompany().getCompany().getName());
            company.setNoOFShares(roundCompany.getGameCompany().getNoOfShares());
            company.setShareValue(roundCompany.getShareValue());
            
            companyList.add(company);
        }
        return companyList;
    }
    
    @RequestMapping(value = "/GetWatchList/{gamePlayerId}", method = RequestMethod.GET, produces = CommonUtil.APPLICATION_JSON)
    public List<CommonShareListViewModel> getWatchListId(@PathVariable(value = "gamePlayerId") Long gamePlayerId) {
        List<CommonShareListViewModel> watchListList = new ArrayList<>();
        GamePlayer gamePlayerList = gamePlayerRepository.findById(gamePlayerId).get();
        
        Set<WatchList> watchList = gamePlayerList.getWatchList();
        
        for(WatchList roundCompany : watchList){
            CommonShareListViewModel watchlistView = new CommonShareListViewModel();
            
            watchlistView.setCompanyId(roundCompany.getGameCompany().getCompany().getId());
            watchlistView.setName(roundCompany.getGameCompany().getCompany().getName());
            watchlistView.setNoOFShares(roundCompany.getGameCompany().getNoOfShares());
            watchlistView.setShareValue(roundCompany.getGameCompany().getShareValue());
            watchlistView.setId(roundCompany.getId());
            
            watchListList.add(watchlistView);
        }
        return watchListList;
    }
    
     @RequestMapping(value = "/GetGamePlayer/{gamePlayerId}", method = RequestMethod.GET, produces = CommonUtil.APPLICATION_JSON)
    public PlayerGameDataViewModel getPlayerGameData(@PathVariable(value = "gamePlayerId") Long gamePlayerId) {
        
        PlayerGameDataViewModel player = new PlayerGameDataViewModel();
        GamePlayer gamePlayer = gamePlayerRepository.findById(gamePlayerId).get();
        
        if(gamePlayer != null){
            player.setPlayerId(gamePlayer.getPlayer().getId());
            player.setScore(gamePlayer.getHighScore());
            player.setTotalPurchase(gamePlayer.getTotalPurchase());
            player.setTotalSales(gamePlayer.getTotalSales());
            player.setPlayerName(gamePlayer.getPlayer().getName());
            player.setBankBalance(gamePlayer.getBankBalance());
            player.setBankName(gamePlayer.getBank().getName());
            player.setBrokerName(gamePlayer.getBroker().getName());
            player.setRound(gamePlayer.getGame().getCurrentRounds());
            
        }
        return player;
    }
    
    @CrossOrigin
    @RequestMapping(value = "/CreateWatch", method = RequestMethod.POST, consumes = CommonUtil.APPLICATION_JSON, produces = CommonUtil.APPLICATION_JSON)
    public ResponseEntity saveWatch(@RequestBody CompanyViewModel companyView){
        WatchList response = null;
        if(companyView != null){
            
            GamePlayer player = gamePlayerRepository.findById(companyView.getGamePlayerId()).get();
            GameCompany company = gameCompanyRepository.findById(companyView.getId()).get();
            
            WatchList watchListView = new WatchList();
            watchListView.setGameCompany(company);
            watchListView.setGamePlayer(player);
            
            response = watchListRepository.save(watchListView);
            
        }
        if(response == null){
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }
    
    @CrossOrigin
    @RequestMapping(value = "/CompleteRound", method = RequestMethod.POST, consumes = CommonUtil.APPLICATION_JSON, produces = CommonUtil.APPLICATION_JSON)
    public ResponseEntity CompleteRound(@RequestBody ResponseViewModel responseViewModel){
        WatchList response = null;
        
        
        botService = new BOTService(gameRepository,gameCompanyRepository,gamePlayerRepository,playerRepository,roundRepository,
            gameRoundRepository,gameRoundPlayerRepository,bankRepository,brokerRepository,companyRepository,
            gameRoundCompanyRepository,watchListRepository,playerPurchaseRepository,playerTransactionRepository);
        
        Game game = gameRepository.findById(responseViewModel.getGameId()).get();
        GameRound round = gameRoundRepository.findById(responseViewModel.getGameRoundId()).get();
        
        botService.play(game, round); 
        
        if(response == null){
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }
    
     @RequestMapping(value = "/GetAllPlayer", method = RequestMethod.GET, produces = CommonUtil.APPLICATION_JSON)
    public Long getAllPlayer() {
//        List<Long> data = new ArrayList();
//        List<Player> players = playerRepository.findAll();
//        for(Player pl : players){
//            data.add(pl.getId());
//        }
//Long a = Long.valueOf(1);
Long b = Long.valueOf(131);
//        GameCompany company= gameCompanyRepository.find(a, b);
//        return company.getId();
return b;
    }
}
