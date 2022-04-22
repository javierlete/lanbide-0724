'use strict';

window.addEventListener('DOMContentLoaded', function () {
    const res = document.getElementById('res');
    const numeros = document.getElementsByClassName('numero');
    const borrar = document.getElementById('borrar');
    const ops = document.getElementsByClassName('op');
    const ejecutar = document.getElementById('ejecutar');

    let a, operacion, b, resultado;

    window.addEventListener('keypress', function (e) {
        console.log(e.key);

        switch (e.key) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9': procesarDigito(e.key); break;
            case '+':
            case '-':
            case '*':
            case '/': procesarOperacion(e.key); break;
            case 'c': procesarBorrar(); break;
            case 'Enter':
            case '=': procesarEjecutar(); break;
        }
    });


    borrar.addEventListener('click', function () {
        procesarBorrar();
    });

    // Esto crearía tantas constantes como botones numéricos haya
    // Cada una de ellas se abandonaría antes de crear la siguiente
    for (const boton of numeros) {
        boton.addEventListener('click', function () {
            // this representa el botón concreto que ha lanzado el evento
            // Si pulsas el botón 2, this es el botón 2
            procesarDigito(this.innerText);
        });
    }

    // Reutilizamos una variable para guardar cada uno de los botones
    let op;
    for (op of ops) {
        op.addEventListener('click', function () {
            // this en este caso representa el botón de operación concreto
            // que se ha pulsado
            procesarOperacion(this.innerText);
        });
    }

    ejecutar.addEventListener('click', function () {
        procesarEjecutar();
    });

    function procesarDigito(digito) {
        res.value += digito;
    }

    function procesarOperacion(o) {
        operacion = o;

        // Guardamos el valor que había en pantalla al pulsar la operación
        a = +res.value;

        // Vaciamos la pantalla
        res.value = '';

        console.log(a);
        console.log(operacion);
    }

    function procesarBorrar() {
        res.value = '';
    }

    function procesarEjecutar() {
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
    }
});
