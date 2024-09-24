// Get HTML elements
const studentList = document.getElementById('student-list');
const addStudentBtn = document.getElementById('add-student-btn');
const updateSBtn = document.getElementById('updateS-btn');
const deleteSBtn = document.getElementById('deleteS-btn');
const updateProfileBtn = document.getElementById('updateProfileBtn');
const logoutBtn = document.getElementById('logout-btn');
const facultyNameSpan = document.getElementById('facultyName');

// Sample data
let students = [
  { id: 1, name: 'Ram', email: 'ram@example.com', department: 'Computer Science' },
  { id: 2, name: 'Riya', email: 'riya@example.com', department: 'Mathematics' },
];

// Display faculty name (for example purpose)
facultyNameSpan.innerText = 'Professor Ajay'; // Replace with dynamic value if needed

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

// Add event listeners to buttons
addStudentBtn.addEventListener('click', () => {
  const newName = prompt('Enter new student name:');
  const newEmail = prompt('Enter new student email:');
  const newDepartment = prompt('Enter new student department:');
  if (newName && newEmail && newDepartment) {
    createStudent(newName, newEmail, newDepartment);
  }
});

updateSBtn.addEventListener('click', () => {
  const studentId = prompt('Enter student ID to update:');
  const newName = prompt('Enter new student name:');
  const newEmail = prompt('Enter new student email:');
  const newDepartment = prompt('Enter new student department:');
  if (studentId && newName && newEmail && newDepartment) {
    updateStudent(studentId, newName, newEmail, newDepartment);
  }
});

deleteSBtn.addEventListener('click', () => {
  const studentId = prompt('Enter student ID to delete:');
  if (studentId) {
    deleteStudent(studentId);
  }
});

// Update profile
updateProfileBtn.addEventListener('click', () => {
  const email = document.getElementById('email').value;
  const officeHours = document.getElementById('officeHours').value;
  if (email && officeHours) {
    // Code to update faculty profile in the database or perform other actions
    alert('Your profile is updated successfully!');
  } else {
    alert('Please fill out all fields.');
  }
});

// Logout functionality
logoutBtn.addEventListener('click', () => {
  window.location.href = 'login.html'; // Redirect to the login page
});

// Initialize student list
showStudents();
