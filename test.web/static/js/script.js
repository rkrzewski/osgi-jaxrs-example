$(document).ready(function() {
	$("#fetch").on("click", function(event) {
		$.ajax({
			url : "/services/test",
			success : function(data) {
				$("#out").val(data.greeting);
			}
		});
	});
});