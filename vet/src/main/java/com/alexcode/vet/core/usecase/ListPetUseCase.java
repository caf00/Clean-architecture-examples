package com.alexcode.vet.core.usecase;

import com.alexcode.vet.core.Pagination;
import com.alexcode.vet.core.usecase.dto.PetDto;

public interface ListPetUseCase {
    Pagination<PetDto> execute(Integer page, Integer size);
}
