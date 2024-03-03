package com.emonkhan;

import com.emonkhan.config.JpaEntityManagerFactory;
import com.emonkhan.dao.Dao;
import com.emonkhan.dao.JpaEmployerDao;
import com.emonkhan.entity.Employer;

import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Employer employer1 = getEmployer(1);
        System.out.println(employer1);
        updateEmployer(employer1, new String[]{"Arjun", "arjun@findme.com"});
        saveEmployer(new Employer("Rupok", "rupok@findme.com"));
        deleteEmployer(getEmployer(2));
        getAllEmployers().forEach(employer -> System.out.println(employer.getName()));
    }

    public static Dao<Employer> getJpaEmployerDao() {
        return JpaEmployerDaoHolder.jpaEmployerDao;
    }

    public static Employer getEmployer(int id) {
        Optional<Employer> anEmployer = getJpaEmployerDao().get(id);
        return anEmployer.orElseGet(
                () -> {
                    return new Employer("Name doesn't exist", "dummy@mail.com");
                });
    }

    public static List<Employer> getAllEmployers() {
        return getJpaEmployerDao().getAll();
    }

    public static void updateEmployer(Employer employer, String[] params) {
        getJpaEmployerDao().update(employer, params);
    }

    public static void saveEmployer(Employer employer) {
        getJpaEmployerDao().save(employer);
    }

    public static void deleteEmployer(Employer employer) {
        getJpaEmployerDao().delete(employer);
    }

    private static class JpaEmployerDaoHolder {
        private static final JpaEmployerDao jpaEmployerDao = new JpaEmployerDao(new JpaEntityManagerFactory().getEntityManager());
    }

}
