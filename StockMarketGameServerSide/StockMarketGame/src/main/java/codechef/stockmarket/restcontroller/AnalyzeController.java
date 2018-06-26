/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.restcontroller;

import codechef.stockmarket.common.*;
import codechef.stockmarket.common.ViewModels.CompanyViewModel;
import codechef.stockmarket.entity.Game;
import codechef.stockmarket.entity.GameCompany;
import codechef.stockmarket.repository.*;
import codechef.stockmarket.service.AnalizeService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thari
 */
@RestController
@RequestMapping("/Analyzer")
public class AnalyzeController {
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
    @RequestMapping(value = "/GetGamePlayer/{gameId}", method = RequestMethod.GET, produces = CommonUtil.APPLICATION_JSON)
    public List<CompanyViewModel> getCompanyHistory(@PathVariable(value = "gameId") Long gameId) {
        
        analizeService = new AnalizeService(gameRepository,gameCompanyRepository,gamePlayerRepository,playerRepository,roundRepository,
            gameRoundRepository,gameRoundPlayerRepository,bankRepository,brokerRepository,companyRepository,
            gameRoundCompanyRepository,watchListRepository,playerPurchaseRepository,playerTransactionRepository);
        
        Game game = gameRepository.findById(gameId).get();
        Map<Long, List<Double>> CompanyHistory;
        CompanyHistory = new HashMap<>();
        List<CompanyViewModel> bestCompanies = new ArrayList<>();
        CompanyHistory = analizeService.AnalyzeCompanies(game);
        
        List<Integer> givenList = analizeService.BestCompanies(CompanyHistory);
        for(int a : givenList){
            GameCompany bestCompany= gameCompanyRepository.findById(Long.valueOf(a)).get();
            CompanyViewModel company = new CompanyViewModel();
            company.setId(bestCompany.getId());
            company.setName(bestCompany.getCompany().getName());
            company.setShareValue(bestCompany.getShareValue());
            company.setNoOFShares(bestCompany.getNoOfShares());
            
            bestCompanies.add(company);
        }
        if(givenList.size() == 0){
            givenList = analizeService.EligiableCompanies(CompanyHistory);
            for(int a : givenList){
            GameCompany bestCompany= gameCompanyRepository.findById(Long.valueOf(a)).get();
            CompanyViewModel company = new CompanyViewModel();
            company.setId(bestCompany.getId());
            company.setName(bestCompany.getCompany().getName());
            company.setShareValue(bestCompany.getShareValue());
            company.setNoOFShares(bestCompany.getNoOfShares());
            
            bestCompanies.add(company);
        }
        }
        return bestCompanies;
    }
}
