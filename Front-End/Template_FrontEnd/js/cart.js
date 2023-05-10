function numberWithCommas(x) {
  return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
// Lấy tất cả các nút "plus"
var changePriceButtonPlus = document.querySelectorAll(".plus");
// Lấy tất cả các nút "minus"
var changePriceButtonMinus = document.querySelectorAll(".minus");

// Lặp qua từng nút plus và thêm sự kiện nhấp chuột vào mỗi nút
changePriceButtonPlus.forEach(function (button) {
  button.addEventListener("click", function () {
    // Lấy các phần tử liên quan đến nút được nhấp
    var listItem = this.closest("tr");

    var numInput = listItem.querySelector("#numberInputProduct");
    var currentVal = numInput.value;
    var newVal = parseInt(currentVal) + 1;
    numInput.value = newVal;
    var itemPrice = parseInt(
      listItem.querySelector("#price").textContent.replace(/\,/g, "")
    );
    listItem.querySelector("#subtotal").textContent = numberWithCommas(
      parseInt(itemPrice) * newVal
    );
  });
});
// Lặp qua từng nút minus và thêm sự kiện nhấp chuột vào mỗi nút
changePriceButtonMinus.forEach(function (button) {
  button.addEventListener("click", function () {
    // Lấy các phần tử liên quan đến nút được nhấp
    var listItem = this.closest("tr");

    var numInput = listItem.querySelector("#numberInputProduct");
    var currentVal = numInput.value;

    var newVal = parseInt(currentVal) - 1;
    if (newVal < 1) {
      newVal = 1;
    }
    numInput.value = newVal;
    var itemPrice = parseInt(
      listItem.querySelector("#price").textContent.replace(/\,/g, "")
    );
    listItem.querySelector("#subtotal").textContent = numberWithCommas(
      parseInt(itemPrice) * newVal
    );
  });
});

// function add() {
//   var numInput = document.getElementById("numberInputProduct");
//   var currentVal = numInput.value;
//   var newVal = parseInt(currentVal) + 1;
//   numInput.value = newVal;
//   var price=parseInt(document.getElementById("priceItem").textContent.replace(/\,/g, ""));
//         document.getElementById("subtotalItem").textContent=numberWithCommas(parseFloat(price)*newVal);

// }

// function subtract() {
//   var numInput = document.getElementById("numberInputProduct");
//   var currentVal = numInput.value;
//   var newVal = parseInt(currentVal) - 1;
//   if (newVal < 1) {
//     newVal = 1;
//   }
//   numInput.value = newVal;
//   var price=parseInt(document.getElementById("priceItem").textContent.replace(/\,/g, ""));
//   document.getElementById("subtotalItem").textContent=numberWithCommas(parseFloat(price)*newVal);

// }
