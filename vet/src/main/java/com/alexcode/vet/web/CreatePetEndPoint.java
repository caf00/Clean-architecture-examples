package com.alexcode.vet.web;

import com.alexcode.vet.core.usecase.dto.CreatePet;
import com.alexcode.vet.web.executor.CreatePetExecutor;
import com.alexcode.vet.web.request.PetRequest;
import com.alexcode.vet.web.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet")
public class CreatePetEndPoint {

    private final CreatePetExecutor createPetExecutor;

    public CreatePetEndPoint(CreatePetExecutor createPetExecutor) {
        this.createPetExecutor = createPetExecutor;
    }

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody PetRequest petRequest) {
        createPetExecutor.executeUseCase(petRequest);
        return ResponseEntity.ok(MessageResponse.newResponse("Pet created successfully"));
    }
}
