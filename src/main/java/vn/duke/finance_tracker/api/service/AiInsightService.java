package vn.duke.finance_tracker.api.service;

import vn.duke.finance_tracker.api.dto.in.AiInsightDtoIn;
import vn.duke.finance_tracker.api.entity.AiInsight;

public interface AiInsightService {

    AiInsight create(AiInsightDtoIn aiInsightDtoIn);
    AiInsight update(Long id, AiInsightDtoIn aiInsightDtoIn);
    AiInsight get(Long id);
    void delete(Long id);

}
