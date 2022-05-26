package com.alexcode.vet.web.executor;

import com.alexcode.vet.core.Pagination;
import com.alexcode.vet.core.usecase.ListPetUseCase;
import com.alexcode.vet.core.usecase.dto.PetDto;
import com.alexcode.vet.web.response.HumanResponse;
import com.alexcode.vet.web.response.ListResponse;
import com.alexcode.vet.web.response.PetResponse;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ListPetExecutor {

    private final ListPetUseCase listPetUseCase;

    public ListPetExecutor(ListPetUseCase listPetUseCase) {
        this.listPetUseCase = listPetUseCase;
    }

    public ListResponse<PetResponse> executeUseCase(Integer page, Integer size) {
        Pagination<PetDto> petDtoPagination = listPetUseCase.execute(page, size);
        return ListResponse.create(
                petDtoPagination.getList().stream().map(p->PetResponse.create(
                        p.getPetId(),
                        p.getName(),
                        p.getAge(),
                        p.getColor(),
                        HumanResponse.create(
                                p.getHuman().getHumanId(),
                                p.getHuman().getFullName(),
                                p.getHuman().getAddress(),
                                p.getHuman().getPhoneNumber()
                        )
                )).collect(Collectors.toList()),
                petDtoPagination.getNumberPage(),
                petDtoPagination.getTotalPage(),
                petDtoPagination.isNext(),
                petDtoPagination.isPrevious()
        );
    }
}
