const form = document.querySelector('#form');
const userName = document.querySelector('#inputName');
const email = document.querySelector('#inputEmail');
const phoneNumber = document.querySelector('#inputphoneNumber');
const password = document.querySelector('#inputPassword');


form.addEventListener('submit',(event) => {
 
   if (!validate()) {
    event.preventDefault();
   } 

})

function validate(){
    const userNameVal = userName.value.trim();
    const emailVal = email.value.trim();
    const passwordVal = password.value.trim();
    const phoneNumberVal = phoneNumber.value.trim();
    let success = true;
    
    if (userNameVal==='') {
        setError(userName,'Username is required')
        success = false;
    }else if((userNameVal.length < 3) || (userNameVal.length > 25)){
        setError(userName,'Username must be between 3 and 25 Characters')
        success = false;
    }else if(!validateUsername(userNameVal)){
        setError(userName,'Username allows only alphanumeric characters and the underscore')
        success = false;
    }else if(!validateUsername1(userNameVal)){
        setError(userName,'Username mut be alphabhet')
        success = false;
    }else {
        setSuccess(userName)
    }

    if (emailVal==='') {
        setError(email,'Email is required')
        success = false;
    } else if (!validateEmail(emailVal)) {
        setError(email,'Please Enter Valid Email')
        success = false;
    }else{
        setSuccess(email)
    }

    if (passwordVal === '') {
        setError(password,'Password is required')
        success = false;
    } else if(passwordVal.length < 8){
        success = false;
        setError(password,'Password must be atleast 8 Character long')
    }else{
        setSuccess(password)
    }
    
     if (phoneNumberVal === '') {
        setError(phoneNumber,'Phone Number is required')
        success = false;
    } else if(!validatePhoneNumber(phoneNumberVal)){
        success = false;
        setError(phoneNumber,'Phone Number Not Valid')
    }else{
        setSuccess(phoneNumber)
    }
   return success;

}

function setError(element,message){
    const inputGroup = element.parentElement;
    const errorElement = inputGroup.querySelector('.error');

    errorElement.innerText = message;
    inputGroup.classList.add('error')
    inputGroup.classList.remove('success')
}

function setSuccess(element){
    const inputGroup = element.parentElement;
    const errorElement = inputGroup.querySelector('.error');

    errorElement.innerText = '';
    inputGroup.classList.add('success')
    inputGroup.classList.remove('error');
}

const validateEmail = (email) =>{
    return String(email)
    .toLowerCase()
    .match(
        /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
    );
}

const validateUsername = (userName) => {
    return String(userName)
    .match(
        /^[A-Za-z0-9_]+$/
    );
}

const validateUsername1 = (userName) => {
    return String(userName)
    .match(
        /^[A-Za-z][A-Za-z0-9]*(?:_+[A-Za-z0-9]+)*$/
    );
}

const validatePhoneNumber = (phoneNumber) => {
	return String(phoneNumber)
	.match(/^\d{10}$/);
}