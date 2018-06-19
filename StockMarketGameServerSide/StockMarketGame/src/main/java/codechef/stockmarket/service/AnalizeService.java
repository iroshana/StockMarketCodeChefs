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
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import static javafx.scene.input.KeyCode.T;
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
    
    public List<Integer> CalculateBest(Map<Long, List<Double>> CompanyHistory){
        
        List<Integer> bestCompanies = new ArrayList();
        HashMap<Long,Double> list = new HashMap<>();
        
        for (Map.Entry<Long, List<Double>> entry : CompanyHistory.entrySet()) {
            Long key = entry.getKey();
            List<Double> value = entry.getValue();
            double shareVal = 0;
            for(double val : value){
                shareVal += val;
            }
            
            list.put(key, shareVal);
        }
        
        Map<Long,Double> map = sortByValues(list);
        Set<Long> keys = map.keySet();
        List<Long> frozenOrder=new ArrayList<>(keys);
        int no = frozenOrder.size() - 3 == 0 ? frozenOrder.size() : frozenOrder.size()-3 ;
        List<Long> sub =frozenOrder.subList(0, no);
        for(int i = 0; i < sub.size(); i ++){
            bestCompanies.add(sub.get(i).intValue());
        }
        return bestCompanies;
    }
    
      private static HashMap sortByValues(HashMap map) { 
       List list = new LinkedList(map.entrySet());
       // Defined Custom Comparator here
       Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
               return ((Comparable) ((Map.Entry) (o1)).getValue())
                  .compareTo(((Map.Entry) (o2)).getValue());
            }
       });

       // Here I am copying the sorted list in HashMap
       // using LinkedHashMap to preserve the insertion order
       HashMap sortedHashMap = new LinkedHashMap();
       for (Iterator it = list.iterator(); it.hasNext();) {
              Map.Entry entry = (Map.Entry) it.next();
              sortedHashMap.put(entry.getKey(), entry.getValue());
       } 
       return sortedHashMap;
  }
}
