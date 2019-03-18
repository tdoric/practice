var stompClient = null;

function setConnected(connected) {
//    $("#connect").prop("disabled", connected);
//    $("#disconnect").prop("disabled", !connected);
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
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/greetings', function (object) {
        	var obj = JSON.parse(object.body);
            showLocation(obj.location);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function showLocation(location) {
    $("#locations").append("<tr><td>" + location.step + "</td><td>" + location.x + "</td><td>" + location.y + "</td></tr>");
}

function start() {
	 $.ajax({
		   type:'GET',
		   url :"generate",
		   success: function(data) {
		        console.log('success',data);
		   },
		   error:function(exception){alert('Exeption:'+exception);}
		}); 
}



$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    connect();
    $( "#connect" ).click(function() { start(); });
    $( "#disconnect" ).click(function() { disconnect(); });
});