'use strict';

var URL = 'http://localhost:3000/personas/';

$(function () {
    recargar();

    $('form').on('submit', guardar);
});

function recargar() {
    cargarTabla();

    // debugger;

    limpiarFormulario();
}

function guardar(e) {
    e.preventDefault();

    var persona = { id: $('#id').val(), nombre: $('#nombre').val() };

    if (persona.id) {
        $.ajax(URL + persona.id, {
            method: 'PUT',
            data: persona
        }).then(recargar);
    } else {
        $.ajax(URL, {
            method: 'POST',
            data: persona
        }).then(recargar);
    }
}

function cargarTabla() {
    $.getJSON(URL, function (datos) {
        $('tbody').empty();

        var fila;

        $(datos).each(function () {
            fila = '<tr><th>' + this.id + '</th><td>' + this.nombre + '</td>'
                + '<td><a href="javascript:editar(' + this.id + ')">Editar</a> ' +
                '<a href="javascript:borrar(' + this.id + ')">Borrar</a></td></tr>';
            $(fila).appendTo('tbody');
        });
    });
}

function limpiarFormulario() {
    $('form input').val(''); // document.getElementById('id').value = '';
}

function borrar(id) {
    $.ajax(URL + id, {
        method: 'DELETE'
    }).then(recargar);
}

function editar(id) {
    $.getJSON(URL + id, function (persona) {
        $('#id').val(id);
        $('#nombre').val(persona.nombre);
    });
}

/*
function miFuncion() {
    alert('prueba');

    var prueba;
}

miFuncion();

(function() {
    alert('prueba');

    var prueba;
})();

// IIFE

alert('prueba');

var prueba;
*/