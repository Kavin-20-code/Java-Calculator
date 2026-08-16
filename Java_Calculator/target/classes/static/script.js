let display = document.getElementById("display");

let error = document.getElementById("error");

let firstNumber = "";

let operator = "";

let secondNumber = "";


// Add number to display
function appendNumber(number) {

    error.textContent = "";

    if (operator === "") {

        firstNumber += number;

        display.textContent = firstNumber;

    } else {

        secondNumber += number;

        display.textContent = secondNumber;
    }
}


// Add operator
function appendOperator(op) {

    if (firstNumber === "") {
        return;
    }

    operator = op;

    display.textContent = op;

}


// Calculate result
async function calculate() {

    if (
        firstNumber === "" ||
        secondNumber === "" ||
        operator === ""
    ) {
        error.textContent =
            "Please enter a complete calculation";

        return;
    }

    try {

        const url =
            `/api/calculator/calculate?a=${firstNumber}&b=${secondNumber}&operator=${encodeURIComponent(operator)}`;

        const response = await fetch(url);

        const data = await response.json();

        if (!response.ok) {

            error.textContent = data.error;

            return;
        }

        display.textContent = data;

        firstNumber = data.toString();

        secondNumber = "";

        operator = "";

    } catch (exception) {

        error.textContent =
            "Unable to connect to server";
    }
}


// Clear calculator
function clearDisplay() {

    firstNumber = "";

    secondNumber = "";

    operator = "";

    display.textContent = "0";

    error.textContent = "";
}


// Delete last character
function deleteLast() {

    if (operator === "") {

        firstNumber =
            firstNumber.slice(0, -1);

        display.textContent =
            firstNumber || "0";

    } else {

        secondNumber =
            secondNumber.slice(0, -1);

        display.textContent =
            secondNumber || "0";
    }
}