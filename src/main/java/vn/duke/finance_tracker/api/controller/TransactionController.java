package vn.duke.finance_tracker.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.duke.finance_tracker.api.dto.in.TransactionDtoIn;
import vn.duke.finance_tracker.api.dto.out.TransactionDtoOut;
import vn.duke.finance_tracker.api.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionDtoOut> create(@RequestBody TransactionDtoIn transactionDtoIn) {
        return ResponseEntity.ok(transactionService.create(transactionDtoIn));
    }
    
}
