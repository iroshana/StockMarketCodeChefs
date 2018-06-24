/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.service;

import codechef.stockmarket.common.ViewModels.CompanyViewModel;
import codechef.stockmarket.entity.*;
import codechef.stockmarket.repository.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
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
    
    public AnalizeService(GameRepository _gameRepository,GameCompanyRepository _gameCompanyRepository,GamePlayerRepository _gamePlayerRepository,PlayerRepository _playerRepository,RoundRepository _roundRepository,
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
    
    public  Map<Long, List<Double>> AnalyzeCompanies(Game game){
        List<Double> rCompanies = null;
        Map<Long, List<Double>> CompanyHistory;
        CompanyHistory = new HashMap<>();
        
        Set<GameRound> gamer = game.getGameRounds();
        
        for(GameRound r : gamer){
            Set<GameRoundCompany> companies = r.getGameRoundCompany();
            for(GameRoundCompany roundCompany : companies){
                if(CompanyHistory.containsKey(roundCompany.getGameCompany().getId())){
                    CompanyHistory.get(roundCompany.getGameCompany().getId()).add(roundCompany.getShareValue());
                }else{
                    rCompanies = new ArrayList();
                    rCompanies.add(roundCompany.getShareValue());
                    CompanyHistory.put(roundCompany.getGameCompany().getId(), rCompanies);
                }
            }
        }
        
        return CompanyHistory;
    }
    
    public List<Integer> CalculateTop(Map<Long, List<Double>> CompanyHistory){
        
        List<Integer> topCompanies = new ArrayList();
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
            topCompanies.add(sub.get(i).intValue());
        }
        return topCompanies;
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
      public List<Integer> EligiableCompanies(Map<Long, List<Double>> CompanyHistory){
          
        List<Integer> eligiableCompanies = new ArrayList();
        HashMap<Long,Double> list = new HashMap<>();
        boolean isEligible = false;
        for (Map.Entry<Long, List<Double>> entry : CompanyHistory.entrySet()) {
            Long key = entry.getKey();
            List<Double> value = entry.getValue();
            double shareVal = 0;
            for(double val : value){
                shareVal += val;
            }
            for(int i = 0 ; i < value.size() ; i++){
                if(i!=0){
                    if(value.get(i-1) > value.get(i)){
                        isEligible = true;
                    }
                }
            }
            if(isEligible){
               list.put(key, shareVal); 
            }
        }
        
        Set<Long> keys = list.keySet();
        List<Long> frozenOrder=new ArrayList<>(keys);
        int no = frozenOrder.size() - 3 == 0 ? frozenOrder.size() : frozenOrder.size()-3 ;
        List<Long> sub =frozenOrder.subList(0, no);
        for(int i = 0; i < sub.size(); i ++){
            eligiableCompanies.add(sub.get(i).intValue());
        }
        
        return eligiableCompanies;
      }
      
      public List<Integer> BestCompanies(Map<Long, List<Double>> CompanyHistory){
          
        List<Integer> bestCompanies = new ArrayList();
        HashMap<Long,Double> list = new HashMap<>();
        boolean isBest = false;
        for (Map.Entry<Long, List<Double>> entry : CompanyHistory.entrySet()) {
            Long key = entry.getKey();
            List<Double> value = entry.getValue();
            double shareVal = 0;
            for(double val : value){
                shareVal += val;
            }
            for(int i = 0 ; i < value.size() ; i++){
                if(i!=0){
                    if(value.get(i-1) > value.get(i)){
                        isBest = true;
                    }else{
                        isBest = false;
                        break;
                    }
                }
            }
            if(isBest){
               list.put(key, shareVal); 
            }
        }
        
        Set<Long> keys = list.keySet();
        List<Long> frozenOrder=new ArrayList<>(keys);
        int no = frozenOrder.size() - 3 == 0 ? frozenOrder.size() : frozenOrder.size()-3 ;
        List<Long> sub =frozenOrder.subList(0, no);
        for(int i = 0; i < sub.size(); i ++){
            bestCompanies.add(sub.get(i).intValue());
        }
        
        return bestCompanies;
      }
      
      public double ChangeCompany(boolean increase,double shValue){
          int yes = 1;
          double shareVal = 0;
          int high = 5;
          int low = 1;
          int val = 0;
          Random random = new Random();
        DecimalFormat df = new DecimalFormat("#.00"); 
          boolean value = random.nextBoolean();
          if(increase){
              val = random.nextInt(high-low) + low;
              shareVal =  shValue + (shValue * val/100);
          }else{
              if(value){
                 val = random.nextInt(high-low) + low;
                shareVal = shValue + (shValue * val/100);
              }else{
                  val = random.nextInt(high-low) + low;
                    shareVal = shValue - (shValue * val/100);
              }
          }
          shareVal = Double.parseDouble(df.format(shareVal));
          return shareVal;
      }
}
