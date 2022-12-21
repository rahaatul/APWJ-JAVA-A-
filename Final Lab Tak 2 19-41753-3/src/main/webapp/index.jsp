<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Currency Converter</title>

    <link rel="stylesheet"
          href=
                  "https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src=
                    "https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
    </script>
    <script src=
                    "https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js">
    </script>
    <script src=
                    "https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js">
    </script>

    <link rel="preconnect"
          href="https://fonts.gstatic.com">
    <link href=
                  "https://fonts.googleapis.com/css2?family=Amiri&family=Lobster&family=Pacifico&display=swap"
          rel="stylesheet">

    <!-- linking style.css file-->
    <link rel="stylesheet" href="style.css">
</head>

<body>

<!-- Currency Converter -->
<h1 class="heading text-center display-2">
    Currency Converter</h1>

<hr>
<div class="container">

    <div class="main">

        <div class="form-group">
            <label for="oamount">
                Amount to Convert :
            </label>
            <input type="text"
                   class="form-control searchBox"
                   placeholder="0.00"
                   id="oamount">
        </div>

        <div class="row">
            <div class="col-sm-6">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">From</span>
                    </div>
                    <select class="form-control from" id="sel1">
                        <option value="">Select One …</option>
                        <option value="USD">USD</option>

                    </select>
                </div>
            </div>

            <div class="col-sm-6">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">To</span>
                    </div>
                    <select class="form-control to" id="sel2">
                        <option value="">Select One …</option>
                        <option value="BDT">BDT</option>

                    </select>
                </div>
            </div>
        </div>

        <div class="text-center">

            <!-- convert button -->
            <button class="btn btn-primary convert m-2"
                    type="submit">
                Convert
            </button>

            <!-- reset button -->
            <button class="btn btn-primary m-2"
                    onclick="clearVal()">
                Reset
            </button>
        </div>

    </div>

    <div id="finalAmount" class="text-center">

        <!-- Display the converted amount -->
        <h2>Result :
            <span class="finalValue"
                  style="color:green;">
		</span>
        </h2>
    </div>
</div>

<!-- linking script.js file -->
<script src="script.js"></script>
</body>

</html>



//css



body {
background-color: aliceblue;
background-position: center;
background-size: cover;
background-attachment: fixed;
background-repeat: no-repeat;
}

.heading {
font-family: 'Pacifico', cursive;
margin: 35px auto 20px;
}

hr {
border-top: 2px solid black;
width: 40%;
margin-bottom: 55px;
}

.main {
width: 50vw;
margin: auto;
padding: 30px;
border-radius: 5px;
background-color: rgba(0, 0, 0, 0.5);
color: white;
}

label {
font-size: 20px;
}

.btn {
width: 200px;
}

#finalAmount {
font-family: 'Lobster', cursive;
display: none;
margin: 50px auto;
}

#finalAmount h2 {
font-size: 50px;
}

.finalValue {
font-family: 'Amiri', serif;
}

@media (max-width: 768px) {
hr {
width: 60%;
}
.main {
width: 100%;
}
}

@media (max-width: 400px) {
.heading {
font-size: 60px;
}
hr {
width: 75%;
}
#finalAmount h2, .finalValue {
font-size: 40px;
}
}




//javascript

// include api for currency change
const api = "https://api.exchangerate-api.com/v4/latest/USD";

// for selecting different controls
var search = document.querySelector(".searchBox");
var convert = document.querySelector(".convert");
var fromCurrecy = document.querySelector(".from");
var toCurrecy = document.querySelector(".to");
var finalValue = document.querySelector(".finalValue");
var finalAmount = document.getElementById("finalAmount");
var resultFrom;
var resultTo;
var searchValue;

// Event when currency is changed
fromCurrecy.addEventListener('change', (event) => {
resultFrom = `${event.target.value}`;
});

// Event when currency is changed
toCurrecy.addEventListener('change', (event) => {
resultTo = `${event.target.value}`;
});

search.addEventListener('input', updateValue);

// function for updating value
function updateValue(e) {
searchValue = e.target.value;
}

// when user clicks, it calls function getresults
convert.addEventListener("click", getResults);

// function getresults
function getResults() {
fetch(`${api}`)
.then(currency => {
return currency.json();
}).then(displayResults);
}

// display results after convertion
function displayResults(currency) {
let fromRate = currency.rates[resultFrom];
let toRate = currency.rates[resultTo];
finalValue.innerHTML =
((toRate / fromRate) * searchValue).toFixed(2);
finalAmount.style.display = "block";
}

// when user click on reset button
function clearVal() {
window.location.reload();
document.getElementsByClassName("finalValue").innerHTML = "";
};
