package fr.limayrac.declarationFrais.declarationFrais.controller;

import fr.limayrac.declarationFrais.declarationFrais.model.ExpenseDeclaration;
import fr.limayrac.declarationFrais.declarationFrais.service.ExpenseDeclarationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.webflow.executor.FlowExecutionResult;
import org.springframework.webflow.executor.FlowExecutor;

@Controller
@RequestMapping("/expenseDeclaration")
public class ExpenseDeclarationController {

    @Autowired
    private FlowExecutor flowExecutor;


}
