package com.example.baitap.test;



import static org.junit.jupiter.api.Assertions.*;

import com.example.baitap.Service.EmployeeService;
import com.example.baitap.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeServiceTest {
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeService = new EmployeeService();
    }

    @Test
    void testAddEmployee() {
        Employee emp = new Employee(1, "John", "Doe", "john.doe@example.com");
        assertTrue(employeeService.addEmployee(emp));
        assertNotNull(employeeService.findEmployeeById(1));
    }

    @Test
    void testUpdateEmployee() {
        Employee emp = new Employee(1, "John", "Doe", "john.doe@example.com");
        employeeService.addEmployee(emp);

        assertTrue(employeeService.updateEmployee(1, "Jane", "Smith", "jane.smith@example.com"));
        assertEquals("Jane", employeeService.findEmployeeById(1).getFirstName());
    }

    @Test
    void testUpdateEmployee_NotFound() {
        assertFalse(employeeService.updateEmployee(2, "Alice", "Brown", "alice.brown@example.com"));
    }

    @Test
    void testDeleteEmployee() {
        Employee emp = new Employee(1, "John", "Doe", "john.doe@example.com");
        employeeService.addEmployee(emp);

        assertTrue(employeeService.deleteEmployee(1));
        assertNull(employeeService.findEmployeeById(1));
    }

    @Test
    void testDeleteEmployee_NotFound() {
        assertFalse(employeeService.deleteEmployee(2));
    }

    @Test
    void testFindEmployeeById_Exists() {
        Employee emp = new Employee(1, "John", "Doe", "john.doe@example.com");
        employeeService.addEmployee(emp);

        assertNotNull(employeeService.findEmployeeById(1));
        assertEquals("John", employeeService.findEmployeeById(1).getFirstName());
    }

    @Test
    void testFindEmployeeById_NotFound() {
        assertNull(employeeService.findEmployeeById(100));
    }

    @Test
    void testAddMultipleEmployees() {
        Employee e1 = new Employee(1, "John", "Doe", "john.doe@example.com");
        Employee e2 = new Employee(2, "Alice", "Brown", "alice.brown@example.com");

        assertTrue(employeeService.addEmployee(e1));
        assertTrue(employeeService.addEmployee(e2));
        assertEquals(2, employeeService.getAllEmployees().size());
    }

    @Test
    void testUpdateEmployee_KeepSameValues() {
        Employee emp = new Employee(1, "John", "Doe", "john.doe@example.com");
        employeeService.addEmployee(emp);

        assertTrue(employeeService.updateEmployee(1, "John", "Doe", "john.doe@example.com"));
    }

    @Test
    void testDeleteAllEmployees() {
        employeeService.addEmployee(new Employee(1, "John", "Doe", "john.doe@example.com"));
        employeeService.addEmployee(new Employee(2, "Alice", "Brown", "alice.brown@example.com"));

        assertTrue(employeeService.deleteEmployee(1));
        assertTrue(employeeService.deleteEmployee(2));
        assertEquals(0, employeeService.getAllEmployees().size());
    }
}

