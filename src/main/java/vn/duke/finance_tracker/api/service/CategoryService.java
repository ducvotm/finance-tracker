package vn.duke.finance_tracker.api.service;

import vn.duke.finance_tracker.api.dto.in.CategoryDtoIn;
import vn.duke.finance_tracker.api.entity.Category;

public interface CategoryService {

    Category create(CategoryDtoIn categoryDtoIn);
    Category update(Long id, CategoryDtoIn categoryDtoIn);
    Category get(Long id);
    void delete(Long id);

}
