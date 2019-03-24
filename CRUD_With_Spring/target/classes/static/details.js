$(document).ready(function() {
	$('#detail').on('click', function(event) {
		event.preventDefault();
		var joblistid : $("#joblistid").val();
		ajaxGet();
	});
	function ajaxGet() {
		$.ajax({
			type : "GET",
			url : "/detailList?listid="+listid,
			complete : function() {
				$("#postResultDiv2").hide().load(location.href + " #postResultDiv2>*", "").fadeIn("slow");
			},
			error : function(e) {
				$("#postResultDiv2").html("<strong>HATA | ERROR</strong>");
				console.log("ERROR: ", e);
			}
		});
	}
});
