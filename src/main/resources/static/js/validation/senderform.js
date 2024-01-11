function validateSenderLocation(inputElement) {
    const location = inputElement.value.trim();

    if (location === '' || location.length > 30) {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }
}
function validateSenderHeight(inputElement) {
    var height = inputElement.value.trim();
    if (height === '' || !/^[+]?\d+(\.\d{1,3})?$|^[+]?\d+$/.test(height)) {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }

}
function validateSenderBandwidth(inputElement) {
    var bandwidth = inputElement.value.trim();
    if (bandwidth === '' || !/^[+]?\d+(\.\d{1,3})?$|^[+]?\d+$/.test(bandwidth)) {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }

}
function validateSenderWorks() {
    const worksInputs = document.querySelectorAll('input[name="works"]');
    var isValid = false;

    worksInputs.forEach((input) => {
        if (input.checked) {
            isValid = true;
        }
    });

    if (!isValid) {
        document.querySelector('.gender-switch').style.borderColor = 'red';
    } else {
        document.querySelector('.gender-switch').style.borderColor = 'green';
    }
}


function validateSenderForm() {
    var location = document.getElementById('location').value;
    var worksInputs = document.querySelectorAll('input[name="works"]:checked');
    var isValidWorks = worksInputs.length > 0;
    var height = document.getElementById('height').value;
    var bandwidth = document.getElementById('bandwidth').value;

    if (location.trim() === '' || height.trim() === '' || bandwidth.trim() === '' || !isValidWorks) {
        alert('All fields are required');
    } else if (location.length > 30) {
        alert('Location exceeds 30 characters');
    }
    else if (!/^[+]?\d+(\.\d{1,3})?$/.test(height)) {
        alert('Please enter a valid number with up to three decimal places.');
    }
    else if (!/^[+]?\d+(\.\d{1,3})?$/.test(bandwidth)) {
        alert('Please enter a valid number with up to three decimal places.');
    }
    else {
        document.getElementById('senderForm').submit();
    }
}

