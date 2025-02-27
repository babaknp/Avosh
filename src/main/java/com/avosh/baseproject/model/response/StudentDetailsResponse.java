package com.avosh.baseproject.model.response;

import com.avosh.baseproject.model.Student;
import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "StudentDetailsResponse",namespace = "http://www.avosh.com/xml/definitions")
public class StudentDetailsResponse {

    @XmlElement(name = "Student", required = true)
    protected Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student value) {
        this.student = value;
    }

}
