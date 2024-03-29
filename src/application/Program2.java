package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Program2 {

    public static void main(String [] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== TEST 1: findById =======");
        Department dep = departmentDao.findById(1);
        System.out.println();
        System.out.println(dep);

        System.out.println("\n=== TEST 2: findAll =======");
        List<Department> list = departmentDao.findAll();
        System.out.println();
        for (Department d : list) {
            System.out.println(d);
        }

        System.out.println("\n=== TEST 3: insert department =======");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println();
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n===TEST 4: department update ===");
        dep = departmentDao.findById(5);
        dep.setName("Games");
        departmentDao.update(dep);
        System.out.println();
        System.out.println("Update completed: " + dep.getName());

        System.out.println("\n===TEST 5: department delete ===");
        System.out.println();
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed!");

        sc.close();
    }
}
