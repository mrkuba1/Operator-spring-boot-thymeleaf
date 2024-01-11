function validateEmployeeName(inputElement) {
    const name = inputElement.value.trim();

    if (name === '' || name.length > 20) {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }
}

function validateEmployeeSurname(inputElement) {
    const surname = inputElement.value.trim();

    if (surname === '' || surname.length > 30) {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }
}

function validateEmployeePESEL(inputElement) {
    const pesel = inputElement.value.trim();

    if (!/^\d{11}$/.test(pesel) || pesel === '') {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }
}

function validateEmployeeGender() {
    const genderInputs = document.querySelectorAll('input[name="gender"]');
    var isValid = false;

    genderInputs.forEach((input) => {
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

function validateDateOfEmployment(inputElement) {
    const dateOfEmployment = inputElement.value.trim();
    const currentDate = new Date().toISOString().split('T')[0];  // Get current date in the format YYYY-MM-DD

    if (dateOfEmployment === '') {
        inputElement.style.borderColor = 'red';
        // alert('Date of employment is required.');
    } else if (dateOfEmployment > currentDate) {
        inputElement.style.borderColor = 'red';
        // alert('Date of employment cannot be in the future.');
    } else {
        inputElement.style.borderColor = 'green';
    }
}

function validateDateOfDismissal(inputElement) {
    const dateOfDismissal = inputElement.value.trim();
    const dateOfEmployment = document.getElementById('dateOfEmployment').value.trim();

    if (dateOfDismissal !== '') {
        if (dateOfDismissal < dateOfEmployment) {
            inputElement.style.borderColor = 'red';
            // alert('Dismissal date cannot be earlier than the date of employment.');
        } else if (dateOfDismissal > new Date().toISOString().split('T')[0]) {
            inputElement.style.borderColor = 'red';
            // alert('Dismissal date cannot be in the future.');
        } else {
            inputElement.style.borderColor = 'green';
        }
    } else {
        inputElement.style.borderColor = '';
    }
}


function validateEmployeeForm() {
    var name = document.getElementById('name').value;
    var surname = document.getElementById('surname').value;
    var pesel = document.getElementById('peselNumber').value;
    var genderInputs = document.querySelectorAll('input[name="gender"]:checked');
    var isValidGender = genderInputs.length > 0;
    var dateOfEmployment = document.getElementById('dateOfEmployment').value;
    var dateOfDismissal = document.getElementById('dateOfDismissal').value;

    if (name.trim() === '' || pesel.trim() === '' || surname.trim() === '' || !isValidGender || dateOfEmployment.trim() === '') {
        alert('All fields are required');
    } else if (name.length > 20) {
        alert('Name exceeds 20 characters');
    } else if (surname.length > 30) {
        alert('Surname exceeds 30 characters');
    } else if (!/^\d{11}$/.test(pesel)) {
        alert('PESEL must have exactly 11 digits');
    } else if (!isValidDate(dateOfEmployment)) {
        alert('Invalid date of employment or date in the future');
    } else if (dateOfDismissal.trim() !== '' && !isValidDate(dateOfDismissal)) {
        alert('Invalid date of dismissal');
    } else {
        document.getElementById('employeeForm').submit();
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




