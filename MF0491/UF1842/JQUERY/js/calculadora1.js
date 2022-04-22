'use strict';

// window.addEventListener('DOMContentLoaded', function() {
$(function () {
    // const op1 = document.getElementById('op1');
    // const op = document.getElementById('op');
    // const op2 = document.getElementById('op2');
    // const btnIgual = document.getElementById('btn-igual');
    // const res = document.getElementById('res');

    // btnIgual.addEventListener('click', function () {
    $('#btn-igual').on('click', function() {
        // const a = +op1.value;
        // const b = +op2.value;
        // const operador = op.value;
        var a  = +$('#op1').val();
        var b = +$('#op2').val();
        var operador = $('#op').val();
        var resultado;

        switch (operador) {
            case '+': resultado = a + b; break;
            case '-': resultado = a - b; break;
            case '*': resultado = a * b; break;
            case '/': resultado = a / b; break;
        }

        $('#res').text(resultado);
    });
});
