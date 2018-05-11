package hu.unideb.inf.notebookservice.service.test;

import hu.unideb.inf.notebookservice.persistence.entity.EmployeeEntity;
import hu.unideb.inf.notebookservice.persistence.repository.EmployeeRepository;
import hu.unideb.inf.notebookservice.service.domain.Employee;
import hu.unideb.inf.notebookservice.service.domain.Maintenance;
import hu.unideb.inf.notebookservice.service.impl.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Spy
    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private static EmployeeEntity employeeA;

    private static EmployeeEntity employeeB;

    @BeforeClass
    public static void setUpClass() {

        EmployeeEntity testEmployeeA = new EmployeeEntity();
        testEmployeeA.setId(1L);
        testEmployeeA.setUsername("EmployeeA");
        testEmployeeA.setPassword("PasswordA");

        employeeA = testEmployeeA;

        EmployeeEntity testEmployeeB = new EmployeeEntity();
        testEmployeeB.setId(2L);
        testEmployeeB.setUsername("EmployeeB");
        testEmployeeB.setPassword("PasswordB");

        employeeB = testEmployeeB;
    }

    @Before
    public void initMock() {
        MockitoAnnotations.initMocks(this);

        Mockito.when(employeeRepository.save(Mockito.any(EmployeeEntity.class)))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if (((EmployeeEntity) args[0]).getId() == null) {
                        ((EmployeeEntity) args[0]).setId(91L);
                    }
                    return args[0];
                });

        Mockito.when(employeeRepository.findByUsername(Mockito.anyString()))
                .thenAnswer(invocation -> {
                    Object[] args = invocation.getArguments();
                    if((args[0]).equals(employeeA.getUsername()))
                        return employeeA;
                    else if((args[0]).equals(employeeB.getUsername()))
                        return employeeB;
                    else
                        return null;
                    }
                );
    }

    @Test
    public void addEmployeeTest() {
        Assert.assertNotNull(employeeRepository);

        Employee newEmployee = new Employee();
        newEmployee.setUsername("EmployeeTest");
        newEmployee.setPassword("PasswordTest");
        newEmployee.setMaintenances(Collections.singletonList(new Maintenance()));

        Employee saveEmployee = employeeService.addEmployee(newEmployee);

        Assert.assertNotNull(saveEmployee);
        Assert.assertNotNull(saveEmployee.getUsername());
        Assert.assertNotNull(saveEmployee.getPassword());
        Assert.assertNull(saveEmployee.getMaintenances());
    }

    @Test
    public void findByUsernameTest() {
        Assert.assertNotNull(employeeRepository);
        EmployeeEntity testEmployee = employeeRepository.findByUsername("EmployeeA");

        Assert.assertNotNull(testEmployee);
        Assert.assertNotNull(testEmployee.getUsername());
        Assert.assertNotNull(testEmployee.getPassword());
        Assert.assertEquals("EmployeeA",employeeA.getUsername());
        Assert.assertNotEquals("EmployeeB", employeeA.getUsername());
        Assert.assertNull(testEmployee.getService());
    }
}
