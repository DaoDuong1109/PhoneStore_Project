$(document).ready(function () {
    $("#form_login").validate({
        errorClass: "error-class",
        validClass: "valid-class",
        errorElement: "div",
        errorPlacement: function (error, element) {
            if (element.parent(".input-group").length) {
                error.insertAfter(element.parent());
            } else {
                error.insertAfter(element);
            }
        },
        onError: function () {
            $(".input-group.error-class")
                    .find(".help-block.form-error")
                    .each(function () {
                        $(this).closest(".form-group").addClass("error-class").append($(this));
                    });
        },
        rules: {
            email: {
                required: true,
                maxlength: 50,

            },
            password: {
                required: true,
                minlength: 8,
                maxlength: 32,
            },
            captcha: {
                required: true,
            }
        },
        messages: {
            email: {
                required: "Nhập Email",
                maxlength: "Độ dài tối đa 50 ký tự",

            },
            password: {
                required: "Nhập Password",
                minlength: "Độ dài tối thiểu 8 ký tự",
                maxlength: "Độ dài tối đa 32 ký tự",
            },
            captcha: {
                required: "Enter Captcha",
            }
        },
    });

    $(document).click("#save", function () {
        let result = $("#form_login").valid();
        console.log(result);
    });
});
