type = ['','info','success','warning','danger'];


demo = {
    initPickColor: function(){
        $('.pick-class-label').click(function(){
            var new_class = $(this).attr('new-class');
            var old_class = $('#display-buttons').attr('data-class');
            var display_div = $('#display-buttons');
            if(display_div.length) {
            var display_buttons = display_div.find('.btn');
            display_buttons.removeClass(old_class);
            display_buttons.addClass(new_class);
            display_div.attr('data-class', new_class);
            }
        });
    },

	showNotification: function(from, align){
    	color = 2;

    	$.notify({
        	icon: "notifications",
        	message: "Report is approved and sent to the authorities."

        },{
            type: type[color],
            timer: 4000,
            placement: {
                from: from,
                align: align
            }
        });
        
        
	},
    
     showNotificationReject: function(from, align){
    	color = 4;
    
    	$.notify({
        	icon: "notifications",
        	message: "Report is rejected."

        },{
            type: type[color],
            timer: 4000,
            placement: {
                from: from,
                align: align
            }
        });
	}

}
