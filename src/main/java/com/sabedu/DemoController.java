/**
 * 
 */
package com.sabedu;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sabedu.entity.Country;

/**
 * @author Sunil
 *
 * DemoController.java Jan 8, 2021 11:46:25 AM
 */
@RestController
public class DemoController {
	@RequestMapping(value = "/rest/getCountry")
    public ResponseEntity<Country> getCountry() {
        Country c = new Country();
        c.setName("France");
        c.setPopulation(66984000);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Responded", "MyController");
        //return ResponseEntity.accepted().headers(headers).body(c);
       // return ResponseEntity.badRequest().body(c);
       // return new ResponseEntity (HttpStatus.DESTINATION_LOCKED);
        return new ResponseEntity ("success",HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(value = "/rest/getCountry2")
    @ResponseBody
    public Country getCountry2() {
        Country c = new Country();
        c.setName("France");
        c.setPopulation(66984000);
        return c;
    }    
	
}
