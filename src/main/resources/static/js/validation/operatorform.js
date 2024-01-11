function validateOperatorName(inputElement) {
    const name = inputElement.value.trim();

    if (name === '' || name.length > 30) {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }
}

function validateEmail(inputElement) {
    const email = inputElement.value.trim();

    if (!/\S+@\S+\.\S+/.test(email) || email.length > 30 || email === '') {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }
}

function validatePhoneNumber(inputElement) {
    const phone = inputElement.value.trim();

    if (!/^\d{3}-\d{3}-\d{3}$/.test(phone) || phone === '') {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }
}

function validateNipNumber(inputElement) {
    const nip = inputElement.value.trim();

    if (!/^\d{10}$/.test(nip) || nip === '') {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }
}

function validateOperatorForm() {
    var name = document.getElementById('name').value;
    var nip = document.getElementById('nipNumber').value;
    var email = document.getElementById('email').value;
    var phone = document.getElementById('phoneNumber').value;

    if (name.trim() === '' || nip.trim() === '' || email.trim() === '' || phone.trim() === '') {
        alert('All fields are required');
    } else if (name.length > 30) {
        alert('Name exceeds 30 characters');
    } else if (!/^\d{10}$/.test(nip)) {
        alert('NIP must have exactly 10 digits');
    } else if (!/\S+@\S+\.\S+/.test(email) || email.length > 30) {
        alert('Email is incorrect or exceeds 30 characters');
    } else if (!/^\d{3}-\d{3}-\d{3}$/.test(phone)) {
        alert('Phone number must be in the format xxx-xxx-xxx');
    } else {
        document.getElementById('operatorForm').submit();
    }
}

