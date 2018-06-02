package codechef.stockmarket.restcontroller;

import codechef.stockmarket.common.CommonUtil;
import codechef.stockmarket.entity.Test;
import codechef.stockmarket.repository.TestRepositoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestRepositoryService testRepositoryService = null;

    @ApiOperation(value = "Add Value")
    @CrossOrigin
    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = CommonUtil.APPLICATION_JSON, produces = CommonUtil.APPLICATION_JSON)
    public ResponseEntity saveTest(@RequestBody Test test){

        Test response = testRepositoryService.save(test);


        return new ResponseEntity(response, HttpStatus.OK);
    }

    @ApiOperation("Delete Value")
    @CrossOrigin
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, consumes = CommonUtil.APPLICATION_JSON, produces = CommonUtil.APPLICATION_JSON)
    public ResponseEntity deleteTest(@RequestBody Test test){
        try {
            testRepositoryService.delete(test);
        }catch (Exception ex){

        }

        return new ResponseEntity(HttpStatus.OK);

    }
}
