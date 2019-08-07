function addEventListenerOnPayWithCreditCardButton() {
    let payWithCreditCardButton = document.getElementById("pay-with-credit-card-button");
    payWithCreditCardButton.addEventListener("click", eventListenerOnPayWithCreditCardButton);
}


function eventListenerOnPayWithCreditCardButton() {
    let fname = document.getElementById("fname");
    let fullname = document.getElementById("fullname");

    let email = document.getElementById("email");
    let emailTitle = document.getElementById("email-title");

    let adr = document.getElementById("adr");
    let adrTitle = document.getElementById("adr-title");

    let city = document.getElementById("city");
    let cityTitle = document.getElementById("city-title");

    let state = document.getElementById("state");
    let stateTitle = document.getElementById("state-title");

    let zip = document.getElementById("zip");
    let zipTitle = document.getElementById("zip-title");

    let counter = 0;

    if (fname.value.length == 0) {
        fullname.innerHTML = `<label for="fname" id="fullname"><i class="fa fa-user"></i> Full Name<span class="billing-data-alert"> *min. 1 character</span></label>`;
    } else {
        fullname.innerHTML = `<label for="fname" id="fullname"><i class="fa fa-user"></i> Full Name</label>`;
        counter++;
    }
    if (email.value.length < 6) {
        emailTitle.innerHTML = `<label for="email"><i class="fa fa-envelope"></i> Email<span class="billing-data-alert"> *min. 6 characters</span></label>`;
    } else {
        emailTitle.innerHTML = `<label for="email"><i class="fa fa-envelope"></i> Email</label>`;
        counter++;
    }
    if (adr.value.length < 5) {
        adrTitle.innerHTML = `<label for="adr"><i class="fa fa-address-card-o"></i> Address <span class="billing-data-alert"> *min. 5 characters</span></label>`;
    } else {
        adrTitle.innerHTML = `<label for="adr"><i class="fa fa-address-card-o"></i> Address</label>`
        counter++;
    }
    if (city.value.length < 3) {
        cityTitle.innerHTML = `<label for="city"><i class="fa fa-institution"></i> City <span class="billing-data-alert"> *min. 3 characters</span></label>`;
    } else {
        cityTitle.innerHTML = `<label for="city"><i class="fa fa-institution"></i> City</label>`;
        counter++;
    }
    if (state.value.length < 2) {
        stateTitle.innerHTML = `<label for="state">State <span class="billing-data-alert"> *min. 2 characters</span></label>`;
    } else {
        stateTitle.innerHTML = `<label for="state">State</label>`;
        counter++;
    }
    if (zip.value.length < 3) {
        zipTitle.innerHTML = `<label for="zip">Zip <span class="billing-data-alert"> *min. 3 characters</span></label>`;
    } else {
        zipTitle.innerHTML = `<label for="zip">Zip</label>`;
        counter++;
    }
    if (counter == 6) {
        let payWithCreditCardButton = document.getElementById("pay-with-credit-card-button");
        payWithCreditCardButton.dataset.toggle = 'modal';

        let paypalContainer = document.getElementById("paypal-container");
        paypalContainer.className = "enabled";
    }

}


function addEventListenerOnPayButtonOnModal() {
    let payButton = document.getElementById("modal-button");
    payButton.addEventListener("click", eventListenerOnPayButton)
}


function eventListenerOnPayButton() {
    let cname = document.getElementById("cname");
    let nameTitle = document.getElementsByClassName("cardname-title");

    let ccnum = document.getElementById("ccnum");
    let ccnumTitle = document.getElementsByClassName("ccnum-title");

    let expmonth = document.getElementById("expmonth");
    let expmonthTitle = document.getElementsByClassName("expmonth-title");

    let expyear = document.getElementById("expyear");
    let expyearTitle = document.getElementsByClassName("expyear-title");

    let cvv = document.getElementById("cvv");
    let cvvTitle = document.getElementsByClassName("cvv-title");

    let counter = 0;

    if (cname.value < 1) {
        nameTitle[0].innerHTML = `<label for="cname">Name on Card <span class="billing-data-alert"> *min. 1 character</span></label>`;
    } else {
        nameTitle[0].innerHTML = `<label for="cname">Name on Card</label>`;
        counter++;
    }
    if (ccnum.value.length < 13 || ccnum.value.length > 16) {
        ccnumTitle[0].innerHTML = `<label for="ccnum">Credit card number <span class="billing-data-alert"> *min. 13 max. 16 digits</span></label>`;
    } else {
        ccnumTitle[0].innerHTML = `<label for="ccnum">Credit card number</label>`;
        counter++;
    }
    if (expmonth.value.length < 3) {
        expmonthTitle[0].innerHTML = `<label for="expmonth">Exp Month <span class="billing-data-alert"> *min 3 characters</span></label>`;
    } else {
        expmonthTitle[0].innerHTML = `<label for="expmonth">Exp Month</label>`;
        counter++;
    }
    if (expyear.value.length < 4) {
        expyearTitle[0].innerHTML = `<label for="expyear">Exp Year <span class="billing-data-alert"> *min. 4 digits</span></label>`;
    } else {
        expyearTitle[0].innerHTML = `<label for="expyear">Exp Year</label>`;
        counter++;
    }
    if (cvv.value.length < 3 || cvv.value.length > 4) {
        cvvTitle[0].innerHTML = `<label for="cvv">CVV <span class="billing-data-alert"> *min. 3 max. 4 digits</span></label>`;
    } else {
        cvvTitle[0].innerHTML = `<label for="cvv">CVV</label>`;
        counter++;
    }

    if (counter == 5) {
        location.href = "/payment";
    }
}


function main() {
    addEventListenerOnPayWithCreditCardButton();
    addEventListenerOnPayButtonOnModal();
}


main();