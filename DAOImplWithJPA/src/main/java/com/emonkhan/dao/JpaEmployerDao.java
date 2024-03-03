package com.emonkhan.dao;

import com.emonkhan.entity.Employer;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;

public class JpaEmployerDao implements Dao<Employer> {

    private EntityManager entityManager;

    public JpaEmployerDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Employer> get(int id) {
        return Optional.ofNullable(entityManager.find(Employer.class, id));
    }

    @Override
    public List<Employer> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Employer e");
        return query.getResultList();
    }

    @Override
    public void save(Employer employer) {
        executeInsideTransaction(entityManager -> entityManager.persist(employer));
    }

    @Override
    public void update(Employer employer, String[] params) {
        employer.setName(Objects.requireNonNull(params[0], "Name can't be null"));
        employer.setEmail(Objects.requireNonNull(params[1], "Mail can't be null"));
        executeInsideTransaction(entityManager -> entityManager.merge(employer));
    }

    @Override
    public void delete(Employer employer) {
        executeInsideTransaction(entityManager -> entityManager.remove(employer));
    }

    private void executeInsideTransaction(Consumer<EntityManager> action) {
        EntityTransaction tx = entityManager.getTransaction();
        try {
            tx.begin();
            action.accept(entityManager);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
    }
}
