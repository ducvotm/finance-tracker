package vn.duke.finance_tracker.api.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.duke.finance_tracker.api.dto.in.TransactionDtoIn;
import vn.duke.finance_tracker.api.dto.out.TransactionDtoOut;
import vn.duke.finance_tracker.api.service.TransactionService;

import java.util.HashMap;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<TransactionDtoOut> create(@RequestBody @Valid TransactionDtoIn transactionDtoIn) {
        return ResponseEntity.ok(transactionService.create(transactionDtoIn));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TransactionDtoOut> update(@PathVariable Long id, @RequestBody @Valid TransactionDtoIn transactionDtoIn) {
        return ResponseEntity.ok(transactionService.update(id, transactionDtoIn));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionDtoOut> get(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.get(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        transactionService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
