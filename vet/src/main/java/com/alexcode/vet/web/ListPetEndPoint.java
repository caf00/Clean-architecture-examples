package com.alexcode.vet.web;

import com.alexcode.vet.web.executor.ListPetExecutor;
import com.alexcode.vet.web.response.ListResponse;
import com.alexcode.vet.web.response.PetResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pet")
public class ListPetEndPoint {
    private final ListPetExecutor listPetExecutor;

    public ListPetEndPoint(ListPetExecutor listPetExecutor) {
        this.listPetExecutor = listPetExecutor;
    }


    @GetMapping
    public ResponseEntity<ListResponse<PetResponse>> list(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size
    ) {
        ListResponse<PetResponse> listResponse = listPetExecutor.executeUseCase(page, size);
        return ResponseEntity.ok(listResponse);
    }
}
