package com.alexcode.vet.core.usecase.impl;

import com.alexcode.vet.core.domain.HumanRepository;
import com.alexcode.vet.core.domain.PetRepository;
import com.alexcode.vet.core.domain.entity.Human;
import com.alexcode.vet.core.domain.entity.Pet;
import com.alexcode.vet.core.usecase.CreatePetUseCase;
import com.alexcode.vet.core.usecase.dto.CreatePet;

public class CreatePetUseCaseImpl implements CreatePetUseCase {

    private final PetRepository petRepository;
    private final HumanRepository humanRepository;

    public CreatePetUseCaseImpl(PetRepository petRepository,
                                HumanRepository humanRepository) {
        this.petRepository = petRepository;
        this.humanRepository = humanRepository;
    }

    @Override
    public void execute(CreatePet pet) {
        Human human = humanRepository.findById(pet.getHumanId())
                        .orElseThrow(()->new RuntimeException("Error"));
        petRepository.save(Pet.createWithOutId(
                pet.getName(),
                pet.getAge(),
                pet.getColor(),
                human
        ));
    }
}
