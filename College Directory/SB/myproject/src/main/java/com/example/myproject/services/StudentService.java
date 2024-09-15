package com.example.myproject.services;

@Service
public class StudentService {
    
    @Autowired
    private StudentRepository studentRepository;
    
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public Student updateStudent(Long id, Student student) {
        Student existingStudent = getStudentById(id);
        if (existingStudent != null) {
            existingStudent.setName(student.getName());
            existingStudent.setDepartment(student.getDepartment());
            // Update other fields as needed
            return studentRepository.save(existingStudent);
        }
        return null;
    }
    
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
