function validateCustomerName(inputElement) {
    const name = inputElement.value.trim();

    if (name === '' || name.length > 30) {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }
}

function validateCustomerSurname(inputElement) {
    const surname = inputElement.value.trim();

    if (surname === '' || surname.length > 30) {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }
}

function validateCustomerPhoneNumber(inputElement) {
    const phone = inputElement.value.trim();

    if (!/^\d{3}-\d{3}-\d{3}$/.test(phone) || phone === '') {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }
}

function validateCustomerForm() {
    var name = document.getElementById('name').value;
    var surname = document.getElementById('surname').value;
    var phone = document.getElementById('phoneNumber').value;

    if (name.trim() === '' || surname.trim() === '' || phone.trim() === '') {
        alert('All fields are required');
    } else if (name.length > 30) {
        alert('Name exceeds 30 characters');
    } else if (surname.length > 30) {
        alert('Surname exceeds 30 characters');
    } else if (!/^\d{3}-\d{3}-\d{3}$/.test(phone)) {
        alert('Phone number must be in the format xxx-xxx-xxx');
    } else {
        document.getElementById('customerForm').submit();
    }
}

