document.addEventListener('DOMContentLoaded', () => {
    const numDots = 50;

    // Aggiungi i pallini animati allo sfondo
    for (let i = 0; i < numDots; i++) {
        const dot = document.createElement('div');
        dot.classList.add('animated-dot');
        dot.style.left = `${Math.random() * 100}vw`;
        dot.style.top = `${Math.random() * 100}vh`;
        document.body.appendChild(dot);
    }

    // Aggiungi inoltre dei pallini nella sezione descrizione,
    // che reagiranno con l'effetto "explode" al mouseover.
    const description = document.querySelector('.description');
    if (description) {
        for (let i = 0; i < numDots; i++) {
            const dot = document.createElement('div');
            dot.classList.add('animated-dot');
            dot.style.left = `${Math.random() * 100}%`;
            dot.style.top = `${Math.random() * 100}%`;
            description.appendChild(dot);
        }
    }
});