'use strict';

// interaccionUsuario();
// Ejemplos básicos de alert, confirm, prompt...
function interaccionUsuario() {
    // Diálogo modal para mostrar un mensaje y esperar a aceptar
    alert('Alerta');

    // Diálogo modal con Aceptar o Cancelar
    const siONo = confirm('Confirmación');

    // Mostrar mensaje en la consola del navegador
    console.log('El usuario ha respondido', siONo, typeof siONo);

    // Pedir un texto por alerta.
    // SIEMPRE devuelve un string
    const nombre = prompt('¿Cómo te llamas?');

    console.log('El nombre introducido es ' + nombre, typeof nombre);

    let numero = 5;

    console.log('El número vale', numero, typeof numero);

    numero = prompt('Introduce un número');

    // El + sirve para convertir el texto en un número
    numero = +numero; //parseInt(numero);

    console.log('El número vale', numero, typeof numero);

    console.log(numero + 10);
}

// conversiones();

function conversiones() {
    // El + convierte a number
    const op1 = +prompt('Dime el op1');
    const op2 = parseInt(prompt('Dime el op2'), 10);

    // Sumamos dos number
    console.log(op1 + op2);

    // Concatenamos dos string
    console.log(op1.toString() + op2.toString());

    // Convertimos a boolean
    console.log(!!op1, !!op2);

    // Error porque usamos el operador de asignación '=' en lugar del de comparación
    //console.log(op1 = op2);

    // Comparación normal de igual
    console.log(op1 == '5');

    // Comparación estrictamente igual
    // Compara también si los tipos son iguales
    console.log(op1 === '5');
}

// sentenciasControl();

function sentenciasControl() {
    // Condicionales
    const estaSeguro = confirm('¿Estás seguro?');

    if (estaSeguro) {
        console.log('Está seguro');
    } else {
        console.log('No está seguro');
    }

    const mes = +prompt('Dime el número de mes');
    let dias;

    if (mes === 2) {
        dias = 28;
    } else if (mes === 4 || mes === 6 || mes === 9 || mes === 11) {
        dias = 30;
    } else {
        dias = 31;
    }

    // Concatenación mediante +
    console.log('El mes ' + mes + ' tiene ' + dias + ' días');

    switch (mes) {
        case 2: dias = 28; break;
        case 4:
        case 6:
        case 9:
        case 11: dias = 30; break;
        default: dias = 31;
    }

    // Formato de texto con cadenas que utilizan ` en lugar de '
    // ES2015
    console.log(`El mes ${mes} tiene ${dias} días`);

    // Repetitivas (bucles)

    let c = 1;

    // Se repite desde 0 a n veces
    while (c <= 10) {
        console.log(c);
        c++; // c += 1; // c = c + 1;
    }

    // Se repite desde 1 a n veces

    c = 1;
    let otroMas;

    do {
        console.log(c++);
        otroMas = confirm('¿Sacamos otro número?');
    } while (otroMas && c <= 10);

    // Igual que el for que hay después
    let cont = 1;

    while (cont <= 5) {
        console.log(cont);
        cont++;
    }

    // Equivalente al while de encima
    for (let contador = 1; contador <= 5; contador++) {
        console.log(contador);
    }

    // No funciona la siguiente sentencia porque
    // el for anterior utiliza let para contador
    // Eso implica que no puede accederse el dato
    // fuera del contexto del for

    // console.log('Fin', contador);
}

// arrays();

// Arreglos, matrices, arrays...
function arrays() {
    const arr = Array(3);

    arr[0] = 5;
    arr[1] = 10;
    arr[2] = 3;

    arr[3] = 20;

    arr[10] = 66;

    arr[7] = 'Hola';

    arr['casa'] = 'home';

    arr.perro = 'dog';

    arr.push('Lalaralalaaa');

    console.log(arr);

    // Como un foreach pero recorriendo las claves
    // y no los valores
    for (let clave in arr) {
        console.log(clave, arr[clave]);
    }

    // Muestra exclusivamente los valores que están
    // almacenados bajo índices numéricos (foreach)
    for (let dato of arr) {
        console.log(dato);
    }

    const diasSemana = ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo'];
    const temperaturasDiaSemana = [23, 0, 48, 3, 4, 6, 78];

    console.log('Lunes', temperaturasDiaSemana[0]);

    const diccionarioDiasTemperaturas = [];

    for (let i = 0; i < diasSemana.length; i++) {
        console.log(diasSemana[i], temperaturasDiaSemana[i] + 'C');
        diccionarioDiasTemperaturas[diasSemana[i]] = temperaturasDiaSemana[i];
    }

    console.log(diccionarioDiasTemperaturas);
    console.log(diccionarioDiasTemperaturas['Martes']);

    for (let i = 0; i < diasSemana.length; i++) {
        let dia = diasSemana[i];
        console.log(dia);
    }

    for (let dia of diasSemana) {
        console.log(dia);
    }

    const nombres = [];

    let otroMas, nombre;

    do {
        nombre = prompt('Dime un nombre');

        // Añadir al array en siguiente posición numérica
        nombres.push(nombre);

        otroMas = confirm('¿Otro más?');
    } while (otroMas);

    for (nombre of nombres) {
        console.log(nombre);
    }

    console.log(nombres);

    let termino, traduccion;
    const diccionario = [];

    do {
        termino = prompt('Dime un término en español');
        traduccion = prompt('Dame la traducción a inglés');

        // Asocia como índice el termino al valor
        // traduccion
        diccionario[termino] = traduccion;

        otroMas = confirm('¿Otro más?');
    } while (otroMas);

    termino = prompt('Dime un término y te lo traduzco');
    console.log(diccionario[termino]);

    const diccionarioDiasSemana = [];

    diccionarioDiasSemana['lunes'] = 1;
    diccionarioDiasSemana['martes'] = 2;
    diccionarioDiasSemana['miercoles'] = 3;
    diccionarioDiasSemana['jueves'] = 4;
    diccionarioDiasSemana.viernes = 5;
    diccionarioDiasSemana.sabado = 6;
    diccionarioDiasSemana.domingo = 7;

    console.log(diccionarioDiasSemana.viernes);
    console.log(diccionarioDiasSemana['jueves']);
}

