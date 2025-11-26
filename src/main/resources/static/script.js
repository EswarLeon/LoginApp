

async function register() {
    let data = {
        email: document.getElementById("email").value,
        password: document.getElementById("password").value,
        confirmedpassword: document.getElementById("confirm").value
    };

    let res = await fetch("/page/register", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    });

    if (res.status === 200) {
            window.location.href = "/login.html";
        } else {
            document.getElementById("msg").innerText = await res.text();
        }
}

async function login() {
    let data = {
        email: document.getElementById("email").value,
        password: document.getElementById("password").value
    };

    let res = await fetch("/page/login", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data),
        credentials: "include"
    });

    if (res.status === 200) {
        window.location.href = "/home.html";
    } else {
        document.getElementById("msg").innerText = await res.text();
    }
}

function togglePassword() {
    let pass = document.getElementById("password");
    let confirm = document.getElementById("confirm");

    if (pass.type === "password") {
        pass.type = "text";
        confirm.type = "text";
        document.getElementById("eyeIcon").src = "eye-off.svg";
        document.getElementById("eyeIcon2").src = "eye-off.svg";
    } else {
        pass.type = "password";
        confirm.type = "password";
        document.getElementById("eyeIcon").src = "eye.svg";
        document.getElementById("eyeIcon2").src = "eye.svg";
    }
}




