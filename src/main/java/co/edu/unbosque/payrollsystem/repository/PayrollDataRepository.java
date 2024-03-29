package co.edu.unbosque.payrollsystem.repository;

import co.edu.unbosque.payrollsystem.model.PayrollData;
import co.edu.unbosque.payrollsystem.repository.jpa.PayrollDataJpa;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Data
@Repository(value = "payrollDataRepository")
public class PayrollDataRepository {

    @Autowired
    private PayrollDataJpa payrollDataJpa;

    public Optional<PayrollData> save(PayrollData payrollData) {
        return Optional.of(payrollDataJpa.save(payrollData));
    }

    public Optional<List<PayrollData>> findByPayrollId(Integer payrollId) {
        return Optional.ofNullable(payrollDataJpa.findByPayrollId(payrollId));
    }

    public Float getAvgSalary() {
        return payrollDataJpa.avgSalary();
    }

}