// operadores();

function operadores() {
    // Aritméticos
    // +, -, *, /, % (resto de la división entera)

    console.log(5 ** 3); // 5 elevado a 3

    console.log(Math.max(5, 6, 3, 2, 1));

    console.log(5 + 3 + 1);

    // Comparaciones
    // >, <, >=, <=, ==, ===, !=, !==
    console.log(5 == '5'); // true
    console.log(5 === '5'); // false (los tipos no concuerdan)

    const x = -10;

    // Lógicos
    // &&, &, ||, |, !

    // Dentro del rango 1 a 10
    console.log(1 <= x && x <= 10);
    // Fuera del rango 1 a 10
    console.log(!(1 <= x && x <= 10));
    console.log(x < 1 || x > 10);

    // Operadores a NIVEL DE BITS (casi anecdóticos)
    console.log(5 & 3); // 5 AND 3
    console.log(5 | 3); // 5 OR  3
    console.log(5 ^ 3); // 5 XOR 3

    // Asignación
    let y, z;
    y = z = 1;

    // Siendo @ (inventado) cualquier operador como +, - ...
    // x = x @ y;
    // x @= y

    y /= 7;

    // Post/preincrementos y post/predecrementos

    z = 1;

    console.log('POST INCREMENTO')
    console.log('ANTES', z);
    console.log('DURANTE', z++);
    console.log('DESPUÉS', z);

    z = 1;

    console.log('PRE INCREMENTO');
    console.log('ANTES', z);
    console.log('DURANTE', ++z);
    console.log('DESPUÉS', z);

    // Operador ternario
    // booleano ? resultadoSiVerdadero : resultadoSiFalso

    const b = true;

    console.log(b ? 'OK' : 'KO');

    y = 10; z = 55;
    console.log(y > z ? y : z);

    // Operador "nullish coalescing"
    let v = 10;

    console.log(v ? v : 'VALE NULO');
    console.log(v ?? 'VALE NULO');

    v ??= 'Vale nulo';
}

// funciones();

function funciones() {
    function sumar(a, b) {
        return a + b;
    }

    console.log(sumar(5, 7));
    console.log(sumar(1, 2));
}

var objetos = function () {
    // Objeto sin prototipo
    var p = Object();

    p.nombre = 'Javier';
    p.apellido = 'Lete';
    p['profesion'] = 'Profesor';

    p.nombreCompleto = function () {
        return this.nombre + ' ' + this.apellido;
    };

    function datosCompletos() {
        return this.nombreCompleto() + ' ' + this.profesion;
    }

    p.datosCompletos = datosCompletos;

    console.log(p);

    console.log(p['nombre']);

    console.log(typeof p);
    console.log(typeof p.nombreCompleto);
    console.log(p.nombreCompleto);
    console.log(p.nombreCompleto());

    // console.log(datosCompletos());
    console.log(p.datosCompletos());

    // Objeto con prototipo
    function Persona(nombre, apellido, profesion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.profesion = profesion;
    }

    Persona.prototype.nombreCompleto = function () {
        return this.nombre + ' ' + this.apellido;
    }

    Persona.prototype.datosCompletos = function () {
        return this.nombreCompleto() + ' ' + this.profesion;
    }
    // Fin declaración prototipo Persona
    var persona = new Persona('Pepe', 'Pérez', 'Informático');

    console.log(persona);
    console.log(typeof persona);

    console.log(persona.nombre);
    console.log(persona.nombreCompleto());
    console.log(persona.datosCompletos());

    var persona2 = new Persona('Desconocido');

    console.log(persona2);
    console.log(persona2.datosCompletos());

    console.log('asdf'.substring(1, 3));

    String.prototype.substring = function () {
        return 'Lalaralalaaaaa';
    }

    console.log('asdf'.substring(1, 3));
}

// objetos();

clases();

function clases() {
    class Persona {
        constructor(nombre, apellido, profesion) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.profesion = profesion;
        }
        nombreCompleto() {
            return this.nombre + ' ' + this.apellido;
        }
    }

    Persona.prototype.datosCompletos = function () {
        return this.nombreCompleto() + ' ' + this.profesion;
    }

    const persona = new Persona('Pepe', 'Pérez', 'Informático');

    persona.sexo = 'Masculino';
    persona.profession = 'aksjdfkasd';

    console.log(persona);
    console.log(typeof persona);

    console.log(persona.nombre);
    console.log(persona.nombreCompleto());
    console.log(persona.datosCompletos());

    const persona2 = new Persona('Desconocido');

    console.log(persona2);
    console.log(persona2.datosCompletos());

    const personas = [];

    personas.push(new Persona('Javier', 'Lete', 'profesor'));
    personas.push(new Persona('Pepe', 'Pérez', 'Programador'));
    personas.push(new Persona('Juan', 'González', 'Gerente'));

    for (let p of personas) {
        console.log(p.datosCompletos());
    }
}

objetosJson();

function objetosJson() {
    const persona = {
        nombre: 'Javier',
        apellido: 'Lete',
        profesion: 'Profesor'
    }

    console.log(persona);
}