var stompClient = null;

function setConnected(connected) {
    if (connected) {
    	 $("#locationsLeft").show();
    	 $("#locationsRight").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#locations").html("");
}

function connect() {
    var socket = new SockJS('/websockets');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/locations', function (object) {
        	var obj = JSON.parse(object.body);
            showLocation(obj.location);
        });
    });
}
function connectForStatus() {
    var socket = new SockJS('/websockets');
    stompClientStatus = Stomp.over(socket);
    stompClientStatus.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClientStatus.subscribe('/topic/status', function (object) {
        	var obj = JSON.parse(object.body);
        	showStatus(obj);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    if (stompClientStatus !== null) {
    	stompClientStatus.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function showLocation(location) {
    $("#locations").append("<tr><td>" + location.step + "</td><td>" + location.x + "</td><td>" + location.y + "</td></tr>");
}
function showStatus(msg) {
	 $('div.alert').removeClass( "alert-success  alert-danger" )
	
	if(msg.onRoute){
		 $('div.alert').addClass("alert-success");
	}else{
		 $('div.alert').addClass("alert-danger");
		
	}
	 $('div.alert').html('Status for step '+msg.step + ' is ' + msg.status);
}

function start() {
	 $.ajax({
		   type:'POST',
		   url :"generate",
		   success: function() {
		        console.log('success');
		   },
		   error:function(exception){alert('Exeption:'+exception);}
		}); 
}



$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    connect();
    connectForStatus();
    $( "#generate" ).click(function() { start(); });
    $( "#disconnect" ).click(function() { disconnect(); });
});