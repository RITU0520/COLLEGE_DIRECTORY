// Get the student name, email, department, and year from the HTML
let studentName = document.querySelector('p:nth-child(1)').innerText;
let studentEmail = document.querySelector('p:nth-child(2)').innerText;
let studentDepartment = document.querySelector('p:nth-child(3)').innerText;
let studentYear = document.querySelector('p:nth-child(4)').innerText;

// Function to search for students
function searchStudents() {
  let searchQuery = document.getElementById('studentSearch').value;
  document.getElementById('searchResults').innerHTML = `Searching for: ${searchQuery}`;
}

// Add event listener to the search button
document.querySelector('button').addEventListener('click', searchStudents);

// Function to toggle the dashboard container's class
function toggleDashboardClass() {
  document.querySelector('.dashboard-container').classList.toggle('responsive');
}

// Add event listener to the window resize event
window.addEventListener('resize', function() {
  if (window.innerWidth < 768) {
    toggleDashboardClass();
  } else {
    document.querySelector('.dashboard-container').classList.remove('responsive');
}
});
