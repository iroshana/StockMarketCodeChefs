/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.restcontroller;

import codechef.stockmarket.common.CommonUtil;
import codechef.stockmarket.entity.*;
import codechef.stockmarket.repository.*;
import codechef.stockmarket.service.AnalizeService;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/Company")
public class CompanyController {
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
    AnalizeService analizeService = null;
    @RequestMapping(value = "/GetChartData/{gameId}/{gameCompanyId}", method = RequestMethod.GET, produces = CommonUtil.APPLICATION_JSON)
    public ResponseEntity getCompanyHistory(@PathVariable(value = "gameId") Long gameId,@PathVariable(value = "gameCompanyId") Long gameCompanyId) {
        
        analizeService = new AnalizeService(gameRepository,gameCompanyRepository,gamePlayerRepository,playerRepository,roundRepository,
            gameRoundRepository,gameRoundPlayerRepository,bankRepository,brokerRepository,companyRepository,
            gameRoundCompanyRepository,watchListRepository,playerPurchaseRepository,playerTransactionRepository);
        
        Game game = gameRepository.findById(gameId).get();
        Map<Long, List<Double>> CompanyHistory;
        CompanyHistory = new HashMap<>();
        
        CompanyHistory = analizeService.AnalyzeCompanies(game);
        
        List<Double> history = CompanyHistory.get(gameCompanyId);
        switch(history.size()){
                case 1: 
                for(int i = 0 ; i < 4 ; i++)
                history.add(Double.valueOf(0));
                break;
                case 2: 
                for(int i = 0 ; i < 3 ; i++)
                history.add(Double.valueOf(0));
                break;
                case 3: 
                for(int i = 0 ; i < 2 ; i++)
                history.add(Double.valueOf(0));
                break;
                case 4: 
                for(int i = 0 ; i < 1 ; i++)
                history.add(Double.valueOf(0));
                break;
                default:break;
        }
        if(history.size() <= 0){
            return new ResponseEntity(history, HttpStatus.BAD_REQUEST);
        }else{
            return new ResponseEntity(history, HttpStatus.OK);
        }
    }
}
