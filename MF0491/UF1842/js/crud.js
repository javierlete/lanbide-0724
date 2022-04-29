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

    const error = document.querySelector('#error');

    if (!/^\w{3}[\w ]*$/.test(inputNombre.value)) {
        //alert('El nombre debe tener 3 o más caracteres');

        error.innerHTML = 'El nombre debe tener 3 o más caracteres';
        error.classList.add('error');

        inputNombre.focus();

        return;
    } else {
        error.innerHTML = '';
        error.classList.remove('error');
    }

    const persona = { id: inputId.value, nombre: inputNombre.value };
    const json = JSON.stringify(persona);

    const cabeceras = new Headers();
    cabeceras.append("Content-type", "application/json");

    let metodo = 'POST';
    let url = URL;

    if (persona.id) {
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
    // Ejecuta datatables.destroy()
    // datatables.destroy();
    // }

    // datatables ? datatables.destroy : null;

    // Si existe datatables, ejecuta la sentencia
    // datatables.destroy()
    // datatables && datatables.destroy();

    // Si existe datatables, ejecuta el método destroy()
    // datatables?.destroy();

    // const tbody = document.querySelector('tbody');

    // tbody.innerHTML = '';

    // const respuesta = await fetch(URL);
    // const personas = await respuesta.json();

    // personas.forEach(function (persona) {
    //     const tr = document.createElement('tr');

    //     tr.innerHTML = `
    //         <th>${persona.id}</th>
    //         <td>${persona.nombre}</td>
    //         <td>
    //             <a href="javascript:editar(${persona.id})">Editar</a>
    //             <a href="javascript:borrar(${persona.id})">Borrar</a>
    //         </td>`;

    //     tbody.appendChild(tr);
    // });

    // DATATABLES.NET
    // $(function () {
    if (datatables) {
        datatables.ajax.reload();
    } else {
        datatables = $('table').DataTable({
            language: {
                url: 'json/es-ES.json',
            },
            ajax: {
                url: 'http://localhost:3000/personas/',
                dataSrc: ''
            },
            columns: [
                { data: 'id' },
                { data: 'nombre' },
                { data: null }
            ],
            columnDefs: [{
                targets: -1,
                data: null,
                render: function (data, type, row, meta) {
                    return `
                         <a class="btn btn-primary btn-sm" href="javascript:editar(${data.id})">Editar</a>
                         <a class="btn btn-primary btn-sm" href="javascript:borrar(${data.id})">Borrar</a>
                      `;
                }
            }]
        });
    }
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