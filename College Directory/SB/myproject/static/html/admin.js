// Function to manage student and faculty records
function manageRecords() {
    document.getElementById('content').innerHTML = `
      <h2>Manage Student and Faculty Records</h2>
      <button onclick="addRecord()">Add Record</button>
      <button onclick="deleteRecord()">Delete Record</button>
      <button onclick="updateRecord()">Update Record</button>
    `;
  }
  
  // Function to view dashboard with graphs
  function viewDashboard() {
    document.getElementById('content').innerHTML = `
      <h2>Dashboard with Graphs</h2>
      <canvas id="chart"></canvas>
    `;
    // Add chart.js code to render charts
  }
  
  // Function to add record
  function addRecord() {
    // Add code to add record to database
    alert('Record added successfully!');
  }
  
  // Function to delete record
  function deleteRecord() {
    // Add code to delete record from database
    alert('Record deleted successfully!');
  }
  
  // Function to update record
  function updateRecord() {
    // Add code to update record in database
    alert('Record updated successfully!');
  }
  
  
  