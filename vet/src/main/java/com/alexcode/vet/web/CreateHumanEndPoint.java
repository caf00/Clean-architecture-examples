package com.alexcode.vet.web;

import com.alexcode.vet.web.executor.CreateHumanExecutor;
import com.alexcode.vet.web.request.HumanRequest;
import com.alexcode.vet.web.response.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/human")
public class CreateHumanEndPoint {

    private final CreateHumanExecutor createHumanUseCaseExecutor;

    public CreateHumanEndPoint(CreateHumanExecutor createHumanUseCaseExecutor) {
        this.createHumanUseCaseExecutor = createHumanUseCaseExecutor;
    }

    @PostMapping
    public ResponseEntity<MessageResponse> create(@RequestBody HumanRequest humanRequest) {
        createHumanUseCaseExecutor.executeUseCase(humanRequest);
        return ResponseEntity.ok(MessageResponse.newResponse("Client created successfully"));
    }
}
