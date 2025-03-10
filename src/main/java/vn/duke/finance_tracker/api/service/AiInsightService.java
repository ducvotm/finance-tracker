package vn.duke.finance_tracker.api.service;

public interface AiInsightService {

    AccountDtoOut create(AccountDtoIn accountDtoIn);
    AccountDtoOut update(Long id, AccountDtoIn accountDtoIn);
    AccountDtoOut get(Long id);
    void delete(Long id);

}
