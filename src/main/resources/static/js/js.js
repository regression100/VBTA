
console.log("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");


// function update_account() {
//     var natija=document.getElementById("natija").value;
//     if (natija!==""){
//         alert(natija);
//     }
// }

function aa() {
    var a=document.getElementById("username").value;
    var b=document.getElementById("username").value;
    console.log(a);
    console.log(b);
    console.log(document.getElementById("login_page").getAttribute(' + ${a} +'));
    console.log(document.querySelectorAll('body')[0].getAttribute('+${a}+'));
}

// var theButton = document.getElementById('login_button');
// if (document.getElementById("username").value===null&&document.getElementById("password").value===null){
//     // document.getElementById("login_button").disabled="disabled";
//     theButton.style.display="none";
//     // document.getElementById("login_button").display="none";
// }
// else {
//     // document.getElementById("login_button").disabled="enabled";
//     // document.getElementById("login_button").display="block";
//     theButton.style.display="block";
// }
function transaction_scanner(account) {
    console.log(account)

}

function ValidatePassword() {
    // var data = eval('('+ '${account}' +')');
    var passtd = document.getElementById("passtd").value;
    // var x = document.getElementById("confrimPassword").value;
    // document.getElementById("demo").innerHTML = "You wrote: " + x;
    // var summa = document.getElementById("trans_summa").value;
    var password_ch = document.getElementById("password_ch").value;
    var password_change = document.getElementById("password_change").value;
    var new_password = document.getElementById("new_password").value;
    var confrim_new_password = document.getElementById("confrim_new_password").value;
    // var pin = document.getElementById("trans_pin").value;
    if (password_ch!==""||password_ch!==null){
        if (password_ch !== passtd) {
            // alert("Passwords do not match.");
            document.getElementById("password_ch").style.borderColor="red";
            document.getElementById("password_ch").style.color="red";
            document.getElementById("password_ch").setCustomValidity("Parol notogri")
            // return false;
        }
        else {
            document.getElementById("password_ch").style.borderColor="green";
            document.getElementById("password_ch").style.color="green";
            document.getElementById("password_ch").setCustomValidity("")
        }
    }
    if (password_change!==""||password_change!==null){
        if (password_change !== passtd) {
            // alert("Passwords do not match.");
            document.getElementById("password_change").style.borderColor="red";
            document.getElementById("password_change").style.color="red";
            document.getElementById("password_change").setCustomValidity("Parol notogri")
            // return false;
        }
        else {
            document.getElementById("password_change").style.borderColor="green";
            document.getElementById("password_change").style.color="green";
            document.getElementById("password_change").setCustomValidity("")
        }
    }
    if (new_password !== confrim_new_password) {
        // alert("Passwords do not match.");
        document.getElementById("confrim_new_password").style.borderColor="red";
        document.getElementById("confrim_new_password").style.color="red";
        document.getElementById("confrim_new_password").setCustomValidity("Parol notogri")
        // return false;
    }
    else {
        document.getElementById("confrim_new_password").style.borderColor="green";
        document.getElementById("confrim_new_password").style.color="green";
        document.getElementById("confrim_new_password").setCustomValidity("")
    }

    // return true;
}
function ValidatePin() {
    // var data = eval('('+ '${account}' +')');
    var pintd = document.getElementById("pintd").value;
    // var x = document.getElementById("confrimPassword").value;
    // document.getElementById("demo").innerHTML = "You wrote: " + x;
    // var summa = document.getElementById("trans_summa").value;
    // var password = document.getElementById("trans_password").value;
    var pin = document.getElementById("trans_pin").value;
    var deposit_pin = document.getElementById("deposit_pin").value;
    if (pin!==""||pin!==null){
        if (pin !== pintd) {
            // alert("Passwords do not match.");
            document.getElementById("trans_pin").style.borderColor="red";
            document.getElementById("trans_pin").style.color="red";
            document.getElementById("trans_pin").setCustomValidity("Pin notogri")
            // return false;
        }
        else {
            document.getElementById("trans_pin").style.borderColor="green";
            document.getElementById("trans_pin").style.color="green";
            document.getElementById("trans_pin").setCustomValidity("")
        }
    }
    if (deposit_pin!==""||deposit_pin!==null){
        if (deposit_pin !== pintd) {
            // alert("Passwords do not match.");
            document.getElementById("deposit_pin").style.borderColor="red";
            document.getElementById("deposit_pin").style.color="red";
            document.getElementById("deposit_pin").setCustomValidity("Pin notogri")
            // return false;
        }
        else {
            document.getElementById("deposit_pin").style.borderColor="green";
            document.getElementById("deposit_pin").style.color="green";
            document.getElementById("deposit_pin").setCustomValidity("")
        }
    }

}

