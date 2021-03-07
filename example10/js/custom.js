$(document).ready(function(){
    var modal = $('.element-modalBuy');
    var btn = $('.click_addCart');
    var span = $('.icon-close-modal, .continueBuy');
    var delay = 300;
    var src = $(this).attr("src");
    var btn_mobile = $('.menu-mobile');
    var menu_mobile = $('.menu-mobile-bar');
    var open_menu_mobile = $('.open_sidebar_menu');
    var btn_quick_view = $('.click-quick-view');
    var close_quick_view = $('.close_quick_view');
    var modal_quickView = $('.element-quick-view')


  btn.click(function () {
    modal.fadeIn(delay);
    var src = $(this).closest('div').find('img').attr("src");
    console.log(src);
    $('#popup-img').attr('src',src);
  });

  span.click(function () {
    modal.fadeOut(delay);
  });

  $(window).on('click', function (e) {
    if ($(e.target).is('.element-modalBuy, .modal-addCart')) {
      modal.fadeOut(delay);
    }
  });
  
  //quick view
  btn_quick_view.click(function(){
    modal_quickView.fadeIn(delay);
    console.log('adsf');
  });
  close_quick_view.click(function(){
    modal_quickView.fadeOut(delay);
  })

  $(window).on('click', function (e) {
    if ($(e.target).is('.element-quick-view')) {
      modal_quickView.fadeOut(delay);
    }
  });

 $(".img-small-1 img").click(function(){
        var src_1 = $(this).attr("src");
        $('#big-img').attr('src',src_1);
    })

  //mobile
  btn_mobile.click(function(){
    menu_mobile.fadeIn();
    open_menu_mobile.show(300);
  });

  $(window).on('click', function (e) {
    if ($(e.target).is('.menu-mobile-bar')) {
      menu_mobile.fadeOut(delay);
    }
  });

  $(window).scroll(function(){ 
    if ($(this).scrollTop() > 100) { 
        $('.btn_scrollTop').show(300);  
    } else {     
        $('.btn_scrollTop').hide(300); 
    } 
}); 

  $('.btn_scrollTop').click(function(){ 
      $("html, body").animate({ scrollTop: 0 }, 600); 
      return false; 
  }); 
    
  window.onscroll = function() {myFunction()};
	  
  var header = document.getElementById("main_header");
  var sticky = header.offsetTop;
  
  function myFunction() {
  if (window.pageYOffset > sticky) {
    header.classList.add("sticky");
  } else {
    header.classList.remove("sticky");
  }
  }
  
  //validate form
  function checksignUp() {
    var firstName = $('.firstName').val();
    var lastName = $('.lastName').val();
    var user = $('.user').val();
    var regx_email = /^[\w\-\.]+@[\w\-]+\.[a-z]{2,3}$/;
    var password = $('.password').val();
    var check = true;
    $(".err-firstName").text('');
    $(".err-lastName").text('');
    $(".err-password").text('');
    $(".err-user").text('');
    if(lastName == "" ){
      $(".err-lastName").text('Vui lòng nhập tên đầy đủ');
      check = false;
    }
    if(firstName == "" ){
      $(".err-firstName").text('Vui lòng nhập tên đầy đủ');
      check = false;
    }

    if(user == ""){
      $(".err-user").text('Vui lòng nhập email!');
			check = false;
    }  else {
			if (!regx_email.test(user)) {
				$(".err-user").text('Email sai định dạng!');
				check = false;
			}
		}
		

    if (password == "") {
			$(".err-pass").text('Vui lòng mật khẩu!');
			check = false;
		} else {
			$(".err-pass").text('');
		}
		return check;
  }

  $(".user, .password, .firstName, .lastName").blur(function(event) {
		checksignUp();
  });
  
  $(".submit-signUp").click(function(){
    if(checksignUp()){
      alert("Đăng ký thành công");
    }
  })



})


