<!DOCTYPE html>
<html>
<head>
    <title>Experiment 3</title>
    <style>
        /* Global styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: linear-gradient(135deg, #1e3c72, #2a5298);
            color: #fff;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1 {
            font-size: 2.5rem;
            text-align: center;
            margin-bottom: 1rem;
            animation: fadeIn 1s ease-in-out;
        }

        p {
            font-size: 1.2rem;
            text-align: center;
            margin-bottom: 2rem;
            animation: fadeIn 1.2s ease-in-out;
        }

        /* Form and button styles */
        form {
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 25px;
            padding: 15px 30px;
            font-size: 1rem;
            margin: 10px 0;
            cursor: pointer;
            box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.2);
            transition: transform 0.3s ease, background-color 0.3s ease, box-shadow 0.3s ease;
        }

        button:hover {
            transform: scale(1.1);
            background-color: #45a049;
            box-shadow: 0px 6px 8px rgba(0, 0, 0, 0.3);
        }

        button:active {
            transform: scale(0.95);
            box-shadow: 0px 3px 5px rgba(0, 0, 0, 0.4);
        }

        /* Animations */
        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        /* Footer */
        footer {
            position: absolute;
            bottom: 10px;
            font-size: 0.9rem;
            color: #ddd;
        }
    </style>
</head>
<body>
    <div>
        <h1>Experiment 3</h1>
        <p>Click on a button to see the solution for each problem statement:</p>
        <form action="MainServlet" method="get">
            <button type="submit" name="action" value="setIntegerHeader">Problem 1: Set Integer Header</button>
            <button type="submit" name="action" value="setStringHeader">Problem 2: Set String Header</button>
            <button type="submit" name="action" value="testContentType">Problem 3: Test Content-Type Header</button>
            <button type="submit" name="action" value="handleError">Problem 4: Error Handling</button>
            <button type="submit" name="action" value="testPerformance">Problem 5: Test Performance</button>
        </form>
    </div>
</body>
</html>
