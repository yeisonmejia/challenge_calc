package com.challenge.appgate.calc.operations.infrastructure;

import com.challenge.appgate.calc.operations.actions.OperationExecutor;
import com.challenge.appgate.calc.operations.model.operators.OperationResult;
import com.challenge.appgate.calc.operations.model.user.UserNotExistException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ExecuteOperationController {
    private OperationExecutor operationExecutor;

    public ExecuteOperationController(OperationExecutor operationExecutor) {
        this.operationExecutor = operationExecutor;
    }

    @PostMapping("/api/operation/executeOperation")
    public String execute(HttpServletRequest request, @RequestParam String operator) {
        String session = request.getHeader("Authorization");
        if (session == null) throw new UserNotExistException("User does not exist!");

        OperationResult operationResult = operationExecutor.executeOperation(session, operator);
        return operationResult.getValue().toString();
    }
}
