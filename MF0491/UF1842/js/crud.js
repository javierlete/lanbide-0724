'use strict';

const URL = 'http://localhost:3000/personas/';

let inputId, inputNombre;

window.addEventListener('DOMContentLoaded', async function () {
    inputId = document.querySelector('#id');
    inputNombre = document.querySelector('#nombre');
    
    await cargarTabla();

    document.querySelector('form').addEventListener('submit', guardar);
});

async function guardar(e) {
    // Siempre es recomendable desactivar la propagación del evento
    // cuando este evento es 'submit' -> e.preventDefault()
    // Por defecto un formulario sin action lo que hace es
    // recargar la página (lo que limpia la consola del navegador)
    e.preventDefault();

    const persona = { id: inputId.value, nombre: inputNombre.value };
    const json = JSON.stringify(persona);
    
    const cabeceras = new Headers();
    cabeceras.append("Content-type", "application/json");

    let metodo = 'POST';
    let url = URL;

    if(persona.id) {
        metodo = 'PUT';
        url = URL + persona.id;
    }

    const respuesta = await fetch(url, { method: metodo, body: json, headers: cabeceras });

    console.log(respuesta);

    await cargarTabla();
}

let datatables;

async function cargarTabla() {
    // Si existe datatables
    // if(datatables) {
    //     Ejecuta datatables.destroy()
    //     datatables.destroy();
    // }

    // datatables ? datatables.destroy : null;

    // Si existe datatables, ejecuta la sentencia
    // datatables.destroy()
    // datatables && datatables.destroy();

    // Si existe datatables, ejecuta el método destroy()
    datatables?.destroy();

    const tbody = document.querySelector('tbody');

    tbody.innerHTML = '';

    const respuesta = await fetch(URL);
    const personas = await respuesta.json();

    personas.forEach(function (persona) {
        const tr = document.createElement('tr');

        tr.innerHTML = `
            <th>${persona.id}</th>
            <td>${persona.nombre}</td>
            <td>
                <a href="javascript:editar(${persona.id})">Editar</a>
                <a href="javascript:borrar(${persona.id})">Borrar</a>
            </td>`;

        tbody.appendChild(tr);
    });

    // DATATABLES.NET
    // $(function () {
        datatables = $('table').DataTable( {
            language: {
                url: 'http://cdn.datatables.net/plug-ins/1.11.5/i18n/es-ES.json'
            }
        });
    // });
}

async function borrar(id) {
    const respuesta = await fetch(URL + id, { method: 'DELETE' });

    console.log(respuesta);

    await cargarTabla();
}

async function editar(id) {
    const respuesta = await fetch(URL + id);
    const persona = await respuesta.json();

    inputId.value = persona.id;
    inputNombre.value = persona.nombre;
}

function limpiar() {
    inputId.value = inputNombre.value = '';
}