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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
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
@RequestMapping("/Purchase")
public class PurchaseController {
    @Autowired
    GamePlayerRepository gamePlayerRepository = null;
    @Autowired
    PlayerPurchaseRepository playerPurchaseRepository = null;
    @Autowired
    PlayerTransactionRepository playerTransactionRepository = null;
    
    @RequestMapping(value = "/GetMyShares/{gamePlayerId}", method = RequestMethod.GET, produces = CommonUtil.APPLICATION_JSON)
    public List<CommonShareListViewModel> getMyShares(@PathVariable(value = "gamePlayerId") Long gamePlayerId) {
        List<CommonShareListViewModel> watchListList = new ArrayList<>();
        GamePlayer gamePlayerList = gamePlayerRepository.findById(gamePlayerId).get();
        
        Set<PlayerPurchase> shareList = gamePlayerList.getPlayerPurchase();
        
        for(PlayerPurchase roundCompany : shareList){
            if(roundCompany.getIsSold() == false){
                CommonShareListViewModel watchlistView = new CommonShareListViewModel();
            
                watchlistView.setCompanyId(roundCompany.getGameCompany().getCompany().getId());
                watchlistView.setName(roundCompany.getGameCompany().getCompany().getName());
                watchlistView.setNoOFShares(roundCompany.getGameCompany().getNoOfShares());
                watchlistView.setShareValue(roundCompany.getGameCompany().getShareValue());
                watchlistView.setId(roundCompany.getId());

                watchListList.add(watchlistView);
            }
        }
        return watchListList;
    }
    @RequestMapping(value = "/GetAllPurchases/{gamePlayerId}", method = RequestMethod.GET, produces = CommonUtil.APPLICATION_JSON)
    public List<CommonShareListViewModel> getAllPurchase(@PathVariable(value = "gamePlayerId") Long gamePlayerId) {
        List<CommonShareListViewModel> watchListList = new ArrayList<>();
        GamePlayer gamePlayerList = gamePlayerRepository.findById(gamePlayerId).get();
        
        Set<PlayerPurchase> shareList = gamePlayerList.getPlayerPurchase();
        
        for(PlayerPurchase roundCompany : shareList){
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
    
    @RequestMapping(value = "/GetAllTransactions/{gamePlayerId}", method = RequestMethod.GET, produces = CommonUtil.APPLICATION_JSON)
    public List<TransactionViewModel> getAllTransactions(@PathVariable(value = "gamePlayerId") Long gamePlayerId) {
        List<TransactionViewModel> transactList = new ArrayList<>();
        GamePlayer gamePlayerList = gamePlayerRepository.findById(gamePlayerId).get();
        
        Set<PlayerTransactions> transactionList = gamePlayerList.getPlayerTransactions();
        
        for(PlayerTransactions transaction : transactionList){
                TransactionViewModel transactionView = new TransactionViewModel();
            
                transactionView.setTransactionNo(transaction.getTransactionNo());
                transactionView.setAmount(transaction.getAmount());
                transactionView.setTime(transaction.getTime());
                transactionView.setRoundNo(transaction.getGameRound().getRound().getRoundNo());

                transactList.add(transactionView);
        }
        return transactList;
    }
    
    @RequestMapping(value = "/GetRoundTransactions/{gamePlayerId}/{gameRoundId}", method = RequestMethod.GET, produces = CommonUtil.APPLICATION_JSON)
    public List<TransactionViewModel> getRoundTransactions(@PathVariable(value = "gamePlayerId") Long gamePlayerId, @PathVariable(value = "gameRoundId") Long gameRoundId) {
        List<TransactionViewModel> transactList = new ArrayList<>();
        GamePlayer gamePlayerList = gamePlayerRepository.findById(gamePlayerId).get();
        
        Set<PlayerTransactions> transactionList = gamePlayerList.getPlayerTransactions();
        
        for(PlayerTransactions transaction : transactionList){
                if(Objects.equals(transaction.getGameRound().getId(), gameRoundId)){
                    TransactionViewModel transactionView = new TransactionViewModel();
            
                    transactionView.setTransactionNo(transaction.getTransactionNo());
                    transactionView.setAmount(transaction.getAmount());
                    transactionView.setTime(transaction.getTime());
                    transactionView.setRoundNo(transaction.getGameRound().getRound().getRoundNo());

                    transactList.add(transactionView);
                }
        }
        return transactList;
    }
}
