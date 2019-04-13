package com.webserver;

import com.db.daoJdbc.DisciplineDAO;
import com.db.daoJdbc.EnrollmentDAO;
import com.db.daoJdbc.StudentDAO;
import com.db.daoJdbc.impl.DisciplineDAOImpl;
import com.db.daoJdbc.impl.EnrollmentDAOImpl;
import com.db.daoJdbc.impl.StudentDAOImpl;
import com.db.model.Discipline;
import com.db.model.Enrollment;
import com.db.model.Student;

import java.io.UnsupportedEncodingException;
import java.util.List;

public class StudentInfoImpl implements HttpServlet {

    @Override
    public HttpResponse doPost(HttpRequest request, HttpResponse response) throws UnsupportedEncodingException {

        String postContent = request.getRequest().substring(request.getRequest().indexOf("\r\n\r\n") + 4);
        StudentDAO studentDAO = new StudentDAOImpl();
        DisciplineDAO disciplineDAO = new DisciplineDAOImpl();
        EnrollmentDAO enrollmentDAO = new EnrollmentDAOImpl();
        String studName = postContent.substring(5).replace("+"," ").trim();
        String responseText = "";
        responseText += CurrentStudPattern.header(studName);
        Student student = studentDAO.getByName(studName);
        if (student != null) {
            List<Enrollment> enrollmentList = enrollmentDAO.getByStudentId(student.getId());

            for (Enrollment enrollment : enrollmentList) {
                Discipline discipline = disciplineDAO.get(enrollment.getDisc_id());
                responseText += CurrentStudPattern.studentInfo(discipline.getName(), String.valueOf(enrollment.getGrade()));
            }
        }

        responseText += CurrentStudPattern.footer();

        response.setResponse(responseText);
        return response;
    }

    @Override
    public HttpResponse doGet(HttpRequest request, HttpResponse response) {

        StudentDAO studentDAO = new StudentDAOImpl();
        String responseText = "";
        List<Student> studentList = studentDAO.getAllStudents();

        responseText += AllStudPattern.header();

        for (Student student : studentList) {
            responseText += AllStudPattern.studentInfo(student.getFio(), String.valueOf(student.getCourse()));
        }

        responseText += AllStudPattern.footer();

        response.setResponse(responseText);
        return response;
    }
}
