/*global $, document, window, setTimeout, navigator, console, location*/
console.log("hey")
$(document).ready(function () {

    'use strict';

    var usernameError = true,
        emailError    = true,
        passwordError = true;

    
    // Label effect
    $('input').focus(function () {
        $(this).siblings('label').addClass('active');
    });

    // Form validation
    $('input').blur(function () {

        // User Name
        if ($(this).hasClass('name')) {
            if ($(this).val().length === 0) {
                $(this).siblings('span.error').text('USER NAME CANNOT BE EMPTY').fadeIn().parent('.form-group').addClass('hasError');
                usernameError = true;
            } 
             else {
                $(this).siblings('.error').text('').fadeOut().parent('.form-group').removeClass('hasError');
                usernameError = false;
            }
        }
    

        // PassWord
        if ($(this).hasClass('pass')) {
            if ($(this).val().length < 8) {
                $(this).siblings('span.error').text('PASSWORD CANNOT BE EMPTY').fadeIn().parent('.form-group').addClass('hasError');
                passwordError = true;
            } else {
                $(this).siblings('.error').text('').fadeOut().parent('.form-group').removeClass('hasError');
                passwordError = false;
            }
        }

        

        // label effect
        if ($(this).val().length > 0) {
            $(this).siblings('label').addClass('active');
        } else {
            $(this).siblings('label').removeClass('active');
        }
    });



    // Reload page
    $('a.profile').on('click', function () {
        location.reload(true);
    });


});
