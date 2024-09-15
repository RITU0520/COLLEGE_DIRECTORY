document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault(); // Prevent form from refreshing the page

    // Get form values
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const role = document.getElementById('role').value;

    // A basic username/password check (for demo purposes)
    if (username === 'student' && password === '1234' && role === 'student') {
        window.location.href = 'Student.html'; // Redirect to Student Dashboard
    } else if (username === 'faculty' && password === '1234' && role === 'faculty') {
        window.location.href = 'faculty.html'; // Redirect to Faculty Dashboard
    } else if (username === 'admin' && password === '1234' && role === 'admin') {
        window.location.href = 'dashboard.html'; // Redirect to Admin Dashboard
    } else {
        document.getElementById('error').innerText = 'Invalid credentials!'; // Show error message
    }
});
