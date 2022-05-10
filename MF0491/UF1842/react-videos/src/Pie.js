import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';
import { useEffect } from 'react';

export default function Pie() {
    useEffect(() => {
        const pie = document.getElementById('pie');

        pie.parentElement.classList.add('d-flex');
        pie.parentElement.classList.add('flex-column');

        let nodo = pie;

        while (nodo.parentElement) {
            nodo = nodo.parentElement;
            nodo.classList.add('h-100');
        }
    });
    
    return (
        <footer id="pie" className="bg-dark text-light p-3 mt-auto">
            <p className="text-center">&copy; 2022 - VideosApp</p>
        </footer>);
}
