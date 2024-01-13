function validateOfferName(inputElement) {
    const name = inputElement.value.trim();

    if (name === '' || name.length > 30) {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }
}

function validateOfferType() {
    const typeInputs = document.querySelectorAll('input[name="type"]');
    var isValid = false;

    typeInputs.forEach((input) => {
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

function validateOfferDateOfStart(inputElement) {
    const dateOfStart = inputElement.value.trim();
    const currentDate = new Date().toISOString().split('T')[0];  // Get current date in the format YYYY-MM-DD

    if (dateOfStart === '') {
        inputElement.style.borderColor = 'red';
        // alert('Date of employment is required.');
    } else if (dateOfStart > currentDate) {
        inputElement.style.borderColor = 'red';
        // alert('Date of employment cannot be in the future.');
    } else {
        inputElement.style.borderColor = 'green';
    }
}

function validateOfferDateOfEnd(inputElement) {
    const dateOfEnd = inputElement.value.trim();
    const dateOfStart = document.getElementById('dateOfStart').value.trim();

    if (dateOfEnd === '') {
        inputElement.style.borderColor = 'red';
    } else if (dateOfStart > dateOfEnd) {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }
}

function validateOfferDevice() {
    const deviceInputs = document.querySelectorAll('input[name="device"]');
    var isValid = false;

    deviceInputs.forEach((input) => {
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

function validateOfferValue(inputElement) {
    var value = inputElement.value.trim();
    if (value === '' || !/^[+]?\d+(\.\d{1,2})?$|^[+]?\d+$/.test(value)) {
        inputElement.style.borderColor = 'red';
    } else if (parseFloat(value) > 9999999.99 || parseFloat(value) < -9999999.99) {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }

}

function validateOfferForm() {
    var name = document.getElementById('name').value;
    var typeInputs = document.querySelectorAll('input[name="type"]:checked');
    var isValidType = typeInputs.length > 0;
    var deviceInputs = document.querySelectorAll('input[name="device"]:checked');
    var isValidDevice = deviceInputs.length > 0;
    var dateOfStart = document.getElementById('dateOfStart').value;
    var dateOfEnd = document.getElementById('dateOfEnd').value;
    var value = document.getElementById('value').value;

    if (name.trim() === '' || value.trim() === '' || dateOfStart.trim() === '' || !isValidDevice || !isValidType || dateOfEnd.trim() === '') {
        alert('All fields are required');
    } else if (name.length > 30) {
        alert('Name exceeds 30 characters');
    } else if (!isValidDate(dateOfStart)) {
        alert('Invalid date of start or date in the future');
    } else if (!/^[+]?\d+(\.\d{1,2})?$/.test(value)) {
        alert('Please enter a valid number with up to two decimal places.');
    } else if (dateOfStart > dateOfEnd) {
        alert('Invalid date of end or date in the future');
    } else if (parseFloat(value) > 9999999.99 || parseFloat(value) < -9999999.99) {
        alert('Please enter a number within the range of -9999999.99 to 9999999.99.');
    } else {
        document.getElementById('offerForm').submit();
    }
}

function isValidDate(dateString) {
    var regex = /^\d{4}-\d{2}-\d{2}$/;

    if (!regex.test(dateString)) {
        return false;
    }
    var today = new Date();
    var inputDate = new Date(dateString);

    if (inputDate > today) {
        return false;
    }

    return true;
}