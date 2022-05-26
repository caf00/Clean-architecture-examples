package com.alexcode.vet.web.executor;

import com.alexcode.vet.core.usecase.CreateHumanUseCase;
import com.alexcode.vet.core.usecase.dto.CreateHuman;
import com.alexcode.vet.web.request.HumanRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CreateHumanExecutor {
    private final CreateHumanUseCase createHumanUseCase;

    public CreateHumanExecutor(CreateHumanUseCase createHumanUseCase) {
        this.createHumanUseCase = createHumanUseCase;
    }

    public void executeUseCase(HumanRequest humanRequest) {
        createHumanUseCase.execute(CreateHuman.create(
                humanRequest.getFullName(),
                humanRequest.getAddress(),
                humanRequest.getPhoneNumber()
        ));
    }
}
