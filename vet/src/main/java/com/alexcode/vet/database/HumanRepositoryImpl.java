package com.alexcode.vet.database;

import com.alexcode.vet.core.Pagination;
import com.alexcode.vet.core.domain.HumanRepository;
import com.alexcode.vet.core.domain.entity.Human;
import com.alexcode.vet.database.model.HumanDb;
import com.alexcode.vet.database.repository.HumanJpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;
import java.util.stream.Collectors;

public class HumanRepositoryImpl implements HumanRepository {

    private final HumanJpaRepository humanJpaRepository;

    public HumanRepositoryImpl(HumanJpaRepository humanJpaRepository) {
        this.humanJpaRepository = humanJpaRepository;
    }

    @Override
    public Pagination<Human> findAll(Integer page, Integer size) {
        Page<HumanDb> humanDbPage = humanJpaRepository.findAll(PageRequest.of(page, size));
        return Pagination.create(
                humanDbPage.get().map(h->Human.createWithId(
                        h.getHumanId(),
                        h.getFullName(),
                        h.getAddress(),
                        h.getPhoneNumber()
                )).collect(Collectors.toList()),
                humanDbPage.getNumber(),
                humanDbPage.getTotalPages(),
                humanDbPage.hasNext(),
                humanDbPage.hasPrevious()
        );
    }

    @Override
    public Optional<Human> findById(Integer id) {
        return humanJpaRepository.findById(id).map(h->Human.createWithId(
                h.getHumanId(),
                h.getFullName(),
                h.getAddress(),
                h.getPhoneNumber()
        ));
    }

    @Override
    public void save(Human human) {
        humanJpaRepository.save(HumanDb.createWithOutId(
                human.getFullName(),
                human.getAddress(),
                human.getPhoneNumber()
        ));
    }

    @Override
    public void update(Human human) {

    }
}
