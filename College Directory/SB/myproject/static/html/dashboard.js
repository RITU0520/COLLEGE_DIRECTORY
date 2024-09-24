// Get HTML elements
const studentList = document.getElementById('student-list');
const facultyList = document.getElementById('faculty-list');
const addStudentBtn = document.getElementById('addS-student-btn');
const updateSBtn = document.getElementById('updateS-btn');
const deleteSBtn = document.getElementById('deleteS-btn');
const addFacultyBtn = document.getElementById('add-faculty-btn');
const updateFBtn = document.getElementById('updateF-btn');
const deleteFBtn = document.getElementById('deleteF-btn');
const logoutBtn = document.getElementById('logout-btn');

// Sample data
let students = [
  { id: 1, name: 'Ram', email: 'ram@example.com', department: 'Computer Science' },
  { id: 2, name: 'Riya', email: 'riya@example.com', department: 'Mathematics' },
];

let faculty = [
  { id: 1, name: 'Professor Ajay', email: 'prof.ajay@example.com', department: 'Computer Science' },
  { id: 2, name: 'Professor Anisha', email: 'prof.anisha@example.com', department: 'Mathematics' },
];

// CRUD operations for students
function createStudent(newName, newEmail, newDepartment) {
  const newId = students.length ? students[students.length - 1].id + 1 : 1;
  students.push({ id: newId, name: newName, email: newEmail, department: newDepartment });
  showStudents();
}

function updateStudent(studentId, newName, newEmail, newDepartment) {
  const student = students.find((student) => student.id == studentId);
  if (student) {
    student.name = newName;
    student.email = newEmail;
    student.department = newDepartment;
  }
  showStudents();
}

function deleteStudent(studentId) {
  const index = students.findIndex((student) => student.id == studentId);
  if (index !== -1) {
    students.splice(index, 1);
  }
  showStudents();
}

// CRUD operations for faculty
function createFaculty(newName, newEmail, newDepartment) {
  const newId = faculty.length ? faculty[faculty.length - 1].id + 1 : 1;
  faculty.push({ id: newId, name: newName, email: newEmail, department: newDepartment });
  showFaculty();
}

function updateFaculty(facultyId, newName, newEmail, newDepartment) {
  const fac = faculty.find((fac) => fac.id == facultyId);
  if (fac) {
    fac.name = newName;
    fac.email = newEmail;
    fac.department = newDepartment;
  }
  showFaculty();
}

function deleteFaculty(facultyId) {
  const index = faculty.findIndex((fac) => fac.id == facultyId);
  if (index !== -1) {
    faculty.splice(index, 1);
  }
  showFaculty();
}

// Show student list
function showStudents() {
  studentList.innerHTML = '';
  students.forEach((student) => {
    const row = document.createElement('tr');
    row.innerHTML = `
      <td>${student.id}</td>
      <td>${student.name}</td>
      <td>${student.email}</td>
      <td>${student.department}</td>
    `;
    studentList.appendChild(row);
  });
}

// Show faculty list
function showFaculty() {
  facultyList.innerHTML = '';
  faculty.forEach((fac) => {
    const row = document.createElement('tr');
    row.innerHTML = `
      <td>${fac.id}</td>
      <td>${fac.name}</td>
      <td>${fac.email}</td>
      <td>${fac.department}</td>
    `;
    facultyList.appendChild(row);
  });
}

// Add event listeners to buttons
addStudentBtn.addEventListener('click', () => {
  const newName = prompt('Enter new student name:');
  const newEmail = prompt('Enter new student email:');
  const newDepartment = prompt('Enter new student department:');
  createStudent(newName, newEmail, newDepartment);
});

updateSBtn.addEventListener('click', () => {
  const studentId = prompt('Enter student ID to update:');
  const newName = prompt('Enter new student name:');
  const newEmail = prompt('Enter new student email:');
  const newDepartment = prompt('Enter new student department:');
  updateStudent(studentId, newName, newEmail, newDepartment);
});

deleteSBtn.addEventListener('click', () => {
  const studentId = prompt('Enter student ID to delete:');
  deleteStudent(studentId);
});

addFacultyBtn.addEventListener('click', () => {
  const newName = prompt('Enter new faculty name:');
  const newEmail = prompt('Enter new faculty email:');
  const newDepartment = prompt('Enter new faculty department:');
  createFaculty(newName, newEmail, newDepartment);
});

updateFBtn.addEventListener('click', () => {
  const facultyId = prompt('Enter faculty ID to update:');
  const newName = prompt('Enter new faculty name:');
  const newEmail = prompt('Enter new faculty email:');
  const newDepartment = prompt('Enter new faculty department:');
  updateFaculty(facultyId, newName, newEmail, newDepartment);
});

deleteFBtn.addEventListener('click', () => {
  const facultyId = prompt('Enter faculty ID to delete:');
  deleteFaculty(facultyId);
});

// Logout functionality
logoutBtn.addEventListener('click', () => {
  window.location.href = 'login.html';
});

// Initialize student and faculty lists
showStudents();
showFaculty();
