//cart=[
//      {product:{id:1, name: 'sp1', colorId:1, colorName:'Đen', price: 232}, quantity}
//]
// $(document).ready(function() {
let cart = [];
var product = {};
var total = 0;
window.onload = function () {
  loadTotalProduct();
  showCart();
  // localStorage.removeItem('cart');
  changePrice();

};

function changePrice() {
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
      var amount = parseInt(listItem.querySelector("#amountItem").value);
      var currentVal = numInput.value;

      var newVal = parseInt(currentVal) + 1;
      //check max
      if(newVal>amount){
          numInput.value = amount;
        }
        else{
          numInput.value = newVal;
      }
      var itemPrice = parseInt(
        listItem.querySelector("#price").textContent.replace(/\,/g, "")
      );
      listItem.querySelector("#subtotal").textContent = numberWithCommas(
        parseInt(itemPrice) * numInput.value
      );
      //save into localStorage
      var productId = listItem.querySelector("#productIdItem").value;
      var colorId = listItem.querySelector("#colorIdItem").value;
     
      var cart = JSON.parse(localStorage.getItem("cart"));
      if (cart != null) {
        let item = cart.find(
          (c) => c.data.id == productId && c.data.colorId == colorId
        );

        if (item) {
            if(newVal>amount){
                item.quantity = amount;
            }
            else{
                item.quantity=newVal;
            }
        }
      }
      localStorage.setItem("cart", JSON.stringify(cart));
      loadTotalProduct();
      
    });
  });
  
  // Lặp qua từng nút minus và thêm sự kiện nhấp chuột vào mỗi nút
  changePriceButtonMinus.forEach(function (button) {
    button.addEventListener("click", function () {
      // Lấy các phần tử liên quan đến nút được nhấp
      var listItem = this.closest("tr");
      var amount = parseInt(listItem.querySelector("#amountItem").value);
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
        parseInt(itemPrice) * numInput.value
      );
      //save into localStorage
      var productId = listItem.querySelector("#productIdItem").value;
      var colorId = listItem.querySelector("#colorIdItem").value;
     
      var cart = JSON.parse(localStorage.getItem("cart"));
      if (cart != null) {
        let item = cart.find(
          (c) => c.data.id == productId && c.data.colorId == colorId
        );

        if (item) {
          item.quantity = newVal;
        }
      }
      localStorage.setItem("cart", JSON.stringify(cart));
      loadTotalProduct();
      
    });
  });
}
function addToCart(productId, colorId, quantity) {
  let storage = localStorage.getItem("cart");
  if (storage) {
    cart = JSON.parse(storage);
  }
  var url =
    "http://localhost:9090/product/findDetailProduct?id=" +
    productId +
    "&color=" +
    colorId;

  var p = [];
  $.get(url, function (data) {
    // Hành động khi lấy dữ liệu thành công
    // Gọi callback function để xử lý dữ liệu
    myCallbackFunction(data);
  });

  function myCallbackFunction(data) {
    let item = cart.find(
      (c) => c.data.id == productId && c.data.colorId == colorId
    );
   
    // if (item.quantity <= data.amount) {
        if (item) {
            console.log("sl: "+quantity);
    //       console.log("item");
    //       console.log(item);
    //     // if (quantity > 1) {
    //     //     item.quantity=(item.quantity+quantity)>data.amount?data.amount:(item.quantity+quantity);
    //     // }
    //     // else{
        if(quantity>1){
            item.quantity += quantity;
        }
        else{
            item.quantity += 1;
        }

        if(item.quantity>item.data.amount){
            item.quantity=item.data.amount;
        }
        console.log(item);
    //     // }
      } else {
            cart.push({ data, quantity: 1 });
      }
    // }
    localStorage.setItem("cart", JSON.stringify(cart));
    loadTotalProduct();

  }
}

function loadTotalProduct() {
  var cart = JSON.parse(localStorage.getItem("cart"));
  if (cart != null) {
    var t = 0;
    cart.forEach((e) => {
      t += e.quantity;
    });
    document.getElementById("product-count").innerHTML = t;
  } else {
    document.getElementById("product-count").innerHTML = 0;
  }
}

function showCart() {
  var cartBody = document.getElementById("cartBody");
  cartBody.innerHTML = "";
  let storage = localStorage.getItem("cart");
  if (storage) {
    cart = JSON.parse(storage);
  }
  cart.map((item) => {
    cartBody.innerHTML +=
      `
            <tr class="cart_item">
                <td class="product-remove">
                    <input type="text" hidden name="productIdItem" id="productIdItem" value="${item.data.id}">
                    <input type="text" hidden name="colorIdItem" id="colorIdItem" value="${item.data.colorId} ">
                    <input type="text" hidden name="amountItem" id="amountItem" value="${item.data.amount} ">
                    <a title="Remove this item" class="remove" onclick="removeItem(${item.data.id}, ${item.data.colorId})">×</a>
                </td>
            
                <td class="product-name">
                    <a href="single-product.html?id=` +
      item.data.id +
      `&color=` +
      item.data.colorId +
      `&category=` +
      item.data.category.id +
      `">${item.data.productName}</a>
                </td>
                <td class="product-name">
                    <span>${item.data.colorName}</span>
                </td>
            
                <td class="product-price">
                    <span class="amount" id="price">${numberWithCommas(
                      item.data.price
                    )}</span> VNĐ
                </td>
            
                <td class="product-quantity">
                    <div class="quantity buttons_added">
                        <input type="button" class="minus button-c" value="-"
                            >
            
                        <input type="number" readonly size="4" class="input-text qty text"
                            style="text-align: center;" title="Qty" value="${
                              item.quantity
                            }" min="1"
                            step="1" id="numberInputProduct">
            
                        <input type="button" class="plus button-c" value="+"
                            >
                    </div>
                </td>
            
                <td class="product-subtotal">
                    <span class="amount" id="subtotal" >${numberWithCommas(
                      parseInt(item.data.price * item.quantity)
                    )}</span> VNĐ
                </td>
        </tr>`;
  });
  document.getElementById("cartBody").innerHTML += `<tr>
    <td class="actions" colspan="6">
    
      <input
        type="submit"
        value="Thanh Toán"
        name="proceed"
        class="checkout-button button alt wc-forward button-c"
        />
        
        </td>
        </tr>`;
        
        $("#checkout-form").submit(function (event) {
            event.preventDefault();
            let storage = localStorage.getItem("user");
            if (storage) {
                window.location.href="/Template_FrontEnd/checkout.html";
            }
            else{
                alert("Đăng nhập trước khi đặt hàng!!!")
            }
        })
}
//xoa san pham trong gio hang
function removeItem(productId, colorId) {
  let storage = localStorage.getItem("cart");
  if (storage) {
    cart = JSON.parse(storage);
  }
  //loc san pham
  cart = cart.filter(
    (c) => !(c.data.id === productId && c.data.colorId === colorId)
  );
  localStorage.setItem("cart", JSON.stringify(cart));
  showCart();
  loadTotalProduct();
 
  changePrice();
}
// format price
function numberWithCommas(x) {
  return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
// checkout-form
// })
