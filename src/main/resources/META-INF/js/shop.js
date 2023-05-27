var Shop = {
		
		/**
		 * https://www.w3schools.com/js/js_json_syntax.asp
		 */
		cartData: function(productCode,productAmount,size) {
			var data = {};
			data["productCode"] = productCode;
			data["productAmount"] = productAmount;
			data["size"] = size;
			$.ajax({
				url: "/save-product-to-cart-with-ajax",
				type: "post",
				contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
				data: JSON.stringify(data), // object json -> string json
				
				dataType: "json", // dữ liệu từ web-service trả về là json.
				success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
					if(jsonResult.status == 200) {
						Swal.fire({
						  icon: 'success',
						  title: 'Thêm thành công',
						  showConfirmButton: false,
						  timer: 1000
						});
						$("#small-circle-cart").html(jsonResult.data);
						$( "#cart__product--table" ).load(window.location.href + " #cart__product--table" );
					} else {
						alert('loi');
					}
				},
				error: function (jqXhr, textStatus, errorMessage) { // error callback 
			        
			    }
			});
		},
		saveContact: function() {
			if(!ValidateEmail($("#email").val())) {
				Swal.fire({
							  icon: 'error',
							  title: 'Lỗi',
							  text: 'Email bạn nhập không đúng dạng vui lòng nhập lại',
							});
				return;
			}
			var data = {};
			data["email"] = $("#email").val();
			$.ajax({
				url: "/save-contact-with-ajax",
				type: "post",
				contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
				data: JSON.stringify(data), // object json -> string json
				dataType: "json", // dữ liệu từ web-service trả về là json.
				success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
					//alert(jsonResult.message);
					//$("#message").html(jsonResult.data);
					//$('#blogModal').modal('show');
					if(jsonResult.status == 200) {
						Swal.fire({
						  icon: 'success',
						  title: jsonResult.data,
						  showConfirmButton: false,
						  timer: 1500
						});
						 $("#email").val("");
					}
					else if(jsonResult.status == 404)
					{
						Swal.fire({
							  icon: 'warning',
							  title: 'Thông báo',
							  text: jsonResult.data,
							});
					}
					 else {
						Swal.fire({
							  icon: 'error',
							  title: 'Lỗi',
							  text: jsonResult.data,
							});
					}
				},
				error: function (jqXhr, textStatus, errorMessage) { // error callback 
			        
			    }
			});
		},
		cartDeleteData:function (id,size) {
		const swalWithBootstrapButtons = Swal.mixin({
			  customClass: {
			    confirmButton: 'btn btn-success btn-margin',
			    cancelButton: 'btn btn-danger btn-margin'
			  },
			  buttonsStyling: false
			})

			swalWithBootstrapButtons.fire({
			  title: 'Bạn có muốn xoá sản phẩm này không?',
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonText: 'Xoá',
			  cancelButtonText: 'Huỷ',
			  reverseButtons: true
			}).then((result) => {
			  if (result.isConfirmed) {
			var data = {};
			data["id"] = id;
			data["size"] = size;
			$.ajax({
				url: "/deletecartproduct",
				type: "delete",
				contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
				data: JSON.stringify(data), // object json -> string json
				dataType: "json", // dữ liệu từ web-service trả về là json.
				success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
					if(jsonResult.status == 200) {
						$( "#cart__product--table" ).load(window.location.href + " #cart__product--table" );
						$( "#small-circle-cart" ).load(window.location.href + " #small-circle-cart" );
					} else {
						alert('loi');
					}
				},
				error: function (jqXhr, textStatus, errorMessage) { // error callback 
			        
			    }
			});
			swalWithBootstrapButtons.fire(
			      'Đã xoá!',
			      'Sản phẩm đã được xoá thành công.',
			      'success'
			    )
			  } else if (
			    /* Read more about handling dismissals below */
			    result.dismiss === Swal.DismissReason.cancel
			  ) {
			    swalWithBootstrapButtons.fire(
			      'Đã huỷ',
			      'Sản phẩm được giữ nguyên',
			      'error'
			    )
			  }
			});
		}
}
async function cartData(productCode,productAmount,size){
	sizeList = size.split("-");
 	const inputOptions = new Promise((resolve) => {
		  setTimeout(() => {
		    resolve(
		      sizeList
		    )
		  }, 1000)
		})
		
		const { value: s } = await Swal.fire({
		  title: 'Chọn kích thước',
		  input: 'radio',
		  inputOptions: inputOptions,
		  inputValidator: (value) => {
		    if (!value) {
		      return 'You need to choose something!'
		    }
		  }
		})
		
		if (s) {
		 	Shop.cartData(productCode,productAmount,sizeList[s])
		}
 }
function ValidateEmail(mail) 
{
 if (/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(mail))
  {
    return (true)
  }
    return (false)
}

function replaceQueryParam(param, newval, search) {
    var regex = new RegExp("([?;&])" + param + "[^&;]*[;&]?");
    var query = search.replace(regex, "$1").replace(/&$/, '');
    return (query.length > 2 ? query + "&" : "?") + (newval ? param + "=" + newval : '');
}
function currentPage(id,TotalPages){
	if(id == 1) $('#prevPage').attr("disabled","disabled");
	else if(id == TotalPages) $('#nextPage').attr("disabled","disabled");
	$('#pagi-custom li').removeClass('active');
	$('#'+id).addClass('active');
}
function pmProductCart(productCode,productAmount,size) {
			var data = {};
			data["productCode"] = productCode;
			data["productAmount"] = productAmount;
			data["size"] = size;
			$.ajax({
				url: "/save-product-to-cart-with-ajax",
				type: "post",
				contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
				data: JSON.stringify(data), // object json -> string json
				
				dataType: "json", // dữ liệu từ web-service trả về là json.
				success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
					if(jsonResult.status == 200) {
						$("#small-circle-cart").html(jsonResult.data);
						$( "#cart__product--table" ).load(window.location.href + " #cart__product--table" );
					} else {
						alert('loi');
					}
},
				error: function (jqXhr, textStatus, errorMessage) { // error callback 
			        
			   }
		});
}