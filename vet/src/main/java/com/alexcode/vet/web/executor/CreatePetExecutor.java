package com.alexcode.vet.web.executor;

import com.alexcode.vet.core.usecase.CreatePetUseCase;
import com.alexcode.vet.core.usecase.dto.CreatePet;
import com.alexcode.vet.web.request.PetRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreatePetExecutor {
    private final CreatePetUseCase createPetUseCase;

    public CreatePetExecutor(CreatePetUseCase createPetUseCase) {
        this.createPetUseCase = createPetUseCase;
    }

    public void executeUseCase(PetRequest petRequest) {
        createPetUseCase.execute(CreatePet.create(
                petRequest.getName(),
                petRequest.getAge(),
                petRequest.getColor(),
                petRequest.getHumanId()
        ));
    }
}
