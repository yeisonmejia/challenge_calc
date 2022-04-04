package com.challenge.appgate.calc.operations.infrastructure;

import com.challenge.appgate.calc.operations.actions.UserCreator;
import com.challenge.appgate.calc.operations.model.user.UserId;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserCreatorController {
    public UserCreator userCreator;

    public UserCreatorController(UserCreator userCreator) {
        this.userCreator = userCreator;
    }

    @PostMapping("/api/user/createUser")
    @ResponseBody
    public String execute(HttpServletResponse response){
        UserId user = userCreator.createUser();
        response.setHeader("Authorization", String.valueOf(user.getValue()));
        return String.valueOf(user.getValue());
    }
}
