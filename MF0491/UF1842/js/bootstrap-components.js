'use strict';

class LabelText extends HTMLElement {
    connectedCallback() {
        const id = this.getAttribute('id') ?? '';
        const requerido = this.hasAttribute('requerido') ? 'required' : '';
        const tipo = this.getAttribute('tipo') ?? 'text';
        const patron = this.getAttribute('patron') ? `pattern="${this.getAttribute('patron')}"` : '';
        const sololectura = this.hasAttribute('sololectura') ? 'readonly' : '';

        this.innerHTML = `
        <div class="row mb-3">
            <label for="${id}" class="col-sm-2 col-form-label">${id.toUpperCase()}</label>
            <div class="col-sm-10">
                <input ${sololectura} ${requerido} ${patron}
                    type="${tipo}" class="form-control" id="${id}" name="${id}">
            </div>
        </div>`;
    }
}

class BotonGuardar extends HTMLElement {
    connectedCallback() {
        this.innerHTML = `
        <div class="row mb-3">
            <div class="offset-sm-2 col-sm-10">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </div>
        </div>`;
    }
}

customElements.define('label-text', LabelText);
customElements.define('boton-guardar', BotonGuardar);