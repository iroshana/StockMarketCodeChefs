/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.service;

import codechef.stockmarket.common.ViewModels.CompanyViewModel;
import codechef.stockmarket.entity.*;
import codechef.stockmarket.repository.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author thari
 */
public class AnalizeService {
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
    
    public  Map<Long, List<Double>> AnalyzeCompanies(Game game){
        List<Double> rCompanies = null;
        Map<Long, List<Double>> CompanyHistory;
        CompanyHistory = new HashMap<>();
        
        Set<GameRound> gamer = game.getGameRounds();
        
        for(GameRound r : gamer){
            Set<GameRoundCompany> companies = r.getGameRoundCompany();
            for(GameRoundCompany roundCompany : companies){
                if(CompanyHistory.containsKey(roundCompany.getGameCompany().getCompany().getId())){
                    rCompanies = new ArrayList();
                    rCompanies.add(roundCompany.getShareValue());
                    CompanyHistory.put(roundCompany.getGameCompany().getCompany().getId(), rCompanies);
                }else{
                    CompanyHistory.get(roundCompany.getGameCompany().getCompany().getId()).add(roundCompany.getShareValue());
                }
            }
        }
        
        return CompanyHistory;
    }
    
    public List<Long> CalculateBest(Map<Long, List<Double>> CompanyHistory){
        List<Long> bestCompanies = new ArrayList();
        
        for (Map.Entry<Long, List<Double>> entry : CompanyHistory.entrySet()) {
            Long key = entry.getKey();
            List<Double> value = entry.getValue();
            
        }
        
        return bestCompanies;
    }
}
