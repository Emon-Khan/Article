package com.emonkhan.dao;

import com.emonkhan.entity.Employer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class EmployerDao implements Dao<Employer>{
    private List<Employer> employers = new ArrayList<>();
    public EmployerDao(){
        employers.add(new Employer("Emon Khan", "rkemon94@gmail.com"));
        employers.add(new Employer("Asfack Uddin", "asfackuddin@gmail.com"));
    }

    @Override
    public List<Employer> getAll() {
        return employers;
    }

    @Override
    public Optional<Employer> get(int id) {
        return Optional.ofNullable(employers.get((int) id));
    }

    @Override
    public void save(Employer employer) {
        employers.add(employer);
    }

    @Override
    public void update(Employer employer, String[] params) {
        employer.setName(Objects.requireNonNull(params[0], "Name can't be null"));
        employer.setEmail(Objects.requireNonNull(params[1], "Mail can't be null"));
        employers.add(employer);
    }

    @Override
    public void delete(Employer employer) {
        employers.remove(employer);
    }
}