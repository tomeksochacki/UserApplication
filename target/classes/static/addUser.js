function validate(){
    var name = document.getElementById("name-input");
    var surname = document.getElementById("surname-input");
    var age = document.getElementById("age-input");
    var phoneNumber = document.getElementById("phoneNumber-input");
    var role = document.getElementById("role-input");

    var flag = true;

    if(name.value == ""){
        name.style.background = "#cedaf5";
        flag = false;
    } else {
        name.style.background = "#ffffff";
    }

    if(surname.value == ""){
        surname.style.background = "#cedaf5";
        flag = false;
    } else {
        name.style.background = "#ffffff";
    }

    if(age.value == ""){
        age.style.background = "#cedaf5";
        flag = false
    } else {
        name.style.background = "#ffffff";
    }

    if(phoneNumber.value == ""){
        phoneNumber.style.background = "#cedaf5";
        flag = false;
    } else {
        name.style.background = "#ffffff";
    }

    if(role.value == ""){
        role.style.background = "#cedaf5";
        flag = false;
    } else {
        name.style.background = "#ffffff";
    }

    return flag;
}