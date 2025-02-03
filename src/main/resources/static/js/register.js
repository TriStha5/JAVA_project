var nameError = document.getElementById('name-error');
var emailError = document.getElementById('email-error');
var phoneError = document.getElementById('phone-error');
var localError = document.getElementById('location-error');
var passError = document.getElementById('password-error');
var confError = document.getElementById('confirm-error');
var submitError = document.getElementById('submit-error');
function validateName(){
    var name = document.getElementById('name').value;

    if(name.length == null){
        nameError.innerHTML = 'User name is required';
        return false;
    }
    // if(!name.match(/^[A-Za-z]\._\-[0-9]*$/)){
    if(name.length < 3){
        nameError.innerHTML = 'At least 3 character needed';
        return false;
    }
    if(name.length > 10){
        nameError.innerHTML = 'below 10 character needed';
        return false;
    }
    nameError.innerHTML = '<i class="fa-sharp fa-solid fa-circle-check"></i>';
    return true;
}
function validateEmail(){
    var email = document.getElementById('email').value;
    if(email.length == null){
        emailError.innerHTML = 'Email is required';
        return false;
    }
    if(!email.match(/^[A-Za-z\._\-[0-9]*[@][A-Za-z]*[\.][a-z]{2,4}$/)){
        emailError.innerHTML = 'Email is Invalid';
        return false;
    }
    emailError.innerHTML = '<i class="fa-sharp fa-solid fa-circle-check"></i>';
    return true;
}
function validatePass(){
    var pass = document.getElementById('pass').value;
    if(pass.length == null){
        passError.innerHTML = 'Password is required';
        return false;
    }
    if(pass.length < 8){
        passError.innerHTML = 'Minimum 8 characters';
        return false;
    }
    if(pass.length > 15){
        passError.innerHTML = 'Maximum 15 characters';
        return false;
    }
    if(!pass.match(/^(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{8,15}$/)){
        passError.innerHTML = 'Password must have special character';
        return false;
    }
    if(!pass.match(/^(?=.*[A-Z])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{8,15}$/)){
        passError.innerHTML = 'Password must have uppercase';
        return false;
    }
    if(!pass.match(/^(?=.*[0-9])(?=.*[A-Z])(?=.*[!@#$%^&*])[A-Za-z0-9!@#$%^&*]{8,15}$/)){
        passError.innerHTML = 'Password must have number';
        return false;
    }
    passError.innerHTML = '<i class="fa-sharp fa-solid fa-circle-check"></i>';
    return true;
}
function validateLocation(){
    var local = document.getElementById('location').value;

    if(local.length == null){
        localError.innerHTML = 'Location is required';
        return false;
    }
    if(!local.match(/^[A-Z][a-z]+$/)){
        localError.innerHTML = 'Invalid input';
        return false;
    }
    localError.innerHTML = '<i class="fa-sharp fa-solid fa-circle-check"></i>';
    return true;
}
function validateConf(){
    var conf = document.getElementById('conf').value;
    if(!conf.match(pass.value)){
        confError.innerHTML = 'Password must match';
        return false;
    }
    confError.innerHTML = '<i class="fa-sharp fa-solid fa-circle-check"></i>';
    return true;
}
function validatePhone(){
    var phone = document.getElementById('phone').value;
    if(phone.length == null){
        phoneError.innerHTML = 'Phone number is required';
        return false;
    }
    if(!phone.match(/^[0-9]{10}$/)){
        phoneError.innerHTML = 'Only numbers';
        return false;
    }
    if(phone.length !== 10){
        phoneError.innerHTML = 'Number should be 10 digit';
        return false;
    }

    phoneError.innerHTML = '<i class="fa-sharp fa-solid fa-circle-check"></i>';
    return true;
}
function validateForm(){
    if(!validateName() || !validateEmail() || !validatePass() || !validateConf() || !validatePhone() || !validateLocation()){
        submitError.style.display = 'block';
        submitError.innerHTML = 'Solve error to SignUp';
        setTimeout(function(){submitError.style.display = 'none';}, 3000);
        return false;
    }else{
        alert("Registered successfully");
        return true;
    }
}