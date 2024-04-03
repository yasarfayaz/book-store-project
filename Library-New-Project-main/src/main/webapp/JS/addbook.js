const form = document.querySelector('#form');
const bookName = document.querySelector('#inputBookName');
const author = document.querySelector('#inputAuthorName');
const price = document.querySelector('#inputPrice');
const publishedYear = document.querySelector('#inputPublishedYear');
const bookQty = document.querySelector('#inputBookQty');

form.addEventListener('submit',(event) => {
 
   if (!validate()) {
    event.preventDefault();
   } 

})

function validate(){
    const bookNameVal = bookName.value.trim();
    const authorNameVal = author.value.trim();
    const priceVal = price.value.trim();
    const publishedYearVal = publishedYear.value.trim();
    const bookQtyVal = bookQty.value.trim();
    let success = true;
    
    if (bookNameVal==='') {
        setError(bookName,'BookName is required')
        success = false;
    }else {
        setSuccess(bookName)
    }

    if (authorNameVal==='') {
        setError(author,'AuthorName is required')
        success = false;
    }else{
        setSuccess(author)
    }

    if (priceVal === '') {
        setError(price,'Price is required')
        success = false;
    } else if(priceVal < 0){
        success = false;
        setError(price,'Price is Invalid')
    }else{
        setSuccess(price)
    }
    
     if (publishedYearVal === '') {
        setError(publishedYear,'Published Year is required')
        success = false;
    } else if(publishedYearVal < 1000){
        success = false;
        setError(publishedYear,'Published Year Not Valid')
    }else{
        setSuccess(publishedYear)
    }
    
    if (bookQtyVal === ''){
		setError(bookQty,'Book Qty is required')
        success = false;
	}else{
        setSuccess(bookQty)
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

//const validateEmail = (email) =>{
  //  return String(email)
    //.toLowerCase()
   // .match(
    //    /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
   // );
//}

//const validateBookName = (bookName) => {
 //   return String(bookName)
   // .match(
   //     /^[A-Za-z0-9_]+$/
  //  );
//}



//const validatePhoneNumber = (phoneNumber) => {
//	return String(phoneNumber)
//	.match(/^\d{10}$/);
//}