package com.challenge.appgate.calc.operations.infrastructure;

import com.challenge.appgate.calc.operations.actions.OperandSaver;
import com.challenge.appgate.calc.operations.model.user.UserNotExistException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AddOperandController {

    private OperandSaver operandSaver;

    public AddOperandController(OperandSaver operandSaver) {
        this.operandSaver = operandSaver;
    }

    @PostMapping("/api/operand/addOperand")
    public void execute(HttpServletRequest request, @RequestParam String operand) {
        String session = request.getHeader("Authorization");
        if (session == null) throw new UserNotExistException("User does not exist!");

        operandSaver.saveOperandForUser(session, operand);
    }
}
