<body>
    <h1>Generátor matematických príkladov</h1>

    <div class="container">
        <button onclick="generateProblem()">Generovať príklad</button>
        <div id="problem" class="problem"></div>
        <input type="number" id="answer" placeholder="Zadajte odpoveď" />
        <button onclick="evaluateAnswer()">Overiť odpoveď</button>
        <div id="result" class="result"></div>
    </div>

    <script>
        let currentProblem = '';

        // Funkcia na generovanie matematického príkladu
        function generateProblem() {
            fetch('http://localhost:8080/math/generate')
                .then(response => response.text())
                .then(data => {
                    currentProblem = data;
                    document.getElementById('problem').textContent = currentProblem;
                    document.getElementById('result').textContent = '';
                })
                .catch(error => console.error('Error:', error));
        }

        // Funkcia na overenie odpovede
        function evaluateAnswer() {
            const answer = document.getElementById('answer').value;
            fetch(`http://localhost:8080/math/evaluate?problem=${encodeURIComponent(currentProblem)}&answer=${answer}`, {
                method: 'POST'
            })
            .then(response => response.text())
            .then(data => {
                document.getElementById('result').textContent = data;
            })
            .catch(error => console.error('Error:', error));
        }
    </script>
</body>