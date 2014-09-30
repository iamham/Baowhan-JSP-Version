/*
 *  Document   : readyRegister.js
 *  Author     : pixelcave
 *  Description: Custom javascript code used in Register page
 */

var ReadyRegister = function() {

    return {
        init: function() {
            /*
             *  Jquery Validation, Check out more examples and documentation at https://github.com/jzaefferer/jquery-validation
             */

            /* Register form - Initialize Validation */
            $('#progress-wizard').validate({
                onkeyup: true,
                errorClass: 'help-block animation-slideUp', // You can change the animation class for a different entrance animation - check animations page
                errorElement: 'div',
                errorPlacement: function(error, e) {
                    e.parents('.form-group > div').append(error);
                },
                highlight: function(e) {
                    $(e).closest('.form-group').removeClass('has-success has-error').addClass('has-error');
                    $(e).closest('.help-block').remove();
                },
                success: function(e) {
                    if (e.closest('.form-group').find('.help-block').length === 2) {
                        e.closest('.help-block').remove();
                    } else {
                        e.closest('.form-group').removeClass('has-success has-error');
                        e.closest('.help-block').remove();
                    }
                },
                rules: {
                    'username': {
                        required: true,
                        minlength: 3
                    },
                    'email': {
                        required: true,
                        email: true
                    },
                    'pwd1': {
                        required: true,
                        minlength: 5
                    },
                    'pwd2': {
                        required: true,
                        equalTo: '#pwd1'
                    },
                    'register-terms': {
                        required: true
                    }
                },
                messages: {
                    'username': {
                        required: 'โปรดกรอกชื่อผู้ใช้',
                        minlength: 'โปรดกรอกชื่อผู้ใช้'
                    },
                    'email': 'โปรดกรอกอีเมล์ที่ถูกต้อง',
                    'pwd1': {
                        required: 'โปรดกรอกรหัสผ่าน',
                        minlength: 'รหัสผ่านต้องมากกว่า 5 ตัวอักษร'
                    },
                    'pwd2': {
                        required: 'โปรยืนยันรหัสผ่าน',
                        minlength: 'รหัสผ่านต้องมากกว่า 5 ตัวอักษร',
                        equalTo: 'โปรดกรอกรหัสผ่านให้เหมือนกับด้านบน'
                    },
                    'register-terms': {
                        required: 'โปรดยอมรับข้อตกลงการใช้งาน !'
                    }
                }
            });
        }
    };
}();