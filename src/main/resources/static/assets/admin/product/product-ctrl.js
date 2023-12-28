app.controller("product-ctrl",function($scope,$http){
	$scope.items = [];
	$scope.cates = [];
	$scope.form = {},
	
	$scope.initialize = function(){
		// load product
		$http.get("/rest/products").then(resp=>{
			$scope.items = resp.data;
			$scope.items.forEach(item =>{
				item.createDate = new Date(item.createDate)
			})
		});
		
		// load categories
		$http.get("/rest/categories").then(resp=>{
			$scope.cates = resp.data;
			
		});
	}
	
	
	
	// Xóa form
	$scope.reset = function(){
		$scope.form = {
			createDate: new Date(),
			image: 'cloud-upload.jpg',
			available: true,
		}
	}
	
	// Hiển thị lên form
	$scope.edit = function(item){
		$scope.form=angular.copy(item);
		$(".nav-pills button:eq(0)").tab('show')
	}
	
	$scope.moveForm = function(){
		$(".nav-pills button:eq(0)").tab('show')
	}
	
	$scope.moveList = function(){
		$(".nav-pills button:eq(1)").tab('show')
	}
	
	// Thêm sản phẩm
	$scope.create = function(){
		var item = angular.copy($scope.form);
		$http.post(`/rest/products`,item).then(resp =>{
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.items.push(resp.data);
			$scope.reset();
			alert("Thêm mới sản phẩm thành công!");
		
		}).catch(error =>{
			alert("Lỗi thêm mới sản phẩm!");
			console.log("Error", error);
		});
	}
	
	// Cập nhật
	$scope.update = function(){
		var item = angular.copy($scope.form);
		$http.put(`/rest/products/${item.id}`,item).then(res=>{
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items[index] = item;
			alert("Cập nhật sản phẩm thành công!");
		}).catch(error => {
			alert("Lỗi cập nhật sản phẩm");
			console.log(error)
		});
	}
	
	// Xóa sản phẩm
	$scope.delete = function(item){
		$http.delete(`/rest/products/${item.id}`).then(resp =>{
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items.splice(index,1);
			$scope.reset();
			alert("Xóa sản phẩm thành công!");
		}).catch(error =>{
			alert("Lỗi xóa sản phẩm!");
			console.log(error);
		});
	}
	
	// Upload hình
	$scope.imageChanged = function(files){
		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/rest/upload/images',data,{
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
		}).then(resp => {
			$scope.form.image = resp.data.name;
		}).catch(error =>{
			alert("Lỗi upload hình ảnh");
			console.log("Error",error);
		})
	}
	
	$scope.pager = {
		page: 0,
		size: 5,
		get items(){
			var start = this.page * this.size;
			return $scope.items.slice(start, start + this.size);
		},
		get count(){
			return Math.ceil(1.0 * $scope.items.length / this.size);
		},
		first(){
			this.page = 0;
		},
		prev(){
			this.page--;
			if(this.page < 0){
				this.first();
			}
		},
		next(){
			this.page++;
			if(this.page >= this.count){
				this.last();
			}
		},
		last(){
			this.page = this.count-1;
		}
	}
	
	$scope.initialize();
	$scope.reset();
});