function InvalidMsg(textbox) {
    if (textbox.value === '') {
        // alert("aaaaaaaaaa");
        textbox.setCustomValidity('Toʻldirish shart!');
    }
    else{
        if (textbox.id==="confrimPassword"){
            var password = document.getElementById("password").value;
            var confirmPassword = document.getElementById("confrimPassword").value;
            if (password !== confirmPassword) {
                // alert("Passwords do not match.");
                document.getElementById("confrimPassword").style.borderColor="red";
                document.getElementById("confrimPassword").style.color="red";
                document.getElementById("confrimPassword").setCustomValidity("Parol notogri")
                // return false;
            }
            else {
                document.getElementById("confrimPassword").style.borderColor="green";
                document.getElementById("confrimPassword").style.color="green";
                document.getElementById("confrimPassword").setCustomValidity("")
            }
        }
        else {
            if (textbox.id==="confrimPin"){
                var pin = document.getElementById("pin").value;
                var confrimPin = document.getElementById("confrimPin").value;
                if (pin !== confrimPin) {
                    // alert("Passwords do not match.");
                    document.getElementById("confrimPin").style.borderColor="red";
                    document.getElementById("confrimPin").style.color="red";
                    document.getElementById("confrimPin").setCustomValidity("Pin tasdiqlovi notoʻgʻri")
                    // return false;
                }
                else {
                    document.getElementById("confrimPin").style.borderColor="green";
                    document.getElementById("confrimPin").style.color="green";
                    document.getElementById("confrimPin").setCustomValidity("")
                }
            }
            else {
                if (textbox.id==="trans_summa"){
                    if (parseFloat(textbox.value)>1000){
                        document.getElementById("trans_summa").style.borderColor="red";
                        document.getElementById("trans_summa").style.color="red";
                        document.getElementById("trans_summa").setCustomValidity("Maksimal summa miqdori 1000!")

                    }
                    else {
                        document.getElementById("trans_summa").style.borderColor="green";
                        document.getElementById("trans_summa").style.color="green";
                        document.getElementById("trans_summa").setCustomValidity("")
                    }
                }
                else {

                    if (textbox.id==="deposit_summa"){
                        if (parseFloat(textbox.value)>1000){
                            document.getElementById("deposit_summa").style.borderColor="red";
                            document.getElementById("deposit_summa").style.color="red";
                            document.getElementById("deposit_summa").setCustomValidity("Maksimal summa miqdori 1000!")

                        }
                        else {
                            document.getElementById("deposit_summa").style.borderColor="green";
                            document.getElementById("deposit_summa").style.color="green";
                            document.getElementById("deposit_summa").setCustomValidity("")
                        }
                    }
                    else {
                        if (textbox.validity.typeMismatch) {

                            // alert("bbbbbbbbb");

                            textbox.setCustomValidity('Toʻgʻri kiriting!');
                        }
                        else
                        {
                            // alert("cccccccc");
                            textbox.setCustomValidity('');
                        }
                    }


                }

            }
        }

    }

        // return true;

}

function validatePassword(inputText) {
    var password=document.getElementById("password").value;
    if (password!==null&&password!==""){
        document.form.password.focus();
        return true;
    }
    else {
        alert("Parolni kiriting!");
        document.form.password.focus();
        return false;
    }
}


function tab(evt, name) {
    // console.log(document.getElementById("user_page").getAttribute(' + ${account.getUserName()} +'));
    // Declare all variables
    var i, tabcontent, tablinks;

    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    // Show the current tab, and add an "active" class to the button that opened the tab
    document.getElementById(name).style.display = "block";
    evt.currentTarget.className += " active";
}