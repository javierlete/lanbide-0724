'use strict';

// window.onload = function() { ... }

window.addEventListener('DOMContentLoaded', function () {
    const h1s = document.getElementsByTagName('h1');

    for (let h1 of h1s) {
        console.log(h1.innerText);

        h1.innerText += ' modificado por JavaScript';
    }

    const boton = document.getElementById('btn-saludar');
    const nombre = document.getElementById('nombre');

    boton.addEventListener('click', function () {
        const respuesta = document.createElement('span');
        respuesta.id = 'respuesta';

        console.log(boton.parentNode);

        respuesta.innerText = 'Hola, ' + nombre.value;
        
        // boton.parentNode.appendChild(respuesta);

        boton.insertAdjacentElement('afterEnd', respuesta);

        document.forms[0].innerHTML += '<span>blablabla</span>';
    });
});
