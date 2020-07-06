//Wait for the DOM to be ready
$(function() {
//$().ready(function() {
	$("#contactRegistration").validate({
		/** 
		 * Specify validation rules 
		 */
		rules: {
			/**
			 * The key name on the left side is the name attribute
			 * of an input field. Validation rules are defined
			 * on the right side 
			 */

			contactName: {
				required: true,
				minlength: 5
			},
			contactEmail: {
				required: true,
				// Specify that email should be validated
				// by the built-in "email" rule
				email: true
			},
			contactNumber: {
				required: true,
				digits: true,
				minlength: 10
			}
		},
		// Specify validation error messages
		messages: {
			contactName: {
				required: "Please provide a name",
				minlength: "must contains 5 chars"
			},
			contactNumber: {
				required: "Please provide a contact number",
				digits: "Digits Only",
					minlength: "must contains 10 digits"
			},
			contactEmail: "Please enter a valid email address"
		},
		// Make sure the form is submitted to the destination defined
		// in the "action" attribute of the form when valid
		submitHandler: function(form) {
			form.submit();
		}
	});
});