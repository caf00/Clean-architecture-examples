package com.alexcode.vet.core.usecase.impl;

import com.alexcode.vet.core.Pagination;
import com.alexcode.vet.core.domain.PetRepository;
import com.alexcode.vet.core.usecase.ListPetUseCase;
import com.alexcode.vet.core.usecase.dto.HumanDto;
import com.alexcode.vet.core.usecase.dto.PetDto;

import java.util.stream.Collectors;


public class ListPetUseCaseImpl implements ListPetUseCase {

    private final PetRepository petRepository;

    public ListPetUseCaseImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pagination<PetDto> execute(Integer page, Integer size) {
        return petRepository.findAll(page, size)
                .map(p->Pagination.create(
                        p.getList().stream().map(pet->PetDto.create(
                                pet.getPetId(),
                                pet.getName(),
                                pet.getAge(),
                                pet.getColor(),
                                HumanDto.create(
                                        pet.getHuman().getHumanId(),
                                        pet.getHuman().getFullName(),
                                        pet.getHuman().getAddress(),
                                        pet.getHuman().getPhoneNumber()
                                )
                        )).collect(Collectors.toList()),
                        p.getNumberPage(),
                        p.getTotalPage(),
                        p.isNext(),
                        p.isPrevious()
                ));
    }
}
