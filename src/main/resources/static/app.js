let problems = []; // Zoznam príkladov
let correctCount = 0;
let totalTime = 0;
let currentProblemIndex = 0;

document.addEventListener('DOMContentLoaded', () => {
  generateProblems();
  showProblem();

  document.getElementById('submitAnswerBtn').addEventListener('click', submitAnswer);
  document.getElementById('answerInput').addEventListener('keydown', (e) => {
    if (e.key === 'Enter') {
      submitAnswer();
    }
  });
});

function generateProblems() {
  // Automaticky vygeneruj 10 príkladov
  problems = [];
  for (let i = 0; i < 10; i++) {
    let num1 = Math.floor(Math.random() * 10) + 1;
    let num2 = Math.floor(Math.random() * 10) + 1;
    let operator = Math.random() < 0.5 ? '+' : '-';

    let result = operator === '+' ? num1 + num2 : num1 - num2;

    // Zabezpečíme, že výsledok nebude záporný
    if (result < 0) {
      num1 = num2 + Math.floor(Math.random() * 10) + 1;
      result = num1 - num2;
    }

    problems.push({ num1, num2, operator, result });
  }
}

function showProblem() {
  let problem = problems[currentProblemIndex];
  document.getElementById('mathProblem').textContent = `${problem.num1} ${problem.operator} ${problem.num2}`;
}

function submitAnswer() {
  let userAnswer = parseInt(document.getElementById('answerInput').value, 10);
  let correctAnswer = problems[currentProblemIndex].result;

  let feedbackMessage = '';
  if (userAnswer === correctAnswer) {
    correctCount++;
    feedbackMessage = 'Správne!';
    document.getElementById('feedbackMessage').classList.remove('incorrect');
    document.getElementById('feedbackMessage').classList.add('correct');
  } else {
    totalTime += 60; // pridáme 1 minútu za nesprávnu odpoveď
    feedbackMessage = 'Nesprávne!';
    document.getElementById('feedbackMessage').classList.remove('correct');
    document.getElementById('feedbackMessage').classList.add('incorrect');
  }

  document.getElementById('feedbackMessage').textContent = feedbackMessage;

  // Prejdi na ďalší príklad
  currentProblemIndex++;
  if (currentProblemIndex < problems.length) {
    showProblem();
  } else {
    alert('Koniec príkladov!');
  }

  // Aktualizuj štatistiky
  document.getElementById('correctCount').textContent = correctCount;
  document.getElementById('totalTime').textContent = totalTime;
  document.getElementById('answerInput').value = '';
}
