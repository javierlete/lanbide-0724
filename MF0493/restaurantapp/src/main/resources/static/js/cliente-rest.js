window.addEventListener("DOMContentLoaded", async function () {
	const peticion = await fetch('http://localhost:8080/api/v2/reservas');
	const datos = await peticion.json();
	const reservas = datos._embedded.reservas;
	
	console.log(reservas);
	
	console.log(reservas.length);
	
	console.log(reservas[0]);
	
	for(let r of reservas) {
		const li = document.createElement('li');
		
		console.log(r);
		
		li.innerHTML = `
			${r.nombre} ${r.fechaHora}
		`;
		const ul = document.querySelector('ul');
		
		console.log(ul);
		
		ul.appendChild(li);
	};
});