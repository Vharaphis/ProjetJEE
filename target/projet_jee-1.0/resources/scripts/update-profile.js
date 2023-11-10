const newPassword = document.getElementById("newPassword");
const confirmPassword = document.getElementById("confirmPassword");

function validatePassword(){
    if(newPassword.value !== confirmPassword.value) {
        confirmPassword.setCustomValidity("Passwords Don't Match");
    } else {
        confirmPassword.setCustomValidity('');
    }
}

newPassword.onchange = validatePassword;
confirmPassword.onkeyup = validatePassword;