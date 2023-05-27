window.addEventListener("load", event => {

    // Expand Left Side
    var icon = document.querySelector('.left__icon'),
        left = document.querySelector('.left');

    icon.addEventListener('click', expand);

    function expand() {
        if (left.classList.contains('show')) {
            left.classList.remove('show')
        } else {
            left.classList.add('show')
        }
    }

    var menuItem = document.querySelectorAll('.left__menuItem');

    menuItem.forEach(function (el) {
        el.addEventListener("click", openMenu);
    });

    function openMenu(event) {
        var currentmenuItem = event.currentTarget;

        if (currentmenuItem.classList.contains('open')) {
            currentmenuItem.classList.remove('open');
        } else {
            currentmenuItem.classList.add('open');
        }
    };
})  
//ajax
//delete product
 function deletePrd(id) {
 	const swalWithBootstrapButtons = Swal.mixin({
			  customClass: {
			    confirmButton: 'btn-ok',
			    cancelButton: 'btn-cancel'
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
			
			$.ajax({
				url: "/admin/deleteproduct",
				type: "delete",
				contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
				data: JSON.stringify(data), // object json -> string json
				dataType: "json", // dữ liệu từ web-service trả về là json.
				success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
					if(jsonResult.status == 200) {
						$( "#product__table" ).load(window.location.href + " #product__table" );
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
//delete category
function deleteCate(id) {
 	const swalWithBootstrapButtons = Swal.mixin({
			  customClass: {
			    confirmButton: 'btn-ok',
			    cancelButton: 'btn-cancel'
			  },
			  buttonsStyling: false
			})

			swalWithBootstrapButtons.fire({
			  title: 'Bạn có muốn xoá danh mục này không?',
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonText: 'Xoá',
			  cancelButtonText: 'Huỷ',
			  reverseButtons: true
			}).then((result) => {
			  if (result.isConfirmed) {
			var data = {};
			data["id"] = id;
			
			$.ajax({
				url: "/admin/deletecategory",
				type: "delete",
				contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
				data: JSON.stringify(data), // object json -> string json
				dataType: "json", // dữ liệu từ web-service trả về là json.
				success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
					if(jsonResult.status == 200) {
						$( "#cate__table" ).load(window.location.href + " #cate__table" );
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
//delete sale order
function deleteOrder(id) {
 	const swalWithBootstrapButtons = Swal.mixin({
			  customClass: {
			    confirmButton: 'btn-ok',
			    cancelButton: 'btn-cancel'
			  },
			  buttonsStyling: false
			})

			swalWithBootstrapButtons.fire({
			  title: 'Bạn có muốn xoá đơn đặt hàng này không?',
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonText: 'Xoá',
			  cancelButtonText: 'Huỷ',
			  reverseButtons: true
			}).then((result) => {
			  if (result.isConfirmed) {
			var data = {};
			data["id"] = id;
			
			$.ajax({
				url: "/admin/deleteorder",
				type: "delete",
				contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
				data: JSON.stringify(data), // object json -> string json
				dataType: "json", // dữ liệu từ web-service trả về là json.
				success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
					if(jsonResult.status == 200) {
						$( "#refreshTable" ).load(window.location.href + " #refreshTable" );
					} else {
						alert('loi');
					}
				},
				error: function (jqXhr, textStatus, errorMessage) { // error callback 
			        
		 }
	});
	swalWithBootstrapButtons.fire(
			      'Đã xoá!',
			      'Đơn hàng đã được xoá thành công.',
			      'success'
			    )
			  } else if (
			    /* Read more about handling dismissals below */
			    result.dismiss === Swal.DismissReason.cancel
			  ) {
			    swalWithBootstrapButtons.fire(
			      'Đã huỷ',
			      'Đơn hàng được giữ nguyên',
			      'error'
			    )
			  }
			});
}
//delete customer
function deleteCustomer(id) {
 	const swalWithBootstrapButtons = Swal.mixin({
			  customClass: {
			    confirmButton: 'btn-ok',
			    cancelButton: 'btn-cancel'
			  },
			  buttonsStyling: false
			})

			swalWithBootstrapButtons.fire({
			  title: 'Bạn có muốn xoá khách hàng này không?',
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonText: 'Xoá',
			  cancelButtonText: 'Huỷ',
			  reverseButtons: true
			}).then((result) => {
			  if (result.isConfirmed) {
			var data = {};
			data["id"] = id;
			
			$.ajax({
				url: "/admin/deletecustomer",
				type: "delete",
				contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
				data: JSON.stringify(data), // object json -> string json
				dataType: "json", // dữ liệu từ web-service trả về là json.
				success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
					if(jsonResult.status == 200) {
						$( "#refreshTable" ).load(window.location.href + " #refreshTable" );
					} else {
						alert('loi');
					}
				},
				error: function (jqXhr, textStatus, errorMessage) { // error callback 
			        
		 }
	});
	swalWithBootstrapButtons.fire(
			      'Đã xoá!',
			      'khách hàng đã được xoá thành công.',
			      'success'
			    )
			  } else if (
			    /* Read more about handling dismissals below */
			    result.dismiss === Swal.DismissReason.cancel
			  ) {
			    swalWithBootstrapButtons.fire(
			      'Đã huỷ',
			      'khách hàng được giữ nguyên',
			      'error'
			    )
			  }
			});
}
//set pay
function setPay(id) {
 	const swalWithBootstrapButtons = Swal.mixin({
			  customClass: {
			    confirmButton: 'btn-ok',
			    cancelButton: 'btn-cancel'
			  },
			  buttonsStyling: false
			})

			swalWithBootstrapButtons.fire({
			  title: 'Đơn hàng này đã thanh toán chưa?',
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonText: 'Rồi',
			  cancelButtonText: 'Chưa',
			  reverseButtons: true
			}).then((result) => {
			  if (result.isConfirmed) {
			var data = {};
			data["id"] = id;
			
			$.ajax({
				url: "/admin/setpay",
				type: "PUT",
				contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
				data: JSON.stringify(data), // object json -> string json
				dataType: "json", // dữ liệu từ web-service trả về là json.
				success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
					if(jsonResult.status == 200) {
						$( "#refreshTable" ).load(window.location.href + " #refreshTable" );
					} else {
						alert('loi');
					}
				},
				error: function (jqXhr, textStatus, errorMessage) { // error callback 
			        
		 }
	});
	swalWithBootstrapButtons.fire(
			      'Đã xoá!',
			      'Đơn hàng đã được thanh toán',
			      'success'
			    )
			  } else if (
			    /* Read more about handling dismissals below */
			    result.dismiss === Swal.DismissReason.cancel
			  ) {
			    swalWithBootstrapButtons.fire(
			      'Đã huỷ',
			      'Đơn hàng được giữ nguyên',
			      'error'
			    )
			  }
			});
}
//delete slide 
function deleteSlide(id) {
 	const swalWithBootstrapButtons = Swal.mixin({
			  customClass: {
			    confirmButton: 'btn-ok',
			    cancelButton: 'btn-cancel'
			  },
			  buttonsStyling: false
			})

			swalWithBootstrapButtons.fire({
			  title: 'Bạn có muốn xoá danh mục này không?',
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonText: 'Xoá',
			  cancelButtonText: 'Huỷ',
			  reverseButtons: true
			}).then((result) => {
			  if (result.isConfirmed) {
			var data = {};
			data["id"] = id;
			$.ajax({
				url: "/admin/delete-slide",
				type: "delete",
				contentType: "application/json", // dữ liệu gửi lên web-service có dạng là json.
				data: JSON.stringify(data), // object json -> string json
				dataType: "json", // dữ liệu từ web-service trả về là json.
				success: function(jsonResult) { // được gọi khi web-service trả về dữ liệu.
					if(jsonResult.status == 200) {
						$( "#right__slides" ).load(window.location.href + " #right__slides" );
					} else {
						alert('loi');
					}
				},
				error: function (jqXhr, textStatus, errorMessage) { // error callback 
			        
		 }
	});swalWithBootstrapButtons.fire(
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