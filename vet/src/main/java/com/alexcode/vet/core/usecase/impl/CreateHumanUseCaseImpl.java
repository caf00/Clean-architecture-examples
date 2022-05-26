package com.alexcode.vet.core.usecase.impl;

import com.alexcode.vet.core.domain.HumanRepository;
import com.alexcode.vet.core.domain.entity.Human;
import com.alexcode.vet.core.usecase.CreateHumanUseCase;
import com.alexcode.vet.core.usecase.dto.CreateHuman;

public class CreateHumanUseCaseImpl implements CreateHumanUseCase {

    private final HumanRepository humanRepository;

    public CreateHumanUseCaseImpl(HumanRepository humanRepository) {
        this.humanRepository = humanRepository;
    }

    @Override
    public void execute(CreateHuman human) {
        humanRepository.save(Human.createWithOutId(
                human.getFullName(),
                human.getAddress(),
                human.getPhoneNumber()
        ));
    }
}
