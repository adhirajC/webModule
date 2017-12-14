package webModule;
import java.util.Map;



//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
/*import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

@Autowired
private final UserRepository userRepository;

@Autowired
private final AccountRepository accountRepository;
String handle;


UserController(UserRepository userRepository, AccountRepository accountRepository){
	this.userRepository=userRepository;
	this.accountRepository=accountRepository;
}

    @RequestMapping(value = "/api/validaate", method=RequestMethod.POST)
    public ResponseEntity login(@RequestBody String username, @RequestBody String password) {
       if (this.userRepository.findByUsername(username).isPresent()) {
    	   UserModel user=this.userRepository.findByUsername(username).get();
    	   if(user.getPassword().equals(password)){
    		   return new ResponseEntity(HttpStatus.OK);
    		   }else {return new ResponseEntity(HttpStatus.BAD_REQUEST);	
    	   }
       }
    	   return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
       
   @RequestMapping(value="/api/users/{userID}", method = RequestMethod.GET) 
   public ResponseEntity validateLogin(@PathVariable String username, Model model) {
	   this.handle=username;
      UserModel user=this.userRepository.findByUsername(handle).get();
     
       return new ResponseEntity<UserModel>(user,HttpStatus.BAD_REQUEST);	
    }    
       
  /*  @RequestMapping(value = "/api/validate", method = RequestMethod.POST)
    public ResponseEntity validateLogin(@RequestBody String username, @RequestBody String password) {
        if (this.userRepository.findByUsername(username).isPresent()) {
     	   UserModel user=this.userRepository.findByUsername(username).get();
     	   if(user.getPassword().equals(password)) {
     		   return new ResponseEntity(HttpStatus.OK);	
     	   }
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);	
     }*/
}