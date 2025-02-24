const BASE_URL = "http://localhost:8080/api/users";

function addUser() {
    const name = document.getElementById("name").value;
    const email = document.getElementById("email").value;
	const mobileNumber = document.getElementById("mobileNumber").value;
    const password = document.getElementById("password").value;     
	 const validatePassword = document.getElementById("validatePassword").value;


    fetch(`${BASE_URL}/add`, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, email, mobileNumber, password, validatePassword })
    })
    .then(response => {
        if (!response.ok) {
            throw new Error("Server error: " + response.status);
        }
        return response.json();
    })
    .then(data => {
        alert("User added successfully!");
        window.location.href = "get-users.html"; // Redirect to user list
    })
    .catch(error => {
        console.error("Error:", error);
        alert("An error occurred: " + error.message);
    });
}

function fetchUsers() {
    fetch(BASE_URL)
    .then(response => response.json())
    .then(users => {
        const userList = document.getElementById("userList");
        userList.innerHTML = "";

        Object.keys(users).forEach(key => {
            const user = users[key];
            const li = document.createElement("li");
            li.textContent = `Name: ${user.name}, Email: ${user.email}`;
            userList.appendChild(li);
        });
    })
    .catch(error => {
        console.error("Error fetching users:", error);
        alert("An error occurred while fetching users: " + error.message);
    });
}
