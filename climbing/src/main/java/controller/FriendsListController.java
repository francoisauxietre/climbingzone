package controller;

import com.escalade.demo.domain.User;
import com.escalade.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;

@RestController() // genere les URI de notre API
@RequestMapping("api")

@Api(value = "/Friend", tags = {"Api friends: (GetFriend(id), findFriend(id), DeleteFriend(id))"})
public class FriendsListController {

    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Access-Control-Allow-Origin","*");
    }

    @Autowired
    UserService userService;

    @GetMapping( value = "/Friend/{id}")
    public String findFriendById(@PathVariable int id){
        return "le nom de votre ami est " +id;
    }

    @GetMapping(value = "/Friends")
    public List<User> findAllFriends(){
        //TODO chopper le nom et prenom de l'utilisateur courant
        String name = "test";
        String firstName = "test";

        return userService.findAllFriendsListByFirstNameAndLastName(name, firstName);
    }

    //ajoute un nouvel ami à un utilisateur
    @ApiOperation(value = "Ajouter un ami")
    @PostMapping("/Friend/{id}")
    public ResponseEntity<Void> addFriendList(@PathVariable int id, @RequestParam("name") String name, @RequestParam("firstName") String firstName) {

        // TODO A FAIRE Trouver l'utilisateur courant qui sera loggué
        User courant = userService.findById((long) id);
        if (courant==null){
            return ResponseEntity.noContent().build();
        }
        else {
            URI uri = ServletUriComponentsBuilder.
                    fromCurrentRequestUri().
                    path("/{id}").
                    buildAndExpand(courant.getId()).
                    toUri();
            userService.addFriendsList(courant, name, firstName);
            return ResponseEntity.created(uri).build();
        }


    }

}
