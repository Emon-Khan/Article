package com.emonkhan;

import com.emonkhan.dao.Dao;
import com.emonkhan.dao.EmployerDao;
import com.emonkhan.entity.Employer;

import java.util.Optional;

public class Main {
    private static Dao<Employer> employerDao; // Instance Variable

    public static void main(String[] args) {
        employerDao = new EmployerDao(); //upcasting
        // Get All Employee
        for (Employer employer : employerDao.getAll()) {
            System.out.println(employer);
        }
        // Get Employee by ID
        System.out.println(getEmployer(0));
        Employer employer1 = new Employer("Rois Uddin Khan Emon", 0);
        System.out.println(employer1);
        //Update an existing user
        employerDao.update(employer1);
        for (Employer employer : employerDao.getAll()) {
            System.out.println(employer);
        }
        //Create a new Employee
        Employer employer2 = new Employer("Will Jacks", 2);
        employerDao.save(employer2);
        for (Employer employer : employerDao.getAll()) {
            System.out.println(employer);
        }
        //Delete an Employee
        employerDao.delete(1);
        for (Employer employer : employerDao.getAll()) {
            System.out.println(employer);
        }
    }

    public static Employer getEmployer(int id) {
        Optional<Employer> anEmployer = employerDao.get(id);
        return anEmployer.orElseGet(
                () -> new Employer("Name doesn't exist", -564654));
    }
}
