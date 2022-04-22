'use strict';

window.addEventListener('DOMContentLoaded', function () {
    const res = document.getElementById('res');
    const numeros = document.getElementsByClassName('numero');
    const borrar = document.getElementById('borrar');
    const ops = document.getElementsByClassName('op');
    const ejecutar = document.getElementById('ejecutar');

    let a, operacion, b, resultado;

    borrar.addEventListener('click', function () {
        res.value = '';
    });

    // Esto crearía tantas constantes como botones numéricos haya
    // Cada una de ellas se abandonaría antes de crear la siguiente
    for (const boton of numeros) {
        boton.addEventListener('click', function () {
            // this representa el botón concreto que ha lanzado el evento
            // Si pulsas el botón 2, this es el botón 2
            res.value += this.innerText;
        });
    }

    // Reutilizamos una variable para guardar cada uno de los botones
    let op;
    for (op of ops) {
        op.addEventListener('click', function () {
            // this en este caso representa el botón de operación concreto
            // que se ha pulsado
            operacion = this.innerText;

            // Guardamos el valor que había en pantalla al pulsar la operación
            a = +res.value;

            // Vaciamos la pantalla
            res.value = '';

            console.log(a);
            console.log(operacion);
        });
    }

    ejecutar.addEventListener('click', function () {
        // Almacenamos el valor que hay en pantalla
        // como segundo operando
        b = +res.value;

        console.log(b);

        // Dependiendo de la operación
        switch (operacion) {
            case '+': resultado = a + b; break;
            case '-': resultado = a - b; break;
            case '*': resultado = a * b; break;
            case '/': resultado = a / b; break;
        }

        console.log(resultado);

        // Cargamos el resultado en pantalla
        res.value = resultado;
    });
});
