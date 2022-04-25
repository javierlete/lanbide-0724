'use strict';

window.addEventListener('DOMContentLoaded', function() {
    const htmlCollection = document.getElementsByTagName('h1');

    console.log(htmlCollection); // NO tiene función forEach
    console.log(htmlCollection.forEach);

    // Pero sí podemos recorrerlo con el for...of
    for(let h1 of htmlCollection) {
        console.log(h1)
    }

    const nodeList = document.querySelectorAll('h1');

    console.log(nodeList); // SI tiene función forEach
    console.log(nodeList.forEach);

    for(let h1 of nodeList) {
        console.log(h1)
    }

    nodeList.forEach(function(h1) {
        console.log(h1);
    });
});
