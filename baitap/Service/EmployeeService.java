package com.example.baitap.Service;



import com.example.baitap.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();

    // Thêm nhân viên
    public boolean addEmployee(Employee employee) {
        return employees.add(employee);
    }

    // Sửa thông tin nhân viên
    public boolean updateEmployee(int id, String firstName, String lastName, String email) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setFirstName(firstName);
                emp.setLastName(lastName);
                emp.setEmail(email);
                return true;
            }
        }
        return false;
    }

    // Xóa nhân viên
    public boolean deleteEmployee(int id) {
        return employees.removeIf(emp -> emp.getId() == id);
    }

    // Tìm nhân viên theo Id
    public Employee findEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                return emp;
            }
        }
        return null;
    }

    // Lấy danh sách nhân viên
    public List<Employee> getAllEmployees() {
        return employees;
    }
}
