$(document).ready(function() {
    $("#createlistform").submit(function(event) {
		event.preventDefault();
		ajaxPost();
	});
    function ajaxPost(){
    	var formData = {
        		listname : $("#listname").val(),
        	}
    	$.ajax({
    		type : "POST",
			contentType : "application/json",
			url : "createList",
			data : JSON.stringify(formData),
			success : function() {
				$("#postResultDiv").hide().html("<div class='alert alert-success'>" +
						"<strong>List Created Succesfully.</strong></div>").slideDown("slow");	
				$("#getResultDiv").hide().load(location.href + " #getResultDiv>*", "").fadeIn("slow");
				$(".accordion-section-title").click();
				console.log(result);
			},
			error : function(e) {
				$("#postResultDiv").html("<div class='alert alert-danger'><strong>Beklenmeyen" +
						"Bir Hata Meydana Geldi.</strong></div>");
				console.log("ERROR: ", e);
			}
		});
    	resetData();
    }
    function resetData(){
    	$("#listname").val("");
    }
});