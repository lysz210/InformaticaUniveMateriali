var http = require('http');
var url = require('url');

var server = new http.Server(); // Crea un server HTTP
var io = require('socket.io')( server );



server.on("close", function() {
    console.log("Server chiuso");
});

server.on("connect", function() {
    console.log("Nuova connessione");
});

/*
server.on("request", function(request, response) {
    console.log("Nuova richiesta");
    var path_url = url.parse( request.url );
    console.log("Risorsa: " + path_url.pathname );

    if( path_url.pathname == "/ciao" ) {

        response.writeHead(200, { 
            "Content-Type": "text/plain; charset=UTF-8"
        });
        response.write("Ciao ciao");
        response.end();
    }


    if( path_url.pathname == "/favicon.ico" ) {

        response.writeHead(200, { 
            "Content-Type": "image/x-icon"
        });

        var input = require('fs').createReadStream( 'favicon.ico' );
        input.on("data", function(data) {
            response.write(data);
        });
        input.on("end", function() {
            response.end();
        });
    }

});
*/

io.on('connection', function(socket) {
    console.log("socket.io  client connected");

    socket.on('pole_update', function(obj) {
        io.emit( 'pole_update', obj );
    });
    socket.on('ball_fired', function(obj) {
        console.log("White ball fired");
        io.emit( 'ball_fired', obj );
    });
});

io.on('disconnect', function(){
    console.log('socket.io client disconnected');
});



var currentTime;
var lastTime=Date.now();
setInterval( function() {
    currentTime = Date.now();
    var elapsed = currentTime - lastTime;
    lastTime = currentTime;
    io.emit("game_update",elapsed);
},20);



server.listen(8080); 
