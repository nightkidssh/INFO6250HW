/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validate(form){
    var inputs = document.getElementsByTagName("input");
    for (var i = 0; i<inputs.length; i++){
        if (inputs[i].value.match(/[^\@\.\dA-Za-z ]/)){
            alert("Please check all the inputs, do not enter SPECIAL charactor");
            return false;
         }
     }    
    
    return true;
    
}
