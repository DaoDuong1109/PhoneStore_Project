$(document).ready(function () {
    $("#form_forgotPassword").validate({
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
                
            }
        },
        messages: {
            email: {
                required: "Nhập Email",
                maxlength: "Độ dài tối đa 50 ký tự",
                
            }
        },
    });

     $("#form_forgotPassword").submit(function (event) {
        event.preventDefault();
        let result = $("#form_forgotPassword").valid();
        if(result){
            var email=$("#email").val();
            console.log(email);
        }else{

        }
        console.log(result);

    })
});
