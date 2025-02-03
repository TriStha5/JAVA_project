$(function(){
    $("#form-register").validate({
        messages: {
            name: {
                required: "Please provide a Name"
            },
            address: {
                required: "Please provide an Address"
            },
            type: {
                required: "Please provide a Type"
            },
            url: {
                required: "Please provide an Url"
            },
            discription: {
                required: "Please provide a Discription"
            },
            logo: {
                required: "Please provide a Logo"
            },
            image: {
                required: "Please provide an Image"
            }
        }
    });
    $("#form-total").steps({
        headerTag: "h2",
        bodyTag: "section",
        transitionEffect: "fade",
        // enableAllSteps: true,
        autoFocus: true,
        transitionEffectSpeed: 500,
        titleTemplate : '<div class="title">#title#</div>',
        labels: {
            previous : 'Back',
            next : '<i class="fa-solid fa-arrow-right"></i>',
            finish : '<i type="submit" class="fa-solid fa-check"></i>',
            current : ''
        },
        onStepChanging: function (event, currentIndex, newIndex) { 
            var name = $('#name').val();
            var address = $('#address').val();
            var type = $('#type').val();
            var url = $('#url').val();
            var discription = $('#discription').val();
            var logo = $('#logo').val();
            /*var image = $('#image').val();*/

            $('#name-val').text(name);
            $('#address-val').text(address);
            $('#type-val').text(type);
            $('#url-val').text(url);
            $('#discription-val').text(discription);
            $('#logo-val').text(logo);
            /*$('#image-val').text(image);*/

            $("#form-register").validate().settings.ignore = ":disabled,:hidden";
            return $("#form-register").valid();
            
        }
    });
});


// Image
function readURL(input) {
    if (input.files && input.files[0]) {
  
      var reader = new FileReader();
  
      reader.onload = function(e) {
        $('.image-upload-wrap').hide();
  
        $('.file-upload-image').attr('src', e.target.result);
        $('.file-upload-content').show();
  
        $('.image-title').html(input.files[0].name);
      };
  
      reader.readAsDataURL(input.files[0]);
  
    } else {
      removeUpload();
    }
  }
  
  function removeUpload() {
    $('.file-upload-input').replaceWith($('.file-upload-input').clone());
    $('.file-upload-content').hide();
    $('.image-upload-wrap').show();
  }
  $('.image-upload-wrap').bind('dragover', function () {
          $('.image-upload-wrap').addClass('image-dropping');
      });
      $('.image-upload-wrap').bind('dragleave', function () {
          $('.image-upload-wrap').removeClass('image-dropping');
  });

  function readURL1(input) {
    if (input.files && input.files[0]) {
  
      var reader1 = new FileReader();
  
      reader1.onload = function(e) {
        $('.image-upload-wrap1').hide();
  
        $('.file-upload-image1').attr('src', e.target.result);
        $('.file-upload-content1').show();
  
        $('.image-title1').html(input.files[0].name);
      };
  
      reader1.readAsDataURL(input.files[0]);
  
    } else {
      removeUpload1();
    }
  }
  
  function removeUpload1() {
    $('.file-upload-input1').replaceWith($('.file-upload-input1').clone());
    $('.file-upload-content1').hide();
    $('.image-upload-wrap1').show();
  }
  $('.image-upload-wrap1').bind('dragover', function () {
          $('.image-upload-wrap1').addClass('image-dropping1');
      });
      $('.image-upload-wrap1').bind('dragleave', function () {
          $('.image-upload-wrap1').removeClass('image-dropping1');
  });