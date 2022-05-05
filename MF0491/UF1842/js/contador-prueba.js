window.addEventListener('DOMContentLoaded', () => {
    const contador = document.querySelector('jl-contador');
    contador.clicked = () => {
        console.log('Pulsado');
    };
    
    contador.incremented = (cuenta) => {
        console.log(`Cuenta: ${cuenta}`);
    };

    contador.arrancar();

    setTimeout(() => {
        contador.parar();
    }, 5000);



    // contador.clicked = function() {
    //     console.log('Pulsado');
    // };
});

