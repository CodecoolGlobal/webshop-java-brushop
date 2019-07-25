function addEventListenerOnModalButton() {
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
        fullname.innerHTML = `<label for="fname" id="fullname"><i class="fa fa-user"></i> Full Name<div class="billing-data-alert">minimum 1 character</div></label>`;
    } else {
        fullname.innerHTML = `<label for="fname" id="fullname"><i class="fa fa-user"></i> Full Name</label>`;
        counter++;
    }
    if (email.value.length < 6) {
        emailTitle.innerHTML = `<label for="email"><i class="fa fa-envelope"></i> Email<div class="billing-data-alert">minimum 6 character</div></label>`;
    } else {
        emailTitle.innerHTML = `<label for="email"><i class="fa fa-envelope"></i> Email</label>`;
        counter++;
    }
    if (adr.value.length < 5) {
        adrTitle.innerHTML = `<label for="adr"><i class="fa fa-address-card-o"></i> Address <div class="billing-data-alert">minimum 5 character</div></label>`;
    } else {
        adrTitle.innerHTML = `<label for="adr"><i class="fa fa-address-card-o"></i> Address</label>`
        counter++;
    }
    if (city.value.length < 3) {
        cityTitle.innerHTML = `<label for="city"><i class="fa fa-institution"></i> City <div class="billing-data-alert">minimum 3 character</div></label>`;
    } else {
        cityTitle.innerHTML = `<label for="city"><i class="fa fa-institution"></i> City</label>`;
        counter++;
    }
    if (state.value.length < 2) {
        stateTitle.innerHTML = `<label for="state">State <div class="billing-data-alert">minimum 2 character</div></label>`;
    } else {
        stateTitle.innerHTML = `<label for="state">State</label>`;
        counter++;
    }
    if (zip.value.length < 3) {
        zipTitle.innerHTML = `<label for="zip">Zip <div class="billing-data-alert">minimum 3 character</div></label>`;
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


function main() {
    addEventListenerOnModalButton();
}


main();