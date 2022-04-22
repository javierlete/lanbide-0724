'use strict';

// window.addEventListener('DOMContentLoaded', async function () {

$(function() {
    //const lista = document.getElementById('lista');

    // try {
        // const respuesta = await fetch('json/datos.json');
        // const datos = await respuesta.json();
        
        $.getJSON('json/datos.json', function(datos) {
            $(datos).each(function() {
                $('<li>').text(this.id + ': ' + this.nombre).appendTo('ul');
            });
        }).fail(function (jqxhr, textStatus, error) {
            alert('No se ha podido conectar a los datos');
            console.error(jqxhr, textStatus, error);
        });

        // let li;
        // for (let dato of datos) {
        //     li = document.createElement('li');
        //     li.innerText = dato.id + ': ' + dato.nombre;

        //     lista.appendChild(li);
        // }
    // } catch (error) {
    //     alert('No se ha podido conectar a los datos');
    //     console.error(error);
    // }
});
