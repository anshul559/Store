$(document).ready(function(){
	
	switch(menu){
	case 'About us': $('#about').addClass('active');
	break;
	case 'Contact us': $('#contact').addClass('active');
	break;
	case 'View Product': $('#viewproduct').addClass('active');
	break;
	default : $('#home').addClass('active');
	break;
	}
});