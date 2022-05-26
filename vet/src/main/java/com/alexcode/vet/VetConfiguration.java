package com.alexcode.vet;

import com.alexcode.vet.core.usecase.CreateHumanUseCase;
import com.alexcode.vet.core.usecase.CreatePetUseCase;
import com.alexcode.vet.core.usecase.ListPetUseCase;
import com.alexcode.vet.core.usecase.impl.CreateHumanUseCaseImpl;
import com.alexcode.vet.core.usecase.impl.CreatePetUseCaseImpl;
import com.alexcode.vet.core.usecase.impl.ListPetUseCaseImpl;
import com.alexcode.vet.database.HumanRepositoryImpl;
import com.alexcode.vet.database.PetRepositoryImpl;
import com.alexcode.vet.database.repository.HumanJpaRepository;
import com.alexcode.vet.database.repository.PetJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VetConfiguration {

    private final HumanJpaRepository humanJpaRepository;
    private final PetJpaRepository petJpaRepository;

    public VetConfiguration(HumanJpaRepository humanJpaRepository,
                            PetJpaRepository petJpaRepository) {
        this.humanJpaRepository = humanJpaRepository;
        this.petJpaRepository = petJpaRepository;
    }

    @Bean
    public CreateHumanUseCase createHumanUseCase() {
        return new CreateHumanUseCaseImpl(new HumanRepositoryImpl(humanJpaRepository));
    }

    @Bean
    public CreatePetUseCase createPetUseCase() {
        return new CreatePetUseCaseImpl(
                new PetRepositoryImpl(petJpaRepository),
                new HumanRepositoryImpl(humanJpaRepository));
    }

    @Bean
    public ListPetUseCase listPetUseCase() {
        return new ListPetUseCaseImpl(new PetRepositoryImpl(petJpaRepository));
    }

}
