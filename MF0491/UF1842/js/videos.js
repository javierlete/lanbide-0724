'use strict';

const URL = 'http://localhost:3000/videos/';

window.addEventListener('DOMContentLoaded', async function() {
    const respuesta = await fetch(URL);
    const videos = await respuesta.json();
    
    const videosDom = document.querySelector('#videos');

    let videoDom;

    videos.forEach(video => {
        videoDom = document.createElement('div');
        videoDom.classList.add('col');

        videoDom.innerHTML = `
            <div class="card h-100">
                <img src="http://i3.ytimg.com/vi/${video.url}/hqdefault.jpg" class="card-img-top" alt="">
                <div class="card-body">
                    <h5 class="card-title"><a class="stretched-link" data-bs-toggle="modal" data-bs-target="#video" data-id="${video.id}" href="#">${video.titulo}</a></h5>
                </div>
            </div>
        `;

        videosDom.appendChild(videoDom);
    });

    const videoModal = document.querySelector('#video');
    videoModal.addEventListener('show.bs.modal', async function(e) {
        console.log(e.relatedTarget);
        const id = e.relatedTarget.dataset.id;
        const respuesta = await fetch(URL + id);
        console.log(URL + id);
        console.log(respuesta);
        const video = await respuesta.json();
        console.log(video);

        const embebido = e.target.querySelector('#embebido');
        embebido.src = 'http://www.youtube.com/embed/' + video.url;
    });

    videoModal.addEventListener('hide.bs.modal', function(e) {
        const embebido = e.target.querySelector('#embebido');
        embebido.src = '';
    });
});


