window.onload = function() {
    startGame(document.getElementById("mySvg"));
};

var currentThread = undefined;

function PoolBall(position, speed, number)
{
    this.position = position;
    this.speed = speed;
    this.number = number;

    this.in_pocket_deferred = $.Deferred();

    this.in_pocket_promise = function() {
        return this.in_pocket_deferred.promise();
    }

    this.set_in_pocket = function() {
        this.place(-100,-100);
        this.in_pocket_deferred.resolve( this );
    }
    
    this.update = function(timeStep)
    {
        this.move(this.speed.clone().mul(timeStep));
        while(timeStep-->0)
            this.speed.mul(0.9996);
    };
}


PoolBall.prototype = new Ball(new Vector(0, 0), 22);


function Pole(a, b)
{
    this.a = a;
    this.b = b;    
    this.isPole = "yes";
    
    this.reset = function()
    {
        this.a = new Vector(0,0);
        this.b = new Vector(0,0);
    };
}
Pole.prototype = new Segment(0,0);

function startGame(svg)
{
    var width = svg.getBoundingClientRect().width;
    var height = svg.getBoundingClientRect().height;
    var fps = document.getElementById("fps");

    var balls = [];
    var lines = [];
    var drawables = [];

    var currentPole = new Pole(new Vector(0,0),new Vector(0,0));
    drawables.push(currentPole);

    var ballNumber = 1;
    for (var line = 0; line <= 4; line++)
    {
        var radius = PoolBall.prototype.radius * 2;
        var startY = (height - line * radius) / 2;
        var startX = (width / 2)*0.8 - line * radius;
        for (var column = 0; column <= line; column++)
        {
            var center = new Vector(startX, startY+column*radius);
            var speed = new Vector(0, 0);
            var ball = new PoolBall(center, speed, ballNumber++);
            balls.push(ball);
            drawables.push(ball);
        }
    }
    var white = new PoolBall(new Vector(width*0.7,height/ 2), new Vector(0,0), 0);
    balls.push(white);
    drawables.push(white);


    function addLine(line)
    {
        drawables.push(line);
        lines.push(line);
        return line;
    }
    addLine(new Segment(new Vector(67, 110), new Vector(67, 458)));
    addLine(new Segment(new Vector(107, 67), new Vector(461, 67)));
    addLine(new Segment(new Vector(535, 67), new Vector(890, 67)));
    addLine(new Segment(new Vector(107, 500), new Vector(461, 500)));
    addLine(new Segment(new Vector(535, 500), new Vector(890, 500)));
    addLine(new Segment(new Vector(930, 110), new Vector(930, 458)));
    
    addLine(new Segment(new Vector(30, 30), new Vector(30, 540))).hole = true;
    addLine(new Segment(new Vector(30, 30), new Vector(970, 30))).hole = true;
    addLine(new Segment(new Vector(30, 540), new Vector(970, 540))).hole = true;
    addLine(new Segment(new Vector(970, 30), new Vector(970, 540))).hole = true;


    window.addEventListener("mousedown",
        function(event)
        {
            currentPole.a = new Vector(event.x - svg.offsetLeft, event.y - svg.offsetTop);
            currentPole.b = currentPole.a.clone();
        });

    window.addEventListener("mousemove",
        function(event)
        {
            if(!currentPole.a.isNull())
                currentPole.b = new Vector(event.x - svg.offsetLeft, event.y - svg.offsetTop);
        });

    window.addEventListener("mouseup",
        function(event)
        {
            if(!currentPole.a.isNull())
            {
                if(currentPole.len()>0)
                    white.speed = currentPole.a.clone().sub(currentPole.b).mul(0.005);
                currentPole.reset();
            }
        });


    balls[ balls.length-1 ].in_pocket_promise().done( function(data) {
        alert('White ball in pocket!');
    });

    var current_score=0;
    for( i=0; i<balls.length-1; ++i ) {
        balls[i].in_pocket_promise().done( function( data ) {
            current_score = current_score+1;
        } );
    }

    if (currentThread !== undefined)
        clearInterval(currentThread);

    var currentTime = Date.now();
    var lastTime = Date.now();
    var count = 0;
    var numSamples = 50;
    var totalFps = 0;

    currentThread = setInterval(
            function()
            {
                currentTime = Date.now();
                var elapsed = currentTime - lastTime;
                lastTime = currentTime;

                totalFps += 1000 / elapsed;
                if (count++ % numSamples === 0)
                {
                    fps.innerHTML = "fps: " + totalFps / numSamples;
                    totalFps = 0;
                    $("#score").html("Score: " + current_score );
                }

                var steps = 10;
                var ministep = elapsed / steps;

                while (steps-- > 0)
                {

                    for (var b1 = 0; b1 < balls.length; b1++)
                        for (var b2 = b1 + 1; b2 < balls.length; b2++)
                            if (balls[b1].touchesBall(balls[b2]))
                                balls[b1].bounceWithBall(balls[b2]);

                    for (var b = 0; b < balls.length; b++)
                        for (var l = 0; l < lines.length; l++)
                            if (balls[b].touchesSegment(lines[l]))
                                if(lines[l].hole)
                                    balls[b].set_in_pocket();
                                else    
                                    balls[b].bounceWithSegment(lines[l]);

                    for (var b1 = 0; b1 < balls.length; b1++)
                        balls[b1].update(ministep);

                }

                renderAllSvg(svg, drawables);
            },
            20
            );

}
