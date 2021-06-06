function validate(){
    var login = document.getElementById("login-field");
    var password = document.getElementById("password-field");

    var flag = true;

    if(login.value.length < 3) {
        login.style.background = "#cedaf5";
    } else {
        login.style.background = "#ffffff";
    }

    if(password.value.length < 3) {
        password.style.background = "#cedaf5";
        flag = false;
    } else {
        password.style.background = "#ffffff";
    }

    return flag;
}