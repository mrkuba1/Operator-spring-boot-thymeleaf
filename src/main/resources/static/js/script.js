function successfullyLogout(){
    alert("You have been successfully logged out");
}
function submitLogoutForm() {
    if (confirm('Are you sure you want to log out?')) {
        document.getElementById('logoutForm').submit();
    }
    return false;
}
