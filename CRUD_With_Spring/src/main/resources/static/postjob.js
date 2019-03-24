$(document).ready(function() {
    $("#createjobform").submit(function(event) {
		event.preventDefault();
		var listid : $("#listid").val();
		alert("COMING SOON...");
		//ajaxPost();
	});
    function ajaxPost(){
    	var formData = {
    			title : $("#title").val(),
    			description : $("#description").val(),
    			nopth : $("#nopth").val(),
    			lastDate : $("#lastDate").val(),
        	}
    	$.ajax({
    		type : "POST",
			contentType : "application/json",
			url : "/createJob?listid="+listid,
			data : JSON.stringify(formData),
			success : function() {
				$("#postResultDiv").hide().html("<div class='alert alert-success'>" +
						"<strong>Job Created Succesfully.</strong></div>").slideDown("slow");	
				$("#getResultDiv2").hide().load(location.href + " #getResultDiv2>*", "").fadeIn("slow");
				$(".accordionn-section-title").click();
				console.log(result);
			},
			error : function(e) {
				$("#postResultDiv").html("<div class='alert alert-danger'>" +
						"<strong>Unexpected Error.</strong></div>");
				console.log("ERROR: ", e);
			}
		});
    	resetData();
    }
    function resetData(){
    	$("#title").val("");
    	$("#description").val("");
    	$("#nopth").val("");
    	$("#lastDate").val("");
    }
});