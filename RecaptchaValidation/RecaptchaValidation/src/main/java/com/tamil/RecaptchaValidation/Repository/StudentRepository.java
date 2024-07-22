package com.tamil.RecaptchaValidation.Repository;

import com.tamil.RecaptchaValidation.Model.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.Id;
@Repository
public interface StudentRepository extends JpaRepository<StudentEntity,Integer> {
//    void save(StudentEntity student);
}
