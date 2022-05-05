'use strict';

class ContadorComponente extends HTMLElement {
    cuenta;

    clicked;

    incremented;

    intervalo;

    boton;

    constructor() {
        // Obligatorio para todos los componentes dentro del constructor
        super();
        
        this.shadow = this.attachShadow({ mode: 'open' });
        
        this.boton = document.createElement('button');

        this.boton.addEventListener('click', () => {
            if (this.clicked) {
                this.clicked();
            }

            if (this.intervalo) {
                this.parar();
            } else {
                this.arrancar();
            }
        });

        this.shadow.appendChild(this.boton);
        this.shadow.appendChild(document.createElement('span'));
    }

    connectedCallback() {
        const texto = this.hasAttribute('texto') ? this.getAttribute('texto') : 'Púlsame';
        this.boton.innerText = texto;
    }

    arrancar() {
        this.cuenta = 0;

        this.intervalo = setInterval(() => {
            this.cuenta++;
            this.incremented(this.cuenta);
            this.shadow.querySelector('span').innerText = this.cuenta;
        }, 1000);
    }

    parar() {
        clearInterval(this.intervalo);
        this.intervalo = null;
    }
}

customElements.define('jl-contador', ContadorComponente);
