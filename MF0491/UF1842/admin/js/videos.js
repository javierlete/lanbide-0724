'use strict';

const URL = 'http://localhost:3000/videos/';

window.addEventListener('DOMContentLoaded', async function () {
    ocultar('form');

    cargarVideos();

    document.querySelector('form').addEventListener('submit', guardar);
});

async function guardar(event) {
    event.preventDefault();
    
    const form = document.querySelector('form');
    const formData = new FormData(form);

    console.log(formData);

    const video = {};
    
    formData.forEach((value, key) => video[key] = value);
    
    if(video.id) {
        video.id = +video.id;
    } else {
        delete video.id;
    }

    // Utilizamos los grupos de captura de las expresiones regulares
    // Cada grupo se guarda en una posición del array
    // Los grupos se capturan en el orden en el que se definen
    // (?:) es una expresión regular que no captura nada
    // const regex = /(https:\/\/youtu\.be\/|https:\/\/(?:www\.)?youtube\.com\/watch\?v=)([A-Za-z\d_-]+)/;

    // console.log(video.url.match(regex)[0]);
    // console.log(video.url.match(regex)[1]);
    // console.log(video.url.match(regex)[2]);

    // video.url = video.url.match(regex)[2];

    video.url = video.url
        .replace('https://youtube.com/watch?v=', '')
        .replace('https://youtu.be/', '')
        .replace('https://www.youtube.com/watch?v=', '');

    console.log(video);

    /*const response = await fetch(URL, {
        method: 'POST',
        body: JSON.stringify(video),
        headers: {
            'Content-Type': 'application/json'
        }
    });*/
    
    cargarVideos();
    
    ocultar('form');
    mostrar('table');
}

async function cargarVideos() {
    const respuesta = await fetch(URL);
    const videos = await respuesta.json();

    const tbody = document.querySelector('tbody');

    tbody.innerHTML = '';
        
    videos.forEach(video => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
            <td>${video.id}</td>
            <td>${video.titulo}</td>
            <td>
                <a href="https://www.youtube.com/watch?v=${video.url}" target="_blank">${video.url}</a>
            </td>
            <td>
                <img src="http://i3.ytimg.com/vi/${video.url}/default.jpg" />
            </td>
            <td>
                <a class="btn btn-primary btn-sm" href="javascript:editar(${video.id})">Editar</a>
                <a class="btn btn-danger btn-sm" href="javascript:borrar(${video.id})">Borrar</a>
            </td>
        `;
        tbody.appendChild(tr);
    });
}

async function editar(id) {
    ocultar('table');
    mostrar('form');

    const respuesta = await fetch(URL + id);
    const video = await respuesta.json();

    document.querySelector('#id').value = video.id;
    document.querySelector('#titulo').value = video.titulo;
    document.querySelector('#url').value = 'https://youtube.com/watch?v=' + video.url;
}

function agregar() {
    document.querySelector('#id').value = '';
    document.querySelector('#titulo').value = '';
    document.querySelector('#url').value = '';

    ocultar('table');
    mostrar('form');
}

function ocultar(selector) {
    const elemento = document.querySelector(selector);
    elemento.dataset.displayAnterior = elemento.style.display;
    elemento.style.display = 'none';
}

function mostrar(selector) {
    const elemento = document.querySelector(selector);
    elemento.style.display = elemento.dataset.displayAnterior;
}
