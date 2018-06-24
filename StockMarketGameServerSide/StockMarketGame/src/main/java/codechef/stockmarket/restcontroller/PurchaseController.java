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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Date;
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
@RequestMapping("/Purchase")
public class PurchaseController {
    @Autowired
    GamePlayerRepository gamePlayerRepository = null;
    @Autowired
    PlayerPurchaseRepository playerPurchaseRepository = null;
    @Autowired
    PlayerTransactionRepository playerTransactionRepository = null;
    @Autowired
    GameCompanyRepository gameCompanyRepository = null;
    @Autowired
    BankRepository bankRepository = null;
    @Autowired
    GameRoundRepository gameRoundRepository = null;
    
    @RequestMapping(value = "/GetMyShares/{gamePlayerId}", method = RequestMethod.GET, produces = CommonUtil.APPLICATION_JSON)
    public List<CommonShareListViewModel> getMyShares(@PathVariable(value = "gamePlayerId") Long gamePlayerId) {
        List<CommonShareListViewModel> watchListList = new ArrayList<>();
        GamePlayer gamePlayerList = gamePlayerRepository.findById(gamePlayerId).get();
        
        Set<Playerpurchase> shareList = gamePlayerList.getPlayerPurchase();
        
        for(Playerpurchase roundCompany : shareList){
            if(roundCompany.getIsSold() == false){
                CommonShareListViewModel watchlistView = new CommonShareListViewModel();
            
                watchlistView.setCompanyId(roundCompany.getGameCompany().getId());
                watchlistView.setName(roundCompany.getGameCompany().getCompany().getName());
                watchlistView.setNoOFShares(roundCompany.getNoOfShare());
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
        
        Set<Playerpurchase> shareList = gamePlayerList.getPlayerPurchase();
        
        for(Playerpurchase roundCompany : shareList){
                CommonShareListViewModel watchlistView = new CommonShareListViewModel();
            
                watchlistView.setCompanyId(roundCompany.getGameCompany().getId());
                watchlistView.setName(roundCompany.getGameCompany().getCompany().getName());
                watchlistView.setNoOFShares(roundCompany.getNoOfShare());
                watchlistView.setShareValue(roundCompany.getShareValue());
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
    
    @CrossOrigin
    @RequestMapping(value = "/CreatePurchase", method = RequestMethod.POST, consumes = CommonUtil.APPLICATION_JSON, produces = CommonUtil.APPLICATION_JSON)
    public ResponseEntity createPurchase(@RequestBody PurchaseViewModel purchaseView){
        Playerpurchase response = null;
        String errorMessage = "";
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();
	//System.out.println(dateFormat.format(date));
        try{
            
        
        if(purchaseView != null){
            
            GamePlayer player = gamePlayerRepository.findById(purchaseView.getGamePlayerId()).get();
            GameCompany company = gameCompanyRepository.findById(purchaseView.getGameCompanyId()).get();
            Bank bank = bankRepository.findById(purchaseView.getBankId()).get();
            GameRound round = gameRoundRepository.findById(purchaseView.getGameRoundId()).get();
            
            if(player.getBankBalance() > (purchaseView.getNoOFShares() * company.getShareValue())){
                
                Playerpurchase playerpurchaseView = new Playerpurchase();
                playerpurchaseView.setGameCompany(company);
                playerpurchaseView.setGamePlayer(player);
                playerpurchaseView.setNoOfShare(purchaseView.getNoOFShares());
                playerpurchaseView.setShareValue(company.getShareValue());
                playerpurchaseView.setIsSold(false);

                response = playerPurchaseRepository.save(playerpurchaseView);

                PlayerTransactions Transaction = new PlayerTransactions();
                Transaction.setBank(bank);
                Transaction.setGamePlayer(player);
                Transaction.setGameRound(round);
                Transaction.setAmount(-1 *((float) (purchaseView.getNoOFShares() * company.getShareValue())));
                Transaction.setTime(dateFormat.format(date));
                Transaction.setTransactionNo("T" + dateFormat.format(date));
                playerTransactionRepository.save(Transaction);

                player.setBankBalance(player.getBankBalance()+( -1 *((float) (purchaseView.getNoOFShares() * company.getShareValue()))));
                gamePlayerRepository.save(player);
            }else{
                errorMessage = "Not Enough Bank Balance";
            }
        } 
        }catch(Exception ex)
        {
            errorMessage = ex.getMessage();
        }
        if(!"".equals(errorMessage)){
            return new ResponseEntity(response, HttpStatus.valueOf(errorMessage));
        }else{
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }
    
    @CrossOrigin
    @RequestMapping(value = "/SellMyShares", method = RequestMethod.POST,consumes = CommonUtil.APPLICATION_JSON, produces = CommonUtil.APPLICATION_JSON)
    public ResponseEntity SellShares(@RequestBody SellViewModel sellView){
        Playerpurchase response = null;
        String errorMessage = "";
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	Date date = new Date();
        try{
        if(sellView != null){
            GameRound round = gameRoundRepository.findById(sellView.getGameRoundId()).get();
            Playerpurchase item = playerPurchaseRepository.findById(sellView.getId()).get();
            item.setIsSold(true);
            
            playerPurchaseRepository.save(item);
            
            GameCompany company = gameCompanyRepository.findById(item.getGameCompany().getId()).get();
            
            GamePlayer player = item.getGamePlayer();
            player.setBankBalance(player.getBankBalance() + (item.getNoOfShare()*company.getShareValue()));
            gamePlayerRepository.save(player);
            
            PlayerTransactions Transaction = new PlayerTransactions();
                Transaction.setBank(item.getGamePlayer().getBank());
                Transaction.setGamePlayer(player);
                Transaction.setAmount(((float) (item.getNoOfShare()*company.getShareValue())));
                Transaction.setTime(dateFormat.format(date));
                Transaction.setTransactionNo("T" + dateFormat.format(date));
                Transaction.setGameRound(round);
                playerTransactionRepository.save(Transaction);
            
        } else{
            errorMessage = "Select Record";
        }
        }catch(Exception ex)
        {
            errorMessage = ex.getMessage();
        }
        if(!"".equals(errorMessage)){
            return new ResponseEntity(response, HttpStatus.valueOf(errorMessage));
        }else{
            return new ResponseEntity(response, HttpStatus.OK);
        }
    }
}
