/**
 * Created by Prashant on 14-Jul-17.
 */

function check() {
    var input = document.getElementById('cnfrmPass').value;
    if (input != document.getElementById('pass').value) {
        /*input.setCustomValidity('Password Must be Matching.');*/
        alert("Password and Confirm Password should Match");
        return false;
    }

}