const form = document.querySelector('#form');
const address = document.querySelector('#inputAddress');
const landmark = document.querySelector('#inputLandmark');
const city = document.querySelector('#inputCity');
const state = document.querySelector('#inputState');
const pincode = document.querySelector('#inputPincode');

form.addEventListener('submit',(event) => {
 
   if (!validate()) {
    event.preventDefault();
   } 

})

function validate(){
    const addressVal = address.value.trim();
    const landmarkVal = landmark.value.trim();
    const cityVal = city.value.trim();
    const stateVal = state.value.trim();
    const pincodeVal = pincode.value.trim();
    let success = true;
    
    if (addressVal==='') {
        setError(address,'Address is required')
        success = false;
    }else {
        setSuccess(address)
    }

    if (landmarkVal==='') {
        setError(landmark,'Landmark is required')
        success = false;
    }else{
        setSuccess(landmark)
    }

    if (cityVal === '') {
        setError(city,'city is required')
        success = false;
    
    }else{
        setSuccess(city)
    }
    
     if (stateVal === '') {
        setError(state,'State  is required')
        success = false;
   
    }else{
        setSuccess(state)
    }
    
    if (pincodeVal === ''){
		setError(pincode,'Pincode is required')
        success = false;
    } else if(!validatePincode(pincodeVal)){
        success = false;
        setError(pincode,'Pincode Should be 6 digits')
	}else{
        setSuccess(pincode)
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

const validatePincode = (pincode) => {
	return String(pincode)
	.match(/^\d{6}$/);
}