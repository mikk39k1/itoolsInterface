const temporaryAccessBtn = document.getElementById('temporary-access-btn');
temporaryAccessBtn.addEventListener('click', (e) => {
    e.preventDefault();
    e.stopPropagation();

    const form = temporaryAccessBtn.parentElement;
    const initialsInput = form.querySelector('#initials');
    const initials = initialsInput.value;

    const initialsPattern = /^[A-Za-z]{2,3}$/;

    if (!initialsPattern.test(initials)) {
        Swal.fire({
            title: 'Fejl',
            text: 'Initialer skal indeholde enten 2 eller 3 karakterer',
            icon: 'error',
            confirmButtonColor: 'rgba(132,178,139,0.89)',
            confirmButtonText: 'OK',
        });
        return;
    }

    Swal.fire({
        title: 'Er dette dine initialer?',
        text: initials,
        icon: 'warning',
        cancelButtonText: 'NEJ',
        showCancelButton: true,
        confirmButtonColor: 'rgba(134,178,139,0.89)',
        cancelButtonColor: '#d33',
        confirmButtonText: 'JA',
    }).then((result) => {
        if (result.isConfirmed) {
            form.submit();
        }
    });
});


