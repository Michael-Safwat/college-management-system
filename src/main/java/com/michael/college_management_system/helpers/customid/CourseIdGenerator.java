package com.michael.college_management_system.helpers.customid;

import com.michael.college_management_system.model.Department;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
public class CourseIdGenerator implements IdentifierGenerator {

    private Department department;

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        return "COURSE-" + UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }
}
