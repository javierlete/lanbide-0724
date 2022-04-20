'use strict';

window.addEventListener('DOMContentLoaded', async function () {
    const lista = document.getElementById('lista');

    const respuesta = await fetch('json/datos.json');
    const datos = await respuesta.json();

    let li;
    for(let dato of datos) {
        li = document.createElement('li');
        li.innerText = dato.id + ': ' + dato.nombre;

        lista.appendChild(li);
    }
});
