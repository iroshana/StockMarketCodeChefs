/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codechef.stockmarket.restcontroller;

import codechef.stockmarket.common.CommonUtil;
import codechef.stockmarket.entity.*;
import codechef.stockmarket.repository.*;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author thari
 */
@RestController
@RequestMapping("/Player")
public class CompanyController {
    @Autowired
    CompanyRepository CompanyRepositoryService = null;

    @ApiOperation(value = "Add Value")
    @CrossOrigin
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = CommonUtil.APPLICATION_JSON, produces = CommonUtil.APPLICATION_JSON)
    public ResponseEntity saveTest(@RequestBody Company test){

        Company response = CompanyRepositoryService.save(test);


        return new ResponseEntity(response, HttpStatus.OK);
    }
}
