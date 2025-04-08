document.addEventListener('DOMContentLoaded', () => {
    const numBubbles = 40;

    for (let i = 0; i < numBubbles; i++) {
        const bubble = document.createElement('div');
        bubble.classList.add('background-bubble');
        bubble.style.left = `${Math.random() * 100}vw`;
        bubble.style.animationDuration = `${5 + Math.random() * 10}s`;
        bubble.style.animationDelay = `${Math.random() * 5}s`;
        document.body.appendChild(bubble);
    }
});
