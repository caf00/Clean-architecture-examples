package com.alexcode.vet.database;

import com.alexcode.vet.core.Pagination;
import com.alexcode.vet.core.domain.PetRepository;
import com.alexcode.vet.core.domain.entity.Human;
import com.alexcode.vet.core.domain.entity.Pet;
import com.alexcode.vet.database.model.HumanDb;
import com.alexcode.vet.database.model.PetDb;
import com.alexcode.vet.database.repository.PetJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;
import java.util.stream.Collectors;

public class PetRepositoryImpl implements PetRepository {

    private final PetJpaRepository petJpaRepository;

    public PetRepositoryImpl(PetJpaRepository petJpaRepository) {
        this.petJpaRepository = petJpaRepository;
    }


    @Override
    public Pagination<Pet> findAll(Integer page, Integer size) {
        Page<PetDb> petDbPage = petJpaRepository.findAll(PageRequest.of(page, size));
        return Pagination.create(
                petDbPage.get().map(p->Pet.createWithId(
                        p.getPetId(),
                        p.getName(),
                        p.getAge(),
                        p.getColor(),
                        Human.createWithId(
                                p.getHuman().getHumanId(),
                                p.getHuman().getFullName(),
                                p.getHuman().getAddress(),
                                p.getHuman().getPhoneNumber()
                        )
                )).collect(Collectors.toList()),
                petDbPage.getNumber(),
                petDbPage.getTotalPages(),
                petDbPage.hasNext(),
                petDbPage.hasPrevious()
        );
    }

    @Override
    public Optional<Pet> findById(Integer id) {
        return petJpaRepository.findById(id)
                .map(p->Pet.createWithId(
                        p.getPetId(),
                        p.getName(),
                        p.getAge(),
                        p.getColor(),
                        Human.createWithId(
                                p.getHuman().getHumanId(),
                                p.getHuman().getFullName(),
                                p.getHuman().getAddress(),
                                p.getHuman().getPhoneNumber()
                        )
                ));
    }

    @Override
    public void save(Pet pet) {
        petJpaRepository.save(PetDb.createWithOutId(
                pet.getName(),
                pet.getAge(),
                pet.getColor(),
                HumanDb.createWithId(
                        pet.getHuman().getHumanId(),
                        pet.getHuman().getFullName(),
                        pet.getHuman().getAddress(),
                        pet.getHuman().getPhoneNumber()
                )
        ));
    }

    @Override
    public void update(Pet pet) {

    }
}
