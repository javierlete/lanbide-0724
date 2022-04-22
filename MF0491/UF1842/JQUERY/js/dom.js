'use strict';

$(function () {
    console.log('DENTRO');

    // const h1s = document.getElementsByTagName('h1');
    // for (let h1 of h1s) {
    //     console.log(h1.innerText);

    //     h1.innerText += ' modificado por JavaScript';
    // }
    
    $('h1').each(function() {
        console.log(this.innerText);
        
        this.innerText += ' modificado por JavaScript';
    });
    
    // $('h1').text('Nuevo');

    // const boton = document.getElementById('btn-saludar');
    // const nombre = document.getElementById('nombre');

    // boton.addEventListener('click', function () {
    $('#btn-saludar').on('click', function () {
        // const respuesta = document.createElement('span');
        // respuesta.id = 'respuesta';

        // respuesta.innerText = 'Hola ' + nombre.value;
        
        // boton.parentNode.appendChild(respuesta);

        // boton.insertAdjacentElement('afterend', respuesta);

        $('<span>')
            .attr('id', 'respuesta')
            .text('Hola ' + $('#nombre').val())
            .insertAfter('#btn-saludar');
    });
});

console.log('FUERA');
