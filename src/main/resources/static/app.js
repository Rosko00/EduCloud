let correctCount = 0;
let totalTime = 0;
let questionCount = 0;
let timer;
let startTime;
let currentProblem;

function startTimer() {
    startTime = new Date();
    timer = setInterval(() => {
        let now = new Date();
        totalTime = Math.floor((now - startTime) / 1000);
        document.getElementById("totalTime").innerText = totalTime;
    }, 1000);
}

function stopTimer() {
    clearInterval(timer);
}

function generateProblem() {
    const a = Math.floor(Math.random() * 10);
    const b = Math.floor(Math.random() * 10);
    const operator = Math.random() > 0.5 ? '+' : '-';

    if (operator === '-' && a < b) {
        currentProblem = { a: b, b: a, operator }; // aby sa výsledok stal kladným
    } else {
        currentProblem = { a, b, operator };
    }

    document.getElementById("mathProblem").innerText = `${currentProblem.a} ${operator} ${currentProblem.b} = ?`;
}

function checkAnswer() {
    const userAnswer = parseInt(document.getElementById("answerInput").value);
    let correctAnswer;

    if (currentProblem.operator === '+') {
        correctAnswer = currentProblem.a + currentProblem.b;
    } else {
        correctAnswer = currentProblem.a - currentProblem.b;
    }

    if (userAnswer === correctAnswer) {
        correctCount++;
        document.getElementById("feedbackMessage").innerText = "Správne!";
    } else {
        totalTime += 60; // pridať 1 minútu za nesprávnu odpoveď
        document.getElementById("feedbackMessage").innerText = "Nesprávne!";
    }

    document.getElementById("correctCount").innerText = correctCount;
}

function nextQuestion() {
    questionCount++;
    document.getElementById("answerInput").value = "";

    if (questionCount >= 10) {
        stopTimer();
        document.getElementById("feedbackMessage").innerText = "Koniec, dokončili ste všetky otázky!";
        document.getElementById("mathProblem").innerText = "";
        return;
    }
    generateProblem();
}

// Udalosť na tlačidlo Odoslať
document.getElementById("submitAnswerBtn").addEventListener("click", () => {
    if (questionCount === 0) startTimer();
    checkAnswer();
    nextQuestion();
});

// Poslucháč pre kláves Enter v inpute
document.getElementById("answerInput").addEventListener("keydown", (event) => {
    if (event.key === "Enter") {
        if (questionCount === 0) startTimer();
        checkAnswer();
        nextQuestion();
    }
});

// Zobrazí prvý príklad hneď pri načítaní stránky
document.addEventListener("DOMContentLoaded", () => {
    generateProblem();
});
