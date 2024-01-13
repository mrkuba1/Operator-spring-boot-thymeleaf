function validateDepartmentName(inputElement) {
    const name = inputElement.value.trim();

    if (name === '' || name.length > 19) {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }
}


function validateDepartmentPhoneNumber(inputElement) {
    const phone = inputElement.value.trim();

    if (!/^\d{3}-\d{3}-\d{3}$/.test(phone) || phone === '') {
        inputElement.style.borderColor = 'red';
    } else {
        inputElement.style.borderColor = 'green';
    }
}

function validateDepartmentForm() {
    var name = document.getElementById('name').value;
    var phone = document.getElementById('phoneNumber').value;

    if (name.trim() === '' || phone.trim() === '') {
        alert('All fields are required');
    } else if (name.length > 19) {
        alert('Name exceeds 20 characters');
    } else if (!/^\d{3}-\d{3}-\d{3}$/.test(phone)) {
        alert('Phone number must be in the format xxx-xxx-xxx');
    } else {
        document.getElementById('departmentForm').submit();
    }
}

