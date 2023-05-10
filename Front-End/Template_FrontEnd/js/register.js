$(document).ready(function () {
  $("#register").validate({
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
          $(this)
            .closest(".form-group")
            .addClass("error-class")
            .append($(this));
        });
    },
    rules: {
      userName: {
        required: true,
        maxlength: 50,
      },
      email: {
        required: true,
        maxlength: 50,
        email: true,
      },
      password: {
        required: true,
        minlength: 8,
        maxlength: 32,
      },
      confirmPassword: {
        required: true,
        maxlength: 32,
        equalTo: "#password",
      },
    },
    messages: {
      userName: {
        required: "Nhập tên người dùng",
        maxlength: "Độ dài tối đa 50 ký tự",
      },
      email: {
        required: "Nhập Email",
        maxlength: "Độ dài tối đa 50 ký tự",
      },
      password: {
        required: "Nhập mật khẩu",
        minlength: "Độ dài tối thiểu 8 ký tự",
        maxlength: "Độ dài tối đa 32 ký tự",
      },
      confirmPassword: {
        required: "Nhập xác nhận mật khẩu",
        maxlength: "Độ dài tối đa 32 ký tự",
        equalTo: "Không trùng lặp với mật khẩu đã nhập",
      },
    },
  });
  $("#register").submit(function (event) {
    event.preventDefault();
    let result = $("#register").valid();
    if (result) {
      //   var username = $("#userName").val();
      //   var email = $("#email").val();
      //   var pass = $("#password").val();

      var form = {
        fullname: $("#userName").val(),
        email: $("#email").val(),
        phone: "",
        address: "",
        password: $("#password").val(),
        roleEntity: {
          id: 4,
        },
      };

      $.ajax({
        type: "POST",
        url: "http://localhost:9090/user/createUser",
        data: JSON.stringify(form),
        dataType: "json",
        contentType: "application/json",
        encode: true,
        success: function (data) {
          alert("Đăng ký thành công!");
          localStorage.setItem("user", JSON.stringify(data));
          window.location.href = "/Template_FrontEnd/index.html";
        },
        error: function () {
          alert("Đang ký thất bại!!!");
        },
      });
    }
  });
  // $(document).on("click", "#save", function () {
  // });
});
