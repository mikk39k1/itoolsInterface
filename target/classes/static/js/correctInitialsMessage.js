const temporaryAccessBtn = document.getElementById('temporary-access-btn');
temporaryAccessBtn.addEventListener('click', (e) => {
    e.preventDefault();
    e.stopPropagation();

    const form = temporaryAccessBtn.parentElement;
    const initialsInput = form.querySelector('#initials');
    const initials = initialsInput.value;

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


