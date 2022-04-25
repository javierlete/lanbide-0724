'use strict';

window.addEventListener('DOMContentLoaded', function () {
    const op1 = document.getElementById('op1');
    const op = document.getElementById('op');
    const op2 = document.getElementById('op2');
    const btnIgual = document.getElementById('btn-igual');
    const res = document.getElementById('res');

    btnIgual.addEventListener('click', function () {
        const a = +op1.value;
        const b = +op2.value;
        const operador = op.value;
        let resultado;

        switch (operador) {
            case '+': resultado = a + b; break;
            case '-': resultado = a - b; break;
            case '*': resultado = a * b; break;
            case '/': resultado = a / b; break;
        }

        if (isNaN(resultado)) {
            alert("Las entradas tienen que tener ambos un NUMERO!");
        } else {
            res.innerText = resultado;
        }
    });
});
