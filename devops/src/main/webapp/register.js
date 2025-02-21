document.getElementById("registerForm").addEventListener("submit", function(event) {
    event.preventDefault();

    let name = document.getElementById("name").value.trim();
    let email = document.getElementById("email").value.trim();
    let mobile = document.getElementById("mobile").value.trim();
    let password = document.getElementById("password").value.trim();

    // Validate mobile number
    let mobileRegex = /^[0-9]{10}$/;
    if (!mobileRegex.test(mobile)) {
        alert("Please enter a valid 10-digit mobile number.");
        return;
    }

    // Validate password length
    if (password.length < 6) {
        alert("Password must be at least 6 characters long.");
        return;
    }

    alert(" Registration successful!");
});
