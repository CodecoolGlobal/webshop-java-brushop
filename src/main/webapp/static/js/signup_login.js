function disableSignUpButton() {
    const signUpButton = document.getElementById("sign-up-button");
    signUpButton.addEventListener("click", eventListenerOnSignUpButton);
}


function eventListenerOnSignUpButton() {
    console.log("clicked");
}


function main() {
    disableSignUpButton();
}


main();
