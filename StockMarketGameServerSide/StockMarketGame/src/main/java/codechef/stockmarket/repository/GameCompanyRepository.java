/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.repository;

import codechef.stockmarket.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author thari
 */
public interface GameCompanyRepository  extends JpaRepository<GameCompany, Long>{
//    @Query("SELECT p FROM Game_Company p WHERE company_id = companyId and game_id = gameId")
//    public GameCompany find(@Param("companyId") Long compantId,@Param("gameId") Long gameId);
}
