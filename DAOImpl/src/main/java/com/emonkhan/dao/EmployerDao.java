package com.emonkhan.dao;

import com.emonkhan.entity.Employer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployerDao implements Dao<Employer>{
    private List<Employer> employers = new ArrayList<>();
    public EmployerDao(){
        employers.add(new Employer("Emon Khan", 0));
        employers.add(new Employer("Asfack Uddin", 1));
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
    public void update(Employer employer) {
        employers.get(employer.getEmployerId())
                .setName(employer.getName());
    }

    @Override
    public void delete(int id) {
        Employer employer = employers.get(id);
        employers.remove(employer);
    }
}