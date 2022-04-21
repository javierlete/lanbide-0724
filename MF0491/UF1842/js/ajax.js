'use strict';

// window.addEventListener('DOMContentLoaded', function () {
//     const lista = document.getElementById('lista');

//     fetch('json/datos.json').then(
//         function (respuesta) { return respuesta.json(); }
//     ).then(function (datos) {
//         var li;
//         for (var dato of datos) {
//             li = document.createElement('li');
//             li.innerText = dato.id + ': ' + dato.nombre;

//             lista.appendChild(li);
//         }
//     }
//     );
// });

// window.addEventListener('DOMContentLoaded', function () {
//     const lista = document.getElementById('lista');

//     fetch('json/datos.json').then(
//         respuesta => respuesta.json()
//     ).then(datos => {
//         let li;
//         for (let dato of datos) {
//             li = document.createElement('li');
//             li.innerText = dato.id + ': ' + dato.nombre;

//             lista.appendChild(li);
//         }
//     }
//     );
// });


window.addEventListener('DOMContentLoaded', async function () {
    const lista = document.getElementById('lista');

    try {
        const respuesta = await fetch('json/datos.json');
        const datos = await respuesta.json();

        let li;
        for (let dato of datos) {
            li = document.createElement('li');
            li.innerText = dato.id + ': ' + dato.nombre;

            lista.appendChild(li);
        }
    } catch (error) {
        alert('No se ha podido conectar a los datos');
        console.error(error);
    }
});